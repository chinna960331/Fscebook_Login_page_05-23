package Framework.Functions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class selenium_project_class {
    static WebDriver driver;
    public void Webbroswer() throws Exception {
        System.setProperty("webdeiver.chrome.driver",
                "C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log().info("By this we need to open the Web Broswer");
    }
    public static Logger log() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("src/log4j.properties"));
        PropertyConfigurator.configure(props);
        BasicConfigurator.configure();
        return Logger.getLogger(selenium_project_class.class.getName());
    }
    public void Webpage() throws Exception {
//		Thread.sleep(2000);
        driver.get("https://only-testing-blog.blogspot.com/");
        log().info("By this we need to open the Web Page");
    }
    public void login_info() throws Exception {
        driver.findElement(By.id("gparent_1")).sendKeys("Malla Reddy");
        driver.findElement(By.id("parent_1")).sendKeys("Narsi Reddy");
        driver.findElement(By.id("child_1")).sendKeys("Srikanth Reddy");
        log().info("By this all the information of the family will auto filled");
    }
    public void sec_login_info() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.id("gparent_2")).sendKeys("gparent_2");
        driver.findElement(By.id("parent_2")).sendKeys("Narsi Reddy");
        driver.findElement(By.id("child_2")).sendKeys("Srikanth Reddy");
        log().info("By this we can fill the second in formation of the family will auto filled");
    }
    public void thd_login_info() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.id("tooltip-1")).sendKeys("info3");
        driver.findElement(By.id("sname")).sendKeys("sname3");
        driver.findElement(By.id("yaddress")).sendKeys("Adress3333");
        log().info("By this we can fill the third in formation of the family will auto filled");
    }
    public void Iframe_1() throws Exception {
        Thread.sleep(1000);
        Actions Act = new Actions(driver);
        Act.moveToElement(driver.findElement(By.id("frame1"))).perform();
        driver.switchTo().frame("frame1");
        log().info("By this we can fill the iframe1 in formation of the family will auto filled");
    }
    public void Iframe_2() throws Exception {
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        Actions Act = new Actions(driver);
        Act.moveToElement(driver.findElement(By.id("frame2"))).perform();
        driver.switchTo().frame("frame2");
        log().info("By this we can fill the iframe2 in formation of the family will auto filled");
    }
    public void out_of_frame() throws Exception {
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("text1")).sendKeys("town_name1");
        driver.findElement(By.id("text2")).sendKeys("town_name2");
        log().info("By this we can fill the out of frame in formation of the family will auto filled");
    }
    public void chick_box() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click();
        driver.findElement(By.xpath("(//*[@type='checkbox'])[4]")).click();
        driver.findElement(By.xpath("(//*[@type='checkbox'])[5]")).click();
        log().info("By this we can Click those [5] chick boxes");
    }
    public void Date() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.id("datepicker")).sendKeys("31/03/1996");
        log().info("Auto fill the date");
    }
    public void Double_click() throws Exception {
        Thread.sleep(1000);
        Actions Act = new Actions(driver);
        WebElement doubleclick = driver.findElement(By.xpath("//*[text()='Double-Click Me To See Alert']"));
        Act.doubleClick(doubleclick).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Act.doubleClick(doubleclick).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
    public static void scroll_element(WebElement element) throws Exception {
        Thread.sleep(1000);
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("argument[0].scrollIntoView(true);", element);
            Thread.sleep(1000);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
    public void Scroll() throws Exception {
        WebElement scroll = driver.findElement(By.xpath("(//*[@class='scroll'])"));
//        Actions Act = new Actions(driver);
//        Act.
        scroll_element(scroll);
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        Thread.sleep(2000);
//        js.executeScript("window.scrollBy(0,500);");
//        Thread.sleep(2000);
//        js.executeScript("window.scrollBy(0,-500);");
//        scroll_element(driver, scroll);
//        scroll.sendKeys(Keys.DOWN);
//        scroll.sendKeys(Keys.UP);
    }
    public void Drag_Drop()throws Exception {
        driver.findElement(By.xpath("//*[text()='Drag and Drop']")).click();
        Actions Act=new Actions(driver);
        Thread.sleep(1000);
        WebElement drag=driver.findElement(By.id("dragdiv"));
        WebElement drop=driver.findElement(By.id("dropdiv"));
        Thread.sleep(1000);
        Act.moveToElement(drag).dragAndDrop(drag,drop).perform();
        Thread.sleep(1000);
        driver.navigate().back();
    }
    public void Temp()throws Exception {
        Actions Act=new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("(//*[text()='Lion'])[2]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.name("fname")).sendKeys("name123");
        driver.findElement(By.name("lname")).sendKeys("name321");
        driver.findElement(By.name("sname")).sendKeys("name456");
        driver.findElement(By.xpath("(//*[@type='checkbox'])[9]")).click();
        Thread.sleep(2000);
    }
    public void Alert()throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@type='text'])[13]")).sendKeys("name0000");
        driver.findElement(By.xpath("(//*[@type='text'])[14]")).sendKeys("name111");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
    public void From()throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.name("FirstName")).sendKeys("ravana");
        driver.findElement(By.name("LastName")).sendKeys("lanka");
        driver.findElement(By.name("EmailID")).sendKeys("ravanalanka@gmail.com");
        driver.findElement(By.name("MobNo")).sendKeys("7418529630");
        driver.findElement(By.name("Company")).sendKeys("Rainier");
        driver.findElement(By.xpath("//*[@value='Submit']")).click();
        driver.switchTo().alert().accept();
    }
    public void Login_page()throws Exception {
        Thread.sleep(1000);
        Actions Act=new Actions(driver);
        Act.moveToElement(driver.findElement(By.name("userid"))).sendKeys("chinna").
                moveToElement(driver.findElement(By.name("pswrd"))).sendKeys("password").
                moveToElement(driver.findElement(By.xpath("//*[@value='Login']"))).click().perform();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Act.moveToElement(driver.findElement(By.xpath("//*[@value='Login']"))).sendKeys("adsdfds").
                moveToElement(driver.findElement(By.name("lname"))).sendKeys("xsad").perform();
    }
    public void Mul_()throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Mul']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@value='  4  ']")).click();
        driver.findElement(By.xpath("//*[@value='  x  ']")).click();
        driver.findElement(By.xpath("//*[@value='  5  ']")).click();
        driver.findElement(By.xpath("//*[@value='  =  ']")).click();
    }
    public void Sub_()throws Exception {
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Actions Act=new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='Sub']"))).click().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='  4  ']")).click();
        driver.findElement(By.xpath("//*[@value='  -  ']")).click();
        driver.findElement(By.xpath("//*[@value='  5  ']")).click();
        driver.findElement(By.xpath("//*[@value='  =  ']")).click();
    }
    public void Add_()throws Exception {
        driver.navigate().back();
        Actions Act=new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='Add']"))).click().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='  4  ']")).click();
        driver.findElement(By.xpath("//*[@value='  +  ']")).click();
        driver.findElement(By.xpath("//*[@value='  5  ']")).click();
        driver.findElement(By.xpath("//*[@value='  =  ']")).click();
    }
    public void Calc_()throws Exception {
        driver.navigate().back();
        Actions Act =new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='Calc']"))).click().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='  4  ']")).click();
        driver.findElement(By.xpath("//*[@value='  /  ']")).click();
        driver.findElement(By.xpath("//*[@value='  2  ']")).click();
        driver.findElement(By.xpath("//*[@value='  =  ']")).click();
    }
    public void Attributes_()throws Exception {
        driver.navigate().back();
        Actions Act=new Actions(driver);
        Thread.sleep(1000);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='Attributes']"))).click().perform();
        Thread.sleep(1000);
        driver.findElement(By.id("text1")).sendKeys("name1");
//        driver.findElement(By.id("text2")).sendKeys("name2");
        driver.findElement(By.id("text4")).sendKeys("name3");
        driver.findElement(By.id("check2")).click();
        driver.findElement(By.id("radio1")).click();
        WebElement file=driver.findElement(By.name("img"));
        String filepath="C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23";
        Thread.sleep(1000);
        file.sendKeys(filepath);
    }
    public void Text_Box() throws Exception {
//        driver.navigate().back();
        Thread.sleep(1000);
        Actions Act=new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='TextBox']"))).click().perform();
        driver.findElement(By.id("text1")).sendKeys("lastname");
        driver.findElement(By.id("text4")).sendKeys("Hidden name");
        driver.findElement(By.id("check1")).click();
        driver.findElement(By.id("radio1")).click();
        WebElement file=driver.findElement(By.name("img"));
        String filepath="C:\\Users\\Siri\\IdeaProjects\\Fscebook_Login_page_05-23";
        Thread.sleep(1000);
        file.sendKeys(filepath);
        driver.findElement(By.id("Carlist")).sendKeys("Maruti Car");
//        driver.close();
    }
    public void Alerts()throws Exception {
        driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@onclick='myFunction1()']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@onclick='myFunctionf()']")).click();
        driver.switchTo().alert().sendKeys("hi");
        driver.switchTo().alert().accept();
        log().info("three alerts need to work properly");
        driver.findElement(By.xpath("//*[text()='Open New Page']")).click();
//        driver.findElement(By.xpath("//*[text()='Open New Page']")).click();
    }
    public void in_new_page()throws Exception {
        driver.findElement(By.id("fname")).sendKeys("name first");
        driver.findElement(By.xpath("//*[@value='Car']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("submitButton")).click();
        driver.close();
    }
    public void New_test()throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show Me Prompt']")).click();
        driver.switchTo().alert().accept();
        driver.navigate().back();
        Actions Act= new Actions(driver);
        Act.moveToElement(driver.findElement(By.xpath("//*[text()='New Testing']"))).click();
        driver.findElement(By.name("fname")).sendKeys("killer");
        driver.findElement(By.id("text4")).sendKeys("Ravana");
        driver.findElement(By.xpath("//*[@value='Car']")).click();
        driver.findElement(By.xpath("//*[@value='male']")).click();
        WebElement file=driver.findElement(By.name("img"));
        String filepath="C:\\Users\\Siri\\Pictures\\Screenshots";
        Thread.sleep(1000);
        file.sendKeys(filepath);
    }
    public void Window_Handle()throws Exception {
        String homepage=driver.getWindowHandle();
        Set<String> newpage=driver.getWindowHandles();
        newpage.remove(homepage);
        String Window=newpage.iterator().next();
        driver.switchTo().window(Window);
    }
    public void screenshort(String fileName)throws Exception {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File screen=ts.getScreenshotAs(OutputType.FILE);
        String filename = "./" + fileName + ".jpg";
        FileUtils.copyFile(screen,new File(filename));
    }
    public static Properties readPropertyFile(String fileName) throws Exception {
        File file = new File(System.getProperty("user.dir") +
                "\\src\\main\\java\\Framework\\Testdata\\" + fileName + ".properties");
        FileInputStream fis = new FileInputStream(file);
        log().info("The file is present here: " + file);
        Properties p = new Properties();
        p.load(fis);
        return p;
    }
    public void close() throws Exception {
        Thread.sleep(2000);
//        driver.close();
        driver.quit();
    }
}
