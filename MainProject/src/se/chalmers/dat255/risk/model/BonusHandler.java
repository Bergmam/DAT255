package se.chalmers.dat255.risk.model;

public class BonusHandler {

	private int bonus;
	private int startingTroopNr;

	public int calcProvinceBonusesFromCards(ArrayList<String> names){
		int bonus=0;
		//kod
		/* (skräp från game)
		 * if (card2 != null) { getActivePlayer().exchangeCard((Card) card1,
		 * (Card) card2, (Card) card); // GIVE BONUS // Check if extra bonus
		 * from owned province cards card1 = null; card2 = null; } else { if
		 * (card1 == null) { card1 = card; } else { card2 = card; } }
		 */
		
		return bonus;
	}
	
	public void calcStartBonus() {
		// INITIALIZING STARTING NUMBER OF TROOPS
		startingTroopNr = 50 - players.length * 5;

		// /////////////////// ONLY FOR DEV ///////////////////////////
		// bonus = startingTroopNr - getActivePlayer().getNrOfProvinces();
		bonus = 3;
	}
	
	public void calcBonusUnits() {
		int provinces = getActivePlayer().getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}

		this.bonus += worldMap.getBonus(getActivePlayer());

	}
	
	public int getBonus(){
		return bonus;
	}
	
	public void placeBonusUnits(int units, IProvince province) {
		province.addUnits(units);
		bonus = bonus - units;
	}
	
	public void calcBonusForF0(int numberOfProvinces){
		bonus = startingTroopNr - numberOfProvinces;		

	}
}
