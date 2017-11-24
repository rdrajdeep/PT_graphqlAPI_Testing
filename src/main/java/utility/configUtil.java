package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class configUtil {

    private static Properties properties= new Properties();
    private static FileInputStream fis= null;

    public static void setProperties(){

        try{
                fis= new FileInputStream("configuration.properties");
                properties.load(fis);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static String getProperties(String keyValue){
        setProperties();
        return properties.getProperty(keyValue);
    }

    public static Set <Object> keySet(){
        setProperties();
        return properties.keySet();
    }

}
