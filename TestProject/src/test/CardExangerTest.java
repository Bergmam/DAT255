package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.CardExanger;
import se.chalmers.dat255.risk.model.Player;

public class CardExangerTest {
	Player player1;
	CardExanger cardExanger = new CardExanger();
	CardExanger cardExangerForFlushTest = new CardExanger();

	Card card1 = new Card(Card.CardType.INFANTRY, "aProvince");
	Card card2 = new Card(Card.CardType.INFANTRY, "bProvince");
	Card card3 = new Card(Card.CardType.INFANTRY, "cProvince");
	Card card4 = new Card(Card.CardType.CAVALRY, "dProvince");
	Card card5 = new Card(Card.CardType.JOKER, "eProvince");
	Card card6 = new Card(Card.CardType.ARTILLERY, "fProvince");
	Card card7 = new Card(Card.CardType.JOKER, "eProvince");

	@Before
	public void beforeAllTest() {
		player1 = new Player(0, "Adolf");
		ArrayList cards = player1.getCards();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		cards.add(card6);
		

	}

	@Test
	public void testMakeExange() {

		// makeExchange with one/two card should not do anything. -return null
		assertNull(cardExanger.makeExange(card1, player1));
		assertTrue(card1.isActive());

		assertNull(cardExanger.makeExange(card2, player1));
		assertTrue(card2.isActive());

		// makeExchange with one card two times should inactivate card and return
		// null, 
		assertNull(cardExanger.makeExange(card1, player1));
		assertFalse(card1.isActive());

		// Flush and restart
		cardExanger.flushCards();

		// Nothing should happen if you choose 3 cards, where 2 have the same
		// type and the other another. - return null
		assertNull(cardExanger.makeExange(card1, player1));
		assertNull(cardExanger.makeExange(card2, player1));
		assertNull(cardExanger.makeExange(card4, player1));

		cardExanger.flushCards();

		// If you choose 3 cards of the same type they should do something - return ArrayList<Cards>
		assertNull(cardExanger.makeExange(card1, player1));
		assertNull(cardExanger.makeExange(card2, player1));
		assertTrue(card1.isActive());
		assertTrue(card2.isActive());
		assertNotNull(cardExanger.makeExange(card3, player1));
		
		cardExanger.flushCards();

		//If you choose one card of each cardType(or 1 Joker and two other cards), they should do something - return ArrayList<Cards>
		assertNull(cardExanger.makeExange(card4, player1));
		assertNull(cardExanger.makeExange(card5, player1));
		assertTrue(card5.isActive());
		assertTrue(card4.isActive());
		assertNotNull(cardExanger.makeExange(card6, player1));
		
		player1 = new Player(0, "Adolf");
		ArrayList cards = player1.getCards();
		cards.add(card1);
		cards.add(card5);
		cards.add(card7);
		
		//You cant echange 2 Jokers in one round.
		assertNull(cardExanger.makeExange(card1, player1));
		assertNull(cardExanger.makeExange(card5, player1));
		assertTrue(card1.isActive());
		assertTrue(card5.isActive());
		assertNull(cardExanger.makeExange(card7, player1));
		
		// If you try to exchange 3 cards the cards will be inactivated.
		assertFalse(card1.isActive());
		assertFalse(card5.isActive());
		assertFalse(card7.isActive());
	}

	@Test
	public void testFlushCards() {
		//First we activate 2 cards, then we will test if they are active after flushCards. We also check if we can make exchange with a third card.
		cardExangerForFlushTest.makeExange(card1, player1);
		assertTrue(card1.isActive());
		cardExangerForFlushTest.makeExange(card2, player1);
		assertTrue(card2.isActive());
		
		cardExangerForFlushTest.flushCards();
		
		assertFalse(card1.isActive());
		assertFalse(card2.isActive());
		assertNull(cardExangerForFlushTest.makeExange(card3, player1));
	}

}
