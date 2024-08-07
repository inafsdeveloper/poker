package com.carddeck;

import java.util.*;

public class Hand {
	private Set<Card> cards = new HashSet<>();
	
	public static Hand buildHand(Collection<Card> cardsList) {
		Hand hand = new Hand();
		if(cardsList.size() != 5) {
			throw new IllegalArgumentException("Hand must contain 5 cards");
		}
		for(Card card: cardsList) {
			if(!hand.cards.add(card)) {
				throw new DuplicateCardException("card already exists: " + card);
			}
		}
		return hand;
	}
	
	static class DuplicateCardException extends IllegalArgumentException {
		public DuplicateCardException(String message) {
			super(message);
		}
	}

	public Set<Card> getCards() {
		return cards;
	}
	
	public HandType getType() {
		if(ranksAreSequential() && allSuitsAreTheSame()) {
			return HandType.STRAIGHT_FLUSH;
		}
		
		if(getRankOfHighestNOfAKind(4) != null) {
			return HandType.FOUR_OF_A_KIND;
		}
		
		if(false /* not implemented*/) {
			return HandType.FULL_HOUSE;
		}
		
		if(allSuitsAreTheSame()) {
			return HandType.FLUSH;
		}
		
		if(ranksAreSequential()) {
			return HandType.STRAIGHT;
		}
		
		if(getRankOfHighestNOfAKind(3) != null) {
			return HandType.THREE_OF_A_KIND;
		}
		
		if(false /*not implemented*/) {
			return HandType.TWO_PAIR;
		}
		
		if(getRankOfHighestNOfAKind(2) != null) {
			return HandType.PAIR;
		}
		
		return HandType.HIGH_CARD;
	}
	
	/*
	 * This function return rank of n number of cards that have same rank, 
	 * if multiple n number of cards within a hand have same rank the function return 
	 * highest among those.
	 * For instance we have a hand (2,2,3,3,5) and you ask getRankOfHighestNofAKind(2),
	 * the function 3 even though there are two sets 2 and 3 qualify for 2 of a kind, 
	 * because 3 is higher than 2 function returns 3.
	 * 
	 *   @param n the number of cards in the hand whose rank must be same: pass 2 to find a pair, 3 for 3 of a kind, etc
	 *   @returns the highest rank for which a large-enough subset of cards was found
	 */
	private Rank getRankOfHighestNOfAKind(int n) {
		Map<Rank, Integer> quantityOfEachRank = new HashMap<>();
		for(Card card: getCards()){
			Rank rank = card.getRank();
			Integer numOfRank = quantityOfEachRank.get(rank);
			if(numOfRank == null) {
				numOfRank = 1;
			}else {
				numOfRank++;
			}
			
			quantityOfEachRank.put(rank, numOfRank);
			
		}
		
		List<Rank> ranksPresent = new ArrayList<>(quantityOfEachRank.keySet());
		Collections.sort(ranksPresent);
		Collections.reverse(ranksPresent);
		
		for(Rank rank: ranksPresent) {
			Integer numOfRank = quantityOfEachRank.get(rank);
			if(numOfRank != null && numOfRank >= n)
				return rank;
		}
		
		return null;
	}
	
	/*
	 * Returns true if the ranks are sequential according to the rules for a straight
	 */
	private boolean ranksAreSequential() {
		if(getRankOfHighestNOfAKind(2) != null)
			return false;
		
		List<Rank> ranks = new ArrayList<>();
		
		for(Card card : getCards()) {
			ranks.add(card.getRank());
		}
		
		Collections.sort(ranks);
		
		int handSize = getCards().size();
		return (ranks.get(handSize-1).ordinal() == ranks.get(0).ordinal() + (handSize -1));
	}
	
	/*
	 * Return if all the cards in the hands of same suit or not
	 * */
	private boolean allSuitsAreTheSame() {
		Set<Suit> suits = new HashSet<>();
		for (Card card: getCards()) {
			suits.add(card.getSuit());
		}
		return suits.size() == 1;
	}
}
