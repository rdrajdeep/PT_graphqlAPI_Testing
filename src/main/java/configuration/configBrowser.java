package configuration;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.configUtil;

public class configBrowser {

    private static configBrowser config;
    private configBrowser(){}
    static {
        config=new configBrowser();
    }
    public static configBrowser getInstance(){
        return config;
}

    private String browserName = configUtil.getProperties("Browser");

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void  initiateBrowser( ){

        switch (browserName.toLowerCase()){
            case "chrome":
                    this.launchBrowserByOS();
                    this.setDriver(new ChromeDriver());
                    break;
            case "firefox":
                    this.launchBrowserByOS();
                    this.setDriver(new FirefoxDriver());
                    break;
            case "safari":
                    this.launchBrowserByOS();
                    break;

        }

    }

    public void launchBrowserByOS(){

        System.out.println(OS.isName("Linux"));

       if (OS.isFamilyWindows()){
            System.out.println("launching "+browserName+" browser in OS MS Windows");
            System.setProperty("webdriver.chrome.driver","./Resources/Drivers/chromedriver.exe");
            System.setProperty("webdriver.gecko.driver","./Resources/Drivers/geckodriver.exe");

        }else if (OS.isFamilyUnix()){
            System.out.println("launching "+browserName+" browser in OS Linux");
            System.setProperty("webdriver.chrome.driver","./Resources/Drivers/chromedriver");
            System.setProperty("webdriver.gecko.driver","./Resources/Drivers/geckodriver");

        }else if (OS.isFamilyMac()){
           System.out.println("launching "+browserName+" browser in OS Mac");
           System.setProperty("webdriver.chrome.driver","./Resources/Drivers/chromedriver");
           System.setProperty("webdriver.gecko.driver","./Resources/Drivers/geckodriver");

       }
        else {
            System.out.println("Condition does not match for OS ");
        }

    }

}
