package topQuiz;

import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//The ScrambledWordsCard class is used to generate the JPanel 
//that is going to be shown to the user for each scrambled words question.
//Each instance of ScrambledWordsCard is unique as each scrambled words question
//(and its corresponding solution) are both unique.
public class ScrambledWordsCard {
	
	//This is the solution to the scrambled words question, as an instance variable.
	private String originalWord;
	
	//This is the JPanel that encapsulates the entire scrambled words question, its text
	//field, as well as the button to submit the answer to the question.
	private JPanel scrambledWordsCard;
	
	//This text field holds the answer that the user submits for the scrambled words question.
	private JTextField scrambledWordsUserAnswer;

	//We have to give a default constructor for this class since we are generating a non-default constructor.
	//We will never use this default constructor, so it is here for the sake of completeness.
	public ScrambledWordsCard()
	{
		originalWord = null;
		scrambledWordsCard = null;
		scrambledWordsUserAnswer = null;
	}
	
	//This constructor takes in a scanner object that is able to read from the "QuizQuestions&Answers.txt"
	//file that contains all the questions and solutions associated with a given quiz. The constructor then 
	//calls the generateScrambledWordsCard which will generate the complete JPanel needed to contain a single
	//scrambled words question.
	public ScrambledWordsCard(Scanner scan)
	{
		originalWord = null;
		scrambledWordsCard = new JPanel();
		scrambledWordsUserAnswer = new JTextField(10);
		generateScrambledWordsCard(scan);
	}
	

	//This function reads the "QuizQuestions&Answers.txt" file and adds the question as a 
	//Label to the JPanel. Then, it takes the solution to the scrambled question and modifies
	//the instance variable "solution" with this value read from the file. Then, the solution word is scrambled
	//randomly so each time the TopQuiz application is executed, the scrambled word will have a different spelling. 
	//Finally, a JTextField is added to the JPanel where the student is going to write in their solution to the 
	//scrambled words question. Additional code is written for fonts to keep the font style and size the same between all JPanels.
	//The solution that the student gives for the question can be uppercase or lowercase, it does not matter which case the user
	//utilizes, as if they give the correct spelling, the answer will be marked as correct.
	public void generateScrambledWordsCard(Scanner scan)
	{
		String question = scan.nextLine();
		originalWord = scan.nextLine();
		String originalWordLowerCase = originalWord.toLowerCase();
    	
		List<String> characters = Arrays.asList(originalWordLowerCase.split(""));
		Collections.shuffle(characters);
		String newWord = "";
		for (String character : characters)
		{
			newWord += character;
		}
  		
		Font font = new Font(("SansSerif"), Font.BOLD,27); 
		scrambledWordsCard.setFont(font);
    	   
		JLabel questionLabel = new JLabel(question);
		questionLabel.setFont(font);
    	
		JLabel scrambledWord = new JLabel(newWord);
		scrambledWord.setFont(font);
    	
		scrambledWordsCard.add(questionLabel);
		scrambledWordsCard.add(scrambledWord);
		scrambledWordsCard.add(scrambledWordsUserAnswer);
	}
	
	//This getter is used in the GenerateCards class in order to add the given scrambled words JPanel
	//to the array of all JPanels that make up the CardLayout for the GUI.
	public JPanel getScrambledWordsCard()
	{
		return scrambledWordsCard;
	}
	
	//This getter is used in the GenerateCards class in order to store what the student provided
	//as a solution to a given scrambled words question in order to compare it with the correct
	//solution.
	public JTextField getScrambledWordsUserAnswer()
	{
		return scrambledWordsUserAnswer;
	}
	 
	//This getter is used in the GenerateCards class in order to add the solution for 
	//a given scrambled words question the array of all fill In the blank type solutions.
	//This allows us to check the solutions of a given question against what a given student
	//provides.
	public String getOriginalWord()
	{
		return originalWord;
	}
	 
}
