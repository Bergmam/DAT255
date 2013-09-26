package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import se.chalmers.dat255.risk.model.Deck;
import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.model.Player;


public class PlayerTest {

	@Test
	public void testAddCard(){
		ArrayList<String> provinces = new ArrayList<String>();
		provinces.add("Hej");
		provinces.add("Hejhopp");
		provinces.add("Hejmamma");
		Deck deck = Deck.getInstance(provinces, 3);
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
	
	@Test
	public void testExhangeCard(){
		ArrayList<String> provinces = new ArrayList<String>();
		provinces.add("Hej");
		provinces.add("Hejhopp");
		provinces.add("Hejmamma");
		Deck deck = Deck.getInstance(provinces, 2);
		Player player = new Player(1, "Testare");
		player.addCard();
		player.addCard();
		player.addCard();
		ICard card1 = player.getCards().get(2);
		ICard card2 = player.getCards().get(1);
		ICard card3 = player.getCards().get(0);
		assertTrue(player.exchangeCard(card1, card2, card3));
	}

}
