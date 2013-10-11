package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.BonusHandler;
import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;
import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.model.WorldMap;

public class BonusHandlerTest {
	ArrayList<Player> players = new ArrayList();
	int startingTroopNumber;
	String provinces = "A-B-C-D-E" + "\n" + "B-A-C-E" + "\n" + "C-A-D" + "\n"
			+ "D-A-C-E" + "\n" + "E-A-B-D";
	int continentBonus1 = 3;
	String continents = continentBonus1 + "-continent1-A" + "\n"
			+ "5-continent2-B-C-D-E";
	WorldMap worldMap;
	BonusHandler bH;
	int miniumBonus = 3;

	@Before
	public void beforeTest() {
		players.add(new Player(0, "Linnea"));
		players.add(new Player(1, "Andreas"));
		worldMap = new WorldMap(provinces, continents, players);
		bH = new BonusHandler(worldMap, players.size());
		startingTroopNumber = (50 - players.size() * 5);
	}

	@Test
	public void testBonusFromStart() {
		assertTrue(bH.getBonus() == 0);
		bH.calcBonusForF0(worldMap.getProvinces().size());
		assertTrue(bH.getBonus() == startingTroopNumber
				- worldMap.getProvinces().size());
	}

	@Test
	public void testCalcBonus() {
		int numberOfProvinces = players.get(0).getNrOfProvinces();
		int cBonusForPlayer1;
		// Because one continent just have got one province, we know that player
		// one or two has got one continent. And we also know that the other
		// player havent got any continent, because the other continent contains
		// 4 provinces.

		// Both has minimum bonus for provinces, because there is just 5
		// provinces now.
		bH.calcBonusUnits(players.get(0));
		System.out.println("player1 bonus = " + bH.getBonus());
		if (worldMap.getOwner("A") == players.get(0)) {
			System.out.println("in player1 has A "
					+ (continentBonus1 + miniumBonus) + " == " + bH.getBonus());
			cBonusForPlayer1 = continentBonus1;
			assertTrue(bH.getBonus() == continentBonus1 + miniumBonus);
			bH.calcBonusUnits(players.get(1));
			assertTrue(bH.getBonus() == miniumBonus);
		} else {
			System.out.println("in player2 has A");
			cBonusForPlayer1 = 0;
			assertTrue(bH.getBonus() == miniumBonus);
			bH.calcBonusUnits(players.get(1));
			assertTrue(bH.getBonus() == continentBonus1 + miniumBonus);
		}

		// We add some provinces to players.get(0) to see if the bonus
		// increments.
		while (players.get(0).getNrOfProvinces() < 11) {
			players.get(0).gainProvince();
			bH.calcBonusUnits(players.get(0));
			assertTrue(bH.getBonus() == miniumBonus + cBonusForPlayer1);
		}

		while (players.get(0).getNrOfProvinces() < 42) {
			players.get(0).gainProvince();
			bH.calcBonusUnits(players.get(0));
			assertTrue(bH.getBonus() == players.get(0).getNrOfProvinces() / 3
					+ cBonusForPlayer1);
		}
	}

	@Test
	public void testCalcBonusFromCards() {
		int currentCardBonus = 4;
		int bonusBefore = bH.getBonus();
		ArrayList<String> cards = new ArrayList<String>();
		ArrayList<String> cards1 = new ArrayList<String>();
		
		//No province has ID G, therefor we know that it will not give player bonus
		cards.add("G");
		
		bH.calcBonusesFromCards(cards1, players.get(0));
		assertTrue(bH.getBonus() == currentCardBonus + bonusBefore);
		currentCardBonus += 2;
		
		int playerHasCardProvinces = 0;
		
		if(players.get(0) == worldMap.getOwner("A")){
			playerHasCardProvinces++;
		} 
		if(players.get(0) == worldMap.getOwner("B")){
			playerHasCardProvinces++;
		} 
		if(players.get(0) == worldMap.getOwner("C")){
			playerHasCardProvinces++;
		} 
		cards.add("A");
		cards.add("B");
		cards.add("C");
		
		bH.calcBonusesFromCards(cards1, players.get(0));
		assertTrue(bH.getBonus() == currentCardBonus + bonusBefore + playerHasCardProvinces*2);
		
		
	}
}
