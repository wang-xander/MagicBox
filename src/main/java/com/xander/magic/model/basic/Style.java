package com.xander.magic.model.basic;

public enum Style {
	Null(""), Pop("Pop"), Rock("Rock"), HipHop("HipHop"), Metal("Metal"), Country("Country"), Blues("Blues"),
			House("House"), Electronic("Electronic"), Funk("Funk"), NewAge("NewAge"), Jazz("Jazz"), Soul("Soul"),
			RnB("R&B"), Punk("Punk"), Other("Other");
	private String style = "";

	private Style(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}

	public String toString() {
		return this.style;
	}

	public static void main(String[] a) {
		for (Style s : Style.values()) {
			System.out.println(s.name());
		}
	}
}
