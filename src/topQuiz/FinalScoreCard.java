package topQuiz;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinalScoreCard {
	
	private JPanel finalScoreCard;

	public FinalScoreCard()
	{
		finalScoreCard = null;
	}
	
	public FinalScoreCard(int totalScore, String firstName, String lastName)
	{
		finalScoreCard = new JPanel();
    	Font font = new Font(("SansSerif"), Font.BOLD,27); 
    	finalScoreCard.setFont(font);
    	
    	String finalScore = "Your final score is " + totalScore + " points.";
    	JLabel finalScoreLabel = new JLabel(finalScore);
    	finalScoreLabel.setFont(font);
    	
    	finalScoreCard.add(finalScoreLabel);
    	
    	
			try 
			{
				String totalScoreString = Integer.toString(totalScore);
				FileWriter fileOut = new FileWriter("src/TopQuiz/FinalScores.txt", true);
				BufferedWriter bw = new BufferedWriter(fileOut);
				bw.write(firstName + " " + lastName);
			    bw.newLine();
			    bw.write(totalScoreString);
			    bw.newLine();
			    bw.close();
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
	    	//Need code here to add score to database and create bar graph or pie chart
	    	//Could do bar graph of each individual student
			
			BarChart2 chart = new BarChart2("Summary of Quiz Scores");
			finalScoreCard.add(chart.getChartPanel());

			
			//finalScoreCard.add(WhateverBarGraphIsCalled);
			
		} 
    	
    	
    	
	 public JPanel getFinalScoreCard()
	 {
		 return finalScoreCard;
	 }
	 
	 
}
