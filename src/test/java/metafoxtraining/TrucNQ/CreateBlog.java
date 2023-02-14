package metafoxtraining.TrucNQ;


import jdk.internal.org.xml.sax.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class CreateBlog {
    public void createNewBlog() throws InterruptedException {
        //Access to the site
        System.setProperty("webdriver.chrome.driver","D:\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");

        //Input data to login
        WebDriverWait wait = new WebDriverWait(driver,10 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='inputEmail']")));

        WebElement username = driver.findElement(By.xpath("//*[@data-testid='inputEmail']"));
        username.sendKeys("daklak");
        WebElement password = driver.findElement(By.xpath("//*[@data-testid='inputPassword']"));
        password.sendKeys("12345678");
        WebElement button = driver.findElement(By.xpath("//*[@data-testid='buttonLogin']"));
        button.click();
        Thread.sleep(5000);
        driver.get("https://preview.metafox.app/blog/add");

        Thread.sleep(5000);
        //create a new  blog
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inputTitle']")));
        WebElement titleField = driver.findElement(By.xpath("//input[@data-testid='inputTitle']"));
        titleField.isDisplayed();
        titleField.sendKeys("Test blog Truc Delete");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='textbox']")));
        WebElement desField = driver.findElement(By.xpath("//div[@role='textbox']"));
        desField.sendKeys("Test blog Truc");

        //Click on the Submit button
        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@data-testid='buttonSubmit']"));
        buttonSubmit.click();
        Thread.sleep(2000);

        //Edit blog
        //Click on action menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        WebElement actionMenu = driver.findElement(By.xpath("//button[@data-testid='actionMenuButton']"));
        actionMenu.click();

        //Click on Edit action
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='edit']")));
        WebElement editActionMenu = driver.findElement(By.xpath("//div[@data-testid='edit']"));
        editActionMenu.click();

        //Edit page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='textbox']")));
        WebElement desField1 = driver.findElement(By.xpath("//div[@role='textbox']"));
        desField1.clear();
        desField1.sendKeys("test edit blog and delete blog");

        //Click on Update button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='buttonSubmit']")));
        WebElement buttonUpdate = driver.findElement(By.xpath("//button[@data-testid='buttonSubmit']"));
        buttonUpdate.click();

        // Check on the success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        WebElement flashMessage = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));
        flashMessage.isDisplayed();

        // Delete blog
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        //WebElement actionMenu = driver.findElement(By.xpath("//button[@data-testid='actionMenuButton']"));
        Thread.sleep(3000);
        actionMenu.isDisplayed();
        actionMenu.click();

        // Click on Delete action
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='delete']")));
        WebElement deleteActionMenu = driver.findElement(By.xpath("//div[@data-testid='delete']"));
        deleteActionMenu.click();

        //Click on the popup
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='buttonSubmit']")));
        WebElement buttonSubmitpopup = driver.findElement(By.xpath("//button[@data-testid='buttonSubmit']"));
        buttonSubmitpopup.click();

        //Check success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
        //WebElement flashMessageDelete = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));
        flashMessage.isDisplayed();
        //fla.isDisplayed();

        driver.quit();

    }
}
