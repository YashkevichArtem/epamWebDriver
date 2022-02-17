package CanWin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCanWin  {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");

        driver.findElement(By.xpath("//a[@class='header__btn']")).click();
        driver.findElement(By.name("PostForm[text]")).sendKeys("Hello from WebDriver");
        List<WebElement> driverElements = driver.findElements(By.xpath("//span[@class='select2-selection select2-selection--single']"));
        driverElements.get(1).click();
        driver.findElement(By.xpath("//span[@class='select2-results']//li[contains(text(),'10 Minutes')]")).click();
        driver.findElement(By.id("postform-name")).sendKeys("helloweb");
        driver.findElement(By.xpath("//div[@class='form-group form-btn-container']")).submit();

        driver.quit();
    }



}
