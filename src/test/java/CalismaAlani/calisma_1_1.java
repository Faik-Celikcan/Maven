package CalismaAlani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class calisma_1_1 {

    static WebDriver driver;

    @Before
    public void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void Test01(){

        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();

        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Ucan");
        driver.findElement(By.xpath("//*[@id='DTE_Field_last_name']")).sendKeys("Amasyali");
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("Seko");
        driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("Google");
        driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys("Sekolor");
        driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).sendKeys("2022-11-14");
        driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("7000");

        driver.findElement(By.xpath("//*[@class='DTE_Form_Buttons']")).click();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Ucan Amasyali");
        String x = driver.findElement(By.xpath("//*[@class='sorting_1']")).getText();

        Assert.assertEquals("Ucan Amasyali",x);
        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();

        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();

        driver.findElement(By.xpath("//*[@class='DTE_Form_Buttons']")).click();

        String r= driver.findElement(By.xpath("//*[@class='dataTables_empty']")).getText();

        Assert.assertFalse(r.equalsIgnoreCase("Ucan Amasyali"));

    }

}
