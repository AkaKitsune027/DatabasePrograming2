package dbprogramming2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB10 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Pp272210*";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE student SET email = 'wanassanan.tri-@kmutt.ac.th' WHERE studentID = 650070";
            String sql1 = "UPDATE student SET studentID = 651070 WHERE studentID = 650070";
            String sql2 = "UPDATE student SET deptID = 'IT' WHERE deptID = 123";


            statement.executeUpdate(sql2);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

