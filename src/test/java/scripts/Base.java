package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaCarsPage;
import pages.CarvanaHomePage;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait wait;
    Wait fluentWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarsPage carvanaCarsPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        js =(JavascriptExecutor) driver;
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaCarsPage = new CarvanaCarsPage(driver);

    }

    @AfterMethod
    public void teardown(){
        //TODO If there is a failure take a screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }

}

