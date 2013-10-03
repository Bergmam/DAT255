package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Deck;
import se.chalmers.dat255.risk.model.ICard;

public class DeckTest {

	Deck deck;

	@Before
	public void beforeTests() {
		ArrayList<String> stringList1 = new ArrayList<String>();
		stringList1.add("Sweden");
		stringList1.add("'Merica");
		stringList1.add("Mocambique");
		stringList1.add("Germany");
		stringList1.add("Singapor");
		stringList1.add("L1");
		stringList1.add("L2");
		stringList1.add("L3");
		stringList1.add("L4");
		stringList1.add("L5");
		stringList1.add("L6");
		stringList1.add("L7");
		stringList1.add("L8");
		stringList1.add("L9");
		stringList1.add("L10");
		stringList1.add("Turkmänistan");

		deck = Deck.getInstance();
		deck.CreateCards(stringList1, 3);

	} 
	
	@Test 
	public void testNumberOfCardsInType(){
		// constructor test with deck1
		int jokers1 = 0;
		int artillery1 = 0;
		int cavalry1 = 0;
		int infantry1 = 0;
		LinkedList<ICard> deck1List = deck.getDeckList();

		for (int i = 0; i < deck.getSize(); i++) {
			assertTrue(deck1List.get(i) != null);
			if (deck1List.get(i).getType() == Card.CardType.JOKER) {
				System.out.println("Joker");
				jokers1++;
			}
			if (deck1List.get(i).getType() == Card.CardType.ARTILLERY) {
				System.out.println("artillery");
				artillery1++;
			}
			if (deck1List.get(i).getType() == Card.CardType.CAVALRY) {
				cavalry1++;
			}
			if (deck1List.get(i).getType() == Card.CardType.INFANTRY) {
				infantry1++;
			}
		}
		assertTrue(jokers1 == 3);
		assertTrue(artillery1 == 6);
		assertTrue(cavalry1 == 5);
		assertTrue(infantry1 == 5);
	}

	@Test
	public void testGiveCard() {
		int size = deck.getSize();
		deck.giveCard();
		deck.giveCard();
		deck.giveCard();
		assertTrue(deck.getSize() == size - 3);
	}

	@Test
	public void testDiscard() {
		int size = deck.getSize();
		ICard card1 = deck.giveCard();
		ICard card2 = deck.giveCard();
		ICard card3 = deck.giveCard();
		deck.discard(card1);
		deck.discard(card1);
		deck.discard(card1);

		assertTrue(deck.getSize() == size-3);
		assertTrue(deck.getDiscard().size() == 3);

	}

	@Test
	public void testRecycleCards() {
		int size = deck.getSize();
		int size1 = deck.getDiscard().size();
		deck.recycleCards();
		assertTrue(deck.getSize() == (size + size1));
		assertTrue(deck.getDiscard().size() == 0);
	}

}
