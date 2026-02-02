package CommonUtil;

import java.io.InputStream;
import java.util.Properties;

public class configManager {


    private static  final Properties properties = new Properties();

    static {
        try {
            InputStream input = configManager.class
                    .getClassLoader().getResourceAsStream("config/config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties file does not exist in test/Resources");
            }
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("failed to load config.properties", e);
        }

    }

    private configManager() {

    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

