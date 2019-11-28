/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcmentoring;

import java.sql.*;

/**
 *
 * @author 2ndyrGroupA
 */
public class JDBCmentoring {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbURL = "jdbc:mysql://localhost:3306/sample";
            Connection connection = DriverManager.getConnection(dbURL, "root", "");
            
        
            //addNewStudents(connection, 3,"louie",19);
            addNewStudents(connection, 5,"louie",19);
            //deleteById(connection, 5);
            updateNameById(connection, 5, "wapo");
            updateAgeById(connection, 5, 30);
            //addNewStudents(connection, 2, "niere", 20);
            deleteById(connection,2);
            printAllStudents(connection);
            connection.close();
            
        }catch(ClassNotFoundException e){
            System.out.println("Cannot load Driver");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void printAllStudents(Connection connection) throws SQLException {
        if(connection != null){
            System.out.println("Connection established!");
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM groupmates");
            
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                
                System.out.println(id + ": " + name + ", " + age);
            }
        }
    }
    
    
     public static void addNewStudents(Connection connection, int id, String name, int age) throws SQLException {
         PreparedStatement statement =  connection.prepareStatement("INSERT INTO groupmates VALUES (?, ?, ?)");
         
         statement.setInt(1, id);
         statement.setString(2, name);
         statement.setInt(3, age);
         
         int nb = statement.executeUpdate();
         if (nb > 0){
             System.out.println("Inserted " + nb + " rows");
         }else{
             System.out.println("Not inserted");
         }
     }
     
     public static void deleteById(Connection connection, int id) throws SQLException {
         Statement statement = connection.createStatement();
         
         int nbRows = statement.executeUpdate("DELETE FROM groupmates WHERE id = "+ id);
              
         if (nbRows > 0){
             System.out.println("Deleted id: "+ id);
         }else{
             System.out.println("Not inserted");
         }
     }

     public static void updateNameById(Connection connection,int id, String name) throws SQLException {
         
        PreparedStatement statement = connection.prepareStatement("UPDATE groupmates SET name = ? WHERE id = ?");
        
        statement.setString(1, name);
        statement.setInt(2, id);

        int nbRows = statement.executeUpdate();     
        if (nbRows > 0){
            System.out.println("Updated name succesfully id: "+ id);
        }else{
            System.out.println("Not updated");
        }
     } 

     public static void updateAgeById(Connection connection,int id, int newAge) throws SQLException {
         
        PreparedStatement statement = connection.prepareStatement("UPDATE groupmates SET age = ? WHERE id = ?");
        
        statement.setInt(1, newAge);
        statement.setInt(2, id);

        int nbRows = statement.executeUpdate();     
        if (nbRows > 0){
            System.out.println("Updated age succesfully id: "+ id);
        }else{
            System.out.println("Not updated");
        }
     } 

}
