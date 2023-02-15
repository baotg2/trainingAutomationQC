package metafoxtraining.HuyNH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class HuyNH {

    WebDriver driver;
    WebDriverWait wait;
    public void HuyNH1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://preview.metafox.app");
        driver.manage().window().maximize();
    }
    public void Login() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inputEmail']")));
        WebElement Usernamebutton = driver.findElement(By.xpath("//input[@data-testid='inputEmail']"));
        Usernamebutton.sendKeys("hoanghuy1");
        WebElement Passwordbutton = driver.findElement(By.xpath("//input[@data-testid='inputPassword']"));
        Passwordbutton.sendKeys("12345678");
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@data-testid='buttonLogin']"));
        Loginbutton.click();
        }
        public void GotoMyBlogs() {
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='user']//span[contains(text(),'hoanghuy')]")));
            driver.get("https://preview.metafox.app/blog/my");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@data-testid='itemTitle']//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineHover ltr-4u7vtf']")));
            driver.findElement(By.xpath("//h4[@data-testid='itemTitle']//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineHover ltr-4u7vtf']")).isDisplayed();
            driver.findElement(By.xpath("//h4[@data-testid='itemTitle']//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineHover ltr-4u7vtf']")).click();
        }
        public void Like() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='reactionButton']")));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//button[@data-testid='reactionButton']"))).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@aria-label='Love' and @data-testid='itemReaction']")));
            driver.findElement(By.xpath("//img[@aria-label='Love' and @data-testid='itemReaction']")).click();
            List<WebElement> Loved = driver.findElements(By.xpath("//button[@data-testid='reactionButton' and @aria-label='Love']"));
            if (Loved.size() > 0) {
                Loved.get(0).isDisplayed();
            }
            else {
                WebElement Unlike = driver.findElement(By.xpath("//button[@data-testid='reactionButton' and @aria-label='Like']"));
                Unlike.isDisplayed();
            }
        }
        public void Comment() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='fieldComment']//div[@class='public-DraftEditorPlaceholder-root']//div[contains(text(),'Write a comment...')]")));
            driver.findElement(By.xpath("//button[@data-testid='commentButton']")).click();
            driver.findElement(By.xpath("//div[@role='combobox']")).sendKeys("huy cmt", ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='comment']//p[contains(text(),'huy cmt')]")));
            WebElement checkpointcmt = driver.findElement(By.xpath("//div[@data-testid='comment']//p[contains(text(),'huy cmt')]"));
            checkpointcmt.isDisplayed();
        }
        public void Share() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='menuShareButton']")));
            driver.findElement(By.xpath("//button[@data-testid='menuShareButton']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='share_now']")));
            driver.findElement(By.xpath("//div[@data-testid='share_now']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
            WebElement succes1 = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));
            succes1.isDisplayed();
            driver.get("https://preview.metafox.app/hoanghuy1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'shared a post')]")));
            WebElement succes2 = driver.findElement(By.xpath("//span[contains(text(),'shared a post')]"));
            succes2.isDisplayed();
            driver.quit();
        }
    }

