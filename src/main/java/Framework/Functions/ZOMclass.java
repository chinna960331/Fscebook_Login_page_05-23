package Framework.Functions;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ZOMclass{
    WebDriver driver;
    public void OpenWebpage()throws Exception{
        System.setProperty("webdriver.edge.driver","C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23\\chromedriver.exe");
        WebDriver driver= new EdgeDriver();
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
}
