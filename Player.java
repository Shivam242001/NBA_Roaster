// --== CS400 File Header Information ==--
// Name: Shivam Nanda
// Email: nanda4@wisc.edu
// Team: Red
// Group: EF
// TA: Yelun
// Lecturer: Gary Dalh
// Notes to Grader:
public class Player implements Comparable<Player> {

  String playerName;
  String teamName;
  Double RPG;
  Double PPG;
  Double APG;
  String ID;

  public Player(String ID, String playerName, String teamName, Double PPG, Double RPG, Double APG) {
    super();
    this.playerName = playerName;
    this.teamName = teamName;
    this.RPG = RPG;
    this.PPG = PPG;
    this.APG = APG;
    this.ID = ID;
  }

  // get the player name
  public String getPlayerName() {
    // TODO Auto-generated method stub
    return this.playerName;
  }

  // get the player team
  public String getTeam() {
    // TODO Auto-generated method stub
    return this.teamName;
  }

  // get the player Average Points Per Game
  public Double getAPG() {
    // TODO Auto-generated method stub
    return this.APG;
  }

    // get the player Rebounds Per Game
  public Double getRPG() {
    // TODO Auto-generated method stub
    return this.RPG;
  }

  // get the player Points Per Game
  public Double getPPG() {
    // TODO Auto-generated method stub
    return this.PPG;
  }

  // get the players ID
  public String getID() {
    // TODO Auto-generated method stub
    return this.ID;
  }

  // Returns a string representation of the stats
  @Override
  public String toString() {
    String toReturn = "ID " + this.ID + " Player Name " + this.playerName + "\n" + " Team " + this.teamName + "\n"
        + " Points per game " + this.PPG + " Rebounds per game " + this.RPG + "\n" + " Assists per game " + this.APG;

    return toReturn;

  }
  // Compares the players based on the playerName
  @Override
  public int compareTo(Player otherPlayer) {
    // TODO Auto-generated method stub
    int compareTo = this.playerName.compareTo(otherPlayer.getPlayerName());
    if (compareTo < 0) {
      return -1;
    }
    if (compareTo == 0) {
      return 0;

    } else
      return 1;
  }

}
