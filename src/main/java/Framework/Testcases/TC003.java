package Framework.Testcases;

import Framework.Functions.ZOMclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC003 {
    ZOMclass zom=new ZOMclass();

    @Test
    public void Testclass() throws Exception {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23\\chromedriver.exe");
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.xpath("//*[text()=' Login ']")).click();
        zom.OpenWebpage();
        zom.openorange();
        zom.orangeHRM();
        zom.closetab();

    }
}
