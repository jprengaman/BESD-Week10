package com.promineotech;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) throws SQLException {

    String selection = "";

do {      
    SportDB database = new SportDB();
    System.out.println("Please select a menu option:");
    System.out.println("----------------------------");
    System.out.println("1) Display Sports");
    System.out.println("2) Add Sport");
    System.out.println("3) Update Sport");
    System.out.println("4) Delete Sport");
    Scanner input = new Scanner(System.in);

    selection = input.nextLine();
    
    if (selection.equals("1")) {
      database.getAll();
    } else if (selection.equals("2")) {
      System.out.println("Please enter the name of the sport you'd like to add:");
      String sportName = input.nextLine();
      database.addSport(sportName);
    } else if (selection.equals("3")) {
      System.out.println("Please enter the number of the sport you'd like to change:");
      String idName = input.nextLine();
      System.out.println("Please enter the new name of this sport:");
      String newSportName = input.nextLine();
      database.updateSport(newSportName, idName);
    } else if (selection.equals("4")) {
      System.out.println("Please enter the number of the sport you'd like to delete:");
      String idName = input.nextLine();
      database.deleteSport(idName);
    }
    
    
    System.out.println("Press enter to continue...");
    input.nextLine();
} while (!selection.equals("-1"));
  
  }

}
