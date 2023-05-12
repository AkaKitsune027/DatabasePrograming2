package dbprogramming2;


import java.sql.ResultSet;
import dbprogramming2.DbProgramming2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LAB8 {
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Pp272210*";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
             Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
              String sql = "SELECT * FROM student";
              ResultSet results = statement.executeQuery(sql);
              
              while  (results.next()){
                  System.out.println(results.getString(1)+" "+results.getString(2)+" "+results.getString(3)+" "+results.getString(4)+" "+results.getString(5));
              }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}