package com.carddeck;

import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;
	
	public static Card of(Rank rank, Suit suit) {
		return new Card(rank, suit);
	}
	
	public String getName() {
		return rank.getName() + " " + suit.getName();
	}
	
	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final Card other = (Card) obj;
		return Objects.equals(this.rank, other.rank) &&
				Objects.equals(this.suit, other.suit);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
	
}
