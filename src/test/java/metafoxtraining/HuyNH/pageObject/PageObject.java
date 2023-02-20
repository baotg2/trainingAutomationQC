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
    By comment = By.xpath("//div[@data-testid='fieldComment']//div//div//div//div/..");
    By shareButton = By.xpath("//button[@data-testid='menuShareButton']");
    By shareNowButton = By.xpath("//div[@data-testid='share_now']");
    By flashMessage = By.xpath("//div[@data-testid='flashMessage']");
    By checkComment = By.xpath("//div[@data-testid='comment']//p[contains(text(),'auto_cmt')]");
    By commentBox = By.xpath("//div[@data-testid='fieldComment']//div[contains(text(),'Write a comment...')]");
    public By getUsername() {
        return username;
    }
    public By getUserLogin() {
        return userLogin;
    }
    public By getBlogDetail() {
        return blogDetail;
    }
    public By getLikeButton() {
        return likeButton;
    }
    public By getCommentBox() {
        return commentBox;
    }
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

    public void commentBlog(String yourComment) throws InterruptedException {
        this.clickComment();
        this.setComment(yourComment);
        Thread.sleep(4000);
        driver.findElement(checkComment).isDisplayed();
    }
    public void shareBlog() throws InterruptedException {
        driver.findElement(shareButton).click();
        Thread.sleep(2000);
        driver.findElement(shareNowButton).click();
        Thread.sleep(4000);
        driver.findElement(flashMessage).isDisplayed();
    }

}
