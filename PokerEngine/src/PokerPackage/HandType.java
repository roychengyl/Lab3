package PokerPackage;

import java.util.ArrayList;

/*
 * I was at one point considering making this into a class, but in actuallity, the types of hands are constants, 
 * and the code turned out to be rather straight forward when having HandType as an enum, but I could be wrong.
 */
public enum HandType {
	// This first parameter is rankValue, second is pairValue, third is
	// straight, fourth is flush
	NO_PAIR(0, 0, false, false), ONE_PAIR(1, 1, false, false), TWO_PAIR(2, 2, false, false), THREE_OF_A_KIND(3, 3,
			false, false), STRAIGHT(4, 0, true, false), FLUSH(5, 0, false, true), FULL_HOUSE(6, 4, false,
					false), FOUR_OF_A_KIND(7, 5, false, false), STRAIGHT_FLUSH(8, 0, true, true), ROYAL_FLUSH(9, 0,
							true, true);

	private int rankValue;
	private int pairValue;
	private boolean straight;
	private boolean flush;

	HandType(int rankValue, int pairValue, boolean straight, boolean flush) {
		this.rankValue = rankValue;
		this.pairValue = pairValue;
		this.straight = straight;
		this.flush = flush;
	}

	public boolean getStraightValue() {
		return this.straight;
	}

	public boolean getFlushValue() {
		return this.flush;
	}

	public int getPairValue() {
		return this.pairValue;
	}

	// The return is an int because the position in the array of the highest
	// hand type will be returned
	// judgeHand can be used for judging the players hand AND judging the hands
	// of multiple players
	public static int judgeHand(ArrayList<HandType> handTypeArray) {
		int pos = 0;
		if (handTypeArray.contains(HandType.ROYAL_FLUSH)) pos = handTypeArray.indexOf(HandType.ROYAL_FLUSH);
		else {
			HandType tempHandType = handTypeArray.get(0);
			for (int i = 0; i < handTypeArray.size(); i++) {
				if (compare(handTypeArray.get(i), tempHandType) == 1) {
					tempHandType = handTypeArray.get(i);
					pos = i;
				}
			}
		}
		return pos;
	}

	public static int compare(HandType h1, HandType h2) {
		return Integer.compare(h1.rankValue, h2.rankValue);
	}
}
