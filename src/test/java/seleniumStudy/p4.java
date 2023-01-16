package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class p4 extends TestBase {


    /*
    http://uitestpractice.com/Students/Actions adresine gidelim
    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    Accept ile alert'ü kapatalım
    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
     */

    @Test
    public void Test01(){

        driver.get("http://uitestpractice.com/Students/Actions");

        Actions actions=new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='div2']"))).perform();

        waitFor(3);

        actions.doubleClick(driver.findElement(By.xpath("//*[@name='dblClick']"))).perform();

        Assert.assertEquals("Double Clicked !!",driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        waitFor(2);

        actions.dragAndDrop(driver.findElement(By.xpath("//*[@id='draggable']//p")),driver.findElement(By.xpath("//*[@id='droppable']//p"))).perform();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        Assert.assertEquals("Dropped!",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='droppable']//p"))).getText());


    }
}
