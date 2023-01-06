package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class soru9 extends TestBase {

    // https://the-internet.herokuapp.com/iframe adresine gidiniz
    // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
    // Elemental Selenium linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
    // Source labs linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // ilk sekmeye geri dönelim ve url'ini yazdıralım
    // ilk sekmeyi kapatalım


    @Test
    public void TestS9() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkPencere=driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        driver.findElement(By.xpath("//p")).clear();
        driver.findElement(By.xpath("//p")).sendKeys("Techproeducation");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']")).click();

        Set<String> pencereler = driver.getWindowHandles();

        for(String w:pencereler){

            if(!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }

        }

        String ikinciPencere= driver.getWindowHandle();

        System.out.println(driver.findElement(By.xpath("//h1")).getText());


        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='https://saucelabs.com/']")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='https://saucelabs.com/']")).click();

        Set<String> pencereler2=driver.getWindowHandles();

        for(String w:pencereler2){

            if(!w.equals(ilkPencere)){

                if(!w.equals(ikinciPencere)){

                    driver.switchTo().window(w);
                    break;
                }

            }

        }

        System.out.println(driver.getTitle());

        driver.switchTo().window(ilkPencere);

        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
