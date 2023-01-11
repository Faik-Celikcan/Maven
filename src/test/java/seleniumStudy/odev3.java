package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class odev3 extends TestBase {



    @Test
    public void TestOdev3_1(){
        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        Select select=new Select(driver.findElement(By.id("searchDropdownBox")));

        List<WebElement>dde=select.getOptions();

        int counter=0;
        for(WebElement w:dde){

            System.out.println(w.getText());
            counter++;
        }
        //dropdown menude 40 eleman olduğunu doğrulayın

        //Assert.assertEquals(40,counter);
    }
        //Test02
    @Test
    public void TestOdev3_2(){

        //dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");

        Select select=new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin

        String result=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        Assert.assertTrue(result.contains("iphone"));
        //ikinci ürüne relative locater kullanarak tıklayin

        WebElement firstProduct = driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']"));
        By secondProduct = RelativeLocator.with(By.tagName("div")).toRightOf(firstProduct);
        driver.findElement(secondProduct).click();


        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        String urununBasligi = driver.findElement(By.id("productTitle")).getText();

        String urunFiyati = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']")).getText();

        String x[]=urunFiyati.split("\n");

        System.out.println(x[0]+"."+x[1]);

        System.out.println(urununBasligi);
        //System.out.println(urunFiyati);

        driver.findElement(By.id("submit.add-to-cart")).click();

    }

    @Test
    public void TestOdev3_3(){
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com");

        //dropdown’dan bebek bölümüne secin
        Select select=new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby stroller", Keys.ENTER);
        //sonuç yazsının puset içerdiğini test edin

        WebElement resultText = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        Assert.assertTrue(resultText.getText().contains("stroller"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin

       WebElement ikinciUrun=driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-2']"));
        waitFor(3);
        driver.findElement(RelativeLocator.with(By.tagName("img")).below(ikinciUrun)).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4

        String urununBasligi = driver.findElement(By.id("productTitle")).getText();

        String urunFiyati = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']")).getText();

        String x[]=urunFiyati.split("\n");

        System.out.println(x[0]+"."+x[1]);

        System.out.println(urununBasligi);

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }

}
