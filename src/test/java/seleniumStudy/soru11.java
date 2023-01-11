package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru11 extends TestBase {

    @Test
    public void TestS11(){

        driver.get("https://www.amazon.com.tr");

        driver.findElement(By.id("sp-cc-accept")).click();



        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone13 512", Keys.ENTER);



        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        Assert.assertTrue(result.isDisplayed());

        driver.findElement(By.xpath("(//img[@class='s-image'])[5]")).click();



        driver.findElement(By.xpath("//*[@aria-labelledby='color_name_3-announce']")).click();

        waitFor(3);

       // driver.findElement(By.id("size_name_2-announce")).click();

        String pembe512Baslik = driver.findElement(By.id("productTitle")).getText();

        System.out.print(pembe512Baslik);

        String pembeSize = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();

        System.out.println(" Size : "+pembeSize);

        String pembeColor = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();

        System.out.print("Color: "+pembeColor);

        String pembePrice=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        System.out.println(" Price : "+pembePrice);

        String pembeStok = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();

        System.out.println("Stock: "+pembeStok);

        driver.findElement(By.xpath("(//*[@data-idxintoggleswatchlist='2'])[1]")).click();

        waitFor(2);

        driver.findElement(By.xpath("//*[@id='size_name_1']")).click();

        waitFor(2);

        String mavi256Baslik = driver.findElement(By.id("productTitle")).getText();

        System.out.print(mavi256Baslik);

        String mavi256Size = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();

        System.out.println(" Size : "+mavi256Size);

        String mavi256Color = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();

        System.out.print("Color: "+mavi256Color);

        String mavi256Price=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        System.out.println(" Price : "+mavi256Price);

        String mavi256Stok = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();

        System.out.println("Stock: "+mavi256Stok);

        driver.findElement(By.xpath("//*[@id='size_name_0']")).click();

        waitFor(2);

        String maviBaslik = driver.findElement(By.id("productTitle")).getText();

        System.out.print(maviBaslik);

        String maviSize = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();

        System.out.println(" Size : "+maviSize);

        String maviColor = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();

        System.out.print("Color: "+maviColor);

        String maviPrice=driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        System.out.println(" Price : "+maviPrice);

        String maviStok = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();

        System.out.println("Stock: "+maviStok);

    }
}
