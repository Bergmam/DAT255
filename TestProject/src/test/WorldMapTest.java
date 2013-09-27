package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.WorldMap;

public class WorldMapTest {
String[] names = {"Linnea","Andreas","Erik","Filip"};
Game game = new Game(names);
WorldMap worldMap = new WorldMap(new File("neighbours.txt"),new File("continents.txt"),game.getPlayer());
	
	@Test
	public void testConstructor(){
		// This I took from the file
		System.out.println("number of provinces = " + worldMap.getProvinces().size());
		assertTrue(worldMap.getProvinces().size() == 42);
	}
	
}
