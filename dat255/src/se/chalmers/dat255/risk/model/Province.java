package se.chalmers.dat255.risk.model;

/**
 * Simulates a province on the world map. Contains a number of units and handles
 * troop movement. 
 * 
 */
public class Province implements IProvince{
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
	
	@Override
	public int getUnits(){
		return units;
	}
	
	@Override
	public void addUnits(int units){
		this.units += units; 
	}
	
	@Override
	public void removeUnits(int units){
		this.units -= units; }
	
	
	@Override
	public void moveUnits(int units, IProvince province){
		removeUnits(units);
		province.addUnits(units);
	}
	
	@Override
	public String getId(){
		return id;
	}
}
