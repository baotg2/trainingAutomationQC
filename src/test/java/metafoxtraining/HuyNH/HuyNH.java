package metafoxtraining.HuyNH;

import metafoxtraining.HuyNH.pageObject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HuyNH {

    WebDriver driver;
    WebDriverWait wait;
    PageObject pageObject;


    public void loginSite() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://preview.metafox.app");
        driver.manage().window().maximize();
    }
    public void loginUser() {
        wait = new WebDriverWait(driver, 30);
        pageObject = new PageObject(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getUsername()));
        pageObject.loginMetaFox("hoanghuy1", "12345678");

    }
    public void myBlogs() {
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getUserLogin()));
            driver.get("https://preview.metafox.app/blog/my");
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getBlogDetail()));
            pageObject.clickBlogDetail();
    }
    public void like()  {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getLikeButton()));
            pageObject.clickLikeButton();
    }
    public void comment() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCommentBox()));
            pageObject.commentBlog("auto_cmt");
   }
    public void shareTheBlog() throws InterruptedException {
            pageObject.shareBlog();
            driver.quit();
        }
    }

