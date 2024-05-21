package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    // FrameWork Level Constants
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String DATE_NOW = new SimpleDateFormat("MMddyyyy").format(new Date());
    public static final String CAP_PATH = "src/test/resources/CapabilitiesFile.Json";


}
