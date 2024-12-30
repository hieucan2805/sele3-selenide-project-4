package htt.utils;

import java.time.Duration;

public class Constants {
    // url
    public static final String GOOGLE = "https://google.com";
    public static final String VIETJET_EN = "https://www.vietjetair.com/en";
    public static final String VIETJET_VI = "https://www.vietjetair.com/vi";
    public static final String GRID_HUB_URL = "http://192.168.1.10";

    public static final String PROPERTIES_FILE_PATH_ROOT = PropertiesUtils.getValue("PROPERTIES_FILE_PATH_ROOT");
    public static final String BROWSER_PROPERTIES_FILE_PATH_ROOT = PropertiesUtils.getValue("BROWSER_PROPERTIES_FILE_PATH_ROOT");

    //Date Time Format
    public static final String TIME_FORMAT_CURRENT_DATE_TIME = "MM_dd_yyyy_HH_mm_ss";

    //Time out
    public static final Duration SHORT_WAIT = Duration.ofSeconds(3);
}