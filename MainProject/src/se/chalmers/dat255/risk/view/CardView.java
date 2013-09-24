package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Card;


public class CardView extends AbstractView {

	private Card card;
	
	public CardView(Card card) {
		this.card = card;
	}
	
	public Card getCard(){
		return card;
	}

}
