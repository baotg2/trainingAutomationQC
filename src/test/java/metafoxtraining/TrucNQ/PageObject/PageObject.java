package metafoxtraining.TrucNQ.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    WebDriver driver;
    By username = By.xpath("//*[@data-testid='inputEmail']");
    By password = By.xpath("//*[@data-testid='inputPassword']");
    By login = By.xpath("//*[@data-testid='buttonLogin']");

    By title = By.xpath("//input[@data-testid='inputTitle']");
    By textBox = By.xpath("//div[@role='textbox']");
    By buttonSubmit = By.xpath("//*[@data-testid='buttonSubmit']");
    WebDriverWait wait;
    public PageObject(WebDriver driver){
        this.driver = driver;
    }
    public void fillUsername(String strUserName){
        driver.findElement(username).sendKeys(strUserName);
    }

    public void fillPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }

    public void loginMetafox(String strUsername, String strPassword){
        this.fillUsername(strUsername);
        this.fillPassword(strPassword);
        this.clickLogin();

    }

    public void fillTitle(String strTitle){
        driver.findElement(title).sendKeys(strTitle);
    }

    public void fillTextBox(String strTextBox){
        driver.findElement(textBox).sendKeys(strTextBox);
    }

    public void buttonSubmit(){
        driver.findElement(buttonSubmit).click();
    }
    public void createBlog(String strTitle, String strTextBox){
        this.fillUsername(strTitle);
        this.fillPassword(strTextBox);
        this.clickLogin();
    }

}
