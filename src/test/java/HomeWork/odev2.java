package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.util.Set;

public class odev2 extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //Title in ‘Windows’ oldugunu test edin
    //Click here a tiklayin
    //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

    @Test
    public void TestOdev2() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        String ilkWindowHandle = driver.getWindowHandle();

        String x=driver.getTitle();
        Assert.assertTrue(x.equals("Windows"));

        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(2000);

        Set<String> tumWindowDegerleri = driver.getWindowHandles();

        for (String w:tumWindowDegerleri){

            if(!ilkWindowHandle.equals(w)){
                driver.switchTo().window(w);
                break;
            }
        }
        String wh2Title = driver.getTitle();

        Assert.assertTrue(wh2Title.equals("New Window"));

    }

}
