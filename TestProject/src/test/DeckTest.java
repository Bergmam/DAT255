package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.Deck;

import org.junit.Test;

public class DeckTest {
	
	Deck deck1;
	Deck deck2;
	Deck deck3;
	Deck deck4;
	
	@Test
	public void testDeck() {
		ArrayList<String> stringList1 = new ArrayList<String>();
		stringList1.add("Sweden");
		stringList1.add("'Merica");
		stringList1.add("Mocambique");
		
		
		ArrayList<String> stringList2 = (ArrayList<String>) stringList1.clone();
		stringList2.add("Germany");
		stringList2.add("Singapor");
		stringList2.add("L1");
		stringList2.add("L2");
		stringList2.add("L3");
		stringList2.add("L4");
		stringList2.add("L5");
		
		ArrayList<String> stringList3 = (ArrayList<String>) stringList2.clone();
		stringList3.add("L6");
		stringList3.add("L7");
		stringList3.add("L8");
		stringList3.add("L9");
		stringList3.add("L10");
		
		ArrayList<String> stringList4 = new ArrayList<String>();
		stringList4.add("Turkmänistan");
		
		deck1 = new Deck(stringList1, 3);
		deck2 = new Deck(stringList2, 0);
		deck3 = new Deck(stringList3, 5);
		deck4 = new Deck(stringList4, 3);
		
		//constructor test with deck1
		int jokers1 = 0;
		for(int i = 0; 1 < stringList1.size() + 3; i++){
			Card c = deck1.giveCard();
			assertTrue(c != null);
			if(c.getType() == Card.CardType.JOKER){
				jokers1++;
			}
		}
		assertTrue(jokers1 == 3);
		
		//constructor test with deck2
		int jokers2 = 0;
		for(int i = 0; 1 < stringList2.size() + 0; i++){
			Card c = deck2.giveCard();
			assertTrue(c != null);
			if(c.getType() == Card.CardType.JOKER){
				jokers2++;
			}
		}
		assertTrue(jokers2 == 0);

	}

	@Test
	public void testGiveCard() {
		int size = deck3.getSize();
		deck3.giveCard();
		assertTrue(deck3.getSize() == size-1);
	}

	@Test
	public void testDiscard() {
		deck4.discard(deck3.giveCard());
		assertTrue(deck4.getSize() == 2);
	}

	@Test
	public void testRecycleCards() {
		fail("Not yet implemented"); // TODO
	}

}
