package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class soru4 extends TestBase {

    // url'ye git: http://demo.guru99.com/popup.php
    // ilk pencereyi al
    // "Click Here" butonuna tıklayın
    // setteki tüm pencereyi al
    // diğer pencereye geç
    // e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
    // Gönder düğmesine tıklayarak
    // ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
    // Tekrar ilk pencereye geç
    // İlk pencerede olduğunu doğrula

    @Test
    public void TestS4(){

        driver.get("http://demo.guru99.com/popup.php");

        String ilkPencere = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Set<String>pencereler=driver.getWindowHandles();

        for(String w:pencereler){

            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;

            }

        }

        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com");

        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        String org= driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();

        Assert.assertEquals("This access is valid only for 20 days.",org);

        driver.switchTo().window(ilkPencere);


    }

}
