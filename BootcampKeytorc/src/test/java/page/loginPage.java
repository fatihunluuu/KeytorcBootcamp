package page;

import org.openqa.selenium.WebDriver;

public class loginPage extends page{

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public final String userName = "//input[@id='email']";
    public final String password = "//input[@id='pass']";
    public final String loginButton = "//button[@id='login-button']";
}
