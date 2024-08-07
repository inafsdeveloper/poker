package com.carddeck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandBuilderTest {

	@Test
	public void testHandAcceptsDifferentCards() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		cards.add(Card.of(Rank.EIGHT, Suit.SPADE));
		cards.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand.buildHand(cards);
	}
	
	@Test
	public void testHandRejectsDuplicateCards() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		cards.add(Card.of(Rank.EIGHT, Suit.HEART));
		cards.add(Card.of(Rank.EIGHT, Suit.HEART));
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.THREE, Suit.SPADE));
		try{
			Hand.buildHand(cards);
		}catch(Hand.DuplicateCardException e) {
			e.printStackTrace();
		}
	}
	

}
