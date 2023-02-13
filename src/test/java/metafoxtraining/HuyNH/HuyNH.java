package metafoxtraining.HuyNH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;

public class HuyNH {
    public void HuyNH1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://preview.metafox.app");
        driver.manage().window().maximize();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement Usernamebutton = driver.findElement(By.xpath("//*[@data-testid=\"inputEmail\"]"));
        Usernamebutton.sendKeys("hoanghuy");
        //Input username
        WebElement Passwordbutton = driver.findElement(By.xpath("//*[@data-testid=\"inputPassword\"]"));
        Passwordbutton.sendKeys("12345678");
        //Input password
        WebElement Loginbutton = driver.findElement(By.xpath("//*[@data-testid=\"buttonLogin\"]"));
        Loginbutton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://preview.metafox.app/blog/add");
        sleep(5000);
        //Add Title field.
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid=\"inputTitle\"]")));
        driver.findElement(By.xpath("//*[@data-testid=\"inputTitle\"]")).sendKeys("hoanghuy");
        //add Post field.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"notranslate public-DraftEditor-content\"]")));
        driver.findElement(By.xpath("//*[@class=\"notranslate public-DraftEditor-content\"]")).sendKeys("hoanghuy1");
        // click on the publish button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid=\"buttonSubmit\"]")));
        driver.findElement(By.xpath("//*[@data-testid=\"buttonSubmit\"]")).click();
        //verify the success message
//        WebElement successmessage = driver.findElement(By.xpath("//*[contains(text(),'Blog has been published successfully')]"));
        //Hover to Like Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid=\"reactionButton\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@data-testid=\"reactionButton\"]"))).perform();
        //Love button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Love\" and @data-testid=\"itemReaction\"]")));
        driver.findElement(By.xpath("//*[@aria-label=\"Love\" and @data-testid=\"itemReaction\"]")).click();
        // Comment button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"public-DraftEditorPlaceholder-root\"]//*[contains(text(),'Write a comment...')]")));
        driver.findElement(By.xpath("//*[@data-testid=\"commentButton\"]")).click();
        //Object SendKeys;
        driver.findElement(By.xpath("//div[@role=\"combobox\"]")).sendKeys("comment",ENTER);
        //Share
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid=\"menuShareButton\"]")));
        driver.findElement(By.xpath("//*[@data-testid=\"menuShareButton\"]")).click();
        //share now
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid=\"share_now\"]")));
        driver.findElement(By.xpath("//*[@data-testid=\"share_now\"]")).click();
        driver.quit();

    }
}
