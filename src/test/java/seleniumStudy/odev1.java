package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class odev1 extends TestBase {
    //Bir class olusturun: IframeOdev
    //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    //sayfadaki toplam iframe sayısını bulunuz.
    //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    //Paragrafdaki yaziyi silelim
    //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    @Test
    public void TestOdev1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        List<WebElement> x = driver.findElements(By.xpath("//iframe"));
        int counter=0;
        for(WebElement w:x){
            counter++;
        }
        System.out.println(counter+" Tane iframe var");

        String y =driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(y.contains("Editor"));

        driver.switchTo().frame(0);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframein icindeyim");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        String z=driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();

        Assert.assertTrue(z.contains("Elemental Selenium"));

    }



}
