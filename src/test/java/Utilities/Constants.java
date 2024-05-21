package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    // FrameWork Level Constants
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String DATE_NOW = new SimpleDateFormat("MMddyyyy").format(new Date());
    public static final String CAP_PATH = "src/test/resources/CapabilitiesFile.Json";
    public static final String OUTPUT_DIRECTORY = USER_DIR + "/testOutput/extent-reports/";
    public static final String REPORT_DIR = OUTPUT_DIRECTORY + DATE_NOW + "_report/";
    public static final String RESOURCES_PATH = USER_DIR+ "/src/test/resources/";
    public static final String SCREENSHOT_PATH = REPORT_DIR + "/";


    //Test required constants
    public static String FAV_LEAGUE = "Fav League";
}
