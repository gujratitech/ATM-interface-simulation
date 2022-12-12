package bankmanagement;
import java.sql.*;


//there are 5 points to be kept in mind while doing JDBC connectivity
//1.Register the Driver
//2.Create Connection
//3.Create Statement
//4.Execute query
//5.Close connection
public class Connectivity {
    Connection c;
    Statement s;
    public Connectivity(){

        try {
//            Class.forName(com.mysql.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "harshsql369");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
