package se.chalmers.dat255.risk.model;

import java.io.File;
import java.util.ArrayList;

/**
 * The top game class. Controls flow between our lower classes, such as the
 * battle handler and the WorldMap.
 * 
 */

public class Game implements IGame {
	private Player[] players;
	private int activePlayer;
//	private int currentPhase;
	private WorldMap worldMap;
	private int bonus;
	private BattleHandler battle;
	private Deck deck;
	private IProvince oldClickedProvince = null;
	private boolean movedTroops =false; //F3
	private boolean firstProvinceConqueredThisTurn=true;
	
	//CURRENT PHASE
	private Phase currentPhase=Phase.F1;
	
	/**
	 * Creates a new Game.
	 * lostArmies = 
	 * @param playersId
	 *            The ids of the players
	 */
	public Game(String[] playersId) {
		//deck=Deck.getInstance(new ArrayList<String>().add(new Province("A").getId()), "5");//hårdkodat
		battle = new BattleHandler();
		newGame(playersId);
	}

	
	
	/**
	 * Method for changing the state of the game to the next state if it should
	 * be changed.
	 */
	private void changePhase() {
		if(currentPhase == Phase.F3){
			changeTurn();
			currentPhase = Phase.F3;
		}
		else if(currentPhase== Phase.F1){
			currentPhase=Phase.F2;
		}
		else{
			currentPhase=Phase.F3;
		}
	}

	private void changeTurn() {
		activePlayer = (activePlayer + 1) % players.length;
		oldClickedProvince=null;
		movedTroops=false;
		firstProvinceConqueredThisTurn=true;
		calcBonusUnits();
	}

	/**	OBS OBS OBS OBS
	 * Inte alls som den borde va i nul�get. Inmatning av antal hindrar fortsatt utveckling
	 */

	@Override
	public boolean attack(int offensiveDice, IProvince offensive, IProvince defensive) {
		// TODO decide number of attackers
		//		check if ok in another method
			// Counts the number of defending units
			int defensiveDice = defensive.getUnits() == 1 ? 1 : 2;
			
			int[] result = battle.doBattle(offensiveDice,
					defensiveDice);
	
			offensive.removeUnits(result[0]);
			defensive.removeUnits(result[1]);
			return true;
	}

	@Override
	public Player getActivePlayer() {
		return players[activePlayer];
	}

	@Override
	public void dealCard() {
		getActivePlayer().addCard();
	}

	@Override
	public void calcBonusUnits() {
		int provinces = getActivePlayer().getNrOfProvinces();
		if(provinces <= 9){
			this.bonus = 3; 
		} else {
			this.bonus = provinces/3;
		}
		this.bonus += worldMap.getBonus(getActivePlayer());
	}

	@Override
	public void placeBonusUnits(int units, IProvince province) {
		province.addUnits(units);
		bonus = bonus - units;
	}

	@Override
	public int getBonusUnitsLeft() {
		return bonus;
	}



	@Override
	public void newGame(String[] playersId) throws IllegalArgumentException {
		int noOfPlayers=playersId.length;
		if(noOfPlayers>=6 || noOfPlayers<=2){
			  throw new IllegalArgumentException("The player number must be betwen 2 and 6");
			}
				
			// THE PLAYERS
			players = new Player[noOfPlayers]; 
			for (int i = 0; i < noOfPlayers; i++) {
				players[i] = new Player(i, playersId[i]);
			}
			// SETTING PHASE AND TURN
			 currentPhase=Phase.F1;
			 activePlayer=0;
			 players[activePlayer].setCurrent(true); // Player one knows it�s his turn
		   	 
			// SETTING UP GAMEBOARD RULES AND CREATING PROVINCES
		   	worldMap= new WorldMap(new File("neighbours.txt"), new File("continents.txt"), players);

			// SETTING UP DECK
		//	deck = Deck.getInstanceOf(provinces, 6); // H�rdkodat antal wildcard 
				 
	//		refresh(); //BYTS MOT MOTSVARANDE I LIBGDX
	}



	@Override
	public Phase getCurrentPhase() {
		// TODO Auto-generated method stub
		return currentPhase;
	}


	@Override
	public Player[] getPlayer() {
		// TODO Auto-generated method stub
		return players;
	}


	@Override
	public ArrayList<Province> getGameProvinces() {
		// TODO Auto-generated method stub
		return worldMap.getProvinces();
	}

	
	@Override
	public void handleProvinceClick(IProvince newClickedProvince) {
		// TODO Auto-generated method stub
		// TROOP REINFORCMENT PHASE 1, ONLY THE PLACEMENT
		if(getCurrentPhase()==IGame.Phase.F1){
			//PUT A SINGEL UNIT ON THIS PROVINCE IF OWNED
			if(worldMap.getOwner(newClickedProvince.getId()) == getActivePlayer()){
				placeBonusUnits(1, newClickedProvince);
			}
		}
		// FIGHTING PHASE 2
		else if(getCurrentPhase()==IGame.Phase.F2){
			if(oldClickedProvince!=null){
				// FIGHT IF TWO PROVINCE CLICKED AND OWNED BY DIFFERENT PLAYER 
				// AND ATTACKING PROVINCE OWNED BY ME
				if(checkProvinceOk(oldClickedProvince, newClickedProvince, false)){
					battle(oldClickedProvince, newClickedProvince);
				}

				oldClickedProvince=null;
			}
			else{
				oldClickedProvince=newClickedProvince;
				
			}
		}
		//	MOVING TROOPS IN PHASE 3
		else if(getCurrentPhase()==IGame.Phase.F3){
			if(oldClickedProvince!=null){
				if(checkProvinceOk(oldClickedProvince, newClickedProvince, true)){
				//DONT FORGET TO ADD POP-UP
					moveToProvince(1, oldClickedProvince, newClickedProvince);// MAY BE INVALID INPUT, THEN NOTHING WILL HAPPEN
				}
			}
			else{
				oldClickedProvince=newClickedProvince;
			}
		}
	}
	private void moveToProvince(int nrOfUnits, IProvince from, IProvince goTo){
		if(nrOfUnits- from.getUnits() > 0){
			from.moveUnits(nrOfUnits, goTo);
		}
	}
	
	private boolean checkProvinceOk(IProvince from, IProvince to, boolean sameOwner){
		if(from!=to){
			if(worldMap.isNeighbours(from.getId(), to.getId())){
				if(sameOwner){
					return (worldMap.getOwner(from.getId()) ==  getActivePlayer()) && (worldMap.getOwner(to.getId()) ==  getActivePlayer()); 
				}
				else{
					return (worldMap.getOwner(from.getId()) ==  getActivePlayer()) && (worldMap.getOwner(to.getId()) !=  getActivePlayer()); 
				}
			}
		}
		return false;
	}
	
	private void battle(IProvince from, IProvince to){
		//POP-UP for nr of Offensive dice, untill implemented you may only attack with one
		int nrOfDices=1;
		//if(nrofdice>from.getUnits())
		if(from.getUnits()>1){
			attack(nrOfDices, from, to); 
			if (to.getUnits() == 0) {
				worldMap.changeOwner(to.getId(), getActivePlayer());
				//TODO	move attacking units into 'defensive'
				if(firstProvinceConqueredThisTurn){
					getActivePlayer().addCard();
					firstProvinceConqueredThisTurn=false;
				}
			}
		}
	}
		
}
