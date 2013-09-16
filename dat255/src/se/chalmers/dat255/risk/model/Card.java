package se.chalmers.dat255.risk.model;

public class Card {

	public static enum CardType {INFANTRY, CAVALRY, ARTILLERY, JOKER}
	
	private String provinceName;
	private Card.CardType type;
	
	public Card(Card.CardType type, String name){
		if(type == CardType.JOKER){
			provinceName = "Joker";
		}else{
			provinceName = name;
		}
		this.type = type;	
	}
	
	public String getName(){
		return provinceName;
	}
	
	public Card.CardType getType(){
		return this.type;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(o instanceof Card){
			Card tmp = (Card) o;
			if(this.type == CardType.JOKER || tmp.type == CardType.JOKER){
				return true;
			}
			return this.type == tmp.type;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
