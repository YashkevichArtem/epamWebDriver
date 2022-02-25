package Hardcore.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class YopMail {
    private static final String HOMEPAGE_URL = "https://yopmail.com/ru/";
    private WebDriver driver;
    private String windowCalculator;
    private String mailServiceUrl;
    private String emailAddress;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement mainFrame;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    private WebElement emailFrame;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement totalCost;


    public YopMail(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void MailService() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        windowCalculator = driver.getWindowHandle();
        js.executeScript("window.open()");
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!window.equals(windowCalculator)){
                mailServiceUrl = window;
                break;
            }
        }
        driver.switchTo().window(mailServiceUrl);
        driver.get(HOMEPAGE_URL);
        //Email generator
        driver.findElement(By.xpath("//a[@href='email-generator']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='egen']")));
        emailAddress = driver.findElement(By.xpath("//div[@id='egen']")).getText();
        driver.switchTo().window(windowCalculator);
        driver.switchTo().frame(0);
        driver.switchTo().frame(mainFrame);
        driver.findElement(By.xpath("//form[@name='emailForm']//input[@type='email']")).click();
        driver.findElement(By.xpath("//form[@name='emailForm']//input[@type='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();
        driver.switchTo().window(mailServiceUrl);
    }

    public void MailBox() {
        //Check MailBox
        driver.findElement(By.xpath("//button[@onclick='egengo();']")).click();
        //Refresh
        driver.findElement(By.xpath("//button[@id='refresh']")).click();
        driver.switchTo().frame(emailFrame);
    }

    public String getTotalCost() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return totalCost.getText();
    }
}
