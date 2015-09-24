package PokerPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private int deckSize = 52;
	private ArrayList<Card> deck;
	private int numOfDecks = 1;

	public Deck() {
		// Calls Deck(int) constructor with numOfDecks = 1;
		this(1);
	}

	public Deck(int numOfDecks) {
		this.numOfDecks = numOfDecks;
		// This deck size is the number of cards in the deck
		this.deckSize = numOfDecks * 52;
		this.deck = new ArrayList<Card>(this.deckSize);
		makeDeck(this.numOfDecks);

		Collections.shuffle(this.deck);
	}

	// http://thefamilypodcastnetwork.com/wp-content/uploads/2014/10/meme-sticker-likeaboss.jpg
	public void makeDeck(int numberOfDecks) {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				deck.add(new Card(r, s));
			}
		}
		numberOfDecks += -1;
		if (numberOfDecks == 0)
			return;
		// Recursion for multiple decks
		else
			makeDeck(numberOfDecks);
	}

	public int getSize() {
		return deckSize;
	}

	public void removeCard() throws DeckOutOfCardsException {
		if (this.deckSize > 0) {
			this.deck.remove(0);
			this.deckSize += -1;
		} else {
			throw new DeckOutOfCardsException();
		}
	}

	// Throws and Exception in case there are no more cards.
	public Card getCard() throws DeckOutOfCardsException{
		if (this.deckSize > 0){
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

	// To make static or not to make static???
	public void addNewDeck(int numberOfDecks) {
		this.makeDeck(numberOfDecks);
	}
}
