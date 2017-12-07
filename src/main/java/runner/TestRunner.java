package runner;

import configuration.configBrowser;
import org.openqa.selenium.WebDriver;
import pageObjects.logInPO;
import utility.ConfigUtil;


public class TestRunner {
    private ConfigUtil util= new ConfigUtil();

    public void login(){

        util.sendTextInField(logInPO.user_name, "rajdeep+4"); // Enter user name
        util.sendTextInField(logInPO.password,"rajdeep"); // Enter password
        util.webElement(logInPO.btn_login).click();  // Click log in

    }

    public void registration(){


    }

      public static  void main(String[] args){

        configBrowser.getInstance().initiateBrowser();
        TestRunner run= new TestRunner();
        WebDriver driver = configBrowser.getInstance().getDriver();
        driver.get("http://34.227.27.131/embed/menu");
        run.login();

    }
}
