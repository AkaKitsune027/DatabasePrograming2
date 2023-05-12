package dbprogramming2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB15 {

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
            ResultSet resultSet = statement.executeQuery(sql); 
            ResultSetMetaData rsMetaData = resultSet.getMetaData();           
            
            for (int i = 1; i<= rsMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
                System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

