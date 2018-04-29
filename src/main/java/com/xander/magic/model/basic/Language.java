package com.xander.magic.model.basic;

public enum Language {
	Null(""), English("英语"), Chinese("中文"), Cantonese("粤语"), Japanese("日语"), Korean("韩语"), French("法语"), Thai("泰语"), Other("其他");
	private String lang = "";

	private Language(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return lang;
	}

	public String toString() {
		return this.lang;
	}

	public static void main(String[] a) {
		for (Language lang : Language.values()) {
			System.out.println(lang.name());
		}
	}
}