package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectSQL {
    public Connection getJDBCConnection() {
        Connection connection =null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String UserName = "sa";
            String PassWord = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=JSP";
            connection = DriverManager.getConnection(url, UserName, PassWord);
            if(connection != null){
                System.out.println("Success");
            }
            else {
                System.out.println("Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
