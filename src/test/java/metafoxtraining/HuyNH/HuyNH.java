package metafoxtraining.HuyNH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class HuyNH {

    WebDriver driver;
    WebDriverWait wait;
    public void HuyNH1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://preview.metafox.app");
        driver.manage().window().maximize();
    }
    public void Login() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='inputEmail']")));
        WebElement Usernamebutton = driver.findElement(By.xpath("//*[@data-testid='inputEmail']"));
        Usernamebutton.sendKeys("hoanghuy1");
        //Input username
        WebElement Passwordbutton = driver.findElement(By.xpath("//*[@data-testid='inputPassword']"));
        Passwordbutton.sendKeys("12345678");
        //Input password
        WebElement Loginbutton = driver.findElement(By.xpath("//*[@data-testid='buttonLogin']"));
        Loginbutton.click();
    }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'More')]")));
//        driver.findElement(By.xpath("//*[contains(text(),'More')]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Blogs')]")));
//        driver.findElement(By.xpath("//*[contains(text(),'Blogs')]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='Create New Blog']")));
//        driver.findElement(By.xpath("//*[@data-testid='Create New Blog']")).click();
//        //Add Title field.
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='inputTitle']")));
//        driver.findElement(By.xpath("//*[@data-testid='inputTitle']")).sendKeys("hoanghuy");
//        //add Post field.
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='notranslate public-DraftEditor-content']")));
//        driver.findElement(By.xpath("//*[@class='notranslate public-DraftEditor-content']")).sendKeys("hoanghuy1");
//        // click on the publish button
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='buttonSubmit']")));
//        driver.findElement(By.xpath("//*[@data-testid='buttonSubmit']")).click();
//        //verify the success message
//        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='flashMessage']")));
//        success.isDisplayed();
        public void GotoMyBlogs() {
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='user']//*[contains(text(),'hoanghuy')]")));
            driver.get("https://preview.metafox.app/blog/my");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"ltr-1330e3l\"]")));
            driver.findElement(By.xpath("//*[@class=\"ltr-1330e3l\"]")).isDisplayed();
            driver.findElement(By.xpath("//*[@class=\"ltr-1330e3l\"]")).click();
        }
        public void Like() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='reactionButton']")));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//*[@data-testid='reactionButton']"))).perform();
            //Love button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Love' and @data-testid='itemReaction']")));
            driver.findElement(By.xpath("//*[@aria-label='Love' and @data-testid='itemReaction']")).click();
        }
        public void Comment() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='public-DraftEditorPlaceholder-root']//*[contains(text(),'Write a comment...')]")));
            driver.findElement(By.xpath("//*[@data-testid='commentButton']")).click();
            driver.findElement(By.xpath("//div[@role='combobox']")).sendKeys("commen1t", ENTER);
        }
        public void Share() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='menuShareButton']")));
            driver.findElement(By.xpath("//*[@data-testid='menuShareButton']")).click();
            //share now action
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='share_now']")));
            driver.findElement(By.xpath("//*[@data-testid='share_now']")).click();
        }
        public void Verify() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='flashMessage']")));
            WebElement succes1 = driver.findElement(By.xpath("//*[@data-testid='flashMessage']"));
            succes1.isDisplayed();
            driver.get("https://preview.metafox.app/hoanghuy1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'shared a post')]")));
            WebElement succes2 = driver.findElement(By.xpath("//*[contains(text(),'shared a post')]"));
            succes2.isDisplayed();
            driver.quit();
        }
    }
}
