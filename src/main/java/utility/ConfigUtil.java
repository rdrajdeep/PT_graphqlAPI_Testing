package utility;

import configuration.configBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

public class ConfigUtil {

    private static Properties properties= new Properties();
    private static FileInputStream fis= null;
    private WebDriver driver = configBrowser.getInstance().getDriver();
    private WebElement element;

    //@BeforeClass
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

    public void driverWait(int timeInMili){

       // System.out.println("web driver waiting for element to be found, wait time- "+timeInMili);
        WebDriverWait wait = new WebDriverWait(driver,timeInMili);

    }

    public void explicitlyWait(){

    }

    //@BeforeClass
    public static Set <Object> keySet(){
        setProperties();
        return properties.keySet();
    }

    public WebElement webElement (By locator){

        try {
            this.driverWait(1000);
            element= driver.findElement(locator);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return element;
    }

    public void sendTextInField(By locator, String input){
        try{

            element=this.webElement(locator);
            element.sendKeys(input);

        }   catch (NoSuchElementException e){
             e.printStackTrace();
             System.out.println(e.getMessage());
        }
    }

}
