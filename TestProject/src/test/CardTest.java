package test;

import static org.junit.Assert.*;
import se.chalmers.dat255.risk.model.*;
import org.junit.Test;

public class CardTest {
	ICard card1;
	ICard card2;
	ICard card3;
	ICard card4;
	ICard card5;

	@Test
	public void testCard() {
		card1 = new Card(Card.CardType.ARTILLERY,"1"); 
		assertTrue(card1.getType()==Card.CardType.ARTILLERY);
		card2 = new Card(Card.CardType.CAVALRY,"2"); 
		assertTrue(card2.getType()==Card.CardType.CAVALRY);
		card3 = new Card(Card.CardType.INFANTRY,"3"); 
		assertTrue(card3.getType()==Card.CardType.INFANTRY);
		card4 = new Card(Card.CardType.JOKER,"4"); 
		assertTrue(card4.getType()==Card.CardType.JOKER);
		card5 = new Card(Card.CardType.ARTILLERY,"5");
		
	}

	@Test
	public void testEqualsObject() {
	}

}
