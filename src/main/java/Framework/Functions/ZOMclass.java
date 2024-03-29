package Framework.Functions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Framework.Elements.Elements.*;

public class ZOMclass {
    WebDriver driver;
    public void OpenWebpage() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log().info("BY this we need to log in to the webBrowser");
    }
    public static Logger log() throws Exception {
        Properties pro = new Properties();
        pro.load(new FileInputStream("src/log4j.properties"));
        PropertyConfigurator.configure(pro);
        BasicConfigurator.configure();
        return Logger.getLogger(ZOMclass.class.getName());
    }
    public void OpenWebBrowser() throws Exception {
        driver.get("https://www.facebook.com/");
        log().info("BY this we need to log in to the website");
    }
    public void fbpage() throws Exception {
        String correctID = "sreekanthpininti466@gmail.com";
        String correctPASS = "94408210320";
        String incorrectID = "ssdsdsdsd";
        String incorrectPASS = "741852963";
        log().info("");
        String[][] Datas = {
                {incorrectID, incorrectPASS},
                {incorrectID, correctPASS},
                {correctID, incorrectPASS},
                {correctID, correctPASS}
        };
        for (String[] Data : Datas) {
            WebElement username_field = driver.findElement(name);
            WebElement Password_field = driver.findElement(pass);
            username_field.clear();
            Password_field.clear();
            username_field.sendKeys(Data[0]);
            Password_field.sendKeys(Data[1]);
            WebElement Login_field = driver.findElement(Login);
            Login_field.click();
            log().info("For loop is running");
            try {
                Thread.sleep(2000);
                TakesScreenshot ts = (TakesScreenshot) driver;
                File file = ts.getScreenshotAs(OutputType.FILE);
                String filename = "./fb" + Data[0] + " " + Data[1] + ".jpg";
                FileUtils.copyFile(file, new File(filename));
                driver.navigate().back();
            } catch (Exception e) {
            }
            if (driver.getCurrentUrl().contains("facebook")) {
                log().info("Login failed by username" + Data[0] + "and Password" + Data[1]);
            } else {
                log().info("Login success By username" + Data[0] + "and Password" + Data[1]);
                log().info("For loop stoped here");
                break;
            }
        }
    }
    public void logoutaccount() throws Exception {
        Thread.sleep(2000);
        WebElement img = driver.findElement(logo);
        Actions Act = new Actions(driver);
        Act.moveToElement(img).click(img).build().perform();
        img.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(logout).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@role='button']")).click();
        Thread.sleep(2000);
    }
    public void openorange()throws Exception{
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log().info("BY this we need to log in to the website");
    }
    public void orangeHRM() throws Exception {
        String CorrectID = "Admin";
        String CorrectPass = "admin123";
        String IncorrectID = "abcdefg";
        String IncorrectPass = "123456";

        String[][] Data = {
                {IncorrectID, CorrectPass},
                {CorrectID, IncorrectPass},
                {IncorrectID, IncorrectPass},
                {CorrectID, CorrectPass}
        };
        for (String[] entry : Data) {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            WebElement Username = driver.findElement(By.xpath("//*[@placeholder='Username']"));
            WebElement Password = driver.findElement(By.xpath("//*[@placeholder='Password']"));
            Username.clear();
            Password.clear();
            Username.sendKeys(entry[0]);
            Password.sendKeys(entry[1]);
            WebElement Login = driver.findElement(By.xpath("//*[text()=' Login ']"));
            Login.click();
            try {
                Thread.sleep(3000);
                TakesScreenshot ts = (TakesScreenshot) driver;
                File files = ts.getScreenshotAs(OutputType.FILE);
                String filename = "./orange" + entry[0] + " " + entry[1] + ".jpg";
                FileUtils.copyFile(files, new File(filename));
            } catch (Exception e) {
            }
            if (driver.getCurrentUrl().contains("opensource-demo")) {
                log().info("Login failed by username" + entry[0] + "and Password" + entry[1]);
            } else {
                log().info("Login success By username" + entry[0] + "and Password" + entry[1]);
                break;
            }
        }
    }
    public void closetab(){
        driver.close();
    }
    public void Closebrowser() throws Exception {
        driver.close();
        log().info("By this close field the Web browser will closed");
    }
}
