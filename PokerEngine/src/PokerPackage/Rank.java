package PokerPackage;

import java.util.Comparator;

// Note to self, when trying to change values, remember that they ARE STORED IN SAME MEMORY LOCATION!!!!
public enum Rank implements Comparator<Rank>{
	TWO(2), THREE(3), FOUR(4), FIVE(5),
	SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
	JACK(11), QUEEN(12), KING(13), ACE(14);
	
	private int value;
	
	Rank(int value){
		setRank(value);
	}
	
	public void setRank(int value){
		this.value = value;
	}
	
	public int getRank(){
		return this.value;
	}
	
	// Implementing compare so that I can use TreeMap in Hand class to get the cards in ascending order by rank.
	// This will be useful for evaluating straights.
	public int compare(Rank r1, Rank r2){
		return Integer.compare(r1.getRank(), r2.getRank());
	}
	@Override
	public String toString(){
		return this.value + "";
	}
}
