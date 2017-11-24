package runner;

import configuration.configBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.LoginPO;

public class TestRunner {

    public void login(){


    }

    public static  void main(String[] args){

        configBrowser.getInstance().initiateBrowser();
        WebDriver driver = configBrowser.getInstance().getDriver();
        driver.get("http://34.227.27.131/embed/menu");

    }
}
