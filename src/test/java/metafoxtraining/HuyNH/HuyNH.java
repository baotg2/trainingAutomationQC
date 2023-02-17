package metafoxtraining.HuyNH;

import metafoxtraining.HuyNH.pageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HuyNH {

    WebDriver driver;
    WebDriverWait wait;
    PageObject pageObject;


    public void loginSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://preview.metafox.app");
        driver.manage().window().maximize();
    }
    public void Login() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inputEmail']")));
        pageObject = new PageObject(driver);
        pageObject.loginMetaFox("hoanghuy1", "12345678");

    }
    public void MyBlogs() {
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='user']//span[contains(text(),'hoanghuy1')]")));
            driver.get("https://preview.metafox.app/blog/my");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@data-testid='itemTitle']//a")));
            pageObject.clickBlogDetail();
    }
    public void like()  {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='reactionButton']")));
//            Actions action = new Actions(driver);
//            action.moveToElement(driver.findElement(By.xpath("//button[@data-testid='reactionButton']"))).perform();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@aria-label='Love' and @data-testid='itemReaction']")));
//            driver.findElement(By.xpath("//img[@aria-label='Love' and @data-testid='itemReaction']")).click();
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//button[@data-testid='reactionButton']")).click();
        pageObject.clickLikeButton();
    }
    public void comment() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fieldComment']//div[contains(text(),'Write a comment...')]")));
//            driver.findElement(By.xpath("//button[@data-testid='commentButton']")).click();
//            driver.findElement(By.xpath("//div[@data-testid='fieldComment']//following-sibling::div//div")).sendKeys("123", ENTER);
//            driver.findElement(By.xpath("//div[@data-testid="fieldComment"]")).sendKeys("huy cmt", ENTER);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='comment']//p[contains(text(),'huy cmt')]")));
//            WebElement checkPoint = driver.findElement(By.xpath("//div[@data-testid='comment']//p[contains(text(),'huy cmt')]"));
//            checkPoint.isDisplayed();
        pageObject.commentBlog("huycmt");
   }
    public void Share() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='menuShareButton']")));
            driver.findElement(By.xpath("//button[@data-testid='menuShareButton']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='share_now']")));
            driver.findElement(By.xpath("//div[@data-testid='share_now']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
            WebElement flashMessage = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));
            flashMessage.isDisplayed();
            driver.get("https://preview.metafox.app/hoanghuy1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'shared a post')]")));
            WebElement checkPointShare = driver.findElement(By.xpath("//span[contains(text(),'shared a post')]"));
            checkPointShare.isDisplayed();
            driver.quit();
        }
    }

