package club.banyuan.studyroom.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateUtils {

    public final static String DATE_STYLE = "yyyy-MM-dd";

    public static String getTodayDate() {
        Date date = new Date();
        return DateUtil.format(date, DATE_STYLE);
    }

    public static int getCurrentHour() {
        Date date = new Date();
        return Integer.parseInt(DateUtil.format(date, "HH"));
    }

    public static String getDate(int offset) {
        Date date = new Date();
        return DateUtil.format(DateUtil.offsetDay(date, offset), DATE_STYLE);
    }

}
