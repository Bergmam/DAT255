package se.chalmers.dat255.risk.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.util.Pair;

/**
 * Contains Maps with relations for the provinces on the game board
 * and the players controlling them.
 *
 */

public class WorldMap {

	private HashMap<String, Player> ownership; // Skapas genom lottning
	private final HashMap<String, ArrayList<String>> neighbours; // F�rdefinerad lista som finns i en txt
	
	/*
	 * L�sa in hela filen h�r?
	 */
	public WorldMap(File file){
		
			neighbours = new HashMap<String, ArrayList<String>>();
			
		try {
            //
            // Create a new Scanner object which will read the data 
            // from the file passed in. To check if there are more 
            // line to read from it we check by calling the 
            // scanner.hasNextLine() method. We then read line one 
            // by one till all line is read.
            //
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
	
	public Player getOwner(String provinceName){
		return ownership.get(provinceName);
	}
	
	public void changeOwner(String provinceName, Player player){
		ownership.put(provinceName, player);
	}

	public boolean isNeighbours(String provinceName1, String provinceName2){
		ArrayList list = neighbours.get(provinceName1);
		if(list.contains(provinceName2)){
			return true;
		}
		return false;
	}
}
