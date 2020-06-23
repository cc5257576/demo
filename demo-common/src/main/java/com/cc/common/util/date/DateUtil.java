package com.cc.common.util.date;


import java.util.*;

/**
 * 时间工具类
 * 
 * @author xiaoleilu
 */
public class DateUtil {


    /**
     * 偏移小时
     *
     * @param date 日期
     * @param offset 偏移小时数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static Date offsetHour(Date date, int offset) {
        return offset(date, DateField.HOUR_OF_DAY, offset);
    }

    /**
     * 获取指定日期偏移指定时间后的时间
     *
     * @param date 基准日期
     * @param dateField 偏移的粒度大小（小时、天、月等）{@link DateField}
     * @param offset 偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static Date offset(Date date, DateField dateField, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(dateField.getValue(), offset);
        return cal.getTime();
    }
}
