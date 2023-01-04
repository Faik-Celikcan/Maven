package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class soru6 extends TestBase {

    @Test
    public void testS6() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> frame = driver.findElements(By.xpath("//iframe"));
        System.out.println(frame.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@wmode='transparent']")));
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        Thread.sleep(5000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
        Thread.sleep(3000);

    }



}
