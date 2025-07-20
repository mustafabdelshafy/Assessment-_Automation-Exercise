package org.afaqy.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils() {
        super();
    }

    public final static String PROPERTIES_PATH = "src/main/resources/";

    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();

            // ✅ تحميل ملف environment الثابت
            String envFile = PROPERTIES_PATH + "automationexercise.properties";

            // ✅ تحميل ملف web.properties
            String webFile = PROPERTIES_PATH + "web.properties";

            try (FileInputStream envInput = new FileInputStream(envFile)) {
                properties.load(envInput);
            }

            try (FileInputStream webInput = new FileInputStream(webFile)) {
                properties.load(webInput);
            }

            // ✅ دمج كل الخصائص مع system properties
            properties.putAll(System.getProperties());
            System.getProperties().putAll(properties);

            LogsUtil.info("✅ Loaded environment properties for: automationexercise");
            return properties;

        } catch (Exception e) {
            LogsUtil.error("❌ Failed to Load Environment Properties File: " + e.getMessage());
            return null;
        }
    }

    public static String getPropertyValue(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsUtil.error(e.getMessage());
            return "";
        }
    }
}
