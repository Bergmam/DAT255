package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.CardExanger;
import se.chalmers.dat255.risk.model.ICard;
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

		assertNull(cardExanger.makeExange(card2, player1));

		// makeExchange with one card two times should not do anything - return
		// null
		assertNull(cardExanger.makeExange(card1, player1));

		// Flush and restart
		cardExanger.flushCards();

		// Nothing should happen if you choose 3 cards, where 2 have the same
		// type and the other not. - return null
		assertNull(cardExanger.makeExange(card1, player1));
		assertNull(cardExanger.makeExange(card2, player1));
		assertNull(cardExanger.makeExange(card4, player1));

		cardExanger.flushCards();

		// If you choose 3 cards of the same type they should disapear from
		// players hand.
		
		
		assertNull(cardExanger.makeExange(card1, player1));
		assertNull(cardExanger.makeExange(card2, player1));
		assertTrue(card1.isActive());
		assertTrue(card2.isActive());
		assertNotNull(cardExanger.makeExange(card3, player1));
		

	}

	@Test
	public void testFlushCards() {
		cardExangerForFlushTest.makeExange(card1, player1);
		cardExangerForFlushTest.makeExange(card2, player1);
		cardExanger.flushCards();

	}

}
