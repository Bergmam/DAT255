package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;
import org.junit.Test;

public class GameTest{
	String[] name = new String[]{"Linnea","Andreas","Emil,Bergman","Christoffer","Emma"};
	Game game = new Game (name);
	
	@Test
	public void testGameConstructor(){
		assertTrue(game.getActivePlayer().getName() == "Linnea");
	}
	
	@Test
	public void testChangeTurn(){
		for(int i = 1; i < 100 ; i++ ){
			game.changeTurn();
			assertTrue(name[(i)%(name.length)]==game.getActivePlayer().getName());
		}
	}
	
	/*@Test
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
