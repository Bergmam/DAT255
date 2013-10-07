package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Deck;
import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager;

public class GameTest {

	Game game;
	Game game1;
	Game game2;
	Game game3;
	Game game4;

	@Before
	public void beforeAllTest() {

		String provinces = "A-B-C-D-E" + "\n" + "B-A-C-E" + "\n" + "C-A-D"
				+ "\n" + "D-A-C-E" + "\n" + "E-A-B-D";
		String continents = "3-A-B-C" + "\n" + "2-D-E";
		String[] name = new String[] { "Linnea", "Andreas", "Emil", "Bergman",
				"Christoffer", "Emma" };
		game = new Game();
		game.setupGame(name, provinces, continents);
		String[] name1 = new String[] { "Christoffer", "Emma" };
		game1 = new Game();
		game1.setupGame(name1, provinces, continents);
		String[] name2 = new String[] { "Andreas", "Emil", "Bergman" };
		game2 = new Game();
		game2.setupGame(name2, provinces, continents);
		String[] name3 = new String[] { "Andreas", "Emil", "Bergman",
		"Christoffer" };
		game3 = new Game();
		game3.setupGame(name3, provinces, continents);
		String[] name4 = new String[] { "Andreas", "Emil", "Bergman",
				"Christoffer", "Emma" };

		game4 = new Game();
		// This is because we for every new testMethod wants the same deck.
		Deck.getInstance().getDeckList().clear();
		game4.setupGame(name4, provinces, continents);
	}

	@Test
	public void testActivePlayer() {
		// Checks if the active player is correct
		assertTrue(game.getActivePlayer().getName() == "Linnea");
		assertTrue(game1.getActivePlayer().getName() == "Christoffer");
		assertTrue(game2.getActivePlayer().getName() == "Andreas");
	}

	@Test
	public void testSizeOfPlayerList() {
		// Check if number of player is correct,
		assertTrue(game.getPlayers().size() == 6);
		assertTrue(game1.getPlayers().size() == 2);
		assertTrue(game2.getPlayers().size() == 3);
		assertTrue(game3.getPlayers().size() == 4);
		assertTrue(game4.getPlayers().size() == 5);

	}

	@Test
	public void testSetUpDeck() {
		Deck deck = Deck.getInstance();

		// Because we have to know we have created the deck on the right way in
		// game constructor
		assertTrue(deck.getSize() == game.getGameProvinces().size() + 6);
	}

	/*
	 * @Test public void testBonusUnitsLeft(){ //Check how many troops each
	 * player gets when the game begins assertTrue(game.getBonusUnitsLeft() ==
	 * 20 +
	 * (6-game.getPlayers().size())*5-game.getActivePlayer().getNrOfProvinces()
	 * ); assertTrue(game1.getBonusUnitsLeft() == 20 +
	 * (6-game1.getPlayers().size
	 * ())*5-game1.getActivePlayer().getNrOfProvinces() );
	 * assertTrue(game2.getBonusUnitsLeft() == 20 +
	 * (6-game2.getPlayers().size())
	 * *5-game2.getActivePlayer().getNrOfProvinces() );
	 * assertTrue(game3.getBonusUnitsLeft() == 20 +
	 * (6-game3.getPlayers().size())
	 * *5-game3.getActivePlayer().getNrOfProvinces() );
	 * assertTrue(game4.getBonusUnitsLeft() == 20 +
	 * (6-game4.getPlayers().size())
	 * *5-game4.getActivePlayer().getNrOfProvinces() ); }
	 */

	private int getProvinces() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void testChangePhase() {
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.FBuild);
		game4.handlePhaseEvent();

		// First we have to place out our bonusUnits.
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.FBuild);

		// We can just place units at the province that the active player owns.
		// Therefor
		//Game4 because the number of players are equal to the number of provinces
		IProvince myProvince = null;
		for(int i=0 ; i<game4.getPlayers().size() ; i++){
			for (IProvince mP : game4.getGameProvinces()) {
				if (game4.getActivePlayer().getId() == game4.getOwner(mP.getId())) {
					myProvince = mP;
				}
			}

			while ( game4.getBonusUnitsLeft()>0) {
				game4.handleProvinceEvent(myProvince);
			}
			
			assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.FBuild);
			game4.handlePhaseEvent();
		}
		
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.F1);
		
		// Have to place out bonus units first!
		game4.handlePhaseEvent();
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.F1);
		
		for (IProvince mP : game4.getGameProvinces()) {
			if (game4.getActivePlayer().getId() == game4.getOwner(mP.getId())) {
				myProvince = mP;
			}
		}

		while ( game4.getBonusUnitsLeft()>0) {
			game4.handleProvinceEvent(myProvince);
		}
		
		game4.handlePhaseEvent();
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.F2);
	
		game4.handlePhaseEvent();
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.F3);
		
		game4.handlePhaseEvent();
		assertTrue(game4.getCurrentPhase() == TurnAndPhaseManager.Phase.F1);


	}

	@Test
	public void testPlaceOutBounsUnits() {
		// Cannot test this if I dont know which diffrent provinces the players
		// have got.
	}

	/*
	 * Detta måste testas i Province?
	 * 
	 * 
	 * @Test public void testMoveUnits(){ IProvince prov1 = new
	 * Province("Mallorca"); IProvince prov2 = new Province("Budda");
	 * 
	 * prov1.addUnits(99); prov2.addUnits(13);
	 * assertTrue(prov1.getUnits()==100);
	 * 
	 * game.moveToProvince(3, prov1, prov2);
	 * //assertTrue(prov1.getUnits()==100-3);
	 * assertTrue(prov2.getUnits()==14+3);
	 * 
	 * for(int i = 0; i<10 ; i++){ game.moveToProvince(3, prov1, prov2);
	 * assertTrue(prov1.getUnits()==99-i*3);
	 * assertTrue(prov1.getUnits()==13+i*3); }
	 * 
	 * 
	 * }
	 */

}
