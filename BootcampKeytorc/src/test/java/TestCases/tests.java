package TestCases;

import org.junit.jupiter.api.*;
import page.homePage;
import page.loginPage;
import page.productPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


@TestInstance (TestInstance.Lifecycle.PER_CLASS)
public class tests {

    private WebDriver driver;
    private homePage homePage;
    private loginPage loginPage;
    private productPage productPage;


    @BeforeAll
    public void setUp(){
        System.setProperty("wendriver.chrome.driver", "C:\\Users\\Fatih\\Desktop\\Keytorc Bootcamp\\KeytorcProje\\BootcampKeytorc\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-arigins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        homePage = new homePage(driver);
        loginPage= new loginPage(driver);
        productPage = new productPage(driver);

        driver.get("https://www.vatanbilgisayar.com");
    }

    @Test
    void test1() throws IOException, InterruptedException { //Login
        System.out.println("test1");
        homePage.click(homePage.loginButton);
        homePage.click(homePage.loginClick);
        loginPage.getEmail(loginPage.userName);
        loginPage.getPassword(loginPage.password);
        loginPage.click(loginPage.loginButton);
        Thread.sleep(2000l);
        homePage.isOnRight(homePage.myAccount,"HESABIM");
    }

    @Test
    void test2() { // Search product and cheapest
        System.out.println("test2");
        homePage.click(homePage.searchBox);
        homePage.dataSendKeys(homePage.searchBox, "Playstation 4");
        homePage.click(homePage.searchIcon);
        homePage.isOnRight(homePage.productNameVerify, "Playstation 4");
        homePage.cheapestProduct(homePage.productPrice);
    }

    @Test
    void test3() throws InterruptedException { // cart and logout
        System.out.println("test3");
        productPage.click(productPage.addToCart);
        Thread.sleep(3000l);
        productPage.click(productPage.goToCart);
        Thread.sleep(2000l);
        productPage.isOnRight(productPage.priceVerify, "319,00 TL");
        productPage.click(productPage.vatanLogo);
        homePage.click(productPage.myAccount);
        homePage.click(productPage.logOut);
    }

}
