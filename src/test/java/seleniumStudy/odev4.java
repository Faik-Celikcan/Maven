package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class odev4 extends TestBase {
    //Bir Class olusturalim KeyboardActions2
    //https://html.com/tags/iframe/ sayfasina gidelim
    //video’yu gorecek kadar asagi inin
    //videoyu izlemek icin Play tusuna basin
    //videoyu calistirdiginizi test edin

    @Test
    public void Test01(){
        driver.get("https://html.com/tags/iframe/");

        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN).perform();

        waitFor(3);

        driver.switchTo().frame(0);

        WebElement x=driver.findElement(By.id("movie_player"));

        String ilk=x.getAttribute("class");

        x.click();

        String ikinci=x.getAttribute("class");

        System.out.println(ilk);
        System.out.println(ikinci);

        Assert.assertFalse(ilk.equals(ikinci));
    }
}
