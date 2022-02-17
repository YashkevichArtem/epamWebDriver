package BringItOn.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;



    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void addCode() {

        driver.findElement(By.id("postform-text"))
                .sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

    }

    public void selectSyntaxHighlighting() {
        List<WebElement> driverElements = driver.findElements(By.xpath("//span[@class='select2-selection select2-selection--single']"));
        driverElements.get(0).click();
        driver.findElement(By.xpath("//span[@class='select2-results']//li[contains(text(),'Bash')]")).click();
    }

    public void selectPasteExpiration() {
        List<WebElement> driverElements = driver.findElements(By.xpath("//span[@class='select2-selection select2-selection--single']"));
        driverElements.get(1).click();
        driver.findElement(By.xpath("//span[@class='select2-results']//li[contains(text(),'10 Minutes')]")).click();
    }

    public void addNameTitle() {
        driver.findElement(By.id("postform-name")).sendKeys("how to gain dominance among developers");
    }

    public void createNewPaste() {
        driver.findElement(By.xpath("//div[@class='form-group form-btn-container']")).submit();
    }
}
