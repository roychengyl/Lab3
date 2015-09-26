package PokerPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws DeckOutOfCardsException {
		try {
			playPoker();
		} catch (DeckOutOfCardsException e) {
			Scanner input = new Scanner(System.in);
			System.out.println("The deck is out of cards, would you like to add more?");
			String response = input.nextLine().toString();
			if (response.equals("yes") || response.equals("Yes")) {
				playPoker();
			}else {
				input.close();
				return;
			}
			
			input.close();
		}
	}

	public static void playPoker() throws DeckOutOfCardsException {
		Scanner input = new Scanner(System.in);

		System.out.println("How many decks do you want to have?");
		int numOfDecks = input.nextInt();
		Deck deck = new Deck(numOfDecks);
		
		System.out.println("How many players are there?");
		int numOfPlayers = input.nextInt();
		ArrayList<Hand> playerHands = new ArrayList<Hand>();
		for (int i = 0; i < numOfPlayers; i++){
			//Hand tempHand = new Hand(deck);
			playerHands.add( new Hand(deck));
		}
		
		input.close();
		
		printHands(playerHands);
		printWinner(playerHands);
	}
	
	public static void printHands(ArrayList<Hand> hands){
		for (int i = 0; i < hands.size(); i++) {
			System.out.println("Player " + (i + 1));
			System.out.println(hands.get(i));
			System.out.println(hands.get(i).getHandType());
			System.out.println("");
		}
	}
	
	public static void printWinner(ArrayList<Hand> hands){
		ArrayList<Integer> posOfBestHands = HandType.judgeHands(hands);
		if (posOfBestHands.size() == 1){
			System.out.println("Player " + (posOfBestHands.get(0) + 1) + " wins!");
		}
	}

}
