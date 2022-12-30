package CalismaAlani;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class bos extends TestBase {

    @Test
    public void Test05() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Ahmet");

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        String x =driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals("You entered: Ahmet",x);

    }
}
