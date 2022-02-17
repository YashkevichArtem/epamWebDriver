package BringItOn.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PastebinPostedPage {
    private WebDriver driver;

    public PastebinPostedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String expectedPasteNameTitle() {
        String expected = driver.findElement(By.xpath("//div[@class='info-top']//h1[contains(text(),'how to gain dominance among developers')]"))
                .getText();
        return expected;
    }

    public String expectedSyntaxHighlighting() {
        String expected = driver.findElement(By.xpath("//div[@class='left']//a[contains(text(),'Bash')]")).getText();
        return expected;
    }

    public String expectedCode() {
        String expectedCode = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();
        return expectedCode;
    }
}
