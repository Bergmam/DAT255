package se.chalmers.dat255.risk.model;

public class CardExanger {
	private ICard card1 = null;
	private ICard card2 = null;
	
	public CardExanger(){

	}
	
	public void makeExange(ICard card, Player currentPlayer){
		if (card2 != null) {
			currentPlayer.exchangeCard((Card) card1, (Card) card2,
					(Card) card);
			// GIVE BONUS - Prob best done in return type
			// Check if extra bonus from owned province cards - trouble trouble
			card1 = null;
			card2 = null;
		} else {
			if (card1 == null) {
				card1 = card;
			} else {
				card2 = card;
			}
		}
	}
}
