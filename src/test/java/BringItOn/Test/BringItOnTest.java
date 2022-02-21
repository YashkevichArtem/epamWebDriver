package BringItOn.Test;

import BringItOn.Page.PastebinHomePage;
import BringItOn.Page.PastebinPostedPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void newPaste() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.openPage();
        jse.executeScript("window.scrollBy(0,500)");
        homePage.addCode();
        homePage.selectSyntaxHighlighting();
        homePage.selectPasteExpiration();
        homePage.addNameTitle();
        homePage.createNewPaste();
    }

    @Test(priority = 1)
    public void checkResultFieldPasteNameTitle() {
        String expectedPasteNameTitle = new PastebinPostedPage(driver).expectedPasteNameTitle();
        Assert.assertTrue(expectedPasteNameTitle.contains("how to gain dominance among developers")
                ,"Actual 'Paste Name/Title' is false.");
    }

    @Test(priority = 2)
    public void checkSyntaxHighlighting() {
        String expectedSyntaxHighlighting = new PastebinPostedPage(driver).expectedSyntaxHighlighting();
        Assert.assertTrue(expectedSyntaxHighlighting.contains("Bash")
                ,"Actual 'Syntax Highlighting' is false.");
    }

    @Test(priority = 3)
    public void checkCode() {
        String expectedCode = new PastebinPostedPage(driver).expectedCode();
        Assert.assertTrue(expectedCode.contains("git config --global user.name  \"New Sheriff in Town\"\n"
        + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
        + "git push origin master --force"),"Actual code is false.");
    }

    @AfterTest
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
