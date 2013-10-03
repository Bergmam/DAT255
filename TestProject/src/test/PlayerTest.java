package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Deck;
import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.model.Player;

public class PlayerTest {
	Player player;
	ArrayList<String> provinces;
	Deck deck;

	@Before
	public void beforeTests() {
		player = new Player(1, "Testare");
		provinces = new ArrayList<String>();
		provinces.add("Hej");
		provinces.add("Hejhopp");
		provinces.add("Hejmamma");
		deck = Deck.getInstance();
		deck.CreateCards(provinces, 3);
	}

	@Test
	public void testAddCard() {
		Deck deck = Deck.getInstance();
		player.addCard();
		assertTrue(player.getCards().size() == 1);
	}

	@Test
	public void testProvinces() {
		player.gainProvince();
		player.gainProvince();
		player.gainProvince();
		player.loseProvince();
		player.loseProvince();
		assertTrue(player.getNrOfProvinces() == 1);
	}

	@Test
	public void testExhangeCard() {
		ICard card1 = new Card(Card.CardType.ARTILLERY, "a");
		ICard card2 = new Card(Card.CardType.ARTILLERY, "b");
		ICard card3 = new Card(Card.CardType.ARTILLERY, "c");

		ICard card4 = new Card(Card.CardType.CAVALRY, "d");
		ICard card5 = new Card(Card.CardType.CAVALRY, "e");
		ICard card6 = new Card(Card.CardType.JOKER, "f");

		ICard card7 = new Card(Card.CardType.INFANTRY, "g");
		ICard card8 = new Card(Card.CardType.INFANTRY, "h");
		ICard card9 = new Card(Card.CardType.INFANTRY, "e");

		ICard card10 = new Card(Card.CardType.JOKER, "ff");
		ICard card11 = new Card(Card.CardType.JOKER, "hg");
		ICard card12 = new Card(Card.CardType.ARTILLERY, "dd");

		assertTrue(player.exchangeCard(card1, card2, card3));
		assertTrue(player.exchangeCard(card4, card5, card6));
		assertTrue(!player.exchangeCard(card10, card11, card12));

	}

}
