package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

/**
 * The top game class. Controls flow between our lower classes, such as the
 * battle handler and the WorldMap.
 * 
 */

public class Game implements IGame {
	private Player[] players;
	private int startingTroopNr;
	private WorldMap worldMap;
	private ClickHandler clickHandler;
	private TurnAndPhaseManager phaseHandler;
	private int bonus;
	private BattleHandler battle;
	private Deck deck;
	private IProvince oldClickedProvince = null;
	private boolean movedTroops = false; // F3
	private boolean firstProvinceConqueredThisTurn = true;
	private PropertyChangeSupport pcs;
	// CURRENT PHASE

	private String continentsFile;
	private String neighboursFile;

	/**
	 * Creates a new Game. lostArmies =
	 * 
	 * @param playersId
	 *            The ids of the players
	 */
	public Game(String[] playersId, String neighboursFile, String continentsFile) {
		battle = new BattleHandler();
		this.neighboursFile = neighboursFile;
		this.continentsFile = continentsFile;
		pcs = new PropertyChangeSupport(this);
		newGame(playersId);
	}

	@Override
	public void newGame(String[] playersId) throws IllegalArgumentException {
		phaseHandler = new TurnAndPhaseManager();
		clickHandler = new ClickHandler(phaseHandler);

		int noOfPlayers = playersId.length;
		if (noOfPlayers > 6 || noOfPlayers < 2) {
			throw new IllegalArgumentException(
					"The player number must be betwen 2 and 6");
		}

		createPlayers(playersId);
		players[phaseHandler.getActivePlayer()].setCurrent(true); // Player one
		calcStartBonus();

		// ////////////////// ONLY FOR DEV //////////////////////////
		// SETTING UP GAMEBOARD RULES AND CREATING PROVINCES
		worldMap = new WorldMap(neighboursFile, continentsFile, players);

		setUpDeck();

		// refresh(); //BYTS MOT MOTSVARANDE I LIBGDX
	}

	private void setUpDeck() {
		// SETTING UP DECK
		ArrayList<String> provinces = new ArrayList<String>();
		for (IProvince i : worldMap.getProvinces()) {
			provinces.add(i.getId());
		}
		deck = Deck.getInstance();
		deck.CreateCards(provinces, 6);// H�rdkodat antal wildcard
	}

	private void createPlayers(String[] playersId) {
		players = new Player[playersId.length];
		for (int i = 0; i < playersId.length; i++) {
			players[i] = new Player(i, playersId[i]);
		}
	}

	private void calcStartBonus() {
		// INITIALIZING STARTING NUMBER OF TROOPS
		startingTroopNr = 50 - players.length * 5;

		// /////////////////// ONLY FOR DEV ///////////////////////////
		// bonus = startingTroopNr - getActivePlayer().getNrOfProvinces();
		bonus = 3;
	}

	/**
	 * Method for changing the state of the game to the next state if it should
	 * be changed.
	 */
	public int changePhase() {
		return clickHandler.handlePhaseClick(getActivePlayer(), bonus, players);
	}

	/**
	 * OBS OBS OBS OBS Inte alls som den borde va i nul�get. Inmatning av antal
	 * hindrar fortsatt utveckling
	 */

	@Override
	public boolean attack(int offensiveDice, IProvince offensive,
			IProvince defensive) {
		// TODO decide number of attackers
		// check if ok in another method
		// Counts the number of defending units

		int defensiveDice = defensive.getUnits() == 1 ? 1 : 2;

		int[] result = battle.doBattle(offensiveDice, defensiveDice);

		offensive.removeUnits(result[0]);
		defensive.removeUnits(result[1]);
		return true;
	}

	@Override
	public Player getActivePlayer() {
		return players[phaseHandler.getActivePlayer()];
	}

	@Override
	public void dealCard() {
		getActivePlayer().addCard();
	}

	@Override
	public void calcBonusUnits() {
		int provinces = getActivePlayer().getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}

		this.bonus += worldMap.getBonus(getActivePlayer());

	}

	/**
	 * Method for placing the amount of units the player chooses the place on
	 * the province the player chooses to place them.
	 * 
	 * @param units
	 *            the number of units being placed
	 */
	private void placeBonusUnits(int units, IProvince province) {
		province.addUnits(units);
		bonus = bonus - units;
	}

	@Override
	public int getBonusUnitsLeft() {
		return bonus;
	}

	@Override
	public Phase getCurrentPhase() {
		return phaseHandler.getPhase();
	}

	@Override
	public Player[] getPlayers() {
		return players;
	}

	@Override
	public ArrayList<IProvince> getGameProvinces() {
		return worldMap.getProvinces();
	}

	@Override
	public void handleProvinceClick(IProvince newClickedProvince) {
		// TROOP REINFORCMENT PHASE 1, ONLY THE PLACEMENT
		if (getCurrentPhase() == Phase.F1 && bonus > 0) {
			// PUT A SINGEL UNIT ON THIS PROVINCE IF OWNED
			if (worldMap.getOwner(newClickedProvince.getId()) == getActivePlayer()) {
				placeBonusUnits(1, newClickedProvince);
			}
		}
		// FIGHTING PHASE 2, FIGHT IF TWO PROVINCE CLICKED AND OWNED BY
		// DIFFERENT PLAYER AND ATTACKING PROVINCE OWNED BY ME
		else if (getCurrentPhase() == Phase.F2) {
			if (myProvince(newClickedProvince.getId())) {
				oldClickedProvince = newClickedProvince;
			} else if (oldClickedProvince != null) {
				if (checkProvinceOk(oldClickedProvince, newClickedProvince,
						false)) {

					battle(oldClickedProvince, newClickedProvince);
				} else {
					flushTemps();
				}
			}
			if (oldClickedProvince == null) {
				System.out.println("Moving from: -");
			}

		}

		// MOVING TROOPS IN PHASE 3
		else if (getCurrentPhase() == Phase.F3) {
			if (myProvince(newClickedProvince.getId())
					&& oldClickedProvince == null) {
				oldClickedProvince = newClickedProvince;

			}

			else if (oldClickedProvince != null) {
				if (checkProvinceOk(oldClickedProvince, newClickedProvince,
						true)) {
					// DONT FORGET TO ADD POP-UP//TODO
					// pcs.firePropertyChange("Movement",
					// oldClickedProvince.getUnits(), 1);
					moveToProvince(1, oldClickedProvince, newClickedProvince);// MAY
					flushTemps(); // BE
					// INVALID
					// INPUT,
					// THEN
					// NOTHING
					// WILL
					// HAPPEN
				}
			}
		}
		// Placing troops in build phase
		else if (getCurrentPhase() == Phase.FBuild) {
			if (worldMap.getOwner(newClickedProvince.getId()) == getActivePlayer()
					&& bonus > 0) {
				placeBonusUnits(1, newClickedProvince);
				System.out.print("Current player active is player "
						+ phaseHandler.getActivePlayer() + "\n");
			}
		}

	}

	private void flushTemps() {
		oldClickedProvince = null;
	}

	private boolean myProvince(String province) {
		return getActivePlayer() == worldMap.getOwner(province);
	}

	private void moveToProvince(int nrOfUnits, IProvince from, IProvince goTo) {
		if (from.getUnits() - nrOfUnits > 0) {
			System.out.println("" + from.getUnits() + " units moved from "
					+ from.getId() + " to " + goTo.getId());
			from.moveUnits(nrOfUnits, goTo);
		}
	}

	private boolean checkProvinceOk(IProvince from, IProvince to,
			boolean sameOwner) {
		if (worldMap.isNeighbours(from.getId(), to.getId())) {
			if (sameOwner) {
				return (worldMap.getOwner(from.getId()) == getActivePlayer())
						&& (worldMap.getOwner(to.getId()) == getActivePlayer());
			} else {
				return (worldMap.getOwner(from.getId()) == getActivePlayer())
						&& (worldMap.getOwner(to.getId()) != getActivePlayer());
			}

		}
		return false;
	}

	private void battle(IProvince from, IProvince to) {
		// POP-UP for nr of Offensive dice, untill implemented you may only
		// attack with one //TODO pcs.firePropertyChange("Attack", from, null);

		int nrOfDices = from.getUnits() - 1;
		if (nrOfDices > 3) {
			nrOfDices = 3;
		}

		// if(nrofdice>from.getUnits())
		if (from.getUnits() > 1) {
			attack(nrOfDices, from, to);
			if (to.getUnits() == 0) {
				worldMap.changeOwner(to.getId(), getActivePlayer());
				// TODO move attacking units into 'defensive'
				moveToProvince(1, from, to);
				if (firstProvinceConqueredThisTurn) {
					getActivePlayer().addCard();
					firstProvinceConqueredThisTurn = false;
					System.out.println("Du fick ett kort");
				}
			}
		}
	}

	@Override
	public void handleCardClick(ICard card) {
		clickHandler.handleCardClick(card, getActivePlayer());
		// HAVE TO FIX BONUSES //

		/*
		 * if (card2 != null) { getActivePlayer().exchangeCard((Card) card1,
		 * (Card) card2, (Card) card); // GIVE BONUS // Check if extra bonus
		 * from owned province cards card1 = null; card2 = null; } else { if
		 * (card1 == null) { card1 = card; } else { card2 = card; } }
		 */
	}

	@Override
	public void handlePhaseClick() {
		int result = changePhase();
		if (result == 2) {
			System.out.println("PhaseHandler: New active player "
					+ phaseHandler.getActivePlayer());
			System.out.println("Game: New active player "
					+ getActivePlayer().getId());
			bonus = startingTroopNr - getActivePlayer().getNrOfProvinces();

		} else if (result == 0) {
			worldMap.updateBonus();
			calcBonusUnits();

		}
	}

	@Override
	public int getOwner(String provinceName) {
		return worldMap.getOwner(provinceName).getId();
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);

	}

}
