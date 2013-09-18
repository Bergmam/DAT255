package test;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;
import se.chalmers.dat255.risk.model.Player;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {

		Player p1 = new Player(1, "Sven");
		assertTrue(p1.getNrOfProvinces() == 0);
		Deck deck = Deck.getInstance();
		C1=new Card(CardType.INFANTRY, "Hedekas");
		C2=new Card(CardType.INFANTRY, "Hedekas");
		C3=new Card(CardType.INFANTRY, "Hedekas");		
		p1.addCard(c1);
		p1.addCard(c2);
		p1.addCard(c3);
		assertTrue(p1.exchangeCard(c1, c2, c3));
		
		
		fail("Not yet implemented");
	}

}
