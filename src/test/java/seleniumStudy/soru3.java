package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class soru3 extends TestBase {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    // ikinci emojiye tıklayın
    // ikinci emoji altındaki tüm öğelere tıklayın
    // ana iframe'e geri dön
    //formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // uygula butonuna tıklayın

    @Test
    public void TestS3() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='emoojis']")));

        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        Thread.sleep(2000);

        List<WebElement> x=driver.findElements(By.xpath("//div[@id='nature']/div/img"));

       // x.forEach(WebElement::click);

       for (WebElement w:x){

           w.click();
        }

       driver.switchTo().defaultContent();


       List<WebElement> veriler = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

       List<String> form = new ArrayList<>(Arrays.asList("Erol","Evren","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));

       for(int i=0;i<veriler.size();i++){

           veriler.get(i).sendKeys(form.get(i));

       }


    }
}
