﻿ package com.ndlan.canyin.core.common;
 
 import com.ndlan.canyin.core.utils.EnumUtil;
import com.ndlan.canyin.core.utils.Identities;
import com.ndlan.canyin.core.common.RoleTypeEnum;
import java.io.PrintStream;
 
 public enum RoleTypeEnum
 {
   OTHER("0", "其他"), 
   ADMIN("1", "管理员"), 
   SHOUYIN("2", "收银员"), 
   WAITER("3", "服务员"), 
   PM("4", "经理"), 
   YINGXIAO("5", "营销员"), 
   CAIGOU("6", "采购"), 
   CANGKU("7", "仓库管理员"), 
   SENDMAN("8", "派送员");
 
   public static final String enumCode = "RoleType";
   public static final String enumName = "权限类型";
   private String code;
   private String desc;
 
   private RoleTypeEnum(String code, String desc) { this.code = code;
     this.desc = desc; }
 
   public static String getDesc(String code)
   {
     for (RoleTypeEnum status : values()) {
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
 
   public static void main(String[] args) {
     generateSQL();
   }
 
   public static void generateSQL()
   {
     String uuid = Identities.uuid2();
     String baseSql = "insert into md_base_code (bc_id,bc_code,bc_name,bc_desc,is_enable,version) VALUES ( '" + uuid + "' , " + 
       "'" + "RoleType" + "','" + "权限类型" + "','" + "权限类型" + "','1',0);";
     System.out.println(baseSql);
     EnumUtil.insert(baseSql);
     for (RoleTypeEnum status : values()) {
       String sub_uuid = Identities.uuid2();
       String itemSql = "insert into md_base_code_item (bci_id,bc_id,bc_code,bci_code,bci_name,bci_desc,is_enable,version) VALUES ( '" + 
         sub_uuid + "' , '" + uuid + "' ,'" + "RoleType" + "', '" + status.getCode() + "','" + status.getDesc() + "','" + status.getDesc() + "','1',0); ";
       System.out.println(itemSql);
       EnumUtil.insert(itemSql);
     }
   }
 }

