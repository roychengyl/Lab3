package PokerPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Play {
	
	public static void main(String[] args) {
		/*Scanner input = new Scanner(System.in);
		String response;
		System.out.println("Would you like to play a little game");
		response = input.nextLine().toString();
		//System.out.println(response);
		if (response.equals("yes") || response.equals("Yes")){
			ArrayList<Hand> hands = new ArrayList<Hand>();
			
			System.out.println("How many players do you have? ");
			int numberOfPlayers = input.nextInt();
			// We should actually make a check here to validate that the user has enough cards based on the number of players
			System.out.println("How many decks would you like to have (the minimum amount is 1");
			int numberOfDecks = input.nextInt();
			Deck deck = new Deck(numberOfDecks);
			try{
				for (int i = 0; i < numberOfPlayers; i++){
					Hand tempHand = new Hand(deck);
					hands.add(tempHand);
				}
				for(Hand h :  hands){
					h.printHand();
					System.out.println("");
				}
			} catch (DeckOutOfCardsException e){
				
			}
			
			
		}*/
		
		// testRank();
		//testHand();
		testDeck();

	}

	public static void testHand() {
		Card c10 = new Card(Rank.TEN, Suit.HEART);
		Card c20 = new Card(Rank.THREE, Suit.DIAMOND);
		Card c30 = new Card(Rank.THREE, Suit.SPADE);
		Card c40 = new Card(Rank.THREE, Suit.HEART);
		Card c50 = new Card(Rank.TEN, Suit.SPADE);
		Hand hand = new Hand(c10, c20, c30, c40, c50);
		hand.printHand();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		hand.printHandTypeVals();
		//System.out.println(hand.getHandType().getkickerRankValue());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(hand.getHandType());
		System.out.println(hand.getKickerPossibilities());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Card c1 = new Card(Rank.THREE, Suit.CLUB);
		Card c2 = new Card(Rank.FIVE, Suit.HEART);
		Card c3 = new Card(Rank.FOUR, Suit.DIAMOND);
		Card c4 = new Card(Rank.SEVEN, Suit.CLUB);
		Card c5 = new Card(Rank.SIX, Suit.SPADE);
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		hand2.printHand();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		hand2.printHandTypeVals();
		//System.out.println(hand2.getHandType().getkickerRankValue());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(hand2.getHandType());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Card c11 = new Card(Rank.NINE, Suit.CLUB);
		Card c21 = new Card(Rank.THREE, Suit.HEART);
		Card c31 = new Card(Rank.THREE, Suit.SPADE);
		Card c41 = new Card(Rank.NINE, Suit.HEART);
		Card c51 = new Card(Rank.NINE, Suit.DIAMOND);
		Hand hand3 = new Hand(c11, c21, c31, c41, c51);
		hand3.printHand();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		hand3.printHandTypeVals();
		//System.out.println(hand2.getHandType().getkickerRankValue());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(hand3.getHandType());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<Hand> hands = new ArrayList<Hand>();
		hands.add(hand);
		hands.add(hand3);
		hands.add(hand2);
		ArrayList<Integer> posOfBestHands = HandType.judgeHands(hands);
		System.out.println(posOfBestHands);
		//System.out.println(hands.get(posOfBestHands.get(0)));
		//for (Integer i : posOfBestHands){
			//System.out.println(hands.get(i).getSortedVals());
		//}
		// System.out.println(hand.determineHighCard())
	}

	public static void testDeck() {
			// Testing default constructor
			Deck deck = new Deck();
			deck.printDeck();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(deck.getSize());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Hand hand = new Hand(deck);
				hand.printHand();
				System.out.println(hand.getSortedVals());
				System.out.println(hand.getSuitsInHand());
				System.out.println(hand.getHandType());
				System.out.println(deck.getSize());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println(hand.getKickerPossibilities());
				//Hand hand3 = new Hand(deck);
				//hand3.printHand();
				//System.out.println(hand3.getSortedVals());
				//System.out.println(hand3.getSuitsInHand());
				//System.out.println(deck.getSize());
				//Hand hand12 = new Hand(deck);
				//Hand hand13 = new Hand(deck);
				//Hand hand14 = new Hand(deck);
			} catch (DeckOutOfCardsException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			//System.out.println(deck.getSize());
			// Testing Deck(int)
			// Deck deck2 = new Deck(2);
			// deck2.printDeck();
	}

}
