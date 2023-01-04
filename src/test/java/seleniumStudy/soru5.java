package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class soru5 extends TestBase {

    @Test
    public void TestS5() throws InterruptedException {

        //https://demoqa.com/ url'ine gidin.

        driver.get("https://demoqa.com/");
        String ilkWindow=driver.getWindowHandle();
        //Alerts, Frame & Windows Butonuna click yap
        findElementClick("//*[text()='Alerts, Frame & Windows']");
        Thread.sleep(3000);
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula

        Assert.assertTrue(driver.findElement(By.id("Ad.Plus-728x90")).isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        findElementClick("//*[text()='Browser Windows']");
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
        //New Tab butonuna click yap
        driver.findElement(By.id("tabButton")).click();
        Set<String> pencereler = driver.getWindowHandles();

        for(String w:pencereler){

            if(!w.equals(ilkWindow)){
                driver.switchTo().window(w);
                break;
            }

        }
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("sampleHeading")).isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(ilkWindow);
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());

    }



}
