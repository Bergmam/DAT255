package model;

/**
 * Simulates a province on the world map. Contains a number of units and handles
 * troop movement. 
 * 
 */
public class Province {
	private int units;
	private String id;
	
	public Province(String province){
		id=province;
	}
	
	public int getUnits(){
		return units;
	}
	
	public void addUnits(int units){
		this.units += units; 
	}
	
	public void moveUnits(int units, Province province){
		this.units-=units;
		province.addUnits(units);
	}
	
	public String getId(){
		return id;
	}
}
