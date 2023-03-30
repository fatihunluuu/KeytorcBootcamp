package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends page{

    public homePage(WebDriver driver) {
        super(driver);
    }

    public final String loginButton = "//span[@id='type']";
    public final String loginClick = "//a[.='Giriş Yap']";
    public final String myAccount = "//span[@id='type']";
    public final String searchBox = "//input[@id='navbar-search-input']";
    public final String searchIcon = "//span[@class='icon-search']";
    public final String productNameVerify = "//strong[.='Playstation 4']";
    public final String productPrice = "//span[@class='product-list__price']";
}
