package interfell.vehicle.miles.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    private static final String BEAR_ARCH = "INTERFELL-ARCH";

    private LoggerUtils() {}

    public static String formatArchRow(String text) {
        return formatRow(BEAR_ARCH, text);
    }

    public static String formatRow(String label, String text) {
        return String.format("[%s] %s", label, text);
    }

    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }

    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

}
