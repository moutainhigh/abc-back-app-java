﻿ package com.ndlan.canyin.core.common;
 
 import com.ndlan.canyin.core.utils.EnumUtil;
import com.ndlan.canyin.core.utils.Identities;
import com.ndlan.canyin.core.common.AreaTypeEnum;
import java.io.PrintStream;
 
 public enum AreaTypeEnum
 {
   WAIMAI("waimai", "外卖"), 
   KUAICAN("kuaican", "快餐"), 
   OTHER("other", "其他");
 
   public static final String enumCode = "AreaType";
   public static final String enumName = "区域类型";
   private String code;
   private String desc;
 
   private AreaTypeEnum(String code, String desc) { this.code = code;
     this.desc = desc; }
 
   public static String getDesc(String code)
   {
     for (AreaTypeEnum status : values()) {
       if (status.getCode().equalsIgnoreCase(code)) {
         return status.getDesc();
       }
     }
     return "未知";
   }
 
   public String getDesc() {
     return this.desc;
   }
 
   public void setDesc(String desc) {
     this.desc = desc;
   }
 
   public String getCode() {
     return this.code;
   }
 
   public void setCode(String code) {
     this.code = code;
   }
 
   public static void main(String[] args)
   {
     generateSQL();
   }
 
   public static void generateSQL()
   {
     String uuid = Identities.uuid2();
     String baseSql = "insert into md_base_code (bc_id,bc_code,bc_name,bc_desc,is_enable,version) VALUES ( '" + uuid + "' , " + 
       "'" + "AreaType" + "','" + "区域类型" + "','" + "区域类型" + "','1',0);";
     System.out.println(baseSql);
     EnumUtil.insert(baseSql);
     for (AreaTypeEnum status : values()) {
       String sub_uuid = Identities.uuid2();
       String itemSql = "insert into md_base_code_item (bci_id,bc_id,bc_code,bci_code,bci_name,bci_desc,is_enable,version) VALUES ( '" + 
         sub_uuid + "' , '" + uuid + "' ,'" + "AreaType" + "', '" + status.getCode() + "','" + status.getDesc() + "','" + status.getDesc() + "','1',0); ";
       System.out.println(itemSql);
       EnumUtil.insert(itemSql);
     }
   }
 }

