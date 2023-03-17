package topQuiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MultipleChoiceCard {
	
	private ButtonGroup group;
	private String solution;
	private JPanel multiChoiceCard;

	public MultipleChoiceCard()
	{
		group = null;
		solution = null;
		multiChoiceCard = null;
	}
	
	public MultipleChoiceCard(Scanner scan)
	{
		List<String> possibleAnswers = new ArrayList<>();
 	    String question = scan.nextLine();
 	    System.out.println(question);
 	    String numOfChoices = scan.nextLine();
 	    int numOfChoicesNum = Integer.valueOf(numOfChoices);
 	    for (int i = 0; i < numOfChoicesNum; i++)
 	    {
 	    	String possibleAnswer = scan.nextLine();
 		    possibleAnswers.add(possibleAnswer);
 	    }
 	    scan.nextLine();
 	    solution = scan.nextLine();
 	   
 	    multiChoiceCard = new JPanel();
 	    Font font = new Font(("SansSerif"), Font.BOLD,27); 
 	    multiChoiceCard.setFont(font);
 	   
 	    JLabel questionLabel = new JLabel(question);
 	    questionLabel.setFont(font);
 	    multiChoiceCard.add(questionLabel,BorderLayout.NORTH);
 	   	        	   
 	    group = new ButtonGroup();
 	    for(int i = 0; i <possibleAnswers.size(); i++)
        {
     	   //JPanel newCard = new JPanel();
     	   //JRadioButton answerChoice = new JRadioButton(possibleAnswers.get(i));
     	   
     	   //group.add(answerChoice);
     	   JRadioButton newButton = addRadioButton(multiChoiceCard, possibleAnswers.get(i));
     	   newButton.setFont(font);
     	   
     	   //Need to add button to submit and check answer 
     	   group.add(newButton);
     	   
     	   //Need to add button to submit answer and check if answer is right or not as well 
     	   //as move to the next card in the panel.
     	   
     	   //cardPanel.add(answerChoice);
        }
	}
	
	 public JRadioButton addRadioButton(Container parent, String name)
	 {
		 	JRadioButton newlyAdded = new JRadioButton(name);
		 	//newlyAdded.setActionCommand(name);
	        parent.add(newlyAdded);
	        return newlyAdded;
	 }
	 
	 public String getSolution()
	 {
		 return solution;
	 }
	 
	 public ButtonGroup getButtonGroup()
	 {
		 return group;
	 }
	 
	 public JPanel getMultiChoiceCard()
	 {
		 return multiChoiceCard;
	 }
	 
}
