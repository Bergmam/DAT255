package se.chalmers.dat255.risk.model;

public interface IProvince {

	public int getUnits();
	
	public void addUnits(int units);
	
	public void removeUnits(int units);
	
	/**
	 * Used in F2 after gaining a province and in F3. 
	 */
	public void moveUnits(int units, IProvince province);
	
	public String getId();

}
