package seleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class p7 extends TestBase {


    @Test
    public void Test01(){
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        //2. some-file.txt dosyasini indirelim
        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        waitFor(5);
        String dosyaYolu="C:\\Users\\Faik ÇELİKCAN\\Downloads\\some-file.txt";
        boolean x=Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(x);
    }
}
