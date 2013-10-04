package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;
import org.junit.Test;

public class CardTest {
	ICard card1 = new Card(Card.CardType.ARTILLERY,"1");
	ICard card2 = new Card(Card.CardType.CAVALRY,"2"); 
	ICard card3 = new Card(Card.CardType.INFANTRY,"3");
	ICard card4 = new Card(Card.CardType.JOKER,"4");
	ICard card5 = new Card(Card.CardType.ARTILLERY,"5");

	@Test
	public void testCardType() {
		assertTrue(card1.getType()==Card.CardType.ARTILLERY);
		assertTrue(card2.getType()==Card.CardType.CAVALRY);
		assertTrue(card3.getType()==Card.CardType.INFANTRY);
		assertTrue(card4.getType()==Card.CardType.JOKER);
		
		
	}

	@Test
	public void testEqualsObject() {
		assertTrue(!card1.equals(card2));
		assertTrue(card1.equals(card5));
		assertTrue(!card2.equals(card3));
		assertTrue(!card4.equals(card5));
	}

}
