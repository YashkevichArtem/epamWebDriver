package Hardcore.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleCloudCalculatorConfiguration {
    private WebDriver driver;

    @FindBy(xpath = "//h2[@class='md-title']//b[@class='ng-binding']")
    private WebElement TotalEstimatedCost;

    public GoogleCloudCalculatorConfiguration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void calculatorConfiguration() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.switchTo().frame(0);
        WebElement frameIndexTwo = driver.findElement(By.xpath("//iframe[@id='myFrame']"));
        driver.switchTo().frame(frameIndexTwo);
        driver.findElement(By.xpath("//*[@id='input-0']")).sendKeys("Compute Engine");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainForm']/div[1]/md-icon")));
        driver.findElement(By.xpath("//*[@id='mainForm']/div[1]/md-icon")).click();
        //Number of instances: 4
        driver.findElement(By.xpath("//input[@id='input_78']")).click();
        driver.findElement(By.xpath("//input[@id='input_78']")).sendKeys("4");
        //Series
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_73']")).click();
        driver.findElement(By.xpath("//md-option[@value='n1']")).click();
        //Machine type
        driver.findElement(By.xpath("//md-select-value[@id='select_value_label_74']")).click();
        List<WebElement> types = driver.findElements(By.xpath("//md-option[@ng-repeat='instance in typeInfo']"));
        types.get(3).click();
        //Select "Add GPUs"
        driver.findElement(By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")).click();
        //Select GPU Type
        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        List<WebElement> GPUs = driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option"));
        GPUs.get(3).click();
        //Number of GPUs
        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
        List<WebElement> GpuNumbers = driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option"));
        GpuNumbers.get(1).click();

        //Local SSD
        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        List<WebElement> listSSD = driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option"));
        listSSD.get(2).click();
        //Datacenter location
        driver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']")).click();
        List<WebElement> dataCenter = driver.findElements(By.xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']//md-option"));
        wait.until(ExpectedConditions.elementToBeClickable(dataCenter.get(9)));
        dataCenter.get(9).click();
        //Commited usage
        driver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
        List<WebElement> listCommUsage = driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option"));
        listCommUsage.get(1).click();
        //Button 'Add to estimate'
        driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();
        //Button Email Estimate
        driver.findElement(By.xpath("//button[@aria-label='Email Estimate']")).click();
    }

    public String getTotalEstimatedCost() {
        String input = TotalEstimatedCost.getText().replaceAll("Total Estimated Cost: ","");
        return input.replaceAll(" per 1 month","");
        // Я пытался выполнить это с помощью regex, но к сожалению получал ошибку, о том, что matcher.group() пуст.
//        Pattern pattern = Pattern.compile("USD [0-9],[0-9]+.[0-9]+");
//        Matcher matcher = pattern.matcher(input);
//
//        return matcher.group();
    }
}
