import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first {
    WebDriver driver = new ChromeDriver();
    LoginPage login;


    @BeforeTest
    public void OpenBrwoser() throws InterruptedException {
        String chromepath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromepath);

        System.setProperty("webdriver.chrome.driver", chromepath);




        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        login =new LoginPage();


    }


    @Test
    public void ValidData() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");



        login.usernamePOM(driver).clear();
        login.usernamePOM(driver).sendKeys("tomsmith");
        login.passwordPOM(driver).sendKeys("SuperSecretPassword!");
        login.passwordPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        String expectedResults ="You logged into a secure area!";
        String actualResults =driver.findElement(login.flashPOM()).getText();
        //first assertion
        Assert.assertTrue(actualResults.contains(expectedResults),"Error Message: Text is wrong ");
        //second assertion
        Assert.assertTrue(driver.findElement(login.logoutPOM()).isDisplayed());
        //third assetrion
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }

    @Test
    public void InValidData()
    {
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        login.usernamePOM(driver).clear();
        login.usernamePOM(driver).sendKeys("invaild");
        login.passwordPOM(driver).sendKeys("password");
        login.passwordPOM(driver).sendKeys(Keys.ENTER);
        String expectedResults ="Your username is invalid!";
        String actualResults =driver.findElement(login.flashPOM()).getText();
        //first assertion
        Assert.assertTrue(actualResults.contains(expectedResults),"Error Message: Text is wrong ");
    }

    @AfterTest
    public void CloseDriver()
    {
        driver.quit();

    }
}

