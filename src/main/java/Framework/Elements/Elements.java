package Framework.Elements;

import org.openqa.selenium.By;

public class Elements {

    public static final By name=By.xpath("//*[@name='email']");
    public static final By pass=By.xpath("//*[@name='pass']");
    public static final By Login=By.xpath("//*[text()='Log in']");
    public static final By logo=By.cssSelector("//*[@preserveAspectRatio='xMidYMid slice']");
    public static final By logout=By.cssSelector("div:nth-child(5) > .x1i10hfl .x193iq5w");
}
