package se.chalmers.dat255.risk.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import android.util.Pair;

/**
 * Contains Maps with relations for the provinces on the game board
 * and the players controlling them.
 *
 */

public class WorldMap {

	private HashMap<String, Player> ownership; // Skapas genom lottning
	private final HashMap<Pair<String, String>, Boolean> neighbours; // F�rdefinerad lista som finns i en txt
	
	/*
	 * L�sa in hela filen h�r?
	 */
	public WorldMap(File file){
		
	}
	
	public Player getOwner(String provinceName){
		return ownership.get(provinceName);
	}
	
	public void changeOwner(String provinceName, Player player){
		ownership.put(provinceName, player);
	}
	
	/*
	 * �r os�ker p� hur Pair funkar, kan ge problem.
	 */
	
	public boolean isNeighbours(String provinceName1, String provinceName2){
		Pair<String,String> key = new Pair<String,String>(provinceName1, provinceName2);
		return neighbours.get(key);
	}
}
