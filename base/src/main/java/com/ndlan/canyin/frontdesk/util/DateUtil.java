 package com.ndlan.canyin.frontdesk.util;
 
 import com.ndlan.canyin.core.utils.DateProvider;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
 
 public class DateUtil
 {
   public static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
 
   public static Integer getOffsetDate(Date date)
   {
     int dateSum = 0;
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     String dateStr = format.format(date);
     int year = Integer.valueOf(dateStr.substring(0, 4)).intValue();
     int month = Integer.valueOf(dateStr.substring(5, 7)).intValue();
     int day = Integer.valueOf(dateStr.substring(8, 10)).intValue();
     for (int i = 1; i < month; i++) {
       switch (i) { case 1:
       case 3:
       case 5:
       case 7:
       case 8:
       case 10:
       case 12:
         dateSum += 31; break;
       case 4:
       case 6:
       case 9:
       case 11:
         dateSum += 30; break;
       case 2:
         if (((year % 4 == 0 ? 1 : 0) & (year % 100 != 0 ? 1 : 0) | (year % 400 == 0 ? 1 : 0)) != 0)
           dateSum += 29;
         else dateSum += 28;
       }
     }
     dateSum += day;
     return Integer.valueOf(dateSum);
   }
 
   public static String getTime4XDaysAgo(int x, String time)
   {
     String preDate = null;
     try {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Calendar c = Calendar.getInstance();
       c.setTime(sdf.parse(time));
       c.add(5, -x);
       Date date = c.getTime();
       preDate = sdf.format(date);
     } catch (ParseException e) {
       e.printStackTrace();
     }
     return preDate;
   }
 
   public static Date getTime4XDaysAfter(int x, Date time) {
     Calendar c = Calendar.getInstance();
     c.setTime(time);
     c.add(5, x);
     Date date = c.getTime();
     return date;
   }
 
   public static Long getMinutes(Date start, Date end)
   {
     return Long.valueOf((end.getTime() - start.getTime()) / 60000L);
   }
 
   public static int getWeekDay(Date date) {
     Calendar c = Calendar.getInstance();
     c.setTime(date);
     return c.get(7) - 1;
   }
 
   public static String toString(Date date) {
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     return sdf.format(date);
   }
 
   public static String toStringNoSecond(Date date) {
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
     return sdf.format(date);
   }
 
   public static Date toDate(String dateStr)
   {
     if ((dateStr == null) || (dateStr.isEmpty()))
     {
       return null;
     }
     dateStr = dateStr.trim();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date date = null;
     try {
       date = sdf.parse(dateStr);
     }
     catch (ParseException e) {
       e.printStackTrace();
     }
     return date;
   }
 
   public static Date toSimpleDate(String dateStr) {
     if ((dateStr == null) || (dateStr.isEmpty()))
     {
       return null;
     }
     dateStr = dateStr.trim();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date date = null;
     try {
       date = sdf.parse(dateStr + " 00:00:00");
     }
     catch (ParseException e) {
       e.printStackTrace();
     }
     return date;
   }
   /**
    * 新加    * @param startDate
    * @param endDate
    * @return
    */
   public static String[] getStartAndEdnDate(String startDate, String endDate)
   {
     String[] dateArr = new String[2];
     if (StringUtils.isEmpty(endDate)) {
       endDate = toString(new Date());
     }
 
     if (StringUtils.isEmpty(startDate)) {
       startDate = getTime4XDaysAgo(30, endDate);
     }
     else
     {
       try
       {
         if (daysBetween(startDate, endDate) > 30)
         {
           startDate = getTime4XDaysAgo(30, endDate);
         }
       } catch (ParseException e) {
         startDate = getTime4XDaysAgo(30, endDate);
         e.printStackTrace();
       }
     }
     dateArr[0] = startDate;
     dateArr[1] = endDate;
     return dateArr;
   }
   
   
   public static int daysBetween(String smdate, String bdate)
		     throws ParseException
		   {
		     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		     Calendar cal = Calendar.getInstance();
		     cal.setTime(sdf.parse(smdate));
		     long time1 = cal.getTimeInMillis();
		     cal.setTime(sdf.parse(bdate));
		     long time2 = cal.getTimeInMillis();
		     long between_days = (time2 - time1) / 86400000L;
		     return Integer.parseInt(String.valueOf(between_days));
		   }
   
   
   public static String toYearMonthString(String dateStr) {
	     return toYearMonthString(toDate(dateStr));
	   }
   
   public static String toYearMonthString(Date dateStr)
   {
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
     String date = null;
     try {
       date = sdf.format(dateStr);
     } catch (Exception e) {
       e.printStackTrace();
     }
     return date;
   }
   
   
 
   public static Date toDateTime(String dateStr)
   {
     if ((dateStr == null) || (dateStr.isEmpty()))
     {
       return null;
     }
     dateStr = dateStr.trim();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date date = null;
     SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
     Date now = DateProvider.DEFAULT.getDate();
     try {
       date = sdf.parse(f.format(now) + " " + dateStr);
     }
     catch (ParseException e) {
       e.printStackTrace();
     }
     return date;
   }
 
   public static void main(String[] args) throws ParseException
   {
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
     System.out.println(df.format(new Date()));
   }
 }

