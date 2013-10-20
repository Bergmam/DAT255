package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.NewClass.ProvinceResult;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.ResultType;

/**
 * The top game class. Controls flow between our lower classes, such as the
 * battle handler and the WorldMap.
 * 
 */

public class Game implements IGame {
	private EventHandler eventHandler;
	private BonusHandler bonusHandler;
	private BattleHandler battle;
	private Deck deck;
	private boolean firstProvinceConqueredThisTurn = true;
	private PropertyChangeSupport pcs;
	private MissionHandler missionHandler;
	private GameMode gameMode;
	private NewClass nc;

	private String continentsFile;
	private String neighboursFile;
	private String missionFile;

	private final int maxAllowedPlayers = 6;
	private final int minAllowedPlayers = 3;
	private final int numbersOfWildCards = 6;
	private final int oneDice = 1;
	private final int twoDices = 2;
	private final int threeDices = 3;

	/**
	 * Creates a new Game.
	 * 
	 * @param playersId
	 *            The ids of the players
	 */
	public Game() {
		battle = new BattleHandler();
		gameMode = GameMode.WORLD_DOMINATION;
	}

	@Override
	public void setupGame(List<String> playersId, String neighboursFile,
			String continentsFile, String missionFile) {
		this.neighboursFile = neighboursFile;
		this.continentsFile = continentsFile;
		this.missionFile = missionFile;
		pcs = new PropertyChangeSupport(this);// removed all existing listeners
												// in case this is a second game
		newGame(playersId);
	}

	@Override
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	private void newGame(List<String> playersId)
			throws IllegalArgumentException {
		eventHandler = new EventHandler();
		int noOfPlayers = playersId.size();
		if (noOfPlayers > maxAllowedPlayers || noOfPlayers < minAllowedPlayers) {
			throw new IllegalArgumentException(
					"The player number must be betwen " + minAllowedPlayers
							+ " and " + maxAllowedPlayers);
		}

		nc = new NewClass(eventHandler.getPhaseHandler(), neighboursFile,
				continentsFile, playersId);

		missionHandler = new MissionHandler(getPlayers(), missionFile);

		bonusHandler = new BonusHandler(nc.getWorldMap(), getPlayers().size());
		bonusHandler.calcBonusForF0(getActivePlayer().getNrOfProvinces()); // Instancieate
																			// bonus
		setUpDeck();
	}

	private void setUpDeck() {
		// SETTING UP DECK
		ArrayList<String> provinces = new ArrayList<String>();
		for (IProvince i : nc.getProvinces()) {
			provinces.add(i.getId());
		}
		deck = Deck.getInstance();
		deck.CreateCards(provinces, numbersOfWildCards);
	}

	@Override
	public IPlayer getActivePlayer() {
		return nc.getActivePlayer();
	}

	/*
	 * Places one unit in a province
	 * 
	 * @param province province to place the unit in
	 */
	private void placeBonusUnits(IProvince province) {
		bonusHandler.placeBonusUnits(1, province);
	}

	@Override
	public int getBonusUnitsLeft() {
		return bonusHandler.getBonus();
	}

	@Override
	public Phase getCurrentPhase() {
		return nc.getPhase();
	}

	@Override
	public List<IPlayer> getPlayers() {
		return nc.getPlayers();
	}

	@Override
	public List<IProvince> getGameProvinces() {
		return nc.getProvinces();
	}

	@Override
	public void handleProvinceEvent(IProvince newProvince) {
		ProvinceResult result = nc.handleProvinceEvent(newProvince,
				bonusHandler.getBonus());
		switch (result) {
		case ATTACK:
			pcs.firePropertyChange(ATTACK,
					nc.getOld().getUnits() - 1 >= 3 ? threeDices : nc.getOld()
							.getUnits() - 1, nc.getNew());
			break;
		case BONUS:
			placeBonusUnits(newProvince);
			break;
		case MOVEMET:
			pcs.firePropertyChange(MOVEMENT, nc.getOld().getUnits(), 1);
			break;
		case NOTHING:
			break;
		default:
			break;

		}
	}

	@Override
	public void flushProvinces() {
		nc.flushProvinces();
	}

	@Override
	public void moveToProvince(int nrOfUnits) {
		nc.moveToProvince(nrOfUnits);
	}

	@Override
	public void battle(int nbrOfDice) {

		// if (oldProvince.getUnits() > 1) {
		IProvince old = nc.getOld();
		IProvince second = nc.getNew();

		attack(nbrOfDice, old, second);
		if (second.getUnits() == 0) {
			changeOwner();
			if (firstProvinceConqueredThisTurn) {
				getActivePlayer().addCard();
				firstProvinceConqueredThisTurn = false;
			}
			pcs.firePropertyChange(CONQUER, old.getUnits(), "" + nbrOfDice);
		} else if (old.getUnits() > 1) {
			pcs.firePropertyChange(AGAIN, old.getUnits() - 1 >= 3 ? threeDices
					: old.getUnits() - 1, 0);
		} else {
			flushProvinces();
		}
		// }
	}

	/*
	 * Change the owner and adds a card if its the first province conquered this
	 * turn.
	 */
	private void changeOwner() {
		IPlayer lostProvincePlayer = nc.getOwner(nc.getNew().getId());
		nc.changeOwner(getActivePlayer());

		checkGameOver(lostProvincePlayer);
	}

	// playerlose or removeplayer first?
	private void checkGameOver(IPlayer gameOver) {
		if (gameOver.getNrOfProvinces() == 0) {
			int pos = getPlayers().indexOf(gameOver);
			playerLose(gameOver);
			if (gameMode == GameMode.SECRET_MISSION) {
				missionHandler.playerEliminated(gameOver);
			}
			nc.removePlayer(pos);
		}
		if (getPlayers().size() == 1) {
			win(getPlayers().get(0));
		}

		if (gameMode == GameMode.SECRET_MISSION
				&& missionHandler.winner(getActivePlayer(),
						nc.getPlayersContinents(getActivePlayer()))) {
			win(missionHandler.getWinner());
		}
	}

	private void win(IPlayer win) {
		pcs.firePropertyChange(WIN, 0, win);
	}

	// also handles defeat of neutral players,

	private void playerLose(IPlayer gameOver) {
		gameOver.discard();
		getPlayers().remove(gameOver);
	}

	private boolean attack(int offensiveDice, IProvince offensive,
			IProvince defensive) {

		int defensiveDice = defensive.getUnits() == 1 ? oneDice : twoDices;

		int[] result = battle.doBattle(offensiveDice, defensiveDice);

		offensive.removeUnits(result[0]);
		defensive.removeUnits(result[1]);
		return true;
	}

	@Override
	public void handleCardEvent(ICard card) {
		if (getCurrentPhase() == Phase.F1) {
			ArrayList<String> names = eventHandler.handleCardEvent(card,

			getActivePlayer());
			// HAVE TO FIX BONUSES //
			if (names != null) {
				bonusHandler.calcBonusesFromCards(names, getActivePlayer());
			}
		}
	}

	@Override
	public void surrender(boolean confirm) {
		if (confirm) {
			playerLose(getActivePlayer());
			pcs.firePropertyChange(CHANGE_TURN, nc.surrender(), false);
			if (getPlayers().size() == 1) {
				win(getPlayers().get(0));
				return;
			}
			if (getCurrentPhase() == Phase.FBuild) {
				bonusHandler.calcBonusForF0(getActivePlayer()
						.getNrOfProvinces());
			} else {
				updateValues();
			}
			flushProvinces();
		} else {
			pcs.firePropertyChange(SURRENDER, true, false);
		}
	}

	/*
	 * Text taken from TurnAndPhase
	 * 
	 * Changing phase and then pokes on other methods.
	 * 
	 * ComputeBonusForF0 if if a new bonus shall be computed. ChangedPhase if a
	 * change of phase has taken place. ComputeBonusForF1 if a new turn has
	 * begun (and not in buildingphase = F0). DoNothing if phase didn't change.
	 */
	@Override
	public void handlePhaseEvent() {
		int bonus = bonusHandler.getBonus();
		ResultType result = eventHandler.handlePhaseEvent(getActivePlayer(),
				bonus, getPlayers());
		if (result == ResultType.ComputeBonusForF0) {
			bonusHandler.calcBonusForF0(getActivePlayer().getNrOfProvinces());
			pcs.firePropertyChange(CHANGE_TURN, true, false);
		} else if (result == ResultType.ComputeBonusForF1) {
			updateValues();
			pcs.firePropertyChange(CHANGE_TURN, true, false);
		} else if (result == ResultType.DoNothing) {
			if (bonus > 0) {
				pcs.firePropertyChange(UNITS, true, false);
			} else {
				pcs.firePropertyChange(CARDS, true, false);
			}
		}
		flushProvinces();// clean temps between turns and phases
	}

	private void updateValues() {
		nc.updateBonus();
		bonusHandler.calcBonusUnits(getActivePlayer());
		firstProvinceConqueredThisTurn = true;
	}

	@Override
	public int getOwner(String provinceName) {
		return nc.getOwner(provinceName).getId();
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);

	}

	@Override
	public String getMissionText(IPlayer currentPlayer) {
		return missionHandler.getText(currentPlayer);
	}

	@Override
	public GameMode getGameMode() {
		return gameMode;
	}
}
