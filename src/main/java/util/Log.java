package util;

import java.text.SimpleDateFormat;

public class Log {

    private static java.util.Date date;
    private static SimpleDateFormat sdf;

    public static void WriteLine(MessageType mType, String text) {
        date = new java.util.Date();
        sdf = new SimpleDateFormat("HH:mm:ss");

        switch(mType) {
            case INFO:
                System.out.println("[INFO] [" + sdf.format(date) + "] " + text);

            break;

            case ERROR:
                System.out.println("[ERROR] [" + sdf.format(date) + "] " + text);
            break;
        }

    }
}
