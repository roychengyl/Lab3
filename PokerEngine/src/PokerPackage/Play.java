package PokerPackage;

public class Play {

	public static void main(String[] args) {
		// testRank();
		testHand();
		//testDeck();

	}

	public static void testHand() {
		Card c1 = new Card(Rank.FIVE, Suit.CLUB);
		Card c2 = new Card(Rank.FIVE, Suit.HEART);
		Card c3 = new Card(Rank.FIVE, Suit.DIAMOND);
		Card c4 = new Card(Rank.TWO, Suit.CLUB);
		Card c5 = new Card(Rank.FIVE, Suit.HEART);
		Hand hand = new Hand(c1, c2, c3, c4, c5);
		hand.printHand();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		hand.printHandTypeVals();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(hand.getHandType());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(hand.getHighCard());
		// System.out.println(hand.determineHighCard());
	}

	public static void testDeck() {
			// Testing default constructor
			Deck deck = new Deck();
			deck.printDeck();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(deck.getSize());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			Hand hand = new Hand(deck);
			hand.printHand();
			System.out.println(hand.getSortedVals());
			System.out.println(hand.getSuitsInHand());
			System.out.println(deck.getSize());
			System.out.println(hand.getHighCard());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			Hand hand3 = new Hand(deck);
			hand3.printHand();
			System.out.println(hand3.getSortedVals());
			System.out.println(hand3.getSuitsInHand());
			System.out.println(hand3.getHighCard());
			System.out.println(deck.getSize());
			
			//System.out.println(deck.getSize());
			// Testing Deck(int)
			// Deck deck2 = new Deck(2);
			// deck2.printDeck();
	}

}
