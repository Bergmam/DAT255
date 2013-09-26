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
		String[] name2 = new String[]{"Andreas","Emil","Bergman","Christoffer","Emma"};
		Game game2 = new Game (name2);
		
		//Check if number of player is correct,
		//System.out.println("number of players: " +game1.getPlayer()[4].getName());
		assertTrue(game.getPlayer().length == 6);
		assertTrue(game1.getPlayer().length == 2);
		assertTrue(game2.getPlayer().length == 5);
		
		//Checks if the active player is correct
		assertTrue(game.getActivePlayer().getName() == "Linnea");
		
		//Check how many troops each player gets when the game begins 
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
