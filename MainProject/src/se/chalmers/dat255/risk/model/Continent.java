package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Continent {
	String continentName;
	HashMap<String, Integer> provinceToID;
	String[] provinces;
	int bonus;
	
	public Continent(String continentName, ArrayList<String> provinces, int bonus){
		this.continentName = continentName;
		buildContinent(provinces);
		this.bonus = bonus;
	}
	
	private void buildContinent(ArrayList<String> provinces){
		int i = 0;
		mapProvinces.put(provinces.get(i), i);
		provinces[i]=world.getOwner();
	}
	
	public void update(){
		for(String province){
			getOwner(province);
		}
	}
}
