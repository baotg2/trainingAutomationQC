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

    WebElement actionMenu;
    WebElement buttonSubmit;
    WebElement flashMessage;
    PageObject pageObject = new PageObject(driver);
    public void loginSite() throws InterruptedException {
        //Access to the site
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","D:\\Chrome Driver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://preview.metafox.app/");
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='inputEmail']")));
        pageObject.loginMetafox("daklak", "12345678");

        //Input data to login
        //wait = new WebDriverWait(driver,10);
        //pageObject.loginMetafox("daklak", "12345678");


//        WebElement username = driver.findElement(By.xpath("//*[@data-testid='inputEmail']"));
//        username.sendKeys("daklak");
//        WebElement password = driver.findElement(By.xpath("//*[@data-testid='inputPassword']"));
//        password.sendKeys("12345678");
//        WebElement button = driver.findElement(By.xpath("//*[@data-testid='buttonLogin']"));
//        button.click();
        Thread.sleep(5000);
    }

    public void createBlog() throws InterruptedException{
        driver.get("https://preview.metafox.app/blog/add");
        Thread.sleep(5000);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inputTitle']")));
//        WebElement titleField = driver.findElement(By.xpath("//input[@data-testid='inputTitle']"));
//        titleField.isDisplayed();
//        titleField.sendKeys("Test blog Truc Delete");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='textbox']")));
//        WebElement desField = driver.findElement(By.xpath("//div[@role='textbox']"));
//        desField.sendKeys("Test blog Truc");
//
//        //Click on the Submit button
//        buttonSubmit = driver.findElement(By.xpath("//*[@data-testid='buttonSubmit']"));
//        buttonSubmit.click();
//        Thread.sleep(2000);
//        // Check on the success message
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='flashMessage']")));
//        flashMessage = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));
        //PageObject pageObject = new PageObject(driver);
        pageObject.createBlog("daklak", "12345678");
        flashMessage.isDisplayed();
    }

    public void updateBlog() throws InterruptedException{
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        actionMenu = driver.findElement(By.xpath("//button[@data-testid='actionMenuButton']"));
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
        Thread.sleep(2000);
        flashMessage = driver.findElement(By.xpath("//div[@data-testid='flashMessage']"));


    }

    public void deleteBlog() throws InterruptedException{
        wait =new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='actionMenuButton']")));
        actionMenu = driver.findElement(By.xpath("//button[@data-testid='actionMenuButton']"));
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
        flashMessage.isDisplayed();
        driver.quit();
    }
}
