package com.carddeck;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PrimaryTask3Test {

	@Test
	public void testStraightDetectedWhenThereIsOne() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		cards.add(Card.of(Rank.SIX, Suit.DIAMOND));
		cards.add(Card.of(Rank.SEVEN, Suit.CLUB));
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void testStraightStartingWithAceIsDetected() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		cards.add(Card.of(Rank.TWO, Suit.CLUB));
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void testStraightEndingWithAceIsDetected() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TWO, Suit.CLUB));
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void testStraightNotDetectedWhenThereIsNone() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TEN, Suit.DIAMOND));
		cards.add(Card.of(Rank.TWO, Suit.CLUB));
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.SEVEN, Suit.SPADE));
		cards.add(Card.of(Rank.EIGHT, Suit.HEART));
		
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.STRAIGHT, hand.getType());
	}

	@Test
	public void testStraightNotDetectedWhenThereIsThreeOfAKind() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TEN, Suit.DIAMOND));
		cards.add(Card.of(Rank.TWO, Suit.CLUB));
		cards.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards.add(Card.of(Rank.SEVEN, Suit.SPADE));
		cards.add(Card.of(Rank.SEVEN, Suit.HEART));
		
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void testStraightNotDetectedWhenStartingWithAceAndOtherCardsConsecutiveButNot2() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		cards.add(Card.of(Rank.SIX, Suit.CLUB));
		cards.add(Card.of(Rank.SEVEN, Suit.SPADE));
		cards.add(Card.of(Rank.EIGHT, Suit.HEART));
		
		Hand hand = Hand.buildHand(cards);
		assertNotSame(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void testStraightDetectedWithAceAndHighCard() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.TEN, Suit.HEART));
		cards.add(Card.of(Rank.JACK, Suit.CLUB));
		cards.add(Card.of(Rank.QUEEN, Suit.HEART));
		cards.add(Card.of(Rank.KING, Suit.SPADE));
		cards.add(Card.of(Rank.ACE, Suit.DIAMOND));
		
		Hand hand = Hand.buildHand(cards);
		assertEquals(HandType.STRAIGHT, hand.getType());
	}
}
