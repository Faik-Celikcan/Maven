package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ae1 extends TestBase {

    @Test
    public void aeS1() throws InterruptedException {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam Et' düğmesini tıklayın
        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın

        driver.get("http://automationexercise.com");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

        findElementClick("//*[@href='/login']");

        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Faik");
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]")).sendKeys("ss@gmail.com");

        findElementClick("(//*[@class='btn btn-default'])[2]");

        Thread.sleep(2000);


    }

}
