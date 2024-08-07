package com.carddeck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class FlushTest {

	@Test
	public void testFlushDetected() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards.add(Card.of(Rank.SEVEN, Suit.SPADE));
		cards.add(Card.of(Rank.QUEEN, Suit.SPADE));
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.FLUSH, hand.getType());
	}

	@Test
	public void testFlushNotDetectedWhenThereIsNone() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards.add(Card.of(Rank.QUEEN, Suit.DIAMOND));
		cards.add(Card.of(Rank.TWO, Suit.SPADE));
		cards.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.FLUSH, hand.getType());
	}
}
