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
	private WorldMap worldMap;
	private int bonus;
	private BattleHandler battle;

	/**
	 * Creates a new Game.
	 * 
	 * @param playersId
	 *            The ids of the players
	 */
	public Game(String[] playersId) {
		for (int i = 0; i < playersId.length; i++) {
			players[i] = new Player(i, playersId[i]);
		}
		currentPhase = 1;

		// TODO: Dont forget to change null!!!!!
		worldMap = new WorldMap(null);

		battle = new BattleHandler();
	}

	@Override
	public void changePhase() {
		currentPhase++;
	}

	@Override
	public void changeTurn() {
		// TODO: Check this!
		activePlayer = (activePlayer + 1) % players.length;
		currentPhase = 1;
	}

	@Override
	public void attack(Province offensive, Province defensive) {
		// TODO decide number of attackers
		//		check if ok in another method
		int[] result = battle.doBattle(offensive.getUnits(),
				defensive.getUnits());

		offensive.removeUnits(result[0]);
		defensive.removeUnits(result[1]);

		if (defensive.getUnits() == 0) {
			//TODO	move attacking units into 'defensive'
			worldMap.changeOwner(defensive.getId(), getActivePlayer());
			
		}

	}

	@Override
	public Player getActivePlayer() {
		return players[activePlayer];
	}

	@Override
	public void dealCard() {
		getActivePlayer().addCard(Deck.giveCard());
	}

	@Override
	public void calcBonusUnits() {
		// TODO Auto-generated method stub
	}

	@Override
	public void placeBonusUnits(int units, Province province) {
		province.addUnits(units);
		bonus = bonus - units;
	}

	@Override
	public int getBonusUnitsLeft() {
		return bonus;
	}

}
