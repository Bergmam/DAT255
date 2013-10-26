package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MissionHandler {
	private IPlayer winner;
	private List<IPlayer> eliminatedPlayers;
	private final HashMap<IPlayer, Mission> missionMap;
	private List<Mission> missionsInGame;

	public MissionHandler(List<IPlayer> players, String missionFile) {
		eliminatedPlayers = new ArrayList<IPlayer>();
		missionsInGame = new ArrayList<Mission>();

		Random randGen = new Random();
		int nextRandInt;
		List<Mission> listOfMissions = buildMissions(players, missionFile);
		HashMap<IPlayer, Mission> tempMissionMap = new HashMap<IPlayer, Mission>();

		for (IPlayer player : players) {
			nextRandInt = randGen.nextInt(listOfMissions.size());
			giveMission(player, nextRandInt, tempMissionMap, listOfMissions);

			// DEV Printing
			if (tempMissionMap.get(player).getType() == MissionType.ELIMINATE) {
				System.out.println("UPPDRAG: " + player.getName()
						+ " har i uppdrag att eliminera "
						+ tempMissionMap.get(player).getVictim().getName()
						+ ".");

			} else if (tempMissionMap.get(player).getType() == MissionType.CONQUER_CONTINENTS) {
				System.out.println("UPPDRAG: " + player.getName()
						+ " har i uppdrag att er�vra "
						+ tempMissionMap.get(player).getContinentsToConquer());

			} else if (tempMissionMap.get(player).getType() == MissionType.CONQUER_PROVINCES) {
				System.out.println("UPPDRAG: " + player.getName()
						+ " har i uppdrag att er�vra "
						+ tempMissionMap.get(player).getNeedToConquer()
						+ " provincer.");

			}
			//
		}

		missionMap = tempMissionMap;
	}

	/**
	 * Return true if there is a winner.
	 */
	public boolean winner(IPlayer currentPlayer,
			List<String> continentsCurrentPlayerOwns) {
		for (Mission mission : missionsInGame) {
			if (mission.fullFilled(currentPlayer, continentsCurrentPlayerOwns)) {
				return true;
			}
		}
		return false;
	}

	public IPlayer getWinner() {
		return winner;
	}

	/**
	 * Different types of missions
	 */
	public static enum MissionType {
		ELIMINATE, CONQUER_CONTINENTS, CONQUER_PROVINCES;
	}

	/**
	 * A method for remembering wich players been eliminated.
	 */
	public void playerEliminated(IPlayer player) {
		eliminatedPlayers.add(player);
	}

	/**
	 * Give a player his/hers mission
	 */

	public void giveMission(IPlayer player, int intRand,
			HashMap<IPlayer, Mission> tempMissionsMap,
			List<Mission> listOfMissions) {

		boolean gotAMission = false;
		/*
		 * Worth knowing here is that until QONQUER-missions is implemented,
		 * there is a chance of a never-ending loop.
		 */
		while (!gotAMission) {
			Mission mission = listOfMissions.remove(intRand);
			if (mission.getType() == MissionType.ELIMINATE
					&& mission.getVictim() == player) {
				listOfMissions.add(mission);
			} else {
				mission.setOwner(player);
				tempMissionsMap.put(player, mission);
				missionsInGame.add(mission);
				gotAMission = true;
			}
		}
	}

	/**
	 * Constructing the missions that can be choosen from.
	 */

	public List<Mission> buildMissions(List<IPlayer> players, String missionFile) {
		List<Mission> missions = new ArrayList<Mission>();
		addEliminateMissions(missions, players);
		addConquerContinentMissions(missions, missionFile);
		addConquerProvincesMissions(missions);

		return missions;
	}

	/**
	 * Creates the mission of Eliminate type
	 */

	public void addEliminateMissions(List<Mission> missions,
			List<IPlayer> players) {
		for (IPlayer victim : players)
			missions.add(new Mission(victim));
	}

	/**
	 * Creates the mission of Conquer Continent Mission type
	 */
	public void addConquerContinentMissions(List<Mission> missions,
			String missionFile) {
		String[] pLines = missionFile.split("\\n");
		for (String pLine : pLines) {
			String[] array = pLine.split("-");

			String firstContinent = removeBadChar(array[0]);
			String secondContinent = removeBadChar(array[1]);
			boolean moreThanTwo = array.length > 2;
			missions.add(new Mission(firstContinent, secondContinent,
					moreThanTwo));
		}
	}

	/**
	 * Creates the mission of Conquer Province Mission type
	 */
	public void addConquerProvincesMissions(List<Mission> missions) {
		missions.add(new Mission());
		missions.add(new Mission());
	}

	private String removeBadChar(String p1) {
		return p1.trim();
	}

	/**
	 * Returns a missions mission-text.
	 */
	public String getText(IPlayer currentPlayer) {
		Mission mission = missionMap.get(currentPlayer);
		MissionType type = mission.getType();
		String text = "";
		if (type == MissionType.ELIMINATE) {
			text = "Your mission is to eliminate "
					+ mission.getVictim().getName();
		} else if (type == MissionType.CONQUER_CONTINENTS) {
			text = "Your mission is to conquer "
					+ mission.getContinentsToConquer();
		} else if (type == MissionType.CONQUER_PROVINCES) {
			text = "Your mission is to conquer " + mission.getNeedToConquer()
					+ " provinces.";
		}
		return text;
	}

	/**
	 * Implements a mission to be used locally in this class.
	 */
	private class Mission {

		private MissionType type;
		// ELIMINATE
		private IPlayer owner;
		private IPlayer victim;
		// CONQUER_PROVINCES
		private int needToConquer;
		// CONQUER CONTINETS
		private String firstContinent;
		private String secondContinent;
		private boolean needToTakeThree; // True if you need a total of three
											// continents to win

		public Mission(IPlayer vicitim) {
			this.victim = vicitim;
			this.type = MissionType.ELIMINATE;
		}

		public Mission() {
			this.type = MissionType.CONQUER_PROVINCES;
			needToConquer = 24;
		}

		public Mission(String firstContinent, String secondContinent,
				boolean needToTakeThree) {
			this.type = MissionType.CONQUER_CONTINENTS;
			this.firstContinent = firstContinent;
			this.secondContinent = secondContinent;
			this.needToTakeThree = needToTakeThree;
		}

		/**
		 * Returns true if criteria for winning is fullfilled
		 */
		public boolean fullFilled(IPlayer currentPlayer,
				List<String> continentsCurrentPlayerOwns) {
			if (type == MissionType.ELIMINATE) {
				if (eliminatedPlayers.contains(victim)) {
					winner = owner;
					return true;
				}
			} else if (type == MissionType.CONQUER_PROVINCES) {
				return currentPlayer.getNrOfProvinces() >= needToConquer;
			} else if (type == MissionType.CONQUER_CONTINENTS) {
				return continentalWinner(continentsCurrentPlayerOwns);
			}

			return false;
		}

		public IPlayer getVictim() {
			return victim;
		}

		public MissionType getType() {
			return type;
		}

		public int getNeedToConquer() {
			return needToConquer;
		}

		public void setOwner(IPlayer owner) {
			this.owner = owner;
		}

		/**
		 * Returns the continent as String so it can be used in mission-text.
		 */

		public String getContinentsToConquer() {
			if (needToTakeThree) {
				return "" + firstContinent + ", " + secondContinent
						+ " and one other continent.";
			} else
				return "" + firstContinent + " and " + secondContinent + ".";
		}

		/**
		 * A help-function for deciding if there's a continental winner.
		 */

		private boolean continentalWinner(
				List<String> continentsCurrentPlayerOwns) {
			if (continentsCurrentPlayerOwns.isEmpty()) {
				System.out
						.println("continentalWinner: You don't own any continents");
				return false;
			} else if (continentsCurrentPlayerOwns.contains(firstContinent)
					&& continentsCurrentPlayerOwns.contains(secondContinent)) {
				if (needToTakeThree) {
					return continentsCurrentPlayerOwns.size() >= 3;
				} else {
					return true;
				}
			}
			System.out
					.print("continentalWinner: As of now, you own the continents ");
			for (String cont : continentsCurrentPlayerOwns) {
				System.out.print(cont + " ");
			}
			return false;
		}
	}

}
