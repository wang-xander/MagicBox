package com.xander.magic.model;

public class Singer {

	private String name = "";
	private Gender gender = Gender.Null;
	private String region = "";

	public Singer(String name, Gender gender, String region) {
		this.name = name;
		this.region = region;
		this.gender = gender;
	}

	public Singer(String name) {
		this(name, null, null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String toString() {
//        return this.name + "(" + this.gender + ", " + this.region + ")";
		return this.name;
	}

	public enum Gender {
		Null(""), Male("男"), Female("女");
		private String gen;

		private Gender(String gen) {
			this.gen = gen;
		}

		public String getGen() {
			return gen;
		}

		public String toString() {
			return this.gen;
		}
	}
}
