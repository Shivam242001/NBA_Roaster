
// --== CS400 File Header Information ==--
// Name: Shivam Nanda
// Email: nanda4@wisc.edu
// Team: Red
// Group: EF
// TA: Yelun
// Lecturer: Gary Dalh
// Notes to Grader:
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

// The class reads the player from the input file based on the split in the file

public class PlayerStatsReader {

  public List<Player> readDataSet(BufferedReader inputFileReader)
      throws FileNotFoundException, IOException, DataFormatException {
    Player m;
    String line = "";
    List<Player> playerList = new ArrayList<Player>(); // creats a list of the player from the input file

    BufferedReader br = inputFileReader; // buffer reader reads the input file

    while ((line = br.readLine()) != null) {

      String[] splitted = line.split(","); // Splitted is used to split the contents of the file

      String ID = splitted[0];
      String playerName = splitted[1];
      String teamName = splitted[2];

      Double PPG = Double.valueOf(splitted[3]);
      Double RPG = Double.valueOf(splitted[4]);
      Double APG = Double.valueOf(splitted[5]);

      m = new Player(ID, playerName, teamName, PPG, RPG, APG);

      playerList.add(m); // adds the player to the list
    }

    return playerList;

  }
}
