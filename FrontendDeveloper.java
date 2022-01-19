// --== CS400 File Header Information ==--
// Name: Yash Rustagi
// Email: yrustagi@wisc.edu
// Team: EF red
// Role: Frontend Developer
// TA: Yelun Bao
// Lecturer: Gary Dahl

import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FrontendDeveloper {

  private static Backend backend;

  /**
   * Runs everything. Calls searchByPlayer and searchByTeam methods.
   * 
   * @param args
   * @throws FileNotFoundException
   * @throws IOException
   * @throws DataFormatException
   */
  public static void main(String[] args) throws FileNotFoundException, IOException, DataFormatException {
    Scanner sc = new Scanner(System.in);
    if (args.length == 2) { // for testers
      try {
        PrintStream print = new PrintStream(new File(args[1]));
        System.setOut(print);
        sc = new Scanner(new File(args[0]));
      } catch (FileNotFoundException e) {
        System.out.println("Error");
        sc.close();
        return;
      }
    }
    backend = new Backend(args);
    System.out.println(" ---------------------------------------");
    System.out.print("||");
    System.out.print("WELCOME TO THE BASKETBALL SEARCH ENGINE"); // introductory message
    System.out.println("||");
    System.out.println(" ---------------------------------------");
    String s = "\nPress \"T\" to seach by team or press \"P\" to search by player";
    System.out.println(s);
    while (true) { // running loop begins
      String input = sc.nextLine(); // takes user input for T or P
      if (input.trim().equalsIgnoreCase("T")) { // if the user inputs T, then selectionByTeam method is called
        selectionByTeam();
      } else if (input.trim().equalsIgnoreCase("P")) { // visa versa
        selectionByPlayer();
      } else if (!(input.trim().equalsIgnoreCase("T")) && !(input.trim().equalsIgnoreCase("P")) // condition for error
                                                                                                // message for wrong
                                                                                                // input
          && !(input.trim().equalsIgnoreCase("Q"))) {
        System.out.println("\n==Invalid input! Please try again!==\n");

      }
      if (input.trim().equalsIgnoreCase("Q")) { // After returning back to the main menu, the user can quit the
                                                // application by pressing Q
        System.out.println("\n ---------------------------------------");
        System.out.print("||");
        System.out.print("THANK YOU FOR USING OUR SEARCH ENGINE!");
        System.out.println("||");
        System.out.println(" ---------------------------------------\n");
        break;
      }
      System.out.println(s);
      System.out.println("Press \"Q\" to exit the program");
    }

  }

  /**
   * Helper method for searchByTeam() method. Decides action based on input key
   * 
   * @param teams  list of team players
   * @param option input key
   */
  private static void helper(ArrayList<Player> teams, char option) {

    switch (option) {
    case 'R':
    case 'r':
      System.out.println("\n==TEAM'S RPG STATS==\n");

      for (Player p : teams) { // press r or R to get team RPG
        System.out.println(p.playerName + ": " + p.getRPG() + "\n");
      }
      break;

    case 'A': // press r or R to get team APG
    case 'a':
      System.out.println("\n==TEAM'S APG STATS==\n");
      for (Player p : teams) {
        System.out.println(p.playerName + ": " + p.getAPG() + "\n");
      }
      break;

    case 'P': // press r or R to get team PPG
    case 'p':
      System.out.println("\n==TEAM'S PPG STATS==\n");
      for (Player p : teams) {
        System.out.println(p.playerName + ": " + p.getPPG() + "\n");
      }
      break;

    default:
      System.out.println("\n==Invalid input! Please try again!==\n");
      break;
    }
  }

  /**
   * Helper method for searchByPlayer() method. Decides action based on input key
   * 
   * @param p player
   * @param c input keys
   */
  private static void playerHelper(Player p, char c) {

    switch (c) {
    case 'R': // press r or R to get player RPG
    case 'r':
      System.out.print("||");
      System.out.print(p.playerName + "'s RPG: " + p.getRPG());
      System.out.println("||" + "\n");
      break;

    case 'A': // press a or A to get player APG
    case 'a':
      System.out.print("||");
      System.out.print(p.playerName + "'s APG: " + p.getAPG());
      System.out.println("||" + "\n");
      break;

    case 'P': // press p or P to get player PPG
    case 'p':
      System.out.print("||");
      System.out.print(p.playerName + "'s PPG: " + p.getPPG());
      System.out.println("||" + "\n");
      break;

    default:
      System.out.println("\n==Invalid input! Please try again!==\n");
      break;
    }
  }

  /**
   * After pressing the correct key, this method take a player name as an input
   * and calls the backend to check if its a valid name. If it is, then it returns
   * the player and asks the user to select between rpg, apg, and ppg.
   */
  private static void selectionByPlayer() {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    System.out.println("\n======================");
    System.out.println(" Search By Player Mode");
    System.out.println("======================\n");
    Player p = null;
    while (true) {
      System.out.println("Please type a player name");
      System.out.println("OR press [X] to return to the main page");
      String name = sc.nextLine().toLowerCase(); // user input player name
      if (name.equalsIgnoreCase("X")) {
        break;
      }
      while (true) {
        try {
          p = backend.searchByName(name);
          if (p != null) { // player exists
            break;
          } else {
            System.out.println("\n==Invalid input! Please try again!==\n\n"
                + "Please type a different player name \nOR press [X] to return to the main page");
            name = sc.nextLine().toLowerCase();
            if (name.equalsIgnoreCase("X")) {
              break;
            }
          }
        } catch (Exception e) {
          System.out.println("\n==Invalid input! Please try again!==\n");
          System.out.println("Please type a correct player name!");
          System.out.println("OR press [X] to return to the main page");
          name = sc.nextLine().toLowerCase();
          if (name.equalsIgnoreCase("X")) {
            break;
          }
        }
      }
      if (name.equalsIgnoreCase("X")) {
        return;
      }
      System.out.println("\nSearched name: " + name.toUpperCase() + "\n");
      String input = "";

      while (true) {
        System.out.println("Would you like to see the player's [A]PG, [R]PG, or [P]PG?");
        System.out.println("OR press [X] to return to the main page");
        input = sc.nextLine().toLowerCase();
        if (input.equalsIgnoreCase("X")) {
          break;
        } else {
          playerHelper(p, input.trim().charAt(0));
        }
      }

      break;
    }
  }

  /**
   * After pressing the correct key, this method take a team name as an input and
   * calls the backend to check if its a valid name. If it is, then it returns the
   * team and asks the user to select between rpg, apg, and ppg. Then this method
   * returns a list of all players in the searched team with their selected stats
   * type.
   */
  public static void selectionByTeam() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n======================");
    System.out.println(" Search By Team Mode");
    System.out.println("======================\n");
    ArrayList<Player> teams = null;
    while (true) {
      System.out.println("Please type the team name");
      System.out.println("OR press [X] to return to the main page");
      String name = sc.nextLine().trim().toLowerCase();
      if (name.equalsIgnoreCase("X")) {
        break;
      }
      while (true) {
        try {
          teams = (ArrayList<Player>) backend.searchByTeam(name);
          if (teams != null) { // if the team exists
            break;
          } else {
            throw new NullPointerException();
          }

        } catch (Exception e) {
          System.out.println("\n==Invalid input! Please try again!==\n");
          System.out.println("Please type a correct team name!");
          System.out.println("OR press [X] to return to the main page");
          name = sc.nextLine().toLowerCase();
          if (name.equalsIgnoreCase("X")) {
            break;
          }
        }
      }
      System.out.println("\n==Searched team: " + name.toUpperCase() + "== \n");
      String input = "";

      while (true) {
        System.out.println("Would you like to see the team's [A]PG, [R]PG, or [P]PG?");
        System.out.println("OR press [X] to return to the main page");

        input = sc.nextLine().toLowerCase();
        if (input.equalsIgnoreCase("X")) {
          break;
        }
        helper(teams, input.trim().charAt(0));
      }

      break;
    }
  }
}
