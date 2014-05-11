package me.chriswilson.main;

public class Team {

	private static int idCount = 0;
	private int idNum;
	private String name;
	
	public Team(String name) {
		this.name = name;
		idNum = idCount;
		idCount++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return idNum;
	}

}
