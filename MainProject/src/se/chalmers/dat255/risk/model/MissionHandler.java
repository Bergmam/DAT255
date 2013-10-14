package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.HashMap;

import sun.security.action.GetBooleanAction;

public class MissionHandler {
	Player winner;
	ArrayList<Player> eliminatedPlayers;
	HashMap<Player, Mission> missions;
	ArrayList<Mission> listOfMissions;
	
	public MissionHandler(ArrayList<Player> players){
		for(Player player : players)
			giveMission(player);
	}
	
	private Mission getMission(Player player){
		return missions.get(player);
	}
	
	/**
	 * Return true if there is a winner.
	 */
	public boolean winner(){
		for(Mission mission : listOfMissions){
			if(mission.fullFilled()){
				return true;
			}
		}
		return false;
	}
	
	public Player getWinner(){
		return winner;
	}
	
	public static enum MissionType {
		ELIMINATE, CONQUER;
	}
	
	public void playerEliminated(Player player){
		eliminatedPlayers.add(player);
	}
	
	public void giveMission(Player player){
		
	}
	
	public ArrayList<Mission> buildMissions(ArrayList<Player> players){
		ArrayList<Mission> missions = new ArrayList<Mission>();
		missions.addEliminateMissions();
		
	}
	
	private class Mission{
		
		MissionType type = MissionType.ELIMINATE;
		Player owner;
		Player victim;
		
		public Mission(Player owner){
			this.owner=owner;

		}
		
		
		
		public boolean fullFilled(){
			if(type == MissionType.ELIMINATE){
				if(eliminatedPlayers.contains(victim)){
					winner=owner;
					return true;
				}
			}
			return false;
		}

		
		

	}
	
}
