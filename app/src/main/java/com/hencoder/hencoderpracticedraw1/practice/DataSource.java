package com.hencoder.hencoderpracticedraw1.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author yueban
 * @date 2017/7/23
 * @email fbzhh007@gmail.com
 */
public class DataSource {
    public static final HashMap<String, Integer> HISTOGRAM_PLATFORMS = new LinkedHashMap<>();
    public static final HashMap<String, Integer> CHART_PLATFORMS = new LinkedHashMap<>();

    static {
        HISTOGRAM_PLATFORMS.put("Froyo", 1);
        HISTOGRAM_PLATFORMS.put("FB", 2);
        HISTOGRAM_PLATFORMS.put("ICS", 2);
        HISTOGRAM_PLATFORMS.put("JB", 18);
        HISTOGRAM_PLATFORMS.put("KitKat", 28);
        HISTOGRAM_PLATFORMS.put("L", 32);
        HISTOGRAM_PLATFORMS.put("M", 17);

        CHART_PLATFORMS.put("Froyo", 1);
        CHART_PLATFORMS.put("Gingerbread", 2);
        CHART_PLATFORMS.put("Ice Cream Sandwich", 2);
        CHART_PLATFORMS.put("Jelly Bean", 18);
        CHART_PLATFORMS.put("KitKat", 28);
        CHART_PLATFORMS.put("Lollipop", 32);
        CHART_PLATFORMS.put("Marshmallow", 17);
    }
}
