package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class p6 extends TestBase {


    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    @Test
    public void Test01(){

        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"))).perform();

        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("(//*[@class='a-text-bold'])[3]")).click();
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();
    }
}
