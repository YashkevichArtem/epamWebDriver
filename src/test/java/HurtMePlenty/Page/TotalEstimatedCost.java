package HurtMePlenty.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TotalEstimatedCost {
    private WebDriver driver;

    public TotalEstimatedCost(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String expectedVmClass() {
        return driver.findElement(By.xpath("//md-list-item//div[contains(text(),'VM class: regular')]")).getText();
    }

    public String expectedInstanceType() {
        return driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy']//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']")).getText();
    }

    public String expectedRegion() {
        return driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Region: Frankfurt')]")).getText();
    }

    public String expectedLocalSSD() {
        return driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']"))
                .getText();
    }

    public String expectedCommitmentTerm() {
        return driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'Commitment term: 1 Year')]"))
                .getText();
    }

    public String expectedTotalCost() {
        return driver.findElement(By.xpath("//h2[@class='md-title']//b")).getText();
    }
}
