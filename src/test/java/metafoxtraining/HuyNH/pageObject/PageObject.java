package metafoxtraining.HuyNH.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.ENTER;

public class PageObject {
    WebDriver driver;
    By username = By.xpath("//input[@data-testid='inputEmail']");
    By password = By.xpath("//input[@data-testid='inputPassword']");
    By loginButton = By.xpath("//button[@data-testid='buttonLogin']");
    By userLogin = By.xpath("//a[@data-testid='user']//span[contains(text(),'hoanghuy')]");
    By blogDetail = By.xpath("//h4[@data-testid='itemTitle']//a");
    By likeButton = By.xpath("//button[@data-testid='reactionButton']");
    By commentButton = By.xpath("//button[@data-testid='commentButton']");
    By comment = By.xpath("//div[@data-testid='fieldComment']//following-sibling::div//div");

    public PageObject (WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String user) {
        driver.findElement((username)).sendKeys(user);
    }

    public void setPassword(String pass) {
        driver.findElement((password)).sendKeys(pass);
    }

    public void clickLoginButton() {
        driver.findElement((loginButton)).click();
    }
    public void clickComment() {driver.findElement(commentButton).click();}
    public void setComment(String yourComment) {
        driver.findElement(comment).sendKeys(yourComment, ENTER);
    }
    public void loginMetaFox(String user, String pass) {
        this.setUsername(user);
        this.setPassword(pass);
        this.clickLoginButton();

    }
    public void clickBlogDetail() {
        driver.findElement(blogDetail).isDisplayed();
        driver.findElement(blogDetail).click();
    }
    public void clickLikeButton() {
        driver.findElement(likeButton).click();
    }

    public void commentBlog(String yourComment) {
        this.clickComment();
        this.setComment(yourComment);
    }

}
