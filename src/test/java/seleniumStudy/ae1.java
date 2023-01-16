package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class ae1 extends TestBase {

    @Test
    public void aeS1() throws InterruptedException {


        //1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        findElementClick("//*[@href='/login']");

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        //6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Faik");
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]")).sendKeys("ss@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        findElementClick("(//*[@class='btn btn-default'])[2]");


        Thread.sleep(2000);

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText().equalsIgnoreCase("ENTER ACCOUNT INFORMATION"));

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi

        driver.findElement(By.xpath("//*[@value='Mr']")).click();

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("seko");

        Select select=new Select(driver.findElement(By.id("days")));
        select.selectByValue("11");

        Select select1=new Select(driver.findElement(By.id("months")));
        select1.selectByValue("9");

        Select select2=new Select(driver.findElement(By.id("years")));
        select2.selectByValue("1997");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.

        driver.findElement(By.xpath("//*[@name='newsletter']")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.

        driver.findElement(By.xpath("//*[@name='optin']")).click();
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası

        driver.findElement(By.id("first_name")).sendKeys("The");
        driver.findElement(By.id("last_name")).sendKeys("Tester");
        driver.findElement(By.id("company")).sendKeys("TesterAS");
        driver.findElement(By.id("address1")).sendKeys("Amasya");


        Select select3 =new Select(driver.findElement(By.id("country")));
        select3.selectByValue("Singapore");

        driver.findElement(By.id("state")).sendKeys("Amasya");
        driver.findElement(By.id("city")).sendKeys("Amasya");
        driver.findElement(By.id("zipcode")).sendKeys("05");
        driver.findElement(By.id("mobile_number")).sendKeys("05050500505");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

//        //14. 'HESAP OLUŞTURULDU!' görünür
//        //15. 'Devam Et' düğmesini tıklayın
//
//        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
//
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_1']")));
//
//        driver.findElement(By.xpath("//*[@id='dismiss-button']//div")).click();
//
//        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
//        //17. 'Hesabı Sil' düğmesini tıklayın
//         driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
//         driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
//        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın


    }

}
