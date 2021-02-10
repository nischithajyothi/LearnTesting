import org.openqa.selenium.By;

import java.sql.SQLException;

public class PersonalDetails {

    GlobalExec Ge = new GlobalExec();
    controls control = new controls();
    DBData dbData = new DBData();

    String sName= dbData.ReadTCData("PersonalDetails","DT_NAME");
    String sAddress = dbData.ReadTCData("PersonalDetails","DT_ADDRESS");
    String sCity = dbData.ReadTCData("PersonalDetails","DT_CITY");
    String sState = dbData.ReadTCData("PersonalDetails","DT_STATE");
    String sZipCode = dbData.ReadTCData("PersonalDetails","DT_ZIPCODE");
    String sCardType = dbData.ReadTCData("PersonalDetails","DT_CARD_TYPE");
    String CCNUM = dbData.ReadTCData("PersonalDetails","DT_CC_NUM");
    String  month = dbData.ReadTCData("PersonalDetails","DT_CC_MONTH");
    String year = dbData.ReadTCData("PersonalDetails","DT_CC_YEAR");
    String cardName = dbData.ReadTCData("PersonalDetails","DT_CARD_NAME");
    int confirmationID;
    String validationText =null;

    public PersonalDetails() throws SQLException {
    }

    public void main(String[] args)
    {
        try
        {
            control.setText(By.id("inputName"),sName);
            control.setText(By.id("address"),sAddress);
            control.setText(By.id("city"),sCity);
            control.setText(By.id("state"),sState);
            control.setText(By.id("zipCode"),sZipCode);
            control.dropdownSelect(By.id("cardType"),sCardType);
            control.setText(By.id("creditCardNumber"),CCNUM);
            control.setText(By.id("creditCardMonth"),month);
            control.setText(By.id("creditCardYear"),year);
            control.setText(By.id("nameOnCard"),cardName);
            control.clickbutton(By.className("btn btn-primary"));
            //GlobalExec.driver.findElement(By.id("creditCardNumber")).s
            //Check the successmessage and capture the Confirmation ID

            validationText = GlobalExec.driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
            confirmationID = Integer.parseInt(GlobalExec.driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
            if ((confirmationID!=0 || confirmationID!=' ') && validationText.contains("Thank you for your purchase today"))
            {
                //Sytem.out.Println("Confirmation ID = "+confirmationID
            }



        }
        catch (Exception e)
        {
            //System.out.println()
        }
    }
}
