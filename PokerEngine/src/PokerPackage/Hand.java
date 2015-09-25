package PokerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * TO TEST determine<INSERT CASE HERE> METHODS, CREATE TEST CONSTRUCTORS THAT WILL EXPLICITY CREATE A CERTAIN TYPE OF HAND, E.G. FLUSH, STRAIGHT ETC..
 * 
 */

public class Hand{
	//private boolean isStraight;
	//private boolean isFlush;
	//private int hasPairValue;
	private HandType handType;
	//private Rank highCardRank;
	private ArrayList<Card> hand = new ArrayList<Card>(5);
	// suitsInHand holds the suit type (Suit key), and the **FREQUENCY** of that
	// suit (Integer value)
	private Map<Suit, Integer> suitsInHand = new HashMap<Suit, Integer>();
	// sortedRankInHand holds the ranks (Key) (Ace, two, three...) and the
	// **FREQUENCY** (Integer value) of that rank.
	// sortedRankInHand is a TreeMap so that I can have the card ranks
	// sorted...which makes things easier down the road
	private TreeMap<Rank, Integer> sortedRankInHand = new TreeMap<Rank, Integer>();
	
	// Have ALL the possible kickers in one container. The kickers in the container will be determined by what type of hand you have
	// The reason why kickerPossibilities is in this class instead of HandType (so it could be like, flush + kickerPossibilities) is 
	// 	because I wanted to use the HandType of the Hand to determine how I should take my kickers.
	private List<Rank> kickerPossibilities = new ArrayList<Rank>();

	// This should never be used explicitly
	@SuppressWarnings("unused")
	private Hand() {
	};

	/*
	 * This is the constructor that should mainly be used. Since it is assumed
	 * that a new card from a deck will be drawn only when there is a COMPLETELY
	 * NEW hand being created, we do not need to worry about methods that will
	 * take cards one at a time. This is why the exception is propagated here.
	 */
	public Hand(Deck deck) throws DeckOutOfCardsException {
		try {
			for (int i = 0; i < 5; i++) {

				Card tempCard = deck.getCard();
				this.hand.add(tempCard);
			}
			this.initSuitsAndSorted();

			HandType.checkHand(this);
		
		} catch (DeckOutOfCardsException e) {
			throw new DeckOutOfCardsException();
		}
	}

	// Test constructor
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		this.hand.add(c1);
		this.hand.add(c2);
		this.hand.add(c3);
		this.hand.add(c4);
		this.hand.add(c5);
		initSuitsAndSorted();

		HandType.checkHand(this);
	}

	public HandType getHandType() {
		return handType;
	}

	public void setHandType(HandType handType) {
		this.handType = handType;
	}

	public TreeMap<Rank, Integer> getSortedVals() {
		return this.sortedRankInHand;
	}

	public Map<Suit, Integer> getSuitsInHand() {
		return this.suitsInHand;
	}
	
	public List<Rank> getKickerPossibilities(){
		return this.kickerPossibilities;
	}

	public void setKickerPossibilities(List<Rank> kickers){
		this.kickerPossibilities = kickers;
	}

	// Testing method
	public void printHand() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.hand.get(i));
		}
	}

	// Testing method
	public void printHandTypeVals() {
		System.out.println(this.suitsInHand);
		System.out.println(this.sortedRankInHand);
	}

	// Initializes suitsInHand and sortedRankInHand
	public void initSuitsAndSorted() {
		for (Card c : this.hand) {
			if (suitsInHand.containsKey(c.getSuit())) {
				int curVal = suitsInHand.get(c.getSuit());
				curVal += 1;
				suitsInHand.put(c.getSuit(), curVal);
			} else
				suitsInHand.put(c.getSuit(), 1);
			if (sortedRankInHand.containsKey(c.getRank())) {
				int curVal = sortedRankInHand.get(c.getRank());
				curVal += 1;
				sortedRankInHand.put(c.getRank(), curVal);
			} else
				sortedRankInHand.put(c.getRank(), 1);
		}
	}
}
