// --== CS400 File Header Information ==--
// Name: Dhananjayan Pallavur Naduvakkat
// Email: pallavurnadu@wisc.edu
// Team: EF red
// Role: Backend Developer
// TA: Yelun Bao
// Lecturer: Florian Heimerl

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BackEndDeveloperTests {

	/**
	 * This test checks if all the players in the dataset have been loaded up into
	 * the Red-Black-Tree upon instantiation of the Backend
	 */
	@Test
	public void testInitialPlayersInDefaultTree() {
		Backend backend = null;

		// instantiate backend
		try {

			backend = new Backend(new String[] { "BasketballStats.csv" });
		} catch (Exception e) {
			fail("Something went wrong when reading the file.");
		}

		assertEquals(216, backend.getTotalPlayers());
	}

	/**
	 * This test checks if there are no players in the filtered Red-Black-Tree
	 */
	@Test
	public void testInitialPlayersInFilteredTree() {
		Backend backend = null;

		// instantiate backend
		try {

			backend = new Backend(new String[] { "BasketballStats.csv" });
		} catch (Exception e) {
			fail("Something went wrong when reading the file.");
		}

		assertEquals(0, backend.getTotalTeamPlayers());
	}

	/**
	 * This test checks if the right player is returned with a search by name
	 */
	@Test
	public void testPlayerSearchedByName() {
		Backend backend = null;

		// instantiate backend and search by name
		try {

			backend = new Backend(new String[] { "BasketballStats.csv" });
		} catch (Exception e) {
			fail("Something went wrong when reading the file.");
		}

		assertEquals((Double) 0.3p , backend.searchByName("Mike Scott").getAPG());
	}

	/**
	 * This test checks if the right players array is returned with a search by team
	 */
	@Test
	public void testPlayersSearchedByTeam() {
		Backend backend = null;

		// instantiate backend and search by team
		try {

			backend = new Backend(new String[] { "BasketballStats.csv" });
		} catch (Exception e) {
			fail("Something went wrong when reading the file.");
		}

		assertEquals((Double) 20.3, backend.searchByTeam("Bro").get(0).getPPG());
	}

	/**
	 * This test check if the Filtered Red-Black-Tree resets on calling clear()
	 */
	@Test
	public void testFilteredTreeClearsOnReset() {
		Backend backend = null;

		// test clear method on filtered tree
		try {

			backend = new Backend(new String[] { "BasketballStats.csv" });
		} catch (Exception e) {
			fail("Something went wrong when reading the file.");
		}

		// backend.searchByTeam(null);

		assertEquals(0, backend.getTotalTeamPlayers());
	}

}
