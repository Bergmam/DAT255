package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

/**
 * Help class for Game to manage WorldMap and province events
 * 
 */
class WorldHandler {

	private WorldMap worldMap;
	private IProvince oldProvince, secondProvince;
	private boolean movedTroops;
	private TurnAndPhaseManager phaseHandler;
	private ArrayList<IPlayer> players;

	public WorldHandler(TurnAndPhaseManager phaseHandler,
			String neighboursFile, String continentsFile, List<String> playersId) {
		this.phaseHandler = phaseHandler;

		createPlayers(playersId);

		worldMap = new WorldMap(neighboursFile, continentsFile, players);
	}

	/**
	 * Fetches the first province that was saved
	 * 
	 * @return oldProvince
	 */
	public IProvince getOld() {
		return oldProvince;
	}

	/**
	 * Fetches the second province that was saved
	 * 
	 * @return secondProvince
	 */
	public IProvince getNew() {
		return secondProvince;
	}

	/**
	 * Fetches the owner of a province
	 * 
	 * @param province
	 *            string representive of a province
	 * @return IPlayer that owns the province
	 */
	public IPlayer getOwner(String province) {
		return worldMap.getOwner(province);
	}

	/**
	 * fetches a list of all provinces
	 * 
	 * @return all provinces
	 */
	public List<IProvince> getProvinces() {
		return worldMap.getProvinces();
	}

	/**
	 * checks if two provinces are neighbours
	 * 
	 * @param id
	 *            name of first province
	 * @param id2
	 *            name of second province
	 * @return true if neighbours, false otherwise
	 */
	public boolean isNeighbours(String id, String id2) {
		return worldMap.isNeighbours(id, id2);
	}

	/**
	 * changes owner of secondProvince to new player
	 * 
	 * @param player
	 *            new owner of province
	 */
	public void changeOwner(IPlayer player) {
		worldMap.changeOwner(secondProvince.getId(), player);
	}

	/**
	 * returns all continents a player owns
	 * 
	 * @param player
	 *            owner of continents
	 * 
	 * @return all continents the player owns
	 */
	public List<String> getPlayersContinents(IPlayer player) {
		return worldMap.getPlayersContinents(player);
	}

	/**
	 * updates some variables
	 */
	public void updateBonus() {
		worldMap.updateBonus();
		movedTroops = false;
	}

	/**
	 * get the player whose turn it is
	 * 
	 * @return the active player
	 */
	public IPlayer getActivePlayer() {
		return players.get(phaseHandler.getActivePlayer());
	}

	/**
	 * method for getting all players
	 * 
	 * @return all players
	 */
	public List<IPlayer> getPlayers() {
		return players;
	}

	/**
	 * Determines what should be done with the chosen province
	 * 
	 * @param newProvince
	 *            new province to be handled
	 * @param bonus
	 *            current players bonus units
	 * @return result determining games action
	 */
	public ProvinceResult handleProvinceEvent(IProvince newProvince, int bonus) {
		// TROOP REINFORCMENT PHASE 1, ONLY THE PLACEMENT
		if (phaseHandler.getPhase() == Phase.F1 && bonus > 0) {
			// PUT A SINGEL UNIT ON THIS PROVINCE IF OWNED
			if (getOwner(newProvince.getId()) == getActivePlayer()) {
				// placeBonusUnits(newProvince);
				return ProvinceResult.BONUS;
			}
		}
		// FIGHTING PHASE 2, FIGHT IF TWO PROVINCE CLICKED AND OWNED BY
		// DIFFERENT PLAYER AND ATTACKING PROVINCE OWNED BY ME
		else if (phaseHandler.getPhase() == Phase.F2) {
			return handleProvinceF2(newProvince);
		}// MOVING TROOPS IN PHASE 3
		else if (phaseHandler.getPhase() == Phase.F3 && !movedTroops) {
			return handleProvinceF3(newProvince);
		}// Placing troops in build phase
		else if (phaseHandler.getPhase() == Phase.FBuild) {
			if (getOwner(newProvince.getId()) == getActivePlayer() && bonus > 0) {
				// placeBonusUnits(newProvince);
				return ProvinceResult.BONUS;
			}
		}
		return ProvinceResult.NOTHING;
	}

	/*
	 * help method for handling province events in phase 2
	 */
	private ProvinceResult handleProvinceF2(IProvince newProvince) {
		if (myProvince(newProvince.getId()) && newProvince.getUnits() > 1) {
			if (oldProvince != null) {
				oldProvince.setActive(false);
			}
			oldProvince = newProvince;
			System.out.println("Moving from: " + oldProvince.getId());
			oldProvince.setActive(true);

		} else if (oldProvince != null) {
			// FIGHT IF TWO PROVINCE CLICKED AND OWNED BY DIFFERENT PLAYER
			// AND ATTACKING PROVINCE OWNED BY ME
			if (checkProvinceOk(oldProvince, newProvince, false)) {
				// saving second province to be used later after
				// nbr of dices has been decided by the user
				secondProvince = newProvince;
				secondProvince.setActive(true);
				return ProvinceResult.ATTACK;
			} else {
				flushProvinces();
			}
		}
		if (oldProvince == null) {
			System.out.println("Moving from: -");
		}
		return ProvinceResult.NOTHING;
	}

	/*
	 * help method for handling province events in phase 3
	 */
	private ProvinceResult handleProvinceF3(IProvince newProvince) {
		if (myProvince(newProvince.getId()) && oldProvince == null
				&& newProvince.getUnits() > 1) {
			oldProvince = newProvince;
			oldProvince.setActive(true);
		} else if (oldProvince != null) {
			if (checkProvinceOk(oldProvince, newProvince, true)) {
				if (oldProvince.getUnits() > 1) {

					secondProvince = newProvince;
					secondProvince.setActive(true);

					return ProvinceResult.MOVEMET;
				}
			}
		}
		return ProvinceResult.NOTHING;
	}

	// return if current player owns the province
	private boolean myProvince(String province) {
		return getActivePlayer() == getOwner(province);
	}

	// checks the value of sameOwner
	private boolean checkProvinceOk(IProvince from, IProvince to,
			boolean sameOwner) {
		if (isNeighbours(from.getId(), to.getId())) {
			if (sameOwner) {
				return (getOwner(from.getId()) == getActivePlayer())
						&& (getOwner(to.getId()) == getActivePlayer());
			} else {
				return (getOwner(from.getId()) == getActivePlayer())
						&& (getOwner(to.getId()) != getActivePlayer());
			}

		}
		return false;
	}

	// creates all players
	private void createPlayers(List<String> playersId) {
		players = new ArrayList<IPlayer>();
		for (int i = 0; i < playersId.size(); i++) {
			players.add(new Player(i, playersId.get(i)));
		}
	}

	/**
	 * Inactivate saved provinces and removes their value
	 */
	public void flushProvinces() {
		if (oldProvince != null) {
			oldProvince.setActive(false);
		}
		oldProvince = null;
		if (secondProvince != null) {
			secondProvince.setActive(false);
		}
		secondProvince = null;
	}

	/**
	 * method for reaching the worldmap
	 * 
	 * @return worldMap
	 */
	public WorldMap getWorldMap() {
		return worldMap;
	}

	/**
	 * enum constants for different outcomes of handleProvinceEvent
	 */
	public enum ProvinceResult {
		BONUS, ATTACK, MOVEMET, NOTHING
	}

	/**
	 * moves units from one province to another
	 * 
	 * @param nrOfUnits
	 *            amount of units to be moved
	 */
	public void moveToProvince(int nrOfUnits) {
		if (oldProvince.getUnits() - nrOfUnits > 0) {
			oldProvince.moveUnits(nrOfUnits, secondProvince);
			if (phaseHandler.getPhase() == Phase.F3) {
				movedTroops = true;
			}
		}
		flushProvinces();
	}

	/**
	 * fetches the current phase enum
	 * 
	 * @return the current phase
	 */
	public Phase getPhase() {
		return phaseHandler.getPhase();
	}

	/**
	 * removes a player from the game properly
	 * 
	 * @param pos
	 *            the players position in list
	 */
	public void removePlayer(int pos) {
		phaseHandler.removePlayer(pos);

	}

	/**
	 * make phasehandler handle surrender
	 * 
	 * @return true if change of turn has taken place
	 */
	public boolean surrender() {
		return phaseHandler.surrender(getPlayers());
	}

	/**
	 * returns the bonus of the current player
	 * 
	 * @return bonus of current player
	 */
	public int getBonus() {
		return worldMap.getBonus(getActivePlayer());
	}
}
