package topQuiz;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FillInTheBlankCard {
	
		private String solution;
		private JPanel fillInTheBlankCard;
		private JTextField fillInSelectedAnswer;

		public FillInTheBlankCard()
		{
			solution = null;
			fillInTheBlankCard = null;
			fillInSelectedAnswer = null;
			
		}
		
		public FillInTheBlankCard(Scanner scan)
		{
			String question = scan.nextLine();
	    	System.out.println(question);
	    	scan.nextLine();
	    	solution = scan.nextLine();
	    		    	
	    	fillInTheBlankCard = new JPanel();
        	Font font = new Font(("SansSerif"), Font.BOLD,27); 
        	fillInTheBlankCard.setFont(font);
        	   
        	JLabel questionLabel = new JLabel(question);
        	questionLabel.setFont(font);
        	fillInTheBlankCard.add(questionLabel);
        	fillInSelectedAnswer = new JTextField(10);
        	fillInTheBlankCard.add(fillInSelectedAnswer);
		}
		 
		 public String getSolution()
		 {
			 return solution;
		 }
		 
		 
		 public JPanel getFillInTheBlankCard()
		 {
			 return fillInTheBlankCard;
		 }
		 
		 public JTextField getfillInSelectedAnswer()
		 {
			 return fillInSelectedAnswer;
		 }
		 
}

