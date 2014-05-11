package me.chriswilson.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamList {

	private double[][] probs; //array with probabilities for each team winning a matchup
	private ArrayList<Team> teams;
	
	public TeamList(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			String line = in.nextLine();
			String[] lineSplit;
			while(!line.equals("----------")){
				System.out.println(line);
				teams.add(new Team(line));
				line = in.nextLine();
			}
			
			probs = new double[teams.size()][teams.size()];
			
			for(int i = 0; i < teams.size(); i++){
				line = in.nextLine();
				lineSplit = line.split(" ");
				for(int j = 0; j < teams.size(); j++){
					probs[i][j] = Double.parseDouble(lineSplit[j]);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		String outString = "";
		for(Team t: teams){
			outString += t.getID() + ": " + t.getName() + "\n";
		}
		
		for(double[] a: probs){
			for(double b: a)
				outString += b + " ";
			outString += "\n";
		}
		
		return outString;
	}

}
