package dbprogramming2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB12 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Pp272210*";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "INSERT INTO student(studentID,firstName,lastName,email,deptID)"
                          + "VALUES(?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "651084");
            preparedStatement.setString(2, "Sittha");
            preparedStatement.setString(3, "Manittayakul");
            preparedStatement.setString(4, "zyxma.666@gmail.com");
            preparedStatement.setString(5, "IT");
            
            preparedStatement.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

