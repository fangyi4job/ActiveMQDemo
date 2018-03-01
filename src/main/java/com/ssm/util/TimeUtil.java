package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class TimeUtil {

    public static String getCurrentTime() {
        Date day = new Date();

        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

        System.out.println(df.format(day));

        return df.format(day);
    }
}
