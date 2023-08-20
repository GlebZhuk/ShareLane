package resourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
    @Test
    public void verifySearchMySQLSymbolsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/resourse/chromedriver.exe");
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote=allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("@");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        String sqlMessage=driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
        Assert.assertEquals(sqlMessage,"Please, note that current MySQL settings don't allow searches for words containing less than 4 chars");
    }
}
