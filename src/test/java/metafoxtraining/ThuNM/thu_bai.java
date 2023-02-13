package metafoxtraining.ThuNM;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class thu_bai {
    public void getBrownser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver ();
//      get url
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until (d -> d.findElement (By.xpath ("//*[@data-testid='inputEmail']")).isDisplayed ());
//      login
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
//        Blogs app
        Thread.sleep (5000);
        driver.get ("https://preview.metafox.app/blog");
//      feature/unfeatures
        wait.until (d -> d.findElement (By.xpath ("//*[@data-testid='actionMenuButton']")).isDisplayed ());
        WebElement moreaction = driver.findElement (By.xpath ("//*[@data-testid='actionMenuButton']"));
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
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        msg.isDisplayed ();
//      save/unsave
        Thread.sleep (4000);
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
        msg.isDisplayed ();
//        Report
//        Thread.sleep (4000);
//        moreaction.isDisplayed ();
//        moreaction.click ();
//        WebElement report = driver.findElement (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='report']"));
//        report.isDisplayed ();
//        report.click ();
//        Thread.sleep (4000);


         driver.quit ();
    }

}
