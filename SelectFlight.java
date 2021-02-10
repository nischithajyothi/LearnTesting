import org.openqa.selenium.By;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class SelectFlight {

    GlobalExec Ge = new GlobalExec();
    controls control = new controls();
    DBData dbData = new DBData();

    String fromCity = dbData.ReadTCData("Select Flight","DT_From_City");
    String toCity = dbData.ReadTCData("Select Flight","DT_to_City");

    public SelectFlight() throws SQLException {
    }


    public void main(){
        String validationText=null;
        try
        {

            Ge.driverSetUp();
            control.dropdownSelect(By.name("fromPort"),fromCity);
            control.dropdownSelect(By.name("toPort"),toCity);
            control.clickbutton(By.className("btn btn-primary"));
            GlobalExec.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
            validationText = GlobalExec.driver.findElement(By.xpath("/html/body/div[2]/h3")).getText();
            if(validationText.contains(fromCity+"to"+toCity))
            {
                System.out.println("Pass");//Extent reports should be implemented
            }
            else
            {
                System.out.println("Navigation Failed");
                //Assert Fail
            }


        }
        catch(Exception e)
        {

        }
    }

}
