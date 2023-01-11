package seleniumStudy;

import dev.failsafe.internal.util.Durations;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class soru13 extends TestBase {


    @Test
    public void Test01() {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");

        //anasayfada oldugunuzu dogrulayin

        Assert.assertEquals("https://www.sahibinden.com/", driver.getCurrentUrl());

        //detayli arama tiklayin

        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();
        //detayli arama sayfasina geldiginizi dogrulatin

        Assert.assertEquals("Detaylı Arama", driver.findElement(By.xpath("//h2")).getText());

        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("(//*[@href='/arama/detayli?category=3518'])[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/arama/detayli?category=3613']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/arama/detayli?category=16623']"))).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin

        adres("Amasya", "Merkez", "Akbilek Mah.");
        fiyat("4000", "10000", "USD");
        brut("180","400");

        //filtreler için sağıdakilere benzer methodlar oluşturun
        //    detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
        //    detayli_Arama_Fiyat("4.000","4.000.000","USD");
        //    detayli_Arama_Brut("180","400");
        //    detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
        //.
        //        .
        //        ...
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin

        driver.findElement(By.xpath("//*[@aria-label='Kapat']")).click();

        driver.findElement(By.xpath("//*[@class='btn mtdef']")).click();

        System.out.println(driver.findElement(By.xpath("//*[@class='result-text-sub-group']")).getText());
    }

    public void adres(String sehir, String ilce, String mahalle) {

        driver.findElement(By.xpath("//*[@data-address='city']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//*[text()='" + sehir + "']")).click();

        driver.findElement(By.xpath("//*[@data-address='town']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//*[text()='" + ilce + "']")).click();
        driver.findElement(By.xpath("//*[@class='collapse-pane']")).click();

        driver.findElement(By.xpath("//*[@data-address='quarter']")).click();
        driver.findElement(By.xpath("(//*[@class='js-address-filter'])[4]")).sendKeys(mahalle);
        driver.findElement(By.xpath("//*[text()='" + mahalle + "']")).click();
        driver.findElement(By.xpath("//*[@class='collapse-pane']")).click();
    }

    public void fiyat(String min, String max, String paraBirimi) {

        driver.findElement(By.xpath("//*[@name='price_min']")).sendKeys(min);
        driver.findElement(By.xpath("//*[@name='price_max']")).sendKeys(max);
        Select select = new Select(driver.findElement(By.xpath("//*[@name='price_currency']")));
        select.selectByVisibleText(paraBirimi);

    }

    public void brut(String min,String max){

        driver.findElement(By.xpath("//*[@name='a24_min']")).sendKeys(min);
        driver.findElement(By.xpath("//*[@name='a24_max']")).sendKeys(max);
    }


}
