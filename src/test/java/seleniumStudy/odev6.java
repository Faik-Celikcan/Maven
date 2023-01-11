package seleniumStudy;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class odev6 extends TestBase {
    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin

    @Test
    public void Test01(){

        Faker faker =new Faker();

        driver.get("https://facebook.com");

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(faker.name().firstName());

        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(faker.name().lastName());

        String email=faker.internet().emailAddress();

        driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys(email);

        driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']")).sendKeys(email);

        driver.findElement(By.id("password_step_input")).sendKeys("erolbaskan");

        Select select=new Select(driver.findElement(By.xpath("//*[@id='day']")));

        select.selectByValue("11");

        Select select1=new Select(driver.findElement(By.id("month")));

        select1.selectByValue("9");

        Select select2=new Select(driver.findElement(By.id("year")));

        select2.selectByValue("1997");

        driver.findElement(By.xpath("(//*[@name='sex'])[2]")).click();

        waitFor(2);

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@name='sex'])[2]")).isSelected());
    }
}
