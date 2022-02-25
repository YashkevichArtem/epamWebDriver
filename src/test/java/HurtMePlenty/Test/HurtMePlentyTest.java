package HurtMePlenty.Test;

import HurtMePlenty.Page.GoogleCloudCalculatorConfiguration;
import HurtMePlenty.Page.GoogleCloudHomePage;
import HurtMePlenty.Page.GoogleCloudResultsPage;
import HurtMePlenty.Page.TotalEstimatedCost;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

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
    public void checkVMClass() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedVmClass().contains("VM class: regular"),"Actual 'VM Class' is false.");
    }

    @Test(priority = 4)
    public void checkInsType() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedInstanceType().contains("Instance type: n1-standard-8\nCommitted Use Discount applied"),"Actual 'Instance type' is false.");
    }

    @Test(priority = 5)
    public void checkRegion() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedRegion().contains("Region: Frankfurt"),"Actual 'Region' is false.");
    }

    @Test(priority = 6)
    public void checkLocalSSD() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedLocalSSD().contains("Local SSD: 2x375 GiB\nCommitted Use Discount applied"));
    }

    @Test(priority = 7)
    public void checkCommTerm() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedCommitmentTerm().contains("Commitment term: 1 Year"));
    }

    @Test(priority = 8)
    public void checkTotalCost() {
        TotalEstimatedCost total = new TotalEstimatedCost(driver);
        Assert.assertTrue(total.expectedTotalCost().contains("Total Estimated Cost: USD 1,082.77 per 1 month"));
    }

    @AfterTest
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
