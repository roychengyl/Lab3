package PokerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * TO TEST determine<INSERT CASE HERE> METHODS, CREATE TEST CONSTRUCTORS THAT WILL EXPLICITY CREATE A CERTAIN TYPE OF HAND, E.G. FLUSH, STRAIGHT ETC..
 * 
 * Some of the getters and setters are only here for testing purposes. They will be removed later.
 */

public class Hand {
	private Rank highCard;
	private boolean isStraight;
	private boolean isFlush;
	private int hasPairValue;
	@SuppressWarnings("unused")
	private HandType handType;
	private ArrayList<Card> hand = new ArrayList<Card>(5);
	// suitsInHand holds the suit type (Suit key), and the **FREQUENCY** of that
	// suit (Integer value)
	private Map<Suit, Integer> suitsInHand = new HashMap<Suit, Integer>();
	// sortedRankInHand holds the ranks (Key) (Ace, two, three...) and the
	// **FREQUENCY** (Integer value) of that rank.
	// sortedRankInHand is a TreeMap so that I can have the card ranks
	// sorted...which makes things easier down the road
	private Map<Rank, Integer> sortedRankInHand = new TreeMap<Rank, Integer>();

	// This should never be used explicitly
	private Hand() {
	};

	/*
	 * This is the constructor that should mainly be used. Since it is assumed
	 * that a new card from a deck will be drawn only when there is a COMPLETELY
	 * NEW hand being created, we do not need to worry about methods that will
	 * take cards one at a time. This is why the exception is propagated here.
	 */
	public Hand(Deck deck) {
		for (int i = 0; i < 5; i++) {
			try {
				Card tempCard = deck.getCard();
				this.hand.add(tempCard);

				// Lines 76-81 sets private data members
				determinePairs();
				determineStraight();
				determineFlush();
				determineHighCard();
				checkHand();
			} catch (Exception e) {
				System.out.println("Out offffff cards");
			}
		}
	}

	// Test constructor. USE THIS CONSTRUCTOR IF YOU WANT TO MAKE SURE PRIVATE
	// DATA MEMBERS ARE CORRECT
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		this.hand.add(c1);
		this.hand.add(c2);
		this.hand.add(c3);
		this.hand.add(c4);
		this.hand.add(c5);
		initSuitsAndSorted();

		determinePairs();
		determineStraight();
		determineFlush();
		determineHighCard();
		checkHand();
	}

	public Rank getHighCard() {
		return highCard;
	}

	public void setHighCard(Rank highCard) {
		this.highCard = highCard;
	}

	public boolean isFlush() {
		return isFlush;
	}

	public void setFlush(boolean isFlush) {
		this.isFlush = isFlush;
	}

	public int getHasPairValue() {
		return hasPairValue;
	}

	public void setHasPairValue(int hasPairValue) {
		this.hasPairValue = hasPairValue;
	}

	public HandType getHandType() {
		return handType;
	}

	public void setHandType(HandType handType) {
		this.handType = handType;
	}

	public void setStraight(boolean isStraight) {
		this.isStraight = isStraight;
	}

	public TreeMap getSortedVals() {
		return (TreeMap) this.sortedRankInHand;
	}

	public boolean getIsStraight() {
		return this.isStraight;
	}

	public Map getSuitsInHand() {
		return (Map) this.suitsInHand;
	}

	// Determine pairs
	// Tested
	public void determinePairs() {
		// Four of a kind
		if (this.sortedRankInHand.containsValue(4))
			this.hasPairValue = 5;
		// Full house
		else if (this.sortedRankInHand.containsValue(3) && this.sortedRankInHand.containsValue(2))
			this.hasPairValue = 4;
		// Three of a kind
		else if (this.sortedRankInHand.containsValue(3))
			this.hasPairValue = 3;
		// Two pairs
		else if (this.sortedRankInHand.containsValue(2) && this.sortedRankInHand.size() == 3)
			this.hasPairValue = 2;
		// One pair
		else if (this.sortedRankInHand.containsValue(2))
			this.hasPairValue = 1;
		// Shit out of luck
		else
			this.hasPairValue = 0;
	}

	// Determine straight
	// Tested
	public void determineStraight() {
		// Can't be a straight with less than five cards
		if (this.sortedRankInHand.size() != 5) {
			this.isStraight = false;
			return;
		} else {
			// Need to be able to compare the value at i and i + 1...hence the
			// array
			// Since sortedRankInHand is sorted by key ascending, the array will
			// already be sorted
			Object[] array = sortedRankInHand.keySet().toArray();
			// If you have something better to check for ACE and TWO, be my
			// guest
			if (array[0] == Rank.TWO && array[1] == Rank.THREE && array[2] == Rank.FOUR && array[3] == Rank.FIVE
					&& array[4] == Rank.ACE) {
				this.isStraight = true;
				return;
			}
			// The reason for the minus 1 is because there may be an
			// ArrayIndexOutOfBounds exception thrown if you go through entire
			// array.
			else {
				for (int i = 0; i < array.length - 1; i++) {
					Rank r1 = (Rank) array[i];
					Rank r2 = (Rank) array[i + 1];
					if (r2.getRank() - r1.getRank() != 1) {
						this.isStraight = false;
						return;
					} else {
						this.isStraight = true;
						return;
					}
				}
			}
		}
	}

	// Determine high card
	// Tested
	public void determineHighCard() {
		// As mentioned in the method directly above, the array of the
		// sortedRankInHand keys will already be sorted, i.e. the highest rank
		// is in the last position
		Rank r = (Rank) this.sortedRankInHand.keySet().toArray()[this.sortedRankInHand.size() - 1];
		this.highCard = r;
	}

	// Determine flush
	// Tested
	public void determineFlush() {
		if (this.suitsInHand.size() == 1)
			this.isFlush = true;
		else
			this.isFlush = false;
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

	public void checkHand() {
		/*
		 * This part actually determines what type of hand the player has. It
		 * may be the case that the player's hand qualifies as two HandType's,
		 * e.g. straight and flush... to account for this, the possibleHands
		 * array will hold all the possible types temporarily and the highest
		 * hand type out of the list will be obtained to set handType.
		 */
		// if ()
		ArrayList<HandType> possibleHands = new ArrayList<>();
		// Comparing cards in the players hand to all the types of hands
		for (HandType ht : HandType.values()) {
			if (this.isStraight == ht.getStraightValue() && this.isFlush == ht.getFlushValue()
					&& this.hasPairValue == ht.getPairValue()) {
				if (ht != HandType.ROYAL_FLUSH || ht != HandType.STRAIGHT_FLUSH)
					possibleHands.add(ht);
				else {
					if (this.highCard == Rank.ACE)
						possibleHands.add(HandType.ROYAL_FLUSH);
					else
						possibleHands.add(HandType.STRAIGHT_FLUSH);
				}
			}
		}
		int posOfBestHand = HandType.judgeHand(possibleHands);
		this.handType = possibleHands.get(posOfBestHand);
	}
}
