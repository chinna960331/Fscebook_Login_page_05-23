package Framework.Testcases;


import Framework.Functions.selenium_project_class;
import org.testng.annotations.*;


public class freamework {

    selenium_project_class spc = new selenium_project_class();

    @BeforeTest
    public void Test_Broswer() throws Exception {
        spc.Webbroswer();
    }

    @Test
    public void Test_Webpage() throws Exception {
        spc.Webpage();
//        spc.login_info();
//        spc.sec_login_info();
//        spc.thd_login_info();
//        spc.Iframe_1();
//        spc.Iframe_2();
//        spc.out_of_frame();
//        spc.chick_box();
//        spc.Date();
//        spc.Double_click();
//        spc.Scroll();
//        spc.Drag_Drop();
//        spc.Temp();
//        spc.Alert();
//        spc.From();
//        spc.Login_page();
//        spc.Mul_();
//        spc.screenshort("Mul_");
//        spc.Sub_();
//        spc.screenshort("Sub_");
//        spc.Add_();
//        spc.screenshort("Add_");
//        spc.Calc_();
//        spc.screenshort("Calc_");
//        spc.Attributes_();
//        spc.screenshort("Attributes");
        spc.Text_Box();
        spc.screenshort("TextBox");
        spc.Alerts();
        spc.Window_Handle();
        spc.in_new_page();
        spc.New_test();
    }

    @AfterTest
    public void Close_Browser() throws Exception {
//        spc.close();
    }
}
