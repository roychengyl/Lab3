package PokerPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Moheem Ilyas
 * 
 *         Created: 9/19/2015 Last Modified: 9/25/2015 Description: This class
 *         defines what a normal deck of cards consist of. Assignment: Lab 2
 *
 */

public class Deck {
	private int deckSize = 52;
	private ArrayList<Card> deck;
	private int numOfDecks = 1;

	public Deck() {
		// Calls Deck(int) constructor with numOfDecks = 1;
		this(1, 0);
	}

	/*
	 * This is the primary constructor. It does not actually make the deck. It
	 * just serves to determine the size of the deck and make the ArrayList of
	 * type Card for the deck object.
	 */
	public Deck(int numOfDecks, int numOfJokers) {
		this.numOfDecks = numOfDecks;
		// This deck size is the number of cards in the deck
		this.deckSize = numOfDecks * 52;
		this.deck = new ArrayList<Card>(this.deckSize);
		makeDeck(this.numOfDecks, numOfJokers);

		Collections.shuffle(this.deck);
	}

	/*
	 * This method actually creates the deck. The nested for loop will always
	 * result in the creation of 52 cards... so we only need the deck size for
	 * the recursive call for multiple deck.
	 * 
	 */
	// http://thefamilypodcastnetwork.com/wp-content/uploads/2014/10/meme-sticker-likeaboss.jpg
	public void makeDeck(int numberOfDecks, int numOfJokers) {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				deck.add(new Card(r, s));
			}
		}
		if (numOfJokers > 0) {
			deck.add(new Card(Rank.JOKER));
			--numOfJokers;
		}
		numberOfDecks += -1;
		if (numberOfDecks == 0)
			return;
		// Recursion for multiple decks
		else
			makeDeck(numberOfDecks, numOfJokers);
	}

	public int getSize() {
		return deckSize;
	}

	/*
	 * This method gets the first card in the ArrayList of type Card (as well as
	 * removes it from the ArrayList this.deck).
	 */
	public Card getCard() throws DeckOutOfCardsException {
		if (this.deckSize > 0) {
			Card tempCard = (Card) this.deck.get(0);
			// removeCard();
			this.deck.remove(0);
			this.deckSize += -1;
			return tempCard;
		} else {
			throw new DeckOutOfCardsException();
		}

	}

	// Testing method
	public void printDeck() {
		for (Card c : this.deck) {
			System.out.println(c);
		}
	}

	// This method has not yet been incorporated for the rest of the code, but I
	// thought it could be useful for future error handling endeavors.
	public void addNewDeck(int numberOfDecks, int numOfJokers) {
		this.makeDeck(numberOfDecks, numOfJokers);
	}
}
