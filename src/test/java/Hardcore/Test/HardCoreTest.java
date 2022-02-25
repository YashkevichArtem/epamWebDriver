package Hardcore.Test;

import Hardcore.Page.GoogleCloudCalculatorConfiguration;
import Hardcore.Page.GoogleCloudHomePage;
import Hardcore.Page.GoogleCloudResultsPage;
import Hardcore.Page.YopMail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardCoreTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void searchCalculator(){
        GoogleCloudHomePage homePage = new GoogleCloudHomePage(driver);
        homePage.openPage();
        homePage.searchCalculator();
    }

    @Test(priority = 1)
    public void getCalculator() {
        GoogleCloudResultsPage resultsPage = new GoogleCloudResultsPage(driver);
        resultsPage.getCalculator();
    }

    @Test(priority = 2)
    public void setCalculatorConfiguration() {
        GoogleCloudCalculatorConfiguration calcConf = new GoogleCloudCalculatorConfiguration(driver);
        calcConf.calculatorConfiguration();
    }

    @Test(priority = 3)
    public void createMail() {
        GoogleCloudCalculatorConfiguration calcConf = new GoogleCloudCalculatorConfiguration(driver);
        String totalEstimatedCost = calcConf.getTotalEstimatedCost();
        YopMail yopMail = new YopMail(driver);
        yopMail.MailService();
        yopMail.MailBox();
        Assert.assertTrue(yopMail.getTotalCost().contains(totalEstimatedCost));
    }

    @AfterTest
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
