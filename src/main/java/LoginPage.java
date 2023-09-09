import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement usernamePOM(WebDriver driver)
    {
        By username =By.id("username");
        WebElement usernameEle = driver.findElement(username);
        return usernameEle;


    }
    public WebElement passwordPOM(WebDriver driver)
    {

        return driver.findElement(By.name("password"));


    }
    public By flashPOM()
    {

        return (By.id("flash"));


    }
    public By logoutPOM()
    {

        return (By.cssSelector("a[href=\"/logout\"]"));


    }
}
