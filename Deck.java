import java.util.*;

enum CardType{
	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13);
	
	int value;

	CardType(int v){
		value = v;
	}

	private static HashMap<Integer, CardType> cardTypeMap = new HashMap<Integer, CardType>();
	static {
	    for (CardType type : CardType.values()) {
	        cardTypeMap.put(type.value, type);
	    }
	    //System.out.println(cardTypeMap.toString());
	}

	public static CardType fromInt(int i) {
    	CardType type = cardTypeMap.get(Integer.valueOf(i));
	   	return type;
	}	
	
	public int getValue(){
		return value;
	}
}

enum Suit{
	SPADES(1),
	CLUBS(2),
	DIAMONDS(3),
	HEARTS(4);

	int value;

	Suit(int v){
		value = v;
	}

	private static HashMap<Integer, Suit> suitMap = new HashMap<Integer, Suit>();
	static {
	    for (Suit type : Suit.values()) {
	        suitMap.put(type.value, type);
	    }
	    //System.out.println(suitMap.toString());
	}

	public static Suit fromInt(int i) {
    	Suit suit = suitMap.get(Integer.valueOf(i));
	   	return suit;
	}	
	
	public int getValue(){
		return value;
	}
}

class Card{
	CardType type;
	Suit suit;

	Card(CardType t, Suit s){ 
		type = t; suit = s;
	}

	public CardType getType() {
		return type;
	}

	public Suit getSuit(){
		return suit;
	}

	public void swapCard(Card c){
		type = c.type;
		suit = c.suit;
	}
}


class PackOfCards{
	Card[] deck;
	
	PackOfCards(){
		//System.out.println("HERE");
		int suitLen = Suit.values().length;
		int cardTypeLen =CardType.values().length;
		deck = new Card[suitLen*cardTypeLen];
		for(int i = 0 ; i < suitLen ; ++i){
			for(int j = 0 ; j < cardTypeLen ; ++j){
				deck[i*cardTypeLen + j] = new Card(CardType.fromInt(j+1), Suit.fromInt(i+1));
			}
		}
	}

	public void print(){
		for(int i = 0 ; i < deck.length ; ++i){
			System.out.println(deck[i].getType() + " of " + deck[i].getSuit());
		}
	}

	public void shuffle(){
		int size = deck.length;
		for(int i = 0 ; i < size ; ++i){
			int shufflePos = i + (int)(Math.random()*(size-i));
			Card curr = deck[i];
			CardType currType = deck[i].getType();
			Suit currSuit = deck[i].getSuit();
			Card toShuffle = deck[shufflePos];
			deck[i].swapCard(toShuffle);
			deck[shufflePos].type = currType;
			deck[shufflePos].suit = currSuit;
			
		}
	} 
}

class Deck{
	public static void main(String[] args){
		PackOfCards pack = new PackOfCards();
		//pack.print();
		pack.shuffle();
		pack.print();
	}
}
