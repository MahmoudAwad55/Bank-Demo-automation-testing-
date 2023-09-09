import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class guru99v1 {
    WebDriver driver = new ChromeDriver();


    @BeforeTest
    public void OpenBrwoser() throws InterruptedException {
        String chromepath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromepath);

        System.setProperty("webdriver.chrome.driver", chromepath);




        driver.navigate().to(utli4guru99.BASE_URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }
    @Test
    public void SS1() throws InterruptedException, IOException {

       // driver.navigate().to(utli4guru99.BASE_URL);



        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys(utli4guru99.USER_NAME);
        driver.findElement(By.name("password")).sendKeys(utli4guru99.PASSWD);
//       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(3000);

//        String expectedResults ="You logged into a secure area!";
//        String actualResults =driver.findElement(login.flashPOM()).getText();
//        //first assertion
//        Assert.assertTrue(actualResults.contains(expectedResults),"Error Message: Text is wrong ");
//        //second assertion
//        Assert.assertTrue(driver.findElement(login.logoutPOM()).isDisplayed());
//        //third assetrion
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.getTitle().contains(utli4guru99.EXPECT_TITLE),"error text is wrong");
        File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("F:\\computer science\\TESTING\\guru99\\screenshots\\homepage.png").toPath());




    }
    @Test
    public void SS2() throws InterruptedException {

        driver.navigate().to(utli4guru99.BASE_URL);


        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys("utli4guru99.USER_NAME");
        driver.findElement(By.name("password")).sendKeys(utli4guru99.PASSWD);
//       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("btnLogin")).click();

        Assert.assertTrue(driver.switchTo().alert().getText().contains(utli4guru99.EXPECT_TITLE_BAD_SECINARIO),"error in pop out");
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
    }
    @Test
    public void SS3() throws InterruptedException {
        Thread.sleep(3000);


        driver.navigate().to(utli4guru99.BASE_URL);


        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys(utli4guru99.USER_NAME);
        driver.findElement(By.name("password")).sendKeys("utli4guru99.PASSWD");
//       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.switchTo().alert().getText().contains(utli4guru99.EXPECT_TITLE_BAD_SECINARIO),"error in pop out");
        driver.switchTo().alert().accept();


    }
    @Test
    public void SS4() throws InterruptedException {


        driver.navigate().to(utli4guru99.BASE_URL);


        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys("utli4guru99.USER_NAME");
        driver.findElement(By.name("password")).sendKeys("utli4guru99.PASSWD");
//       driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.switchTo().alert().getText().contains(utli4guru99.EXPECT_TITLE_BAD_SECINARIO),"error in pop out");
        driver.switchTo().alert().accept();


    }

        @AfterTest
    public void CloseDriver()
    {
        driver.quit();

    }

}
