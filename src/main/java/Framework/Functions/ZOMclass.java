package Framework.Functions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static Framework.Elements.Elements.*;


public class ZOMclass{
    WebDriver driver;
    public void OpenWebpage()throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        log().info("BY this we need to log in to the webBrowser");
    }
    public static Logger log()throws Exception {
        Properties pro=new Properties();
        pro.load(new FileInputStream("src/log4j.properties"));
        PropertyConfigurator.configure(pro);
        BasicConfigurator.configure();
        return Logger.getLogger(ZOMclass.class.getName());
    }
    public void OpenWebBrowser()throws Exception {
        driver.get("https://www.facebook.com/");
        log().info("BY this we need to log in to the website");
    }
    public void fbpage()throws Exception{
        String correctID="sreekanthpininti466@gmail.com";
        String correctPASS="94408210320";
        String incorrectID="ssdsdsdsd";
        String incorrectPASS="741852963";

        String [][] Datas={
                {incorrectID,incorrectPASS},
                {incorrectID,correctPASS},
                {correctID,incorrectPASS},
                {correctID,correctPASS}
        };
        for(String[] Data:Datas){
            WebElement username_field=driver.findElement(name);
            WebElement Password_field=driver.findElement(pass);
            username_field.clear();
            Password_field.clear();
            username_field.sendKeys(Data[0]);
            Password_field.sendKeys(Data[1]);
            WebElement Login_field=driver.findElement(Login);
            Login_field.click();
            log().info("For loop is running");
            try{
                Thread.sleep(2000);
                TakesScreenshot ts= (TakesScreenshot) driver;
                File file=ts.getScreenshotAs(OutputType.FILE);
                String filename="./fb"+Data[0]+" "+Data[1]+".jpg";
                FileUtils.copyFile(file,new File(filename));
                driver.navigate().back();
            }catch (Exception e){
            }
            if(driver.getCurrentUrl().contains("facebook")){
                log().info("Login failed by username"+Data[0]+"and Password"+Data[1]);
            }else{
                log().info("Login success By username"+Data[0]+"and Password"+Data[1]);
                log().info("For loop stoped here");
                break;
            }
        }
    }
//    public void logoutaccount()throws Exception {
//        driver.findElement(logo).click();
//        driver.findE/lement(logout).click();
//    }
    public void Closebrowser()throws Exception{
//        driver.close();
        log().info("By this close field the Web browser will closed");
    }
}
