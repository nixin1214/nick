/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理工具类
 * 
 * @author wujing
 */
public final class DateUtil {

	/**
	 * 此类不需要实例化
	 */
	private DateUtil() {
	}

	public static Date date = null;
	public static DateFormat dateFormat = null;
	public static Calendar calendar = null;
	public static final String YEAR_MONTH_PATTERN = "yyyyMM";
	public static final String YEAR_MONTH_DAY_PATTERN = "yyyyMMdd";

	/**
	 * 时间转换：长整型转换为日期字符型
	 * 
	 * @param format
	 *            格式化类型：yyyy-MM-dd
	 * @param time
	 *            13位有效数字：1380123456789
	 * 
	 * @return 格式化结果 (yyyy-MM-dd)
	 */
	public static String formatToString(String format, long time) {
		if (time == 0) {
			return "";
		}
		return new SimpleDateFormat(format).format(new Date(time));
	}

	/**
	 * 时间转换：日期字符型转换为长整型
	 * 
	 * @param format
	 *            格式化类型：yyyy-MM-dd
	 * 
	 * @return 13位有效数字 (1380123456789)
	 */
	public static long formatToLong(String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return Timestamp.valueOf(f.format(new Date())).getTime();
	}

	/**
	 * 获取当前年份
	 * 
	 * @return yyyy (2016)
	 */
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取当前月份
	 * 
	 * @return MM (06)
	 */
	public static String getMonth() {
		Calendar cal = Calendar.getInstance();
		return new DecimalFormat("00").format(cal.get(Calendar.MONTH));
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("-", "/");
			dt = dateStr;
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
			}
			date = (Date) dateFormat.parse(dt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy-MM-dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy-MM-dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 * @throws ParseException
	 */
	public static String add(String date, int day) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long d = df.parse(date).getTime();
		long millis = d + ((long) day) * 24 * 3600 * 1000;
		return df.format(new Date(millis));
	}

	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		date = parseDate(getMonthBegin(strdate));
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 计算日期之间的天数
	 * 
	 * @param beginDate
	 *            开始日期 yyy-MM-dd
	 * @param endDate
	 *            结束日期 yyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static int getDay(String beginDate, String endDate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long to = df.parse(endDate).getTime();
		long from = df.parse(beginDate).getTime();
		return (int) ((to - from) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 获取期间列表
	 * @param beginYearMonth 开始期间
	 * @param endYearMonth 结束期间
	 * @return 期间列表集合
	 */
	public static List<String> getYearMonthArr(String beginYearMonth, String endYearMonth) {
		Date begin = parseDate(beginYearMonth, YEAR_MONTH_PATTERN);
		Date end = parseDate(endYearMonth, YEAR_MONTH_PATTERN);
		List<String> yearMonthList = new ArrayList<String>();

		Calendar baseDate = Calendar.getInstance();
		baseDate.setTime(begin);
		do {
			yearMonthList.add(format(baseDate.getTime(), YEAR_MONTH_PATTERN));
			baseDate.add(Calendar.MONTH, 1);
		} while (baseDate.getTime().compareTo(end) < 0);
		return yearMonthList;
	}

	/**
	 * 获取期间列表
	 * @param beginYearMonth 开始期间
	 * @param endYearMonth 结束期间
	 * @return 期间列表集合
	 */
	public static List<String> getYearMonthDayArr(String beginYearMonth, String endYearMonth) {
		Date begin = parseDate(beginYearMonth, YEAR_MONTH_DAY_PATTERN);
		Date end = parseDate(endYearMonth, YEAR_MONTH_DAY_PATTERN);
		List<String> yearMonthList = new ArrayList<String>();
		Calendar baseDate = Calendar.getInstance();
		baseDate.setTime(begin);
		do {
			yearMonthList.add(format(baseDate.getTime(), YEAR_MONTH_DAY_PATTERN));
			baseDate.add(Calendar.DATE, 1);
		} while (baseDate.getTime().compareTo(end) <= 0);
		return yearMonthList;
	}

	/**
	 * 获取近12个月开始结束期间
	 * @num 需往前推几个月
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 杨北平 新增参数
	public static String[] getBeginEndYearMonth(int num) {
		String[] arr = new String[2];
		calendar = Calendar.getInstance();
		arr[1] = format(calendar.getTime(),	 YEAR_MONTH_PATTERN);
		calendar.add(Calendar.MONTH, -num);
		//modify end
		arr[0] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		return arr;
	}

	/**
	 * 根据定义的结束日期，获取往前n个月的开始和结束节点
	 * @end 结束时间需要前推几个月
	 * @num 需往前推几个月
	 * @return 节点数组
	 */
	public static String[] getBeginEndYearMonth(int end,int num) {
		String[] arr = new String[2];
		calendar = Calendar.getInstance();//获取当前日期
		calendar.add(Calendar.MONTH, -end);//结束时间
		arr[1] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		calendar.add(Calendar.MONTH, -num);//开始时间
		arr[0] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		return arr;
	}

	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转字符串
	 * @param time
	 * @return
	 */
	public static String dateToString(Date time){
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat ("yyyy-MM-dd");
		String ctime = formatter.format(time);

		return ctime;
	}

	/**
	 * 根据日期取前30天的日期
	 * @param yearMonth
	 * @return
	 */
	public static String dateToDay(String yearMonth){
		Calendar theCa = Calendar.getInstance();
		Date beginTime = StrToDate(yearMonth);
		theCa.setTime(beginTime);
		theCa.add(theCa.DATE, -30);
		Date begin = theCa.getTime();
		String start = dateToString(begin);
		return start;
	}
	/**
	 * 获取近12个月开始结束期间
	 * @num 需往前推几个月
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 倪鑫 新增参数
	public static String[] getStartEndYearMonth(int num) {
		String[] arr = new String[2];
		calendar = Calendar.getInstance();
		arr[1] = format(calendar.getTime(), "yyyyMMdd");
		calendar.add(Calendar.DATE, -num);
		//modify end
		arr[0] = format(calendar.getTime(), "yyyyMMdd");
		return arr;
	}


	/**
	 * 获取上一个月26号
	 * @return
	 */
	public static String dateDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,26);
		calendar.add(Calendar.MONTH, -1);
		Date begin = calendar.getTime();
		String start = dateToString(begin);
		return start;
	}
	/**
	 * 获取本月26号
	 * @return
	 */
	public static String dateDays(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,26);
		calendar.add(Calendar.MONTH, 0);
		Date begin = calendar.getTime();
		String end = dateToString(begin);
		return end;
	}
	/**
	 * 获取本月1号
	 * @return
	 */
	public static String datefirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.add(Calendar.MONTH, 0);
		Date begin = calendar.getTime();
		String end = dateToString(begin);
		return end;
	}

	/**
	 * 获取两个时间段的天数
	 * @param
	 * @param
	 * @return
	 */
	public static long getDaySub(String beginDateStr,String endDateStr) {
		long day=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date beginDate = format.parse(beginDateStr);
			Date endDate= format.parse(endDateStr);
			day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000)+new Long(1);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return day;
	}
	/**
	 * 根据提供的时间
	 * @num 需往前推几个月
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 杨北平 新增参数
	public static String[] getBeginMonth(String yearMonth,int num) {
		String[] arr = new String[2];
		Date beginTime = StrTo(yearMonth);
		calendar = Calendar.getInstance();
		calendar.setTime(beginTime);
		arr[1] = format(calendar.getTime(),	 YEAR_MONTH_PATTERN);
		calendar.add(Calendar.MONTH, -num);
		//modify end
		arr[0] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		return arr;
	}

	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date StrTo(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date StrToTwo(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 获取期间列表
	 * @param beginYearMonth 开始期间
	 * @param endYearMonth 结束期间
	 * @return 期间列表集合
	 */
	public static List<String> getYearArr(String beginYearMonth, String endYearMonth) {
		Date begin = parseDate(beginYearMonth, YEAR_MONTH_PATTERN);
		Date end = parseDate(endYearMonth, YEAR_MONTH_PATTERN);
		List<String> yearMonthList = new ArrayList<String>();

		Calendar baseDate = Calendar.getInstance();
		baseDate.setTime(begin);
		for(int i = 0;i<12;i++){
			yearMonthList.add(format(baseDate.getTime(), YEAR_MONTH_PATTERN));
			baseDate.add(Calendar.MONTH, 1);
		}
		return yearMonthList;
	}

	/**
	 * 获取上月26号到当月25号的天数
	 * @return
	 */
	public static long getMonday(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (!sdf.format(new Date()).contains("-01-")){
			calendar.set(Calendar.DAY_OF_MONTH, 26);
			calendar.add(Calendar.MONTH, -1);
		}else{
			calendar.set(Calendar.DATE,1);
		}
		Date date = calendar.getTime();
		Calendar calendar1 = Calendar.getInstance();
		if (!sdf.format(new Date()).contains("-12-")){
			calendar1.set(Calendar.DAY_OF_MONTH, 25);
		}else {
			calendar1.set(Calendar.MONTH,12);
			calendar1.set(Calendar.DATE,1);
		}
		Date date1 = calendar1.getTime();
		long days = DateUtil.getDaySub(sdf.format(date),sdf.format(date1));//得到上月26号到当前日期的天数
		return  days;
	}
	/**
	 * 根据提供的时间
	 * @num 需往前推几天
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 倪鑫 新增参数
	public static String[] getBeginDay(String yearMonth,int num) {
		String[] arr = new String[2];
		Date beginTime = StrToTwo(yearMonth);
		calendar = Calendar.getInstance();
		calendar.setTime(beginTime);
		arr[1] = format(calendar.getTime(),	 "yyyyMMdd");
		calendar.add(Calendar.DATE, -num);
		//modify end
		arr[0] = format(calendar.getTime(), "yyyyMMdd");
		return arr;
	}
	/**
	 * 获取近12个月开始结束期间
	 * @num 需往后推几个月
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 杨北平 新增参数
	public static String[] getNextMonth(int num) {
		String[] arr = new String[2];
		calendar = Calendar.getInstance();
		arr[1] = format(calendar.getTime(),	 YEAR_MONTH_PATTERN);
		calendar.add(Calendar.MONTH, +num);
		//modify end
		arr[0] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		return arr;
	}

	/**
	 *往后推几个月
	 * @param yearMonth
	 * @param num
	 * @return
	 */
	public static String[] startDndDay(String yearMonth,int num) {
		String[] arr = new String[2];
		Date beginTime = StrTo(yearMonth);
		calendar = Calendar.getInstance();
		calendar.setTime(beginTime);
		arr[1] = format(calendar.getTime(),	 YEAR_MONTH_PATTERN);
		calendar.add(Calendar.MONTH, num);
		//modify end
		arr[0] = format(calendar.getTime(), YEAR_MONTH_PATTERN);
		return arr;
	}
	/**
	 * 获取下个月25号
	 * @return
	 */
	public static String nextFiveDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,25);
		calendar.add(Calendar.MONTH, 1);
		Date begin = calendar.getTime();
		String start = dateToString(begin);
		return start;
	}
	/**
	 * 获取当月最后一天
	 * @return
	 */
	public static String lastDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,0);
		calendar.add(Calendar.MONTH, 1);
		Date begin = calendar.getTime();
		String start = dateToString(begin);
		return start;
	}
	/**
	 * 时间判断
	 * @return
	 */
	public static List<Long> timeboolean(){
		List<Long> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		Date date1 = calendar1.getTime();
		String nowdays = sdf.format(date1);//当前时间
		String firstday = datefirstDay();//获取本月第一天
		String endday = dateDays();//本月25号
		String lastendday = dateDay();//获取上个月26号
		String starttime = nextFiveDay();//获取下个月25号
		String lastday = lastDay();//获取本月最后一天
		list.add(getDaySub(firstday,endday));//本月第一天到本月25号的天数
		list.add(getDaySub(firstday,nowdays));//本月第一天到当前时间的天数
		list.add(getDaySub(endday,starttime));//得到本月25号到下个月25号的天数
		list.add(getMonday());//得到上月26号到本月25号的天数
		list.add(getDaySub(lastendday,lastday));//得到上月25号到本月最后一天的天数


		return list;
	}

	/**
	 * 获取近12个月开始结束期间
	 * @num 需往前推几年
	 * @return 期间数组
	 */
	//modify begin 2017-11-9 杨北平 新增参数
	public static String[] getBeginEndYearyear(int num) {
		String[] arr = new String[2];
		calendar = Calendar.getInstance();
		arr[1] = format(calendar.getTime(),	 "yyyy");
		calendar.add(Calendar.YEAR, num);
		//modify end
		arr[0] = format(calendar.getTime(), "yyyy");
		return arr;
	}

	public static int Stringint(String num) {
		int i = 0;
		try{
			i = Integer.parseInt(num);
		}catch (NumberFormatException e){
			e.printStackTrace();
		}
		return  i ;
	}


	//得到传入年份的前一年
	public static String getOldYear(String nowYear){
		String oldYear = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			Date d = format.parse(nowYear);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(Calendar.YEAR,-1);
			d = calendar.getTime();
			oldYear = format.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return oldYear;
	}

	//得到当前月份的前一个月
	public static String getOldMonth(Date nowMonth){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowMonth);
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String oldMonth = format.format(calendar.getTime());
		return oldMonth;
	}
	//季度时间判断
	public static String getwysfx(String security){
		String starttime = null;
		if(security.substring(4).equals("Q1")){
			int a = DateUtil.Stringint(security.substring(0,4))-1;
			starttime = Integer.toString(a)+"Q4";
		}else {
			int b = DateUtil.Stringint(security.substring(5))-1;
			starttime =security.substring(0,5)+Integer.toString(b);
		}
		return starttime;
	}

}
