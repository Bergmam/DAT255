package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager;

public class GameTest{

	Game game;
	Game game1;
	Game game2;
	Game game3;
	Game game4;

	@Before
	public void beforeAllTest(){
		
		String provinces = "A-B-C-D-E" +"\n" + "B-A-C-E" +"\n" + "C-A-D" + "\n" + "D-A-C-E" + "\n" + "E-A-B-D";
		String continents = "3-A-B-C" +"\n" + "2-D-E";
		String[] name = new String[]{"Linnea","Andreas","Emil","Bergman","Christoffer","Emma"};
		game = new Game(name,provinces,continents);
		String[] name1 = new String[]{"Christoffer","Emma"};
		game1 = new Game (name1,provinces,continents);
		String[] name2 = new String[]{"Andreas","Emil","Bergman"};
		game2 = new Game (name2,provinces,continents);
		String[] name3 = new String[]{"Andreas","Emil","Bergman","Christoffer"};
		game3 = new Game (name3,provinces,continents);
		String[] name4 = new String[]{"Andreas","Emil","Bergman","Christoffer","Emma"};
		game4 = new Game (name4,provinces,continents);
	}

	@Test
	public void testActivePlayer(){	
		//Checks if the active player is correct
		assertTrue(game.getActivePlayer().getName() == "Linnea");
	}

	@Test
	public void testPlayerList(){
		//Check if number of player is correct,
		assertTrue(game.getPlayers().size() == 6);
		assertTrue(game1.getPlayers().size() == 2);
		assertTrue(game2.getPlayers().size() == 3);
		assertTrue(game3.getPlayers().size() == 4);
		assertTrue(game4.getPlayers().size() == 5);

	}
	
	@Test
	public void testBonusUnitsLeft(){

		//Check how many troops each player gets when the game begins 
		assertTrue(game.getBonusUnitsLeft() == 20 + (6-game.getPlayers().size())*5-game.getActivePlayer().getNrOfProvinces() );
		assertTrue(game1.getBonusUnitsLeft() == 20 + (6-game1.getPlayers().size())*5-game1.getActivePlayer().getNrOfProvinces() );
		assertTrue(game2.getBonusUnitsLeft() == 20 + (6-game2.getPlayers().size())*5-game2.getActivePlayer().getNrOfProvinces() );
		assertTrue(game3.getBonusUnitsLeft() == 20 + (6-game3.getPlayers().size())*5-game3.getActivePlayer().getNrOfProvinces() );
		assertTrue(game4.getBonusUnitsLeft() == 20 + (6-game4.getPlayers().size())*5-game4.getActivePlayer().getNrOfProvinces() );
	}

	@Test
	public void testChangePhase(){
		assertTrue(game.getCurrentPhase()==TurnAndPhaseManager.Phase.FBuild); 
		//Not implemented yet!
	}

	@Test
	public void testPlaceOutBounsUnits(){
		// Cannot test this if I dont know which diffrent provinces the players have got.
	}

	/*Detta måste testas i Province?
	 * 
	 * 
	 * @Test
	public void testMoveUnits(){
		IProvince prov1 = new Province("Mallorca");
		IProvince prov2 = new Province("Budda");

		prov1.addUnits(99);
		prov2.addUnits(13);
		assertTrue(prov1.getUnits()==100);

		game.moveToProvince(3, prov1, prov2);
		//assertTrue(prov1.getUnits()==100-3);
		assertTrue(prov2.getUnits()==14+3);

		for(int i = 0; i<10 ; i++){
			game.moveToProvince(3, prov1, prov2);
			assertTrue(prov1.getUnits()==99-i*3);
			assertTrue(prov1.getUnits()==13+i*3);
		}


	}*/

}
