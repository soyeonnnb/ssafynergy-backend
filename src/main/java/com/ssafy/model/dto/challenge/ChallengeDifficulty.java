package com.ssafy.model.dto.challenge;

public class ChallengeDifficulty extends Challenge{
	private int id;
	private String name;
	private int index;
	
	public ChallengeDifficulty() {
	}

	public ChallengeDifficulty(int id, String name, int index) {
		super();
		this.id = id;
		this.name = name;
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "ChallengeDifficulty [id=" + id + ", name=" + name + ", index=" + index + "]";
	}
	
}
