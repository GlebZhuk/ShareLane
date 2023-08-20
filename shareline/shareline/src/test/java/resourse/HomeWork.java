package resourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeWork {

    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=
    //2. Ввеси Hleb в поле First Name
    //3. Ввеси Zhuk в поле Last Name
    //4. Ввеси Gleb103@mail.ru в поле Email
    //5. Ввеси 12345 в поле Password
    //6. Ввеси 12345 в поле Confirm Password
    //7. Нажать на кнопку Register
    //8. Проверить сообщение
    private WebDriver driver;

    @Test
    public void verifyRegistrationDatesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resourse/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Hleb");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Zhuk");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Gleb103@mail.ru");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String successfulMessage = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
        Assert.assertEquals(successfulMessage, "Account is created!");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

