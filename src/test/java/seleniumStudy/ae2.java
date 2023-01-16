package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ae2 extends TestBase {

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    //6. Doğru e-posta adresini ve şifreyi girin
    //7. 'Giriş' düğmesine tıklayın
    //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //9. 'Hesabı Sil' düğmesini tıklayın
    //10. 'HESAP SİLİNDİ!' görünür

    @Test
    public void Test01(){

        driver.get("http://automationexercise.com");

        Assert.assertEquals("Automation Exercise",driver.getTitle());

        driver.findElement(By.xpath("//*[@href='/login']")).click();
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("ss@gmail.com");
        driver.findElement(By.xpath("(//*[@name='password'])[1]")).sendKeys("seko");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        System.out.println(driver.findElement(By.xpath("//*[@class='fa fa-user']")).getText());

    }
}
