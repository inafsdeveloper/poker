package com.carddeck;

import com.carddeck.comparators.HighCardComparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimaryTask4Test {

	Comparator<Hand> _comparator = new HighCardComparator();
	
	@Test
	public void testHighCardComparison() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		cards.add(Card.of(Rank.SIX, Suit.DIAMOND));
		cards.add(Card.of(Rank.SEVEN, Suit.CLUB));
		Hand highCardHand1 = Hand.buildHand(cards);
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(Card.of(Rank.QUEEN, Suit.HEART));
		cards2.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards2.add(Card.of(Rank.FIVE, Suit.HEART));
		cards2.add(Card.of(Rank.SIX, Suit.DIAMOND));
		cards2.add(Card.of(Rank.SEVEN, Suit.CLUB));
		Hand highCardHand2 = Hand.buildHand(cards2);
		
		assertTrue(_comparator.compare(highCardHand1, highCardHand2) < 0);
	}
	
	@Test
	public void testTieBetweenIdenticalHighCardHands() {
		List<Card> cards = new ArrayList<>();
		cards.add(Card.of(Rank.THREE, Suit.HEART));
		cards.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards.add(Card.of(Rank.FIVE, Suit.HEART));
		cards.add(Card.of(Rank.SIX, Suit.DIAMOND));
		cards.add(Card.of(Rank.SEVEN, Suit.CLUB));
		Hand highCardHand1 = Hand.buildHand(cards);
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(Card.of(Rank.THREE, Suit.HEART));
		cards2.add(Card.of(Rank.FOUR, Suit.SPADE));
		cards2.add(Card.of(Rank.FIVE, Suit.HEART));
		cards2.add(Card.of(Rank.SIX, Suit.DIAMOND));
		cards2.add(Card.of(Rank.SEVEN, Suit.CLUB));
		Hand highCardHand2 = Hand.buildHand(cards2);
		
		assertEquals(0,_comparator.compare(highCardHand1, highCardHand2));
	}
	
	@Test
	public void testHighCardComparisonTreatsAceHigh() {
		List<Card> cards1 = new ArrayList<>();
		cards1.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards1.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards1.add(Card.of(Rank.JACK, Suit.DIAMOND));
		cards1.add(Card.of(Rank.TWO, Suit.SPADE));
		cards1.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand1 = Hand.buildHand(cards1);
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(Card.of(Rank.ACE, Suit.DIAMOND));
		cards2.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards2.add(Card.of(Rank.SEVEN, Suit.DIAMOND));
		cards2.add(Card.of(Rank.TWO, Suit.SPADE));
		cards2.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand2 = Hand.buildHand(cards2);
		
		assertTrue(_comparator.compare(highCardHand1, highCardHand2) < 0);
	}
	
	@Test
	public void testHighCardComparisonWhereHighCardsHaveSameRank() {
		List<Card> cards1 = new ArrayList<>();
		cards1.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards1.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards1.add(Card.of(Rank.QUEEN, Suit.DIAMOND));
		cards1.add(Card.of(Rank.TWO, Suit.SPADE));
		cards1.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand1 = Hand.buildHand(cards1);
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(Card.of(Rank.QUEEN, Suit.DIAMOND));
		cards2.add(Card.of(Rank.TEN, Suit.SPADE));
		cards2.add(Card.of(Rank.FOUR, Suit.HEART));
		cards2.add(Card.of(Rank.TWO, Suit.SPADE));
		cards2.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand2 = Hand.buildHand(cards2);
		
		assertTrue(_comparator.compare(highCardHand1, highCardHand2) < 0);
	}
	
	@Test
	public void testHighCardComparisonWhereHighThreeCardsHaveSameRank() {
		List<Card> cards1 = new ArrayList<>();
		cards1.add(Card.of(Rank.FIVE, Suit.SPADE));
		cards1.add(Card.of(Rank.SEVEN, Suit.HEART));
		cards1.add(Card.of(Rank.QUEEN, Suit.DIAMOND));
		cards1.add(Card.of(Rank.TWO, Suit.SPADE));
		cards1.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand1 = Hand.buildHand(cards1);
		
		List<Card> cards2 = new ArrayList<>();
		cards2.add(Card.of(Rank.QUEEN, Suit.DIAMOND));
		cards2.add(Card.of(Rank.SEVEN, Suit.SPADE));
		cards2.add(Card.of(Rank.FIVE, Suit.HEART));
		cards2.add(Card.of(Rank.TWO, Suit.SPADE));
		cards2.add(Card.of(Rank.THREE, Suit.SPADE));
		Hand highCardHand2 = Hand.buildHand(cards2);
		
		assertTrue(_comparator.compare(highCardHand1, highCardHand2) < 0);
	}
	

}
