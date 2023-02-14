package metafoxtraining.ThuNM;
import static org.junit.Assert.*;

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

    WebElement moreaction;
    WebElement msg;
    public void getBrownser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");
    }
    public void Login() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@data-testid='inputEmail']")));
        WebElement username = driver.findElement(By.xpath ("//*[@data-testid='inputEmail']"));
        username.isDisplayed ();
        username.sendKeys ("Kaitlyn");
        System.out.println ("username: " + username.getAttribute ("value"));
        WebElement password = driver.findElement (By.xpath ("//*[@data-testid='inputPassword']"));
        password.isDisplayed ();
        password.sendKeys ("123123123");
        WebElement signin = driver.findElement (By.xpath ("//*[@data-testid='buttonLogin']"));
        signin.isDisplayed ();
        signin.click ();
    }

    public void BlogsApp() throws InterruptedException {
        Thread.sleep (5000);
        driver.get ("https://preview.metafox.app/blog");
    }
    public void FeatureOption() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@data-testid='actionMenuButton']")));
        moreaction = driver.findElement (By.xpath ("//*[@data-testid='actionMenuButton']"));
        moreaction.isDisplayed ();
        moreaction.click ();
        Thread.sleep (4000);
        List<WebElement> unfeatured = driver.findElements (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='remove_feature']"));
        if(unfeatured.size()!=0){
            unfeatured.get (0).isDisplayed ();
            unfeatured.get (0).click ();
        }
        else {
            WebElement featured = driver.findElement (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='feature']"));
            featured.isDisplayed ();
            featured.click ();
        }
        msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        msg.isDisplayed ();
    }

    public void SaveOption() throws InterruptedException {
        Thread.sleep (5000);
        moreaction.isDisplayed ();
        moreaction.click ();
        Thread.sleep (4000);
        List<WebElement> save = driver.findElements (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='save']"));
        if(save.size()!=0){
            save.get (0).isDisplayed ();
            save.get (0).click ();
        }else{
            WebElement unsave = driver.findElement (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='un-save']"));
            unsave.isDisplayed ();
            unsave.click ();
        }
        msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        msg.isDisplayed ();
    }
}
