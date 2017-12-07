package pageObjects;

import org.openqa.selenium.By;

public  class LoginPO {

    static final By user_name = By.xpath("*//input[@name=usernameInput]");
    static final String password = "*//input[@name=PasswordInput]";
    static final String btn_login = "*//button[@contains[text()='Log in']] ";

}
