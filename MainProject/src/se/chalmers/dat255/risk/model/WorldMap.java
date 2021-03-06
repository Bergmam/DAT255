package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Contains Maps with relations for the provinces on the game board and the
 * players controlling them.
 * 
 * Has methods for checking and dealing out ownership to territories.
 */
public class WorldMap {

	private final ArrayList<IProvince> allProvinces;

	ArrayList<String> continent = new ArrayList<String>();
	private HashMap<String, IPlayer> ownership;
	int[] bonuses; // Each id, corresponds to a players continental bonus
	ArrayList<Continent> continents; // All the continents that gives bonuses
	// neighbours maps together each territory with all adjacent territories.
	// It gets its information via the class constructor, which in turn reads
	// all information
	// from a text file.
	private HashMap<String, ArrayList<String>> neighbours;

	/**
	 * 
	 * @param provinceString
	 *            the provinces separated with new line and the neighbours of
	 *            the province, separated by "-" Example: A-B-C\nB-A\nC-A
	 * @param continentFile
	 *            representing the different continents. The continents are
	 *            separated with new line. One continent are built up by int
	 *            bonus, followed by the provinces in the continent, separated
	 *            with "-" Example: 3-A-B-C, a continents that gives the bonus 3
	 *            and contains the provinces A,B,C
	 * @param players
	 *            players
	 */
	public WorldMap(String provinceString, String continentFile,
			ArrayList<IPlayer> players) {

		ArrayList<String> listOfProvinces = createProvinces(provinceString,
				players);
		allProvinces = buildProvinces(listOfProvinces);
		createContinents(continentFile);
		randomizeProvinces(listOfProvinces, players);
	}

	/*
	 * Create all the provinces.
	 */
	private ArrayList<String> createProvinces(String string,
			ArrayList<IPlayer> players) {
		HashMap<String, ArrayList<String>> tempNeighbours = new HashMap<String, ArrayList<String>>();
		ArrayList<String> listOfProvinces = new ArrayList<String>();
		ownership = new HashMap<String, IPlayer>();
		bonuses = new int[players.size()];
		String[] pLines = string.split("\\n");
		for (String pLine : pLines) {
			String[] array = pLine.split("-");
			String p1 = array[0];
			listOfProvinces.add(removeBadChar(p1));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 1; i < array.length; i++) {
				String anotherProvince = array[i];
				list.add(removeBadChar(anotherProvince));
			}
			tempNeighbours.put(p1, list);
		}
		neighbours = new HashMap<String, ArrayList<String>>(tempNeighbours);
		return listOfProvinces;
	}

	private String removeBadChar(String p1) {
		return p1.trim();
	}

	/*
	 * Creating the continents.
	 */
	private ArrayList<Continent> createContinents(String continentString) {
		continents = new ArrayList<Continent>();

		String[] cLines = continentString.split("\\n");

		String itsProvinces[];
		for (String line : cLines) {
			String[] array = line.split("-");
			itsProvinces = new String[array.length - 2];

			for (int i = 2; i < array.length; i++) {
				itsProvinces[i - 2] = removeBadChar(array[i]);
			}
			continents.add(new Continent(removeBadChar(array[1]), itsProvinces,
					Integer.parseInt(array[0])));
		}
		return continents;
	}

	/**
	 * Returns ownership of a certain territory.
	 * 
	 * @param provinceName
	 *            A province name sent to the method
	 * @return The owner of the province sent to the method
	 */
	public IPlayer getOwner(String provinceName) {
		return ownership.get(provinceName);
	}

	/**
	 * Changes the ownership of a certain territory. Also changes the number of
	 * provinces that the players involved controls.
	 * 
	 * @param provinceName
	 *            Name of the province that will change owner.
	 * @param player
	 *            Which player the ownership should change to.
	 */

	public void changeOwner(String provinceName, IPlayer player) {
		IPlayer oldPlayer = ownership.get(provinceName);
		oldPlayer.loseProvince();

		ownership.put(provinceName, player);
		player.gainProvince();
	}

	/**
	 * Checks if two territories are adjacent.
	 * 
	 * @param provinceName1
	 * @param provinceName2
	 * @return True if the territories are next to each other.
	 */
	public boolean isNeighbours(String provinceName1, String provinceName2) {
		ArrayList<String> list = neighbours.get(provinceName1);
		for (String province : list) {
			if (provinceName2.equals(province)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Method to deal random provinces to the players at the start of a game.
	 * Every time a province is given to a player, it is removed from the list
	 * of provinces.
	 * 
	 * @param List
	 *            of all provinces
	 * @param List
	 *            of all players
	 */
	private void randomizeProvinces(ArrayList<String> provinceList,
			ArrayList<IPlayer> players) {
		ArrayList<String> temp = provinceList;
		int nrOfProvinces = provinceList.size();

		Random randGen = new Random();
		while (!temp.isEmpty()) {
			for (IPlayer player : players) {
				if (nrOfProvinces > 0)
					ownership.put(temp.remove(randGen.nextInt(nrOfProvinces)),
							player);
				player.gainProvince();
				nrOfProvinces--;
			}
		}
	}

	/**
	 * Builds a list of Province objects from a list of province names
	 * 
	 * @param List
	 *            of all province names
	 * @return List of all province objects on the map
	 */

	private ArrayList<IProvince> buildProvinces(ArrayList<String> nameList) {
		ArrayList<IProvince> provinceList = new ArrayList<IProvince>();
		for (String s : nameList) {
			provinceList.add(new Province(s));
		}
		return provinceList;
	}

	public int getBonus(IPlayer player) {
		return bonuses[player.getId()];
	}

	public void updateBonus() { // in parameter Continent updateContinent
		// updateContinent.update();
		int continentBonus = 0;
		for (int i = 0; i < bonuses.length; i++)
			bonuses[i] = 0; // Empty
		for (Continent continent : continents) { // Fills
			continent.update();
			continentBonus = continent.getBonus();
			if (continent.getContinentOwner() != null)
				bonuses[continent.getContinentOwner().getId()] += continentBonus;
		}
	}

	public ArrayList<IProvince> getProvinces() {
		return allProvinces;
	}

	public ArrayList<String> getPlayersContinents(IPlayer owner) {
		ArrayList<String> continentsThePlayerOwns = new ArrayList<String>();
		int i = 0;
		for (Continent continent : continents) {
			i++;
			if (continent.getContinentOwner() == null) {
				System.out.println("getPlayersContinents: "
						+ continent.getContinentName() + "is owned by nobody");
			} else {
				System.out.println("getPlayersContinents: "
						+ continent.getContinentName() + "is owned by "
						+ continent.getContinentOwner().getName());
			}
			if (continent.getContinentOwner() == owner) {
				continentsThePlayerOwns.add(continent.getContinentName());
			}
		}
		System.out.println("getPlayersContinents: There are " + i
				+ "continents");
		return continentsThePlayerOwns;
	}

	/**
	 * Class for representing continents. Contains the name of the continent,
	 * all provinces in the continent, how many bonus points the continent gives
	 * and who currently owns the continent.
	 * 
	 * Contains method for getting the bonus and the owner, and for updating who
	 * currently owns the continent.
	 * 
	 */
	private class Continent {
		final String[] provinces;
		final int bonus;
		IPlayer owner = null;
		final String continentName;

		public Continent(String continentName, String[] provinces, int bonus) {
			this.provinces = provinces;
			this.bonus = bonus;
			this.continentName = continentName;
		}

		public int getBonus() {
			return bonus;
		}

		public IPlayer getContinentOwner() {
			return owner;
		}

		/**
		 * Updates who owns the Continent. Steps through the list of provinces
		 * in the continent and sees if the same person owns all of them. Runs
		 * when someone takes a province from someone else.
		 */
		public void update() {
			IPlayer tempProvinceOwner = getOwner(provinces[0]);

			for (String province : provinces) {
				if (tempProvinceOwner != getOwner(province)) {
					owner = null;
					return;
				}
				tempProvinceOwner = getOwner(province);
			}
			owner = tempProvinceOwner;
		}

		public String getContinentName() {
			return continentName;
		}

	}
}