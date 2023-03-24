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


//The MultipleChoiceCard class is used to generate the JPanel 
//that is going to be shown to the user for each multiple choice question.
//Each instance of MultipleChoiceCard is unique as each multiple choice question
//(and its corresponding solution) are both unique.
public class MultipleChoiceCard {
	
	//The instance variable that holds the group of buttons (choices) associated with 
	//a given multiple choice question.
	private ButtonGroup group;
	
	//This is the solution to the multiple choice question, as an instance variable.
	private String solution;
	
	//This is the JPanel that encapsulates the entire multiple choice question, its button group 
	//as well as the button to submit the answer to the question.
	private JPanel multiChoiceCard;

	//We have to give a default constructor for this class since we are generating a non-default constructor.
	//We will never use this default constructor, so it is here for the sake of completeness.
	public MultipleChoiceCard()
	{
		group = null;
		solution = null;
		multiChoiceCard = null;
	}
	
	//This constructor takes in a scanner object that is able to read from the "QuizQuestions&Answers.txt"
	//file that contains all the questions and solutions associated with a given quiz. The constructor then 
	//calls the generateMultipleChoiceCard which will generate the complete JPanel needed to contain a single
	//multiple choice question.
	public MultipleChoiceCard(Scanner scan)
	{
		group = new ButtonGroup();
		solution = null;
		multiChoiceCard = new JPanel();
		generateMultipleChoiceCard(scan);
	}
	
	//This function reads the "QuizQuestions&Answers.txt" file and adds the question as a 
	//Label to the JPanel. Then, it takes the possible solutions (there can be many possible solutions
	//as this is a multiple choice question) and each possible answer choice is added to an ArrayList of strings. 
	//Once this is complete, the solution to the multiple choice question is read from the file and the question, 
	//a group of radio buttons (with each button containing one of the possible answers to the question) is added to the 
	//JPanel. Additional code is written for fonts to keep the font style and size the same between all JPanels.
	public void generateMultipleChoiceCard(Scanner scan)
	{
		List<String> possibleAnswers = new ArrayList<>();
		String question = scan.nextLine();
		String numOfChoices = scan.nextLine();
		int numOfChoicesNum = Integer.valueOf(numOfChoices);
		for (int i = 0; i < numOfChoicesNum; i++)
		{
			String possibleAnswer = scan.nextLine();
			possibleAnswers.add(possibleAnswer);
		}
		scan.nextLine();
		solution = scan.nextLine();
 	   
		Font font = new Font(("SansSerif"), Font.BOLD,27); 
		multiChoiceCard.setFont(font);
 	   
		JLabel questionLabel = new JLabel(question);
		questionLabel.setFont(font);
		multiChoiceCard.add(questionLabel,BorderLayout.NORTH);
 	   	        	   
		for(int i = 0; i <possibleAnswers.size(); i++)
		{
			JRadioButton newlyAdded = new JRadioButton(possibleAnswers.get(i));
			multiChoiceCard.add(newlyAdded);
			newlyAdded.setFont(font);
			group.add(newlyAdded);
		}
	}
	 
	//This getter is used in the GenerateCards class in order to add the solution for 
	//a given multiple choice question the array of all multiple choice solutions.
	//This allows us to check the solutions of a given question against what a given student
	//provides.
	public String getSolution()
	{
		return solution;
	}
	
	//This getter is used in the GenerateCards class in order to store what the student provided
	//as a solution to a given multiple choice question in order to compare it with the correct
	//solution.
	public ButtonGroup getButtonGroup()
	{
		return group;
	}
	
	//This getter is used in the GenerateCards class in order to add the given multiple choice JPanel
	//to the array of all JPanels that make up the CardLayout for the GUI.
	public JPanel getMultiChoiceCard()
	{
		return multiChoiceCard;
	}
	 
}
