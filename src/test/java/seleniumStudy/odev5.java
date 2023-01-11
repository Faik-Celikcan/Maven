package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class odev5 extends TestBase {
    //Keyboard Base Actions
    //Homework
    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2- Hover over Me First" kutusunun ustune gelin
    //Link 1" e tiklayin
    //Popup mesajini yazdirin
    //Popup'i tamam diyerek kapatin
    //“Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void Test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"))).perform();
        waitFor(3);
        //Link 1" e tiklayin

        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //Popup mesajini yazdirin

        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun

        actions.clickAndHold(driver.findElement(By.id("click-box"))).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(driver.findElement(By.id("click-box")).getText());

        //8- “Double click me" butonunu cift tiklayin

        actions.doubleClick(driver.findElement(By.xpath("//h2"))).perform();
    }
}
