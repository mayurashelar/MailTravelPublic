package org.mailtravel.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    /**
     * Initialising properties file
     * @return properties object
     */
    public Properties propertiesInit()  {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(file);        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            return prop;
    }

}
