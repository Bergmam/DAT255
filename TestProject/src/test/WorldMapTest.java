package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.model.WorldMap;

public class WorldMapTest {

Player[] players = new Player[]{new Player(1,"Linnea"),new Player(2,"Andreas")};
String provinces = "A-B-C-D-E" +"\n" + "B-A-C-E" +"\n" + "C-A-D" + "\n" + "D-A-C-E" + "\n" + "E-A-B-D";
String continents = "3-A-B-C" +"\n" + "2-D-E";
WorldMap worldMap = new WorldMap(provinces,continents,players);

	@Test
	public void testConstructor(){
		// This I took from the file
		System.out.println("number of provinces = " + worldMap.getProvinces().size());
		assertTrue(worldMap.getProvinces().size() == 5);
	}
	
}
