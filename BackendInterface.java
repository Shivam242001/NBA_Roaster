// --== CS400 File Header Information ==--
// Name: Dhananjayan Pallavur Naduvakkat
// Email: pallavurnadu@wisc.edu
// Team: EF red
// Role: Backend Developer
// TA: Yelun Bao
// Lecturer: Florian Heimerl

import java.util.List;

public interface BackendInterface {
	public int getTotalPlayers();

	public int getTotalTeamPlayers();

	public Player searchByName(String name);

	public List<Player> searchByTeam(String team);

}
