package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class soru10 extends TestBase {

    //Amazon anasayfa adresine gidin.
    //Sayfa’nin window handle degerini String bir degiskene atayin
    //Sayfa title’nin “Amazon” icerdigini test edin
    //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //Sayfa title’nin “TECHPROEDUCATION” icerip içermediğini test edin
    //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //Sayfa title’nin “Walmart” icerip içermediğini test edin
    //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void TestS10() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String ilkPencere=driver.getWindowHandle();

        System.out.println(ilkPencere);
        String amazonHandle=driver.getWindowHandle();

        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.techproeducation.com");

        String x = driver.getTitle();

        Assert.assertFalse(x.contains("TECHPROEDUCATION"));

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://www.walmart.com");

        String y= driver.getTitle();

        Assert.assertTrue(y.contains("Walmart"));

        driver.switchTo().window(ilkPencere);

        Thread.sleep(2000);

       // List<String> pencereler = new ArrayList<>(driver.getWindowHandles());

        //driver.switchTo().window(pencereler.get(0));



    }
}
