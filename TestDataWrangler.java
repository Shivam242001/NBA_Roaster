// --== CS400 File Header Information ==--
// Name: Shivam Nanda
// Email: nanda4@wisc.edu
// Team: Red
// Group: EF
// TA: Yelun
// Lecturer: Gary Dalh
// Notes to Grader:
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;
import org.junit.Test;

public class TestDataWrangler {

  // Tests if all the players are read from the file
  @Test
  public void testReaderNumberOfPlayers() {

    PlayerStatsReader playerReader = new PlayerStatsReader();
    List<Player> player = new ArrayList<Player>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("BasketballStats.csv")); // file reader
      player = playerReader.readDataSet(br);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    assertEquals(player.size(), 216); // checks if the size of the file is as expected

  }
 // Checks if  the names of the players is as expected
  
  @Test
  public void testReaderPlayerNames() {
    PlayerStatsReader playerReader = new PlayerStatsReader();
    List<Player> player = new ArrayList<Player>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("BasketballStats.csv")); // file reader
      player = playerReader.readDataSet(br);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String Player1 = "Aaron Holiday";
    assert (player.get(0).playerName.equals(Player1));

    String Player2 = "Abdel Nader";
    assert (player.get(1).playerName.equals(Player2));

    String Player74 = "Ivica Zubac";
    assert (player.get(73).playerName.equals(Player74));

  }
 // Checks if  the Points per game of the players is as expected
  @Test
  public void testPlayerPPG() {

    PlayerStatsReader playerReader = new PlayerStatsReader();
    List<Player> player = new ArrayList<Player>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("BasketballStats.csv")); // file reader
      player = playerReader.readDataSet(br);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    double PPG1 = 7.8;
    assert (player.get(0).getPPG() == PPG1);

    double PPG2 = 1.3;
    assert (player.get(1).getPPG() == PPG2);

    double PPG74 = 9.1;
    assert (player.get(73).getPPG() == PPG74);
  }

  // Checks if  the Rebounds per game of the players is as expected
  @Test
  public void testPlayerRPG() {

    PlayerStatsReader playerReader = new PlayerStatsReader();
    List<Player> player = new ArrayList<Player>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("BasketballStats.csv")); // file reader
      player = playerReader.readDataSet(br);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    double RPG1 = 1.3;
    assert (player.get(0).getRPG() == RPG1);

    double RPG2 = 1;
    assert (player.get(1).getRPG() == RPG2);

    double RPG74 = 7.2;
    assert (player.get(73).getRPG() == RPG74);
  }

  // Checks if  the Average points per game of the players is as expected
  @Test
  public void testPlayerAPG() {
    PlayerStatsReader playerReader = new PlayerStatsReader();
    List<Player> player = new ArrayList<Player>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("BasketballStats.csv")); // file reader
      player = playerReader.readDataSet(br);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    double APG1 = 2.5;
    assert (player.get(0).getAPG() == APG1);

    double APG2 = 0;
    assert (player.get(1).getAPG() == APG2);

    double APG74 = 0.6;
    assert (player.get(73).getAPG() == APG74);

  }
}
