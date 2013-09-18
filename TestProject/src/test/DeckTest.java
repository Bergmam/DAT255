package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import se.chalmers.dat255.risk.model.*;

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
		int artillery1 = 0;
		int cavalry1 = 0;
		int infantry1 = 0;
		LinkedList<Card> deck1List = deck1.getDeckList();
		for(int i = 0; i < deck1.getSize(); i++){
			assertTrue(deck1List.get(i) != null);
			if(deck1List.get(i).getType() == Card.CardType.JOKER){
				jokers1++;
			}
			if(deck1List.get(i).getType() == Card.CardType.ARTILLERY){
				artillery1++;
			}
			if(deck1List.get(i).getType() == Card.CardType.CAVALRY){
				cavalry1++;
			}
			if(deck1List.get(i).getType() == Card.CardType.INFANTRY){
				infantry1++;
			}
		}
		assertTrue(jokers1 == 3);
		assertTrue(artillery1 == 1);
		assertTrue(cavalry1 == 1);
		assertTrue(infantry1 == 1);
		
		
		//constructor test with deck2
		int jokers2 = 0;
		int artillery2 = 0;
		int cavalry2 = 0;
		int infantry2 = 0;
		LinkedList<Card> deck2List = deck1.getDeckList();
		for(int i = 0; i < deck2.getSize(); i++){
			assertTrue(deck2List.get(i) != null);
			if(deck2List.get(i).getType() == Card.CardType.JOKER){
				jokers2++;
			}
			if(deck2List.get(i).getType() == Card.CardType.ARTILLERY){
				artillery2++;
			}
			if(deck2List.get(i).getType() == Card.CardType.CAVALRY){
				cavalry2++;
			}
			if(deck2List.get(i).getType() == Card.CardType.INFANTRY){
				infantry2++;
			}
		}
		assertTrue(jokers2 == 0);
		assertTrue(artillery2 == 4);
		assertTrue(cavalry2 == 3);
		assertTrue(infantry2 == 3);

	}

	@Test
	public void testGiveCard() {
		int size = deck3.getSize();
		deck3.giveCard();
		deck3.giveCard();
		deck3.giveCard();
		assertTrue(deck3.getSize() == size-3);
	}

	@Test
	public void testDiscard() {
		Card card1 = deck2.giveCard();
		Card card2 = deck2.giveCard();
		Card card3 = deck2.giveCard();
		deck2.discard(card1);
		deck2.discard(card1);
		deck2.discard(card1);
		
		assertTrue(deck2.getSize() == 7);
		assertTrue(deck2.getDiscard().size() == 3);
		
	}

	@Test
	public void testRecycleCards() {
		deck2.recycleCards();
		assertTrue(deck2.getSize() == 10);
		assertTrue(deck2.getDiscard().size() == 0);
	}

}
