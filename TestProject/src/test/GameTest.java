package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;
import org.junit.Test;
import se.chalmers.dat255.risk.model.*;

public class GameTest{
	//private Game game = new Game(null);
	
	@Test
	public void testGameConstructor(){
		String[] name = new String[]{"Linnea","Andreas","Emil,Bergman","Christoffer","Emma"};
		Game game1 = new Game (name);
		assertTrue(game1.getActivePlayer().getName() == "Linnea");
	}
}
