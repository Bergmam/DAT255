package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class CardExanger {
	private ICard card1 = null;
	private ICard card2 = null;
	
	public CardExanger(){

	}
	
	/**
	 * Checks if the player has clicked cards before. If this is the third card that is clicked
	 * 
	 * @param The last card clicked.
	 * @param The current player.
	 * @return
	 */
	public ArrayList<String> makeExange(ICard card, Player currentPlayer){
		if (card2 != null) {
			currentPlayer.exchangeCard((Card) card1, (Card) card2,
					(Card) card);
			ArrayList<String> cardProvinces = new ArrayList<String>();
			cardProvinces.add(card.getName());
			cardProvinces.add(card1.getName());
			cardProvinces.add(card2.getName());
			card1 = null;
			card2 = null;
			return cardProvinces;
			
		} else {
			if (card1 == null) {
				card1 = card;
			} else {
				card2 = card;
			}
			return null;
		}
	}
}
