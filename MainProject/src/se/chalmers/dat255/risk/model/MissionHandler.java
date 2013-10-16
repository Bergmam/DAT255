package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import sun.security.action.GetBooleanAction;

public class MissionHandler {
	private Player winner;
	private ArrayList<Player> eliminatedPlayers;
	private final HashMap<Player, Mission> missionMap;
	private ArrayList<Mission> missionsInGame;
	
	public MissionHandler(ArrayList<Player> players, String missionFile){
		eliminatedPlayers = new ArrayList<Player>();
		missionsInGame = new ArrayList<Mission>();
		
		Random randGen = new Random();
		int nextRandInt;
		ArrayList<Mission> listOfMissions = buildMissions(players, missionFile);
		HashMap<Player, Mission> tempMissionMap = new HashMap<Player, Mission>();

		for(Player player : players){
			nextRandInt = randGen.nextInt(listOfMissions.size());
			giveMission(player, nextRandInt, tempMissionMap, listOfMissions);
			
		// DEV Printing	
			if(tempMissionMap.get(player).getType() == MissionType.ELIMINATE){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att eliminera " + tempMissionMap.get(player).getVictim().getName() + ".");
				
			}
			else if(tempMissionMap.get(player).getType() == MissionType.CONQUER_CONTINENTS){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att er�vra " + tempMissionMap.get(player).getContinentsToConquer());
				
			}
			else if(tempMissionMap.get(player).getType() == MissionType.CONQUER_PROVINCES){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att er�vra " + tempMissionMap.get(player).getNeedToConquer() + " provincer.");
				
			}
			// 
		}
		
		
		
		missionMap = tempMissionMap;
	}
	
	private Mission getMission(Player player){
		return missionMap.get(player);
	}
	
	/**
	 * Return true if there is a winner.
	 */
	public boolean winner(Player currentPlayer, ArrayList<String> continentsCurrentPlayerOwns){
		for(Mission mission : missionsInGame){
			if(mission.fullFilled(currentPlayer, continentsCurrentPlayerOwns)){
				return true;
			}
		}
		return false;
	}
	
	public Player getWinner(){
		return winner;
	}
	
	public static enum MissionType {
		ELIMINATE, CONQUER_CONTINENTS, CONQUER_PROVINCES;
	}
	
	public void playerEliminated(Player player){
		eliminatedPlayers.add(player);
	}
	
	public void giveMission(Player player, int intRand, HashMap<Player, Mission> tempMissionsMap, ArrayList<Mission> listOfMissions){

		boolean gotAMission = false;
		/*
		 * Worth knowing her is that until QONQUER-missions is implemented, there is a chance of
		 * a never-ending loop.
		 */
		while(!gotAMission){
			Mission mission = listOfMissions.remove(intRand);
			if(mission.getType() == MissionType.ELIMINATE && mission.getVictim() == player){
				listOfMissions.add(mission);
			}
			else{
				mission.setOwner(player);
				tempMissionsMap.put(player, mission);
				missionsInGame.add(mission);
				gotAMission=true;
			}
		}
	}
	
	public ArrayList<Mission> buildMissions(ArrayList<Player> players, String missionFile){
		ArrayList<Mission> missions = new ArrayList<Mission>();
		addEliminateMissions(missions, players);
		addConquerContinentMissions(missions, missionFile);
		addConquerProvincesMissions(missions);
		
		return missions;
	}
	
	public void addEliminateMissions(ArrayList<Mission> missions, ArrayList<Player> players){
		ArrayList<Player> notVictims = players;
		for(Player victim : players)
			missions.add(new Mission(victim));
	}
	
	public void addConquerContinentMissions(ArrayList<Mission> missions, String missionFile){
		String[] pLines = missionFile.split("\\n");
		for (String pLine : pLines) {
			String[] array = pLine.split("-");
			
			String firstContinent = removeBadChar(array[0]);
			String secondContinent = removeBadChar(array[1]);
			boolean moreThanTwo = array.length > 2;
			missions.add(new Mission(firstContinent, secondContinent, moreThanTwo));
		}
	}
	
	public void addConquerProvincesMissions(ArrayList<Mission> missions){
		missions.add(new Mission());
		missions.add(new Mission());
	}
	
	private String removeBadChar(String p1) {
		return p1.trim();
	}
	
	public String getText(Player currentPlayer){
		Mission mission = missionMap.get(currentPlayer);
		MissionType type = mission.getType();
		String text="";
		if(type==MissionType.ELIMINATE){
			text = "Your mission is to eliminate " + mission.getVictim();
		}
		else if(type==MissionType.CONQUER_CONTINENTS){
			text = "Your mission is to conquer " + mission.getContinentsToConquer();
		}
		else if(type==MissionType.CONQUER_PROVINCES){
			text = "Your mission is to conquer " + mission.getNeedToConquer() + " provinces.";
		}
		return text;
	}
	
	
	private class Mission{
		
		private MissionType type;
		// ELIMINATE
		private Player owner;
		private Player victim;
		//	CONQUER_PROVINCES
		private int needToConquer;
		//	CONQUER CONTINETS
		private String firstContinent;
		private String secondContinent;
		private boolean needToTakeThree; // True if you need a total of three continents to win
		
		
		public Mission(Player vicitim){
			this.victim=vicitim;
			this.type=MissionType.ELIMINATE;
		}
		
		public Mission(){
			this.type=MissionType.CONQUER_PROVINCES;
			needToConquer=24;
		}
		
		public Mission(String firstContinent, String secondContinent, boolean needToTakeThree){
			this.type=MissionType.CONQUER_CONTINENTS;
			this.firstContinent = firstContinent;
			this.secondContinent = secondContinent;
			this.needToTakeThree = needToTakeThree;
		}
		
		
		
		public boolean fullFilled(Player currentPlayer, ArrayList<String> continentsCurrentPlayerOwns){
			if(type == MissionType.ELIMINATE){
				if(eliminatedPlayers.contains(victim)){
					winner=owner;
					return true;
				}
			}
			else if(type == MissionType.CONQUER_PROVINCES){
					return currentPlayer.getNrOfProvinces() >=needToConquer;
			}
			else if(type == MissionType.CONQUER_CONTINENTS){
				return continentalWinner(continentsCurrentPlayerOwns);
			}
			
			return false;
		}
		
		public Player getVictim(){
			return victim;
		}
		 
		public Player getOwner(){
			return owner;
		}
		public MissionType getType(){
			return type;
		}
		public int getNeedToConquer(){
			return needToConquer;
		}
		
		public void setOwner(Player owner){
			this.owner = owner;
		}
		
		public String getContinentsToConquer(){
			if(needToTakeThree){
				return "" + firstContinent + ", "  +secondContinent + " and one other continent.";
			}else
				return "" + firstContinent + " and "  +secondContinent + ".";
		}
		
		private boolean continentalWinner(ArrayList<String> continentsCurrentPlayerOwns){
			if(continentsCurrentPlayerOwns.isEmpty()){
				System.out.println("continentalWinner: You don't own any continents");
				return false;
			}
			else if(continentsCurrentPlayerOwns.contains(firstContinent) && 
					continentsCurrentPlayerOwns.contains(secondContinent)){
				if(needToTakeThree){
					return continentsCurrentPlayerOwns.size()>=3;
				}else{
					return true;
				}
			}
			System.out.print("continentalWinner: As of now, you own the continents ");
			for(String cont : continentsCurrentPlayerOwns){
				System.out.print(cont + " ");
			}
			return false;
		}
	}
	
}
