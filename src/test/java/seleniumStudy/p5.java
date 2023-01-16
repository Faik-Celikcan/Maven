package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class p5 extends TestBase{

    /*
        -http://spicejet.com/ sayfasına gidelim
        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        -Sayfa başlığının Fleet içerdiğini test edelim
     */

    @Test
    public void Test01(){

        driver.get("http://spicejet.com/");

        driver.findElement(By.xpath("//*[text()='Fleet']")).click();

    }
}
