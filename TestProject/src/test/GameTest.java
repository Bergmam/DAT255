package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;
import org.junit.Test;

public class GameTest{
	String[] name = new String[]{"Linnea","Andreas","Emil","Bergman","Christoffer","Emma"};
	Game game = new Game (name);
	
	@Test
	public void testGameConstructor(){
		String[] name1 = new String[]{"Christoffer","Emma"};
		Game game1 = new Game (name1);
		String[] name2 = new String[]{"Andreas","Emil","Bergman"};
		Game game2 = new Game (name2);
		String[] name3 = new String[]{"Andreas","Emil","Bergman","Christoffer"};
		Game game3 = new Game (name3);
		String[] name4 = new String[]{"Andreas","Emil","Bergman","Christoffer","Emma"};
		Game game4 = new Game (name4);
		
		//Check if number of player is correct,
		//System.out.println("number of players: " +game1.getPlayer()[4].getName());
		assertTrue(game.getPlayer().length == 6);
		assertTrue(game1.getPlayer().length == 2);
		assertTrue(game2.getPlayer().length == 3);
		assertTrue(game3.getPlayer().length == 4);
		assertTrue(game4.getPlayer().length == 5);
		
		//Checks if the active player is correct
		assertTrue(game.getActivePlayer().getName() == "Linnea");
		
		
	
		//Check how many troops each player gets when the game begins 
		assertTrue(game.getBonusUnitsLeft() == 20 + (6-game.getPlayer().length)*5-game.getActivePlayer().getNrOfProvinces() );
		assertTrue(game1.getBonusUnitsLeft() == 20 + (6-game1.getPlayer().length)*5-game1.getActivePlayer().getNrOfProvinces() );
		assertTrue(game2.getBonusUnitsLeft() == 20 + (6-game2.getPlayer().length)*5-game2.getActivePlayer().getNrOfProvinces() );
		assertTrue(game3.getBonusUnitsLeft() == 20 + (6-game3.getPlayer().length)*5-game3.getActivePlayer().getNrOfProvinces() );
		assertTrue(game4.getBonusUnitsLeft() == 20 + (6-game4.getPlayer().length)*5-game4.getActivePlayer().getNrOfProvinces() );
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
