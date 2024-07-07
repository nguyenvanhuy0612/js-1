package org.huy.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertyUtils {

    public static Properties read(String filePath) {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
