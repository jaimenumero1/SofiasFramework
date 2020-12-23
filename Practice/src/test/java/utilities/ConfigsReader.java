package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    private static Properties properties;

    static{
        //here we will load our config file so that this class can read from it
        try {

            String path = "src/test/resources/configs.properties";

            FileInputStream input = new FileInputStream(path);

            properties = new Properties();
            properties.load(input);
            input.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }


    //only one method to read a value from configs.properties file
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
