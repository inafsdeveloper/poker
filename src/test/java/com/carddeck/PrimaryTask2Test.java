package com.carddeck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PrimaryTask2Test {

	@Test
	public void testFullHouseDetectedWhenThereIsOne() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.TWO, Suit.HEART));
		cards.add(Card.of(Rank.EIGHT, Suit.SPADE));
		cards.add(Card.of(Rank.EIGHT, Suit.HEART));
		cards.add(Card.of(Rank.EIGHT, Suit.DIAMOND));
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.FULL_HOUSE, hand.getType());
	}
	
	@Test
	public void testFullHouseNotDetectedWhenThereIsNone() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.TWO, Suit.HEART));
		cards.add(Card.of(Rank.EIGHT, Suit.SPADE));
		cards.add(Card.of(Rank.NINE, Suit.HEART));
		cards.add(Card.of(Rank.TEN, Suit.DIAMOND));
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.FULL_HOUSE, hand.getType());
	}
	
	@Test
	public void testFullHouseNotDetectedWhenThereIsTwoPair() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.TWO, Suit.HEART));
		cards.add(Card.of(Rank.EIGHT, Suit.SPADE));
		cards.add(Card.of(Rank.NINE, Suit.HEART));
		cards.add(Card.of(Rank.NINE, Suit.DIAMOND));
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.FULL_HOUSE, hand.getType());
	}

}
