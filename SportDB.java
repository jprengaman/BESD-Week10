package com.promineotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SportDB {
  private String connectionString = "jdbc:mysql://localhost:3306/sports?allowMultiQueries=true";
  private String username = "root";
  private String password = "password";
    
  public void getAll() {
    try {
      // Open Connection
      Connection connection = DriverManager.getConnection(connectionString, username, password);
      System.out.println("MySQL connected at: " + connectionString);
      
      //Prepare SQL Statement
      String sql = "SELECT * FROM sports;";
      PreparedStatement statement = connection.prepareStatement(sql);
      //Bind parameters
      
      //Execute SQL Statement / Open Reader
      ResultSet rs = statement.executeQuery();
      
      //Read Row by Row
      while(rs.next()) {
        String id = rs.getString("id");
        String name = rs.getString("name");
        System.out.printf("[%s] %s%n", id, name);
      }
      //Close connection
      connection.close();
      System.out.println("MySQL connection closed.");
    } catch (SQLException e) {
      System.out.println("Database connection error:" + e.getMessage());
      e.printStackTrace();
    }
  }
  
public void addSport(String sportName) throws SQLException {
  try {
    // Open Connection
    Connection connection = DriverManager.getConnection(connectionString, username, password);
    System.out.println("MySQL connected at: " + connectionString);
    
    //Prepare SQL Statement
    String sql = "INSERT INTO sports (name) VALUES (?);";
    PreparedStatement statement = connection.prepareStatement(sql);
    //Bind parameters
    statement.setString(1, sportName);
    //Execute SQL Statement / Open Reader
    statement.executeUpdate();
    
    //Read Row by Row
    
    //Close connection
    connection.close();
    System.out.println("MySQL connection closed.");
  } catch (SQLException e) {
    System.out.println("Database connection error:" + e.getMessage());
    e.printStackTrace();
  }
}

public void updateSport(String idName, String newSportName) throws SQLException {
try {
  // Open Connection
  Connection connection = DriverManager.getConnection(connectionString, username, password);
  System.out.println("MySQL connected at: " + connectionString);
  
  //Prepare SQL Statement
  String sql = "UPDATE sports SET name = ? WHERE id = ?;";
  PreparedStatement statement = connection.prepareStatement(sql);
  //Bind parameters
  statement.setString(2, newSportName);
  statement.setString(1, idName);
  //Execute SQL Statement / Open Reader
  statement.executeUpdate();
  
  //Read Row by Row
  
  //Close connection
  connection.close();
  System.out.println("MySQL connection closed.");
} catch (SQLException e) {
  System.out.println("Database connection error:" + e.getMessage());
  e.printStackTrace();
}
}

public void deleteSport(String idName) throws SQLException {
try {
  // Open Connection
  Connection connection = DriverManager.getConnection(connectionString, username, password);
  System.out.println("MySQL connected at: " + connectionString);
  
  //Prepare SQL Statement
  String sql = "DELETE FROM sports WHERE id = ?;";
  PreparedStatement statement = connection.prepareStatement(sql);
  //Bind parameters
  statement.setString(1, idName);
  //Execute SQL Statement / Open Reader
  statement.executeUpdate();
  
  //Read Row by Row
  
  //Close connection
  connection.close();
  System.out.println("MySQL connection closed.");
} catch (SQLException e) {
  System.out.println("Database connection error:" + e.getMessage());
  e.printStackTrace();
}
}

}
