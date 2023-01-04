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


        driver.get("https://yandex.com.tr/search/?lr=11507&text=youtube&src=suggest_B");

        String x =driver.getWindowHandle();
        driver.findElement(By.xpath("//span[@class='OrganicTitleContentSpan organic__title'][1]")).click();
        driver.switchTo().window(x);
        driver.findElement(By.xpath("//*[text()='Sabah: ']")).click();

        Thread.sleep(2000);


        switchToWindow("You Tube");
    }
}
