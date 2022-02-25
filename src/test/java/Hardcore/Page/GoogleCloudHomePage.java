package Hardcore.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void searchCalculator() {
        String searchBox = "//div[@class='devsite-searchbox']//input[@name='q']";
        driver.findElement(By.xpath(searchBox)).click();

        driver.findElement(By.xpath(searchBox))
                .sendKeys("Google Cloud Platform Pricing Calculator");
        driver.findElement(By.xpath(searchBox)).submit();
    }
}
