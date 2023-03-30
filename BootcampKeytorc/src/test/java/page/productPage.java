package page;

import org.openqa.selenium.WebDriver;

public class productPage extends page{

    public productPage(WebDriver driver) {
        super(driver);
    }

    public final String addToCart = "//span[.='Sepete Ekle']";
    public final String goToCart = "//input[@class='btn btn-dark-blue goToBasket']";
    public final String priceVerify = "//td[@class='text-right active']";
    public final String vatanLogo = "//img[@alt='Vatan Bilgisayar']";
    public final String myAccount = "//span[@id='type']";
    public final String logOut = "//a[@href='/MemberTransaction/Logout?returnUrl=%2F&logtab=signup']";
}
