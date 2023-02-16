package metafoxtraining.ThuNM;
import static org.junit.Assert.*;

import metafoxtraining.ThuNM.pageObject.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class thu_bai {
    WebDriver driver;
    WebDriverWait wait;

    PageObject pageObject;
    public void getBrownser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");
    }
    public void Login() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        pageObject = new PageObject(driver);
        wait.until (ExpectedConditions.visibilityOfElementLocated (pageObject.getUsername ()));
        pageObject.Login("Kaitlyn","123123123");
    }

    public void BlogsApp() throws InterruptedException {
        Thread.sleep (5000);
        driver.get ("https://preview.metafox.app/blog");
    }
    public void FeatureOption() throws InterruptedException {
        wait.until (ExpectedConditions.visibilityOfElementLocated (pageObject.getMoreactions ()));
        pageObject.clickMoreActions ();
        Thread.sleep (4000);
        List<WebElement> unfeatured = pageObject.unFeature ();
        if(unfeatured.size()!=0){
            unfeatured.get (0).isDisplayed ();
            unfeatured.get (0).click ();
        }
        else {
            pageObject.clickFeature ();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFlagMessage ()));
        pageObject.displayMessage ();
    }

    public void SaveOption() throws InterruptedException {
        Thread.sleep (2000);
        pageObject.clickMoreActions ();
        Thread.sleep (4000);
        List<WebElement> save = pageObject.save ();
        if(save.size()!=0){
            save.get (0).isDisplayed ();
            save.get (0).click ();
        }else{
            pageObject.clickUnsave ();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFlagMessage()));
        pageObject.displayMessage ();
    }

    public void ReportOption() throws InterruptedException {
        Thread.sleep (5000);
        pageObject.clickMoreActions ();
        Thread.sleep (4000);
        pageObject.clickReport ();
        wait.until (ExpectedConditions.visibilityOfElementLocated (pageObject.getSubmitReport ()));
        pageObject.clickSubmitReport ();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFlagMessage ()));
        pageObject.displayMessage ();
        Thread.sleep (3000);
        driver.quit ();
    }
}
