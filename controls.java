import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

//Controls Required
public class controls {

    public void setText(By element,String value)
    {
        try {
            GlobalExec.driver.findElement(element).sendKeys(value);
        }
        catch (Exception e)
        {

        }

    }

    public void dropdownSelect(By element,String dropdownValue)
    {

        Select selectValue = new Select(GlobalExec.driver.findElement(element));
        try
        {
            selectValue.selectByValue(dropdownValue);
        }
        catch (Exception e)
        {
            System.out.println("exception"+e);//instead of this Extent reports can be implemented.....
        }
    }

    public void clickbutton(By element)
    {
        try{
            GlobalExec.driver.findElement(element).click();
        }
        catch (Exception e)
        {
            //System.Out
        }
    }

    public void clickCheckbox(By element)
    {
        try
        {
            boolean sCheck = GlobalExec.driver.findElement(element).isSelected();
            if (sCheck=true)
            {
                //System.out.println(already Checked
            }
            else
            {
                GlobalExec.driver.findElement(element).click();
            }
        }
        catch (Exception e)
        {
            //System.out.println(e)
        }
    }


}
