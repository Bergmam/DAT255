package model;

public interface GameInterface {
	
	public void changePhase();
	
	public void changeTurn();
	
	public void attack(Province offensiv, Province defensive);
	
	public Player getActivePlayer();
	
	public void dealCard();
	
	public int calcBonus();
	
	public void placeUnits();
	

}
