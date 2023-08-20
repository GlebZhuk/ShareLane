package resourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyEmailTest {
    @Test
   public void verifyEmailEmptyValue (){
        System.setProperty("webdriver.chrome.driver","src/test/java/resourse/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String emptyFieldMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(emptyFieldMessage,"Oops, error. Email and/or password don't match our records");
    }
}
