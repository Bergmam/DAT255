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
//	private ArrayList<Mission> listOfMissions;
	
	public MissionHandler(ArrayList<Player> players){
		eliminatedPlayers = new ArrayList<Player>();
		missionsInGame = new ArrayList<Mission>();
		Random randGen = new Random();
		int nextRandInt;
		ArrayList<Mission> listOfMissions = buildMissions(players);
		HashMap<Player, Mission> tempMissionMap = new HashMap<Player, Mission>();

		for(Player player : players){
			nextRandInt = randGen.nextInt(listOfMissions.size());
			giveMission(player, nextRandInt, tempMissionMap, listOfMissions);
			
			
			if(tempMissionMap.get(player).getType() == MissionType.ELIMINATE){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att eliminera " + tempMissionMap.get(player).getVictim().getName() + ".");
				
			}
			else if(tempMissionMap.get(player).getType() == MissionType.CONQUER_CONTINENTS){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att erövra " + "kontinenter.");
				
			}
			else if(tempMissionMap.get(player).getType() == MissionType.CONQUER_PROVINCES){
				System.out.println("UPPDRAG: " + player.getName() + " har i uppdrag att erövra " + tempMissionMap.get(player).getNeedToConquer() + " provincer.");
				
			}
		}
		
		
		
		missionMap = tempMissionMap;
	}
	
	private Mission getMission(Player player){
		return missionMap.get(player);
	}
	
	/**
	 * Return true if there is a winner.
	 */
	public boolean winner(Player currentPlayer){
		for(Mission mission : missionsInGame){
			if(mission.fullFilled(currentPlayer)){
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
	
	public ArrayList<Mission> buildMissions(ArrayList<Player> players){
		ArrayList<Mission> missions = new ArrayList<Mission>();
		addEliminateMissions(missions, players);
		addConquerContinentMissions(missions);
		addConquerProvincesMissions();
		
		return missions;
	}
	
	public void addEliminateMissions(ArrayList<Mission> missions, ArrayList<Player> players){
		ArrayList<Player> notVictims = players;
		for(Player victim : players)
			missions.add(new Mission(victim, MissionType.ELIMINATE));
	}
	
	public void addConquerContinentMissions(ArrayList<Mission> missions){
		missions.add(new Mission(24));
		missions.add(new Mission(18));
	}
	
	public void addConquerProvincesMissions(){
		
	}
	
	private class Mission{
		
		private MissionType type;
		// ELIMINATE
		private Player owner;
		private Player victim;
		//	CONQUER_PROVINCES
		private int needToConquer;
		
		public Mission(Player vicitim, MissionType type){
	//		this.owner=owner;
			this.victim=vicitim;
			this.type=MissionType.ELIMINATE;
		}
		
		public Mission(int numberOfProvincesToConquer){
	//		this.owner=owner;
			this.type=MissionType.CONQUER_PROVINCES;
			needToConquer=numberOfProvincesToConquer;
		}
		
		
		
		public boolean fullFilled(Player currentPlayer){
			if(type == MissionType.ELIMINATE){
				if(eliminatedPlayers.contains(victim)){
					winner=owner;
					return true;
				}
			}
			else if(type == MissionType.CONQUER_PROVINCES){
				if(needToConquer == 24){
					return currentPlayer.getNrOfProvinces() >=24;
				}
				else if(needToConquer == 18){
					if(currentPlayer.getNrOfProvinces() >=24){
						return checkSoTwoInEachProvince(currentPlayer);
					}
				}
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
		
		private boolean checkSoTwoInEachProvince(Player player){
		//	TODO Need to be implemented correct, now it just checks if you have enough troop
			// also need to check so that they are placed at least two on each province
			
			return true;
		}

	}
	
}
