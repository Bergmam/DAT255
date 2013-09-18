package se.chalmers.dat255.risk.model;

/**
 * Interface for provinces.
 * 
 */
public interface IProvince {

	/**
	 * Getter for units in the province
	 * 
	 * @return the number of units in the province
	 */
	public int getUnits();

	/**
	 * Adds units to this province
	 * 
	 * @param units
	 *            , number of units to be added
	 */
	public void addUnits(int units);

	/**
	 * Removes units from this province
	 * 
	 * @param units
	 *            , number of units to be removed
	 */
	public void removeUnits(int units);

	/**
	 * Move units forom this province to another province. Used in F2 after
	 * gaining a province and in F3.
	 * 
	 * @param units
	 *            , number of units to be moved
	 * 
	 * @param province
	 *            , the province to receive the units
	 */
	public void moveUnits(int units, IProvince province);

	/**
	 * Fetches the string identification of this province
	 * 
	 * @return the name(ID) of this province
	 */
	public String getId();

}
