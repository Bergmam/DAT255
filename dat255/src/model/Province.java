package model;

/**
 * Simulates a province on the world map. Contains a number of units and handles
 * troop movement. 
 * 
 */
public class Province {
	private int units;
	private String id;
	
	/**
	 * Creates a new Province
	 * 
	 * @param province id of the province
	 */
	public Province(String province){
		id=province;
		units=1;  // Have do be atleast one soldier
	}
	
	public int getUnits(){
		return units;
	}
	
	public void addUnits(int units){
		this.units += units; 
	}
	
	public void removeUnits(int units){
		this.units -= units; 
	}
	
	/**
	 * Used in F2 after gaining a province and in F3. 
	 */
	public void moveUnits(int units, Province province){
		removeUnits(units);
		province.addUnits(units);
	}
	
	public String getId(){
		return id;
	}
}
