package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;

import org.junit.Test;

public class BattleHandlerTest {
	public BattleHandler bh = new BattleHandler();
	
	@Test
	public void testDoBattle(){
		
		int offensive = 3;
		int defensive = 2;
		int[] lost = bh.doBattle(offensive, defensive);
		assertTrue(lost[0]+lost[1] ==2);
		
		defensive--;
		lost = bh.doBattle(offensive, defensive);
		assertTrue(lost[0]+lost[1] == 1);
		
		
	}
	
}
