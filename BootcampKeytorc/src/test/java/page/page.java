package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class page {

    WebDriver driver;

    public page(WebDriver driver){
        this.driver = driver;
    }

    public void click(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public void dataSendKeys(String locator, String data){
        driver.findElement(By.xpath(locator)).sendKeys(data);
    }

    public void getEmail(String locator) throws IOException {

        File file = new File("C:\\Users\\Fatih\\Desktop\\Keytorc Bootcamp\\KeytorcProje\\BootcampKeytorc\\Notepad\\email.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader2 = new BufferedReader(reader);
        String email = bufferedReader2.readLine();
        bufferedReader2.close();
        driver.findElement(By.xpath(locator)).sendKeys(email);
    }

    public void getPassword(String locator) throws IOException {
        File file = new File("C:\\Users\\Fatih\\Desktop\\Keytorc Bootcamp\\KeytorcProje\\BootcampKeytorc\\Notepad\\password.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String password = bufferedReader.readLine();
        bufferedReader.close();
        driver.findElement(By.xpath(locator)).sendKeys(password);
    }

    public void isOnRight(String locator, String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6L));
        String data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();
        if(data.equals(expected)){
            System.out.println(data+" doğrulaması tamamlandı.");
        }else {
            System.out.println(data+" doğrulaması tamamlanamadı.");
        }
        Assert.assertEquals(data, expected);
    }

    public void cheapestProduct(String locator){
        List<WebElement> productList = driver.findElements(By.xpath(locator));

        String stringCheapest = productList.get(0).getText();
        stringCheapest = stringCheapest.replace(".","");
        int cheapest = Integer.parseInt(stringCheapest);
        int temp;
        int count=0;

        int size = productList.size();
        for (int i = 1; i<size; i++){
            String stringTemp = productList.get(i).getText();
            stringTemp = stringTemp.replace(".","");
            temp = Integer.parseInt(stringTemp);
            if (cheapest>temp){
                cheapest = temp;
                count = i;
            }
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(productList.get(count), 0, -50).click().build().perform();
        System.out.println("En ucuz ürün bulundu.");
    }

}
