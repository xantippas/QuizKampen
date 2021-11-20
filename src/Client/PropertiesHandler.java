package Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    private Properties properties;

    public PropertiesHandler() {
        this.properties = new Properties();
    }

    public void readPropertiesFromPropertyFile () {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("gameConfig.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        }
        catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty (String propertyName) {
        return properties.getProperty(propertyName);
    }


}
