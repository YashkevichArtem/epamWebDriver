package Hardcore.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GoogleCloudResultsPage {
    private WebDriver driver;

    public GoogleCloudResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getCalculator() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//div[@class='gs-title']//*[contains(text(),'Google Cloud Pricing Calculator')]")).click();
    }
}
