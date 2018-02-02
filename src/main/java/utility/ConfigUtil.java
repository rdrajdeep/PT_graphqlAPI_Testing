package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class ConfigUtil {

    private static Properties properties= new Properties();
    private static FileInputStream fis= null;
    private Logger logger= Logger.getLogger(ConfigUtil.class);
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

    public void configureLogger(){

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss:mmm");

        String currentTime=dateFormat.format(new Date());

        System.setProperty("logFileName","log_"+currentTime+".log");

        String log4jConfigFile = System.getProperty("user.dir")+ File.separator + "log4j.properties";

        PropertyConfigurator.configure(log4jConfigFile);

    }


    public static Set <Object> keySet(){
        setProperties();
        return properties.keySet();
    }

}
