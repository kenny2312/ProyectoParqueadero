package dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class myConnection {
    public static String dbName = "db_registro";
    public static String dbUser = "root";
    public static String dbPass = "";
    public static Connection ConectToMysql(){
        Connection con = null;
        try {
            System.out.println("XD");
            System.out.println("XD1");
            String strCon = "jdbc:mysql://localhost/"+dbName;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(strCon,dbUser,dbPass);
        } catch (Exception e) {
           
        }
        return con;
    }
}
