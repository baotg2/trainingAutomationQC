package metafoxtraining.TrucNQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
   public static void main(String[] args)
   {
       WebDriver driver= new ChromeDriver();
       driver.get("http://testng.org/doc/maven.html");
       driver.manage().window().maximize();
   }
}
