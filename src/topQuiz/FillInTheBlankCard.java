package topQuiz;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//The FillInTheBlankCard class is used to generate the JPanel 
//that is going to be shown to the user for each fill in the blank question.
//Each instance of FillInTheBlankCard is unique as each fill in the blank question
//(and its corresponding solution) are both unique.
public class FillInTheBlankCard {
	
	//This is the solution to the fill in the blank question, as an instance variable.
	private String solution;
	
	//This is the JPanel that encapsulates the entire fill in the blank question, its text
	//field, as well as the button to submit the answer to the question.
	private JPanel fillInTheBlankCard;
	
	//This text field holds the answer that the user submits for the fill in the blank question.
	private JTextField fillInSelectedAnswer;
	
	//We have to give a default constructor for this class since we are generating a non-default constructor.
	//We will never use this default constructor, so it is here for the sake of completeness.
	public FillInTheBlankCard()
	{
		solution = null;
		fillInTheBlankCard = null;
		fillInSelectedAnswer = null;	
	}
		
	//This constructor takes in a scanner object that is able to read from the "QuizQuestions&Answers.txt"
	//file that contains all the questions and solutions associated with a given quiz. The constructor then 
	//calls the generateFillInTheBlankCard which will generate the complete JPanel needed to contain a single
	//fill in the blank question.
	public FillInTheBlankCard(Scanner scan)
	{
		solution = null;
		fillInTheBlankCard =  new JPanel();
		fillInSelectedAnswer = new JTextField(10);
		generateFillInTheBlankCard(scan);
	}
	
	//This function reads the "QuizQuestions&Answers.txt" file and adds the question as a 
	//Label to the JPanel. Then, it takes the solution to the fill in the blank question and modifies
	//the instance variable "solution" with this value read from the file. Finally, a JTextField is added
	//to the JPanel where the student is going to write in their solution to the fill in the blank question.
	//Additional code is written for fonts to keep the font style and size the same between all JPanels.
	public void generateFillInTheBlankCard(Scanner scan)
	{
		String question = scan.nextLine();
		System.out.println(question);
		scan.nextLine();
		solution = scan.nextLine();
		
		Font font = new Font(("SansSerif"), Font.BOLD,27); 
		fillInTheBlankCard.setFont(font);
		
		JLabel questionLabel = new JLabel(question);
		questionLabel.setFont(font);
		
		fillInTheBlankCard.add(questionLabel);
		fillInTheBlankCard.add(fillInSelectedAnswer);
	}
		 
	//This getter is used in the GenerateCards class in order to add the solution for 
	//a given fill in the blank question the array of all fill In the blank solutions.
	//This allows us to check the solutions of a given question against what a given student
	//provides.
	public String getSolution()
	{
		return solution;
	}
	
	//This getter is used in the GenerateCards class in order to add the given fill in the blank JPanel
	//to the array of all JPanels that make up the CardLayout for the GUI.
	public JPanel getFillInTheBlankCard()
	{
		return fillInTheBlankCard;
	}
	
	//This getter is used in the GenerateCards class in order to store what the student provided
	//as a solution to a given fill in the blank question in order to compare it with the correct
	//solution.
	public JTextField getfillInSelectedAnswer()
	{
		return fillInSelectedAnswer;
	}
		 
}

