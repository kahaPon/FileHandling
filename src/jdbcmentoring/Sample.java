/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcmentoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2ndyrGroupA
 */
public class Sample {
    
    public static void main (String []args) 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbURL = "jdbc:mysql://localhost:3306/sample";
            Connection connection = DriverManager.getConnection(dbURL, "root", "");
            
            insert100Rows(connection,1,2,3,4,5);
            print(connection);
            
            connection.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Cannot load driver");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void print(Connection connection) throws SQLException
    {
        if(connection != null){
            System.out.println("Connection established!");
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM groupmates");
            
            while (rs.next()){
                int fst = rs.getInt("fst");
                int snd = rs.getInt("snd");
                int trd = rs.getInt("trd");
                int frt = rs.getInt("frt");
                int fth = rs.getInt("fth");
                
                System.out.println(fst + ", " + snd + ", " + trd+ ", "+frt+", ");
            }
        }
    }
    
    public static void insert100Rows(Connection connection,int fst,int snd,int trd, int frt, int fth) throws SQLException
    {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO data VALUES (?,?,?,?,?)");
            
            statement.setInt(1, fst);
            statement.setInt(2, snd);
            statement.setInt(3, trd);
            statement.setInt(4, frt);
            statement.setInt(5, fth);
            
            int nd = statement.executeUpdate();
            
            if(nd > 0)
            {
                System.out.println("Inserted "+nd+"rows");
            }
            else
            {
                System.out.println("Not Inserted");
            }
        
    }
}
