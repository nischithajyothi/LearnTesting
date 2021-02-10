import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.sql.Driver;

//Functions required
public class GlobalExec {

    controls controls = new controls();

    public static WebDriver driver;
    public static String url = "https://blazedemo.com/";

    //Setup the Driver
    public void driverSetUp()
    {
        //test to run on chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.setBinary(new File(""));

        driver = new ChromeDriver(options);
        
    }

    public void Login(String username,String password)
    {
        driver.get(url);
        controls.setText(By.id("username"),username);
        controls.setText(By.id("Password"), password);
        //ExtentHtmlreporter



    }

}


