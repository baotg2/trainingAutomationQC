package metafoxtraining.ThuNM.pageObject;

import org.bouncycastle.LICENSE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObject {
    WebDriver driver;
    WebDriverWait wait;
    By username = By.xpath ("//*[@data-testid='inputEmail']");
    By password = By.xpath ("//*[@data-testid='inputPassword']");
    By loginButton = By.xpath ("//*[@data-testid='buttonLogin']");
    By moreactions = By.xpath ("//*[@data-testid='actionMenuButton']");
    By unfeature = By.xpath ("//div[@data-testid='action menu']//div[@data-testid='remove_feature']");
    By feature = By.xpath ("//div[@data-testid='action menu']//div[@data-testid='feature']");
    By save = By.xpath ("//div[@data-testid='action menu']//div[@data-testid='save']");
    By unsave = By.xpath ("//div[@data-testid='action menu']//div[@data-testid='un-save']");
    By report = By.xpath ("//div[@data-testid='action menu']//div[@data-testid='report']");
    By submitReport = By.xpath ("//form[@data-testid='form']//button[@data-testid='buttonSubmit']");

    By flagMessage = By.xpath("//div[@data-testid='flashMessage']");
    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String name){
        driver.findElement(username).sendKeys(name);
    }

    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void Login(String name, String pass){
        this.setUsername (name);
        this.setPassword (pass);
        this.clickLoginButton();
    }

    public void clickMoreActions(){
        driver.findElement(moreactions).click();
    }

    public void clickFeature(){
        driver.findElement(feature).click();
    }

    public List<WebElement> unFeature(){
        return driver.findElements (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='remove_feature']"));
    }
    public void clickUnsave(){
        driver.findElement(unsave).click();
    }

    public List<WebElement> save(){
        return driver.findElements (By.xpath ("//div[@data-testid='action menu']//div[@data-testid='save']"));
    }

    public void clickReport(){
        driver.findElement(report).click();
    }

    public void clickSubmitReport(){
        driver.findElement(submitReport).click();
    }
    public void displayMessage(){
        driver.findElement (flagMessage).isDisplayed ();
    }


}
