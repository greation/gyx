package com.jg2b.common.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.logging.LogFactory;

/**
 * 时间处理的工具类
 * @author zhangyaotang
 * @version 1.0 Created on 2016年5月4日
 */
public class DateTool {
	public DateTool() {
	}

	public static String getChineseDate(Date date) {
		if (date == null) {
			return new String();
		} else {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyyMMdd", new DateFormatSymbols());
			String s = simpledateformat.format(date);
			return s.substring(0, 4) + "-"
					+ Integer.parseInt(s.substring(4, 6)) + "-"
					+ Integer.parseInt(s.substring(6, 8)) + "-";
		}
	}

	public static String getCurrentDate_String() {
		Calendar calendar = Calendar.getInstance();
		String s = null;
		String s1 = (Integer.valueOf(calendar.get(1))).toString();
		String s2 = null;
		String s3 = null;

		if (calendar.get(2) < 9) {

			s2 = "0" + String.valueOf(calendar.get(2) + 1);
		} else {

			s2 = String.valueOf(calendar.get(2) + 1);
		}

		if (calendar.get(5) < 10) {

			s3 = "0" + String.valueOf(calendar.get(5));
		} else {

			s3 = String.valueOf(calendar.get(5));
		}
		s = s1 + s2 + s3;
		return s;
	}

	public static String getCurrentDate_String(String s) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		return getDate(date, s);
	}

	public static String getCurrentData() {

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(date);
		return time;
	}

	public static int calBetweenTwoMonth(String s, String s1) {
		int i = 0;
		if (s.length() != 6 || s1.length() != 6) {
			i = -1;
		} else {
			int j = Integer.parseInt(s);
			int k = Integer.parseInt(s1);
			if (j < k) {
				i = -2;
			} else {
				int l = Integer.parseInt(s.substring(0, 4));
				int i1 = Integer.parseInt(s.substring(4, 6));
				int j1 = Integer.parseInt(s1.substring(0, 4));
				int k1 = Integer.parseInt(s1.substring(4, 6));
				i = (l - j1) * 12 + (i1 - k1);
			}
		}
		return i;
	}

	public static int convertDateToYear(Date date) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy", new DateFormatSymbols());
		return Integer.parseInt(simpledateformat.format(date));
	}

	public static String convertDateToYearMonth(Date date) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMM", new DateFormatSymbols());
		try {
			return simpledateformat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertDateToYearMonthDay(Date date) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd", new DateFormatSymbols());
		try {
			return simpledateformat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static int daysBetweenDates(Date date, Date date1) {
		boolean flag = false;
		if (date1.getYear() > date.getYear())
			flag = true;
		else if (date1.getYear() == date.getYear())
			if (date1.getMonth() > date.getMonth())
				flag = true;
			else if (date1.getMonth() == date.getMonth() && date1.getDay() > date.getDay())
				flag = true;
		if (flag) {
			Date date2 = date;
			date = date1;
			date1 = date2;
		}
		int i = 0;
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTime(date1);
		calendar1.setTime(date);
		int j = calendar.get(6);
		int k = calendar1.get(1);
		for (int l = calendar.get(1); k > l;) {
			calendar.set(2, 11);
			calendar.set(5, 31);
			i += calendar.get(6);
			l++;
			calendar.set(1, l);
		}

		int i1 = calendar1.get(6);
		i = (i + i1) - j;
		if (flag)
			return -i;
		else
			return i;
	}

	public static Date getDateBetween(Date date, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(5, i);
		return calendar.getTime();
	}

	public static String getDateBetween_String(Date date, int i, String s) {
		Date date1 = getDateBetween(date, i);
		return getDate(date1, s);
	}

	public static String increaseYearMonth(String s) {
		int i = (Integer.valueOf(s.substring(0, 4))).intValue();
		int j = (Integer.valueOf(s.substring(4, 6))).intValue();
		j++;
		if (j <= 12 && j >= 10)
			return s.substring(0, 4) + (Integer.valueOf(j)).toString();
		if (j < 10)
			return s.substring(0, 4) + "0" + (Integer.valueOf(j)).toString();
		else
			return (Integer.valueOf(i + 1)).toString() + "0"
					+ (Integer.valueOf(j - 12)).toString();
	}

	public static String increaseYearMonth(String s, int i) {
		int j = (Integer.valueOf(s.substring(0, 4))).intValue();
		int k = (Integer.valueOf(s.substring(4, 6))).intValue();
		k += i;
		if (k > 0) {
			j += k / 12;
			if (k % 12 == 0) {
				k = 12;
				j--;
			} else {
				k %= 12;
			}
		} else {
			j = (j + k / 12) - 1;
			k = 12 + k % 12;
		}
		if (k <= 12 && k >= 10)
			return j + (Integer.valueOf(k)).toString();
		else
			return j + "0" + (Integer.valueOf(k)).toString();
	}

	public static String descreaseYearMonth(String s) {
		int i = (Integer.valueOf(s.substring(0, 4))).intValue();
		int j = (Integer.valueOf(s.substring(4, 6))).intValue();
		j--;
		if (j >= 10)
			return s.substring(0, 4) + (Integer.valueOf(j)).toString();
		if (j > 0 && j < 10)
			return s.substring(0, 4) + "0" + (Integer.valueOf(j)).toString();
		else
			return (Integer.valueOf(i - 1)).toString() + (Integer.valueOf(j + 12)).toString();
	}

	public static String addYearMonth(String s) {
		int i = (Integer.valueOf(s.substring(0, 4))).intValue();
		int j = (Integer.valueOf(s.substring(4, 6))).intValue();
		j++;
		if (j >= 10 && j < 12)
			return s.substring(0, 4) + (Integer.valueOf(j)).toString();
		if (j > 0 && j < 10)
			return s.substring(0, 4) + "0" + (Integer.valueOf(j)).toString();
		else
			return (Integer.valueOf(i + 1)).toString() + "0" + (Integer.valueOf(j - 12)).toString();
	}

	public static String getChineseDate_Date(Date date) {
		if (date == null) {
			return new String();
		} else {
			SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd", new DateFormatSymbols());
			String s = simpledateformat.format(date);
			return s.substring(0, 4) + "年" + Integer.parseInt(s.substring(4, 6)) + "月" + Integer.parseInt(s.substring(6, 8)) + "日";
		}
	}

	public static Date getCurrentDate() {

		Calendar calendar = Calendar.getInstance();

		Date date = calendar.getTime();
		return date;
	}

	public static String getCurrentYearMonth() {
		Calendar calendar = Calendar.getInstance();

		String s = (Integer.valueOf(calendar.get(1))).toString();
		String s1 = null;

		if (calendar.get(2) < 9) {

			s1 = "0" + (Integer.valueOf(calendar.get(2) + 1)).toString();
		} else {

			s1 = (Integer.valueOf(calendar.get(2) + 1)).toString();
		}
		return s + s1;
	}

	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();

		int i = calendar.get(1);
		return i;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static Date stringToDate(String s, String s1) {
		if (s == null)
			return null;
		Hashtable hashtable = new Hashtable();
		String s2 = new String();
		String s3 = s1.toLowerCase();
		if (s3.indexOf("yyyy") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("yyyy")), "yyyy");
		else if (s3.indexOf("yy") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("yy")), "yy");
		if (s3.indexOf("mm") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("mm")), "MM");
		if (s3.indexOf("dd") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("dd")), "dd");
		if (s3.indexOf("hh24") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("hh24")), "HH");
		if (s3.indexOf("mi") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("mi")), "mm");
		if (s3.indexOf("ss") != -1)
			hashtable.put(Integer.valueOf(s3.indexOf("ss")), "ss");
		for (int i = 0; s3.indexOf("-", i) != -1; i++) {
			i = s3.indexOf("-", i);
			hashtable.put(Integer.valueOf(i), "-");
		}

		for (int j = 0; s3.indexOf("/", j) != -1; j++) {
			j = s3.indexOf("/", j);
			hashtable.put(Integer.valueOf(j), "/");
		}

		for (int k = 0; s3.indexOf(" ", k) != -1; k++) {
			k = s3.indexOf(" ", k);
			hashtable.put(Integer.valueOf(k), " ");
		}

		for (int l = 0; s3.indexOf(":", l) != -1; l++) {
			l = s3.indexOf(":", l);
			hashtable.put(Integer.valueOf(l), ":");
		}

		if (s3.indexOf("年") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("年")), "年");
		}
		if (s3.indexOf("月") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("月")), "月");
		}
		if (s3.indexOf("日") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("日")), "日");
		}
		if (s3.indexOf("时") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("时")), "时");
		}
		if (s3.indexOf("分") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("分")), "分");
		}
		if (s3.indexOf("秒") != -1) {
			hashtable.put(Integer.valueOf(s3.indexOf("秒")), "秒");
		}
		boolean flag = false;
		while (hashtable.size() != 0) {
			Enumeration enumeration = hashtable.keys();
			int j1 = 0;
			do {
				if (!enumeration.hasMoreElements())
					break;
				int i1 = ((Integer) enumeration.nextElement()).intValue();
				if (i1 >= j1)
					j1 = i1;
			} while (true);
			String s4 = (String) hashtable.get(Integer.valueOf(j1));
			hashtable.remove(Integer.valueOf(j1));
			s2 = s4 + s2;
		}
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s2);
		Date date = new Date();
		try {
			date = simpledateformat.parse(s);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return date;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String dateToString(Date date, String s) {
		if (date == null)
			return "";
		Hashtable hashtable = new Hashtable();
		String s1 = new String();
		String s2 = s.toLowerCase();
		if (s2.indexOf("yyyy") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("yyyy")), "yyyy");
		else if (s2.indexOf("yy") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("yy")), "yy");
		if (s2.indexOf("mm") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("mm")), "MM");
		if (s2.indexOf("dd") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("dd")), "dd");
		if (s2.indexOf("hh24") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("hh24")), "HH");
		if (s2.indexOf("mi") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("mi")), "mm");
		if (s2.indexOf("ss") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("ss")), "ss");
		for (int i = 0; s2.indexOf("-", i) != -1; i++) {
			i = s2.indexOf("-", i);
			hashtable.put(Integer.valueOf(i), "-");
		}

		for (int j = 0; s2.indexOf("/", j) != -1; j++) {
			j = s2.indexOf("/", j);
			hashtable.put(Integer.valueOf(j), "/");
		}

		for (int k = 0; s2.indexOf(" ", k) != -1; k++) {
			k = s2.indexOf(" ", k);
			hashtable.put(Integer.valueOf(k), " ");
		}

		for (int l = 0; s2.indexOf(":", l) != -1; l++) {
			l = s2.indexOf(":", l);
			hashtable.put(Integer.valueOf(l), ":");
		}

		if (s2.indexOf("年") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("年")), "年");
		}
		if (s2.indexOf("月") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("月")), "月");
		}
		if (s2.indexOf("日") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("日")), "日");
		}
		if (s2.indexOf("时") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("时")), "时");
		}
		if (s2.indexOf("分") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("分")), "分");
		}
		if (s2.indexOf("秒") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("秒")), "秒");
		}
		while (hashtable.size() != 0) {
			Enumeration enumeration = hashtable.keys();
			int j1 = 0;
			do {
				if (!enumeration.hasMoreElements())
					break;
				int i1 = ((Integer) enumeration.nextElement()).intValue();
				if (i1 >= j1)
					j1 = i1;
			} while (true);
			String s3 = (String) hashtable.get(Integer.valueOf(j1));
			hashtable.remove(Integer.valueOf(j1));
			s1 = s3 + s1;
		}
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1,
				new DateFormatSymbols());
		return simpledateformat.format(date);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getDate(Date date, String s) {
		if (date == null)
			return "";
		Hashtable hashtable = new Hashtable();
		String s1 = new String();
		String s2 = s.toLowerCase();
		if (s2.indexOf("yyyy") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("yyyy")), "yyyy");
		else if (s2.indexOf("yy") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("yy")), "yy");
		if (s2.indexOf("mm") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("mm")), "MM");
		if (s2.indexOf("dd") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("dd")), "dd");
		if (s2.indexOf("hh24") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("hh24")), "HH");
		if (s2.indexOf("mi") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("mi")), "mm");
		if (s2.indexOf("ss") != -1)
			hashtable.put(Integer.valueOf(s2.indexOf("ss")), "ss");
		for (int i = 0; s2.indexOf("-", i) != -1; i++) {
			i = s2.indexOf("-", i);
			hashtable.put(Integer.valueOf(i), "-");
		}

		for (int j = 0; s2.indexOf("/", j) != -1; j++) {
			j = s2.indexOf("/", j);
			hashtable.put(Integer.valueOf(j), "/");
		}

		for (int k = 0; s2.indexOf(" ", k) != -1; k++) {
			k = s2.indexOf(" ", k);
			hashtable.put(Integer.valueOf(k), " ");
		}

		for (int l = 0; s2.indexOf(":", l) != -1; l++) {
			l = s2.indexOf(":", l);
			hashtable.put(Integer.valueOf(l), ":");
		}

		if (s2.indexOf("年") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("年")), "年");
		}
		if (s2.indexOf("月") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("月")), "月");
		}
		if (s2.indexOf("日") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("日")), "日");
		}
		if (s2.indexOf("时") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("时")), "时");
		}
		if (s2.indexOf("分") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("分")), "分");
		}
		if (s2.indexOf("秒") != -1) {
			hashtable.put(Integer.valueOf(s2.indexOf("秒")), "秒");
		}

		while (hashtable.size() != 0) {
			Enumeration enumeration = hashtable.keys();
			int j1 = 0;
			do {
				if (!enumeration.hasMoreElements())
					break;
				int i1 = ((Integer) enumeration.nextElement()).intValue();
				if (i1 >= j1)
					j1 = i1;
			} while (true);
			String s3 = (String) hashtable.get(Integer.valueOf(j1));
			hashtable.remove(Integer.valueOf(j1));
			s1 = s3 + s1;
		}
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1,
				new DateFormatSymbols());
		return simpledateformat.format(date);
	}

	public static boolean yearMonthGreatEqual(String s, String s1) {
		String s2 = s.substring(0, 4);
		String s3 = s1.substring(0, 4);
		String s4 = s.substring(4, 6);
		String s5 = s1.substring(4, 6);
		if (Integer.parseInt(s2) > Integer.parseInt(s3))
			return true;
		if (Integer.parseInt(s2) == Integer.parseInt(s3))
			return Integer.parseInt(s4) >= Integer.parseInt(s5);
		else
			return false;
	}

	public static boolean yearMonthGreater(String s, String s1) {
		String s2 = s.substring(0, 4);
		String s3 = s1.substring(0, 4);
		String s4 = s.substring(4, 6);
		String s5 = s1.substring(4, 6);
		if (Integer.parseInt(s2) > Integer.parseInt(s3))
			return true;
		if (Integer.parseInt(s2) == Integer.parseInt(s3))
			return Integer.parseInt(s4) > Integer.parseInt(s5);
		else
			return false;
	}

	public static String getOracleFormatDateStr(Date date) {
		return getDate(date, "YYYY-MM-DD HH24:MI:SS");
	}

	public static String getDateStr(Date date) {
		return getDate(date, "YYYYMMDDHH24MISS");
	}

	public static String getLastDay(String s) {
		int i = Integer.parseInt(s.substring(0, 4));
		int j = Integer.parseInt(s.substring(4, 6));
		String s1 = "";
		if (j == 2) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
				s1 = "29";
			else
				s1 = "28";
		} else if (j == 4 || j == 6 || j == 9 || j == 11)
			s1 = "30";
		else
			s1 = "31";
		return String.valueOf(i) + "年" + String.valueOf(j) + "月" + s1 + "日";
	}

	public static String getMonthBetween(String s, int i) {
		int j;
		int k;
		String s1;
		j = Integer.parseInt(s.substring(0, 4));
		k = Integer.parseInt(s.substring(4, 6));
		s1 = "";
		if (s.length() > 6)
			s1 = s.substring(6, s.length());
		for (k += i; k <= 0; k += 12)
			j--;

		for (; k > 12; k -= 12)
			j++;

		if (k < 10)
			return Integer.toString(j) + "0" + Integer.toString(k) + s1;
		return Integer.toString(j) + Integer.toString(k) + s1;

	}

	public static String getMonthBetween(String s, String s1) {
		String s2;
		if (s.equals("") || s1.equals("") || s.length() != 6
				|| s1.length() != 6) {
			s2 = "";
		} else {
			int i = Integer.parseInt(s.substring(0, 4)) * 12
					+ Integer.parseInt(s.substring(4, 6));
			int j = Integer.parseInt(s1.substring(0, 4)) * 12
					+ Integer.parseInt(s1.substring(4, 6));
			s2 = String.valueOf(i - j);
		}
		return s2;
	}
   /**
    * 
    * @param s (yyyyMMDDhhmmss)
    * @return
    */
	public static String getStrHaveAcross(String s) {
		return s.substring(0, 4) + "-" + s.substring(4, 6) + "-"
				+ s.substring(6, 8);

	}

	public static String getFirstDayOfNextMonth() {
		String s = getCurrentDate_String();
		return increaseYearMonth(s.substring(0, 6)) + "01";
	}

	public static Integer getPrevDate(Integer time) {
		String str = String.valueOf(time);
		str = str.substring(0, 4) + "-" + str.substring(4, 6) + "-"
				+ str.substring(6);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(str);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
			str = format.format(c.getTime());
			str = str.substring(0, 4) + str.substring(5, 7) + str.substring(8);
			time = Integer.valueOf(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	static {
		LogFactory.getLog("wooh");
	}

	public static Integer getNowDate() {
		Calendar c = Calendar.getInstance();
		String year = c.get(Calendar.YEAR) + "";
		int month = c.get(Calendar.MONTH) + 1;
		String mo = "";
		String da = "";
		if (month < 10) {
			mo = "0" + month;
		} else {
			mo = month + "";
		}
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			da = "0" + day;
		} else {
			da = "" + day;
		}
		return Integer.valueOf(year + "" + mo + "" + da);
	}

	/**
	 * 传入时间格式
	 * 
	 * @param str
	 * @return
	 */
	public static String getDate_str(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		return sdf.format(new Date());
	}

	/**
	 * TODO(将字符串转换成时间类型)
	 * 
	 * @author EX-LIAOKUNLIN001
	 * @param str
	 *            时间
	 * @return
	 * @throws BusinessException
	 *             Date
	 * @createDate 2015-8-10
	 */
	public static Date strToDate(String str) {
		SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = timeformat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * TODO(计算两个日期之间相隔天数)
	 * 
	 * @author EX-LIAOKUNLIN001
	 * @param d1
	 * @param d2
	 * @return long
	 * @createDate 2015-8-10
	 */
	public static long dateDiff(Date d1, Date d2) {
		long n1 = d1.getTime();
		long n2 = d2.getTime();
		long diff = Math.abs(n1 - n2);
		diff /= 3600 * 1000 * 24;
		return diff;
	}
}
