// --== CS400 File Header Information ==--
// Name: Dhananjayan Pallavur Naduvakkat
// Email: pallavurnadu@wisc.edu
// Team: EF red
// Role: Backend Developer
// TA: Yelun Bao
// Lecturer: Florian Heimerl

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * Backend class that manages the creation and updation of the Red-Black Tree of
 * Players
 * 
 * @author Dhananjayan Pallavur Naduvakkat
 */
public class Backend implements BackendInterface {
	private PlayerStatsReader statsReader = new PlayerStatsReader();
	private List<Player> playerData = new ArrayList<Player>();
	private RedBlackTree<Player> defaultTree;
	private RedBlackTree<Player> dynamicTree;

	/**
	 * One argument constructor that instantiates the class and reads the data with
	 * the given file path
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DataFormatException
	 */
	public Backend(String[] args) throws FileNotFoundException, IOException, DataFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		this.playerData = statsReader.readDataSet(reader);
		this.defaultTree = new RedBlackTree<Player>();
		this.dynamicTree = new RedBlackTree<Player>();
		for (Player p : playerData) {
			defaultTree.insert(p);
		}
	}

	/**
	 * Fetches the total number of players in the default data tree
	 */
	@Override
	public int getTotalPlayers() {
		return this.defaultTree.size();
	}

	/**
	 * Fetches the total number of players in the dynamic team tree
	 */
	@Override
	public int getTotalTeamPlayers() {
		return this.dynamicTree.size();
	}

	/**
	 * Searches the default tree for a player with the name. Returns null if no
	 * match found
	 * 
	 * @param name
	 */
	@Override
	public Player searchByName(String name) {
		if (name == null) {
			return null;
		}
		for (Player p : this.defaultTree) {
			if (p.playerName.toLowerCase().equals(name.toLowerCase())) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Searches the default tree by name and adds players to an ArrayList and
	 * returns it. If team not found, returns empty ArrayList
	 * 
	 * @param team
	 */
	@Override
	public List<Player> searchByTeam(String team) {
		this.clearTeamTree();
		if (team == null) {
			return null;
		}
		List<Player> results = new ArrayList<Player>();
		for (Player p : this.defaultTree) {
			if (p.teamName.toLowerCase().equals(team.toLowerCase())) {
				results.add(p);
			}
		}
		if (results.size() == 0) {
			return null;
		} else {
			return results;
		}
	}

	/**
	 * Private helped method to clear the dynamic tree
	 */
	private void clearTeamTree() {
		this.dynamicTree = new RedBlackTree<Player>();
	}
}
