package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class DAO {
    protected static Connection connection;
    protected static PreparedStatement ps;
    protected static ResultSet rs;
    private static String connectURL = "jdbc:mysql://127.0.0.1:3306/university";
    private static String user = "root";
    private static String pass = "123";

    {}
    static{} 
    
    protected static void connect() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectURL, user, pass);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
