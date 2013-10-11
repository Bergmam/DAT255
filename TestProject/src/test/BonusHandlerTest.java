package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.BonusHandler;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.model.WorldMap;

public class BonusHandlerTest {
	ArrayList<Player> players = new ArrayList();
	String provinces = "A-B-C-D-E" + "\n" + "B-A-C-E" + "\n" + "C-A-D" + "\n"
			+ "D-A-C-E" + "\n" + "E-A-B-D";
	String continents = "3-continent1-A-B-C" + "\n" + "2-continent2-D-E";
	WorldMap worldMap;
	BonusHandler bH;
	
	@Before
	public void beforeTest() {
		players.add(new Player(0, "Linnea"));
		players.add(new Player(1, "Andreas"));
		worldMap = new WorldMap(provinces, continents, players);
		bH = new BonusHandler(worldMap, players.size());
	}
	
	@Test
	public void testBonusFromStart(){
		assertTrue(bH.getBonus()==0);
		bH.calcBonusForF0(worldMap.getProvinces().size());
		assertTrue(bH.getBonus() == (50 - players.size() * 5)-worldMap.getProvinces().size());
	}

}
