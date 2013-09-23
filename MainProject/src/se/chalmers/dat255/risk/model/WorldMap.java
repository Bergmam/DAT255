package se.chalmers.dat255.risk.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.Bones;

/**
 * Contains Maps with relations for the provinces on the game board
 * and the players controlling them.
 *
 * Has methods for checking and dealing out ownership to territories.
 */

public class WorldMap {

	private final ArrayList<Province> allProvinces;

	ArrayList<String> continent=new ArrayList<String>();
	private HashMap<String, Player> ownership; 
	int[] bonuses;
	// neighbours maps together each territory with all adjacent territories.
	// It gets its information via the class constructor, which in turn reads all information
	// from a text file. 
	private final HashMap<String, ArrayList<String>> neighbours;
	
	
	public WorldMap(File provinceFile, File continentFile, Player[] players){
		
			HashMap<String, ArrayList<String>> tempNeighbours = new HashMap<String, ArrayList<String>>();
			ArrayList<String> listOfProvinces = new ArrayList<String>();
			ownership= new HashMap<String, Player>(); 
		try {
            Scanner scanner = new Scanner(provinceFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split("-");
                String p1 = array[0];
                listOfProvinces.add(p1);
                ArrayList<String> list = new ArrayList<String>();
                for(int i = 1; i < array.length; i++){
                	list.add(array[i]);
                }
                tempNeighbours.put(p1, list);
                
            }
/*          scanner= new Scanner(continentFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split("-");
                int nrOfContinents=0;
                ArrayList<String> continent = array[0];
                listOfProvinces.add(p1);
                ArrayList<String> list = new ArrayList<String>();
                for(int i = 1; i < array.length; i++){
                	list.add(array[i]);
                }
                tempNeighbours.put(p1, list);
                
            }
*/
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		allProvinces = buildProvinces(listOfProvinces);
		randomizeProvinces(listOfProvinces, players);

        neighbours =  new HashMap<String, ArrayList<String>>(tempNeighbours);

	}
	
	/**
	 * Returns ownership of a certain territory.
	 * 
	 * @param A province name sent to the method
	 * @return The owner of the province sent to the method
	 */
	public Player getOwner(String provinceName){
		return ownership.get(provinceName);
	}
	
	/**
	 * Changes the ownership of a certain territory.
	 * Also changes the number of provinces that the players involved controls.
	 * 
	 * @param Name of the province that will change owner. 
	 * @param Which player the ownership should change to.
	 */
	
	public void changeOwner(String provinceName, Player player){
		Player oldPlayer = ownership.get(provinceName);
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
	public boolean isNeighbours(String provinceName1, String provinceName2){
		ArrayList<String> list = neighbours.get(provinceName1);
		if(list.contains(provinceName2)){
			return true;
		}
		return false;
	}
	
	/**
	 * Method to deal random provinces to the players at the start of a game.
	 * Every time a province is given to a player, it is removed from the list of provinces.
	 * 
	 * @param List of all provinces
	 * @param List of all players
	 */
	private void randomizeProvinces(ArrayList<String> provinceList, Player[] players){
		ArrayList<String> temp = provinceList;
		int nrOfPlayers = players.length, 
			nrOfProvinces = provinceList.size();
		
		Random randGen = new Random();
		while(!temp.isEmpty()){
			for(Player player:players){
				ownership.put(temp.remove(randGen.nextInt(nrOfProvinces)), player);
				nrOfProvinces--;
			}
		}	
	}
	
	/**
	 * Builds a list of Province objects from a list of province names
	 * 
	 * @param List of all province names
	 * @return List of all province objects on the map
	 */
	
	private ArrayList<Province> buildProvinces(ArrayList<String> nameList){
		ArrayList<Province> provinceList = new ArrayList<Province>();
		for(String s : nameList){
			provinceList.add(new Province(s));
		}
		return provinceList;
	}
	
	public int getBonus(Player player){
		return bonuses[player.getId()];
	}
	
	public int updateBonus(Province province){
		
		return 0;
	}
	
	private class Continent {
		String continentName;
		HashMap<String, Integer> provinceToID;
		String[] provinces;
		int bonus;
		
		public Continent(String continentName, ArrayList<String> provinces, int bonus){
			this.continentName = continentName;
	//		buildContinent(provinces);
			this.bonus = bonus;
		}
		
		private void buildContinent(ArrayList<String> provinces){
			int i = 0;
			mapProvinces.put(provinces.get(i), i);
			provinces[i]=world.getOwner();
		}
		
		public void update(){
			Player tempProvince = getOwner(provinces[0]);
			for(String province: provinces){
				if(tempProvince != getOwner(province)){
					return false
				}
				//Uppdatera tempprovince blabla
			}
		}
	}
}
