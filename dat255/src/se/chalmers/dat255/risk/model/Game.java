package se.chalmers.dat255.risk.model;

/**
 * The top game class. Controls flow between our lower classes, such as the
 * battle handler and the WorldMap.
 * 
 */

public class Game implements GameInterface {
	private Player[] players;
	private int activePlayer;
	private int currentPhase;
	
	/**
	 * Creates a new Game.
	 * @param playersId The ids of the players
	 */
	public Game(String[] playersId) {
		for(int i = 0; i < playersId.length ; i++){
			players[i]= new Player(i, playersId[i]);
		}
		currentPhase=1;
	}

	@Override
	public void changePhase() {
		currentPhase++;
	}

	@Override
	public void changeTurn() {
		// Check this!
		activePlayer = (activePlayer+1)%players.length;
		currentPhase = 1;
	}

	@Override
	public void attack(Province offensiv, Province defensive) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getActivePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dealCard() {
		// TODO Auto-generated method stub

	}

	@Override
	public int calcBonusUnits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void placeBonusUnits(int units, Province province) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBonusUnitsLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

}
