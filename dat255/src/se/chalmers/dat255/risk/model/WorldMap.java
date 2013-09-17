package se.chalmers.dat255.risk.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains Maps with relations for the provinces on the game board
 * and the players controlling them.
 *
 * Has methods for checking and dealing out ownership to territories.
 */

public class WorldMap {

	private HashMap<String, Player> ownership; 
	// neighbours maps together each territory with all adjacent territories.
	// It gets its information via the class constructor, which in turn reads all information
	// from a text file. 
	private final HashMap<String, ArrayList<String>> neighbours; 
	
	public WorldMap(File file){
		
			neighbours = new HashMap<String, ArrayList<String>>();
			
		try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split("-");
                String p1 = array[0];
                ArrayList<String> list = new ArrayList<String>();
                for(int i = 1; i < array.length; i++){
                	list.add(array[i]);
                }
                neighbours.put(p1, list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
		ownership.get(provinceName).loseProvince();
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
}
