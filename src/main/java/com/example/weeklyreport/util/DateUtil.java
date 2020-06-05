package com.example.weeklyreport.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <br>
 * 〈功能详细描述〉
 *
 * @author dpf
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYYMMDD_SLASH = "yyyy/MM/dd";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYYMMDD = "yyyyMMdd";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_CN_TIME = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYY_MM_DD = "yyyy-MM-dd";


    /**
     * 时间常量
     */
    private static final String DATEFORMATE_HHMMSS = "HHmmss";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYYY_MM = "yyyy-MM";

    /**
     * 年月日常量
     */
    private static final String DATEFORMATE_YYMMDD = "yyMMdd";

    /**
     * 年月日:时分秒 常量
     */
    private static final String DATEFORMATE_YYYYMMDD_HHMMSS = "yyyyMMdd:HHmmss";

    /**
     * 日期常量
     */
    private static final String DATEFORMATE_DD = "dd";

    /**
     *
     * 功能描述: <br>
     * 根据指定格式对日期进行格式化
     *
     * @param date
     * @param format
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String parseDate(Date date, String format) {
        if (null == date){
            return "";
        }
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.format(date);
    }

    /**
     *
     * 功能描述: <br>
     * 获得当前时间
     *
     * @return
     * @see
     * @since
     */
    public static java.sql.Date getCurDate() {
        return getDate(getCurTime());
    }

    /**
     *
     * 功能描述: <br>
     * 获得当前时间
     *
     * @return
     * @see
     * @since
     */
    public static Timestamp getCurTime() {
        return new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public static String getCurYYYY_MM_DD() {
        DateFormat YYYY_MM_DD = new SimpleDateFormat(DATEFORMATE_YYYY_MM_DD);
        return YYYY_MM_DD.format(getCurTime());
    }

    public static String getCurHHMMSS() {
        DateFormat HHMMSS = new SimpleDateFormat(DATEFORMATE_HHMMSS);
        return HHMMSS.format(getCurTime());
    }

    public static String getFormatCurDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATEFORMATE_YYYY_MM_DD_HHMMSS);
        Date curdate = getCurDate();
        return formatter.format(curdate);
    }







    /**
     *
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getTime() {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        return time.toString();
    }

    /**
     * 得到当前日期
     *
     * @param type :0日期中间横线;1：有横线
     * @return
     */
    public static String getDate(int type) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);

        int month = now.get(Calendar.MONTH) + 1;

        int day = now.get(Calendar.DAY_OF_MONTH);

        String sMonth = String.valueOf(month);

        if (sMonth.length() == 1) {
            sMonth = 0 + sMonth;
        }

        String sDay = String.valueOf(day);
        if (sDay.length() == 1) {
            sDay = 0 + sDay;
        }

        String tDate = String.valueOf(year) + "-" + sMonth + "-" + sDay;
        if (type == 0) {
            tDate = String.valueOf(year) + sMonth + sDay;
        }

        return tDate;
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成java.util.Date
     *
     * @param dateStr
     * @return
     */
    public static java.util.Date getDateOfStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date da = null;
        try {
            da = df.parse(dateStr);
        } catch (Exception e) {
            logger.debug("转换异常" + e);
        }
        return da;

    }

    /**
     * 把yyyy-MM-dd HH:mm:ss格式的字符串转换成java.util.Date
     *
     * @param dateStr
     * @return
     */
    public static java.util.Date getDateOfLongStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date da = null;
        try {
            da = df.parse(dateStr);
        } catch (Exception e) {
            logger.debug("转换异常" + e);
        }
        return da;
        /*
         * Date date = Date.valueOf(dateStr); return new Timestamp(date.getTime());
         */
    }

    /**
     * 把yyyyMMdd格式的字符串转换成java.util.Date
     *
     * @param dateStr
     * @return
     */
    public static Date getDateOfShortStr(String dateStr) {
        Date da = null;
        try {
            DateFormat YYYYMMDD_FORMAT = new SimpleDateFormat(
                    DATEFORMATE_YYYYMMDD);
            da = new Date(YYYYMMDD_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        }
        return da;
    }

    /**
     * 把yyyyMMddHHmmss格式的字符串转换成java.util.Date
     *
     * @param dateStr
     * @return
     */
    public static Date getDateOfLongtStr(String dateStr) {
        Date da = null;
        try {
            DateFormat YYYYMMDDHHMMSS_FORMAT = new SimpleDateFormat(
                    DATEFORMATE_YYYYMMDDHHMMSS);
            da = new Date(YYYYMMDDHHMMSS_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        }
        return da;
    }

    /**
     * 把日期转换成 yyyyMMdd格式的字符串
     *
     * @param date
     * @return
     */
    public static String getShortStrDate(java.util.Date date) {
        DateFormat YYYYMMDD_FORMAT = new SimpleDateFormat(DATEFORMATE_YYYYMMDD);
        return YYYYMMDD_FORMAT.format(date);
    }

    /**
     * 把日期转换成 yyyyMMddHHmmss格式的字符串
     *
     * @param date
     * @return
     */
    public static String getShortStrDateTime(java.util.Date date) {
        DateFormat YYYYMMDDHHMMSS_FORMAT = new SimpleDateFormat(
                DATEFORMATE_YYYYMMDDHHMMSS);
        return YYYYMMDDHHMMSS_FORMAT.format(date);
    }

    /**
     * 把yyyyMMdd格式字符串转换成 java.sql.Date
     *
     * @param dateStr
     * @return
     */
    public static java.sql.Date getSqlDateByShortStr(String dateStr) {
        java.sql.Date da = null;
        try {
            DateFormat YYYYMMDD_FORMAT = new SimpleDateFormat(
                    DATEFORMATE_YYYYMMDD);
            da = new java.sql.Date(YYYYMMDD_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        }
        return da;
    }

    /**
     * 把yyyyMMddHHmmss格式字符串转换成 java.sql.Date
     *
     * @param dateStr
     * @return
     */
    public static java.sql.Date getSqlDateTimeByShortStr(String dateStr) {
        java.sql.Date da = null;
        try {
            DateFormat YYYYMMDDHHMMSS_FORMAT = new SimpleDateFormat(
                    DATEFORMATE_YYYYMMDDHHMMSS);
            da = new java.sql.Date(YYYYMMDDHHMMSS_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        }
        return da;
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Timestamp
     *
     * @param dateStr
     * @return Timestamp
     */
    public static Timestamp getTimeOfDateStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(dateStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {
        }
        return time;
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Timestamp，且该时间是该天的最后时间
     *
     * @param dateStr
     * @return Timestamp
     */
    public static Timestamp getTimeEndOfDateStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(dateStr);
            time = new java.sql.Timestamp(da.getTime()
                    + 24
                    * 60
                    * 60
                    * 100L
                    - 1);
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {

        }
        /*
         * Date date = Date.valueOf(dateStr); date.setTime(date.getTime() + 24 * 60 * 60 * 1000 - 1); return new
         * Timestamp(date.getTime());
         */
        return time;
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Timestamp，且该时间是该天的开始时间
     *
     * @param dateStr
     * @return Timestamp
     */
    public static Timestamp getTimeBeginOfDateStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(dateStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {

        }

        return time;
    }

    /**
     * 把yyyy-MM-dd HH:mm:ss.S格式的字符串转换成Timestamp
     *
     * @param timeStr
     * @return Timestamp
     */
    public static Timestamp getTimeOfTimeStr(String timeStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(timeStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {

        }

        return time;
    }

    /**
     * 把yyyy-MM-dd HH:mm:ss.S格式的字符串转换成Date
     *
     * @param timeStr
     * @return Timestamp
     */
    public static Date getDateOfTimeStr(String timeStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date da = null;
        try {
            da = df.parse(timeStr);

        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {

        }

        return da;
    }

    /**
     * 把pattern格式的字符串转换成Timestamp
     *
     * @param timeStr
     * @return Timestamp
     */
    public static Timestamp getTimeOfTimeStr(String timeStr, String pattern) {
        DateFormat df = new java.text.SimpleDateFormat(pattern);
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(timeStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
            logger.debug("转换异常：" + e);
        } finally {

        }
        return time;
    }

    /**
     * 根据Timestamp获得日期
     *
     * @param time
     * @return java.sql.Date
     */
    public static java.sql.Date getDate(Timestamp time) {
        return (new java.sql.Date(time.getTime()));
    }

    /**
     * 获取给定日期中的当月第几号
     *
     * @param t
     * @return
     */
    public static int getDate(Date t) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTimeInMillis(t.getTime());

        return now.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得对应时间time的相应field的值。 如获得当前时间的分钟，则调用方式如下 getTimeFieldStr(getCurTime(), Calendar.MINUTE)
     *
     * @param time
     * @param field
     * @return String
     */
    public static String getTimeFieldStr(Timestamp time, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date(time.getTime()));
        int fieldValue = calendar.get(field);
        if (field == Calendar.MONTH)
            fieldValue++;
        return String.valueOf(fieldValue);
    }

    /**
     * 获得时间time对应的中文日期的字符串
     *
     * @param time
     * @return String -- 如 2003年5月12日
     */
    public static String getDateCn(Timestamp time) {
        if (time == null)
            return null;
        String dateCn = getTimeFieldStr(time, Calendar.YEAR) + "年" + getTimeFieldStr(time, Calendar.MONTH) + "月"
                + getTimeFieldStr(time, Calendar.DATE) + "日";
        return dateCn;
    }

    /**
     * 获得时间time对应的中文日期的字符串
     *
     * @param time
     * @return String -- 如 2003-5-12
     */
    public static String getDateString(Timestamp time, String v) {
        String dateCn = getTimeFieldStr(time, Calendar.YEAR) + v + getTimeFieldStr(time, Calendar.MONTH) + v
                + getTimeFieldStr(time, Calendar.DATE);
        return dateCn;
    }

    /**
     * 获得日期dateStr是星期几，日期格式是“yyyy-MM-dd”
     *
     * @param dateStr
     * @return String -- 如 星期日
     */
    public static String getDayOfWeekCn(String dateStr) {
        Calendar cal = Calendar.getInstance();
        String weekCn = null;
        Timestamp time = getTimeOfDateStr(dateStr);
        if (time != null) {
            cal.setTime(time);
            int day = cal.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case 1:
                    weekCn = "星期日";
                    break;
                case 2:
                    weekCn = "星期一";
                    break;
                case 3:
                    weekCn = "星期二";
                    break;
                case 4:
                    weekCn = "星期三";
                    break;
                case 5:
                    weekCn = "星期四";
                    break;
                case 6:
                    weekCn = "星期五";
                    break;
                case 7:
                    weekCn = "星期六";
                    break;
                default:
                    weekCn = "";
            }
        }
        return weekCn;
    }

    /**
     * 将 Timestamp 对应的日期以 "yyyy-MM-dd" 格式返回一个字符串
     *
     * @param stamp
     * @return
     */
    public static String formatDate(Timestamp stamp) {
        if (stamp == null){
            return "";
        }

        return new java.sql.Date(stamp.getTime()).toString();
    }

    /**
     * 格式化日期格式返回字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDDformateDateString(java.util.Date date) {
        DateFormat DATEFORMATE_DD = new SimpleDateFormat(
                "dd");
        return formateDate(date,DATEFORMATE_DD);
    }



    public static String getFormatDate(java.util.Date date) {
        String customDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        customDate = formatter.format(date);
        return customDate;
    }



    /**
     * 格式化日期格式返回字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formateDate(java.util.Date date, DateFormat dateFormat) {
        return dateFormat.format(date);
    }


}
