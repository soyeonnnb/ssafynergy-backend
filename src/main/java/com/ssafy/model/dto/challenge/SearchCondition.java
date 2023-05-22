package com.ssafy.model.dto.challenge;

public class SearchCondition {
	  private String key = "none";
	  private String word;
	  private String orderBy = "none";
	  private String orderByDir;
	  private int difficulty = 0;
	  private boolean possibility = false;

	  public SearchCondition() {
	  }

	  public SearchCondition(String key, String word, String orderBy, String orderByDir, int difficulty, boolean possibility) {
	    this.key = key;
	    this.word = word;
	    this.orderBy = orderBy;
	    this.orderByDir = orderByDir;
	    this.difficulty = difficulty;
	    this.possibility = possibility;
	  }

	  public String getKey() {
	    return key;
	  }

	  public void setKey(String key) {
	    this.key = key;
	  }

	  public String getWord() {
	    return word;
	  }

	  public void setWord(String word) {
	    this.word = word;
	  }

	  public String getOrderBy() {
	    return orderBy;
	  }

	  public void setOrderBy(String orderBy) {
	    this.orderBy = orderBy;
	  }

	  public String getOrderByDir() {
	    return orderByDir;
	  }

	  public void setOrderByDir(String orderByDir) {
	    this.orderByDir = orderByDir;
	  }

	  public int getDifficulty() {
	    return difficulty;
	  }

	  public void setDifficulty(int difficulty) {
	    this.difficulty = difficulty;
	  }

	  public boolean isPossibility() {
	    return possibility;
	  }

	  public void setPossibility(boolean possibility) {
	    this.possibility = possibility;
	  }
}
