package test;

import java.util.ArrayList;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;
import se.chalmers.dat255.risk.model.Deck;
import se.chalmers.dat255.risk.model.Player;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testAddCard(){
		ArrayList<String> provinces = new ArrayList<String>();
		provinces.add("Hej");
		provinces.add("Hejhopp");
		provinces.add("Hejmamma");
		Player player = new Player(1, "Testare");
		player.addCard();
		assertTrue(player.getCards().size() == 1);
	}
	
	@Test
	public void testProvinces(){
		Player player = new Player(1, "Testare");
		player.gainProvince();
		player.gainProvince();
		player.gainProvince();
		player.loseProvince();
		player.loseProvince();
		assertTrue(player.getNrOfProvinces() == 1);
	}

}
