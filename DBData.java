import javax.management.Query;
import javax.security.auth.login.Configuration;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DBData {

    String DBServer = "TestDB";//this needs to be read from appconfig
    String DBName = "AutoTest";//this needs to be read from appconfig
    String DBUser = "testUser";//this needs to be read from appconfig
    String DBPassword = "testpass";// This needs to be read from Appconfig file due to security of password embedding


    public String ReadTCData(String TCName,String ParaName) throws SQLException {

        String sqlquery = null;
        String connectionstring;

        connectionstring = "SERVER=" + DBServer + ";" + "DATABASE=" + DBName + ";" + "UID=" + DBUser + ";" + "PASSWORD=" + DBPassword + ";";

        Connection connection = DriverManager.getConnection(connectionstring);
        Statement queryStatement = connection.createStatement();
        sqlquery = "SELECT TC_DATA FROM TC_LIST WHERE APPID=1 and TCID="+TCName;
        ResultSet dbdata = queryStatement.executeQuery(sqlquery);
        while(dbdata.next())
        {
            ParaName= dbdata.getString("PARA_VALUE").toString();


        }
        if(ParaName ==null)
        {
            //Write a failure message
        }
        return ParaName;
    }
}
