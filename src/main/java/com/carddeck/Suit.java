package com.carddeck;

public enum Suit {

	SPADE("Spade"),
	HEART("Heart"),
	DIAMOND("Diamond"),
	CLUB("Club");
	
	private String name;
	
	Suit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
