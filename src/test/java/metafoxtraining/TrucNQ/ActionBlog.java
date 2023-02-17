package metafoxtraining.TrucNQ;

import metafoxtraining.TrucNQ.PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBlog {
    WebDriver driver ;
    WebDriverWait wait;
    PageObject pageObject;

    public void loginSite() throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","D:\\Chrome Driver\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='inputEmail']")));
        pageObject = new PageObject(driver);
        pageObject.loginMetafox("daklak", "12345678");
        Thread.sleep(5000);
    }

    public void createBlog() throws InterruptedException{
        driver.get("https://preview.metafox.app/blog/add");
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inputTitle']")));
        Thread.sleep(5000);
        pageObject.createBlogMetafox("daklak", "12345678");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        pageObject.setFlashMessage();
        Thread.sleep(2000);
    }

    public void updateBlog() throws InterruptedException{
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        Thread.sleep(5000);
        pageObject.editBlogMetafox("test edit blog");



    }

    public void deleteBlog() throws InterruptedException{
        wait =new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        Thread.sleep(5000);
        pageObject.deleteBlogMetafox();
        Thread.sleep(2000);

    }
}
