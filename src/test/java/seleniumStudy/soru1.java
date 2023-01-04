package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class soru1 extends TestBase {

    /*
     1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
     2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
     3-Option3 ü seçin.
     4-Option3 ün seçili olduğunu doğrulayın.
    */

    @Test
    public void TestS1(){

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement x=driver.findElement(By.xpath("//*[text()='Dropdown Example']"));

        Assert.assertTrue(x.isDisplayed());

        WebElement y= driver.findElement(By.id("dropdown-class-example"));

        Select z=new Select(y);

        z.selectByValue("option3");

        WebElement t=z.getFirstSelectedOption();

        Assert.assertTrue(t.isSelected());

    }
}
