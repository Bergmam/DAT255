package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

public class TurnAndPhaaseManagerTest {
	TurnAndPhaseManager tAPM = new TurnAndPhaseManager();
	ArrayList<Player> players = new ArrayList<Player>();

	@Before
	public void beforeAllTest() {
		players.add(new Player(0, "nea"));
		players.add(new Player(1, "neaa"));
		players.add(new Player(2, "John"));

	}

	@Test
	public void testInitiate() {
		assertTrue(tAPM.getPhase() == Phase.FBuild);
		assertTrue(tAPM.getActivePlayer() == 0);
	}

	@Test
	public void testChangePhase() {
		// When Phase.build, it shouldnt change Phase until its the last player.
		// But it should change playerturn
		tAPM.changePhase(players.get(0), players);
		assertTrue(tAPM.getPhase() == Phase.FBuild);
		assertTrue(tAPM.getActivePlayer() == players.get(1).getId());

		tAPM.changePhase(players.get(1), players);
		assertTrue(tAPM.getPhase() == Phase.FBuild);
		assertTrue(tAPM.getActivePlayer() == players.get(2).getId());

		tAPM.changePhase(players.get(players.size() - 1), players);
		assertTrue(tAPM.getPhase() == Phase.F1);
		assertTrue(tAPM.getActivePlayer() == players.get(0).getId());

		// now we will change Phase like :
		// F1(player1)-F2(player1)-F3(player1)-F1(player2)-F2(player2)-F3(player2)....
		tAPM.changePhase(players.get(0), players);
		assertTrue(tAPM.getPhase() == Phase.F2);
		assertTrue(tAPM.getActivePlayer() == players.get(0).getId());

		tAPM.changePhase(players.get(0), players);
		assertTrue(tAPM.getPhase() == Phase.F3);
		assertTrue(tAPM.getActivePlayer() == players.get(0).getId());

		tAPM.changePhase(players.get(0), players);
		assertTrue(tAPM.getPhase() == Phase.F1);
		assertTrue(tAPM.getActivePlayer() == players.get(1).getId());

		tAPM.changePhase(players.get(1), players);
		assertTrue(tAPM.getPhase() == Phase.F2);
		assertTrue(tAPM.getActivePlayer() == players.get(1).getId());
	}

	@Test
	public void testSurrender() {
		// Surrender will change Phase to phase build if the players are in
		// phase build and its not the last player in players.
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.FBuild);
		
		tAPM.changePhase(players.get(0), players);
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.FBuild);
		
		//Now it always should be phase1
		tAPM.changePhase(players.get(1), players);
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.F1);
		
		tAPM.changePhase(players.get(1), players);
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.F1);
		
		tAPM.changePhase(players.get(1), players);
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.F1);
		
		tAPM.changePhase(players.get(2), players);
		tAPM.surrender(players);
		assertTrue(tAPM.getPhase()==Phase.F1);
		
	}

}
