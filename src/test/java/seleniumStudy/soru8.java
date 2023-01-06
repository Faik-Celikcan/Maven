package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class soru8 extends TestBase {

    //- https://html.com/tags/iframe/ adresine gidiniz
    //- youtube videosunu çalıştırınız
    //- üç saniye çalıştıktan sonra sayfayı yenileyiniz
    //- yeni sekmede amazon adresine gidiniz
    //- iphone aratınız
    //- arama sonucu olarak sadece sonuc sayısını yazdırınız
    //- ilk sekmeye geri dönüp url'ini konsola yazdıralım
    //- amazon sayfasını kapatalım
    //- Sonra diğer sekmeyide kapatalım
    //TestBase'deki @After notasyonu çalışacak

    @Test
    public void TestS8() throws InterruptedException {

        driver.get("https://html.com/tags/iframe/");

        String ilkPencere = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']")));

        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        Thread.sleep(3000);

        driver.navigate().refresh();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        String ikinciPencere= driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        String result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

        String resultArr [] = result.split(" ");

        System.out.println("Result --> "+resultArr[2]);

        driver.switchTo().window(ilkPencere);

        System.out.println(driver.getCurrentUrl());

        driver.switchTo().window(ikinciPencere).close();


    }
}
