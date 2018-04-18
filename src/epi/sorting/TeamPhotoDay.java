// 14.8
package epi.sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TeamPhotoDay {
	public static void main(String args[]) {
		Team a = new Team(6);
		Team b = new Team(6);
		a.addPlayer(new Player(1));
		a.addPlayer(new Player(2));
		a.addPlayer(new Player(3));
		a.addPlayer(new Player(4));
		a.addPlayer(new Player(5));
		a.addPlayer(new Player(6));
		b.addPlayer(new Player(2));
		b.addPlayer(new Player(3));
		b.addPlayer(new Player(4));
		b.addPlayer(new Player(5));
		b.addPlayer(new Player(6));
		b.addPlayer(new Player(7));

		System.out.println(validPlaceMentExists(a, b));
		System.out.println(validPlaceMentExists(b, a));
	}

	// chek if Team "a" can be places in front of "B" 
	public static boolean validPlaceMentExists(Team a, Team b) {
		Collections.sort(a.players);
		Collections.sort(b.players);

		for (int i = 0; i < a.players.size(); i++) {
			if (a.players.get(i).height >  b.players.get(i).height) {
				return false;
			}
		}
		return true;
	}
}

class Team {
	List<Player> players;

	Team (int size) {
		players = new ArrayList<>(size);
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}
}

class Player implements Comparable<Player> {
	int height;

	Player(int height) {
		this.height = height;
	}

	public int compareTo (Player he) {
		return Integer.compare(this.height, he.height);
	}
}