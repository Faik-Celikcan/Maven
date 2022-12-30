package CalismaAlani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class calisma_1 {

    static WebDriver driver;

    public static void main(String[] args) {

        /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
        if(x.equalsIgnoreCase("Ucan Amasyali")){
            System.out.println("ok");

        }else System.out.println("no");


        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();

        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();

        driver.findElement(By.xpath("//*[@class='DTE_Form_Buttons']")).click();

        Boolean y = driver.findElement(By.xpath("//*[@class='dataTables_empty']")).isDisplayed();

        if(y=true){
            System.out.println("ok");

        }else System.out.println("no");
    }
}
