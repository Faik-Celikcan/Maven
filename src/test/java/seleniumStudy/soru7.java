package seleniumStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class soru7 extends TestBase {

    //Amazon sayfasına gidelim
    //Dropdown menuyu yazdıralım
    //Dropdown menuden baby secelim
    //arama bölümünden milk aratalım
   @Test
    public void TestS7() throws InterruptedException {

       driver.get("https://amazon.com");

       WebElement x = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

       Select y = new Select(x);

       List<WebElement> lst = y.getOptions();

       for(WebElement w:lst){

           System.out.println(w.getText());
       }
       y.selectByVisibleText("Baby");

       Thread.sleep(2000);

       driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("milk",Keys.ENTER);
       Thread.sleep(2000);

   }

}
