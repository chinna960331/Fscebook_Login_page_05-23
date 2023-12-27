package Framework.Testcases;

import Framework.Functions.ZOMclass;

import org.testng.annotations.*;


public class TC001 {
    ZOMclass zom=new ZOMclass();
    @BeforeMethod
    public void TC001_open_browser()throws Exception{
        zom.OpenWebpage();
    }
    @Test
    public void TC001_FBPage()throws Exception {
        zom.OpenWebBrowser();
        zom.fbpage();
        zom.logoutaccount();
    }
    @AfterMethod
    public void TC001_Close()throws Exception{
        zom.Closebrowser();
    }
}
