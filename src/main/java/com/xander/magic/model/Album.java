package com.xander.magic.model;

import com.xander.magic.model.basic.Language;

public class Album {
	private String name = "";
	private Singers singers;
	private Language language = Language.Null;
	private String year = "";

	public Album() {
		this("", "");
	}

	public Album(String name, String singerStr) {
		this(name, singerStr, "", Language.Null);
	}

	public Album(String name, String singerStr, String year, Language lang) {
		this.language = lang;
		this.name = name;
		this.singers = new Singers(singerStr);
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Singers getSingers() {
		return singers;
	}

	public void setSingers(Singers singers) {
		this.singers = singers;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String toString() {
		String out = "";
		if (this.name != null && !this.name.equals("")) {
			out = name;
			if (this.year != null && !this.year.equals("")) {
				out = out + " [" + year + "]";
			}
		}
		return out;
	}
}
