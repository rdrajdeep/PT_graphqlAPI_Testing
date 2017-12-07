package pageObjects;

import org.openqa.selenium.By;

public interface logInPO {

     By user_name = By.xpath("//*[@id=\"root\"]/div/div/div[1]/input[1]");
     By password = By.xpath("//*[@id=\"root\"]/div/div/div[1]/input[2]");
     By btn_login = By.xpath("//*[@id=\"root\"]/div/div/div[1]/button[1]");


}
