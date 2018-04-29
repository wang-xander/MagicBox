package com.xander.magic.model;

import java.util.ArrayList;
import java.util.List;

public class Singers {
	private List<Singer> singers = new ArrayList<Singer>();

	public Singers() {

	}

	public Singers(String singerStr) {
		this();
		this.parseAndSetSinger(singerStr);
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

	public void addSinger(Singer singer) {
		if (this.singers == null) {
			this.singers = new ArrayList<Singer>();
		}
		this.singers.add(singer);
	}

	public String getSingerString() {
		if (singers != null && singers.size() > 0) {
			String singer = singers.get(0).getName();
			for (int i = 1; i < singers.size(); i++) {
				singer = singer + "&" + singers.get(i).getName();
			}
			return singer;
		}
		return "";
	}

	public void parseAndSetSinger(String singerStr) {
		if (singerStr != null && !singerStr.equals("")) {
			String[] ss = singerStr.split("&");
			for (String s : ss) {
				if (s != null && !s.equals(""))
					this.singers.add(new Singer(s));
			}
		}
	}

	public String toString() {
		return this.getSingerString();
	}

}
