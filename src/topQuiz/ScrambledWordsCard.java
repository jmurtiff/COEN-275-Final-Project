package topQuiz;

import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScrambledWordsCard {
	
	private String originalWord;
	private JPanel scrambledWordsCard;
	private JTextField scrambledWordsUserAnswer;

	public ScrambledWordsCard()
	{
		originalWord = null;
		scrambledWordsCard = null;
		scrambledWordsUserAnswer = null;
	}
	
	public ScrambledWordsCard(Scanner scan)
	{
		String question = scan.nextLine();
    	System.out.println(question);
    	originalWord = scan.nextLine();
    	String originalWordLowerCase = originalWord.toLowerCase();
    	
    	List<String> characters = Arrays.asList(originalWordLowerCase.split(""));
 		Collections.shuffle(characters);
  		String newWord = "";
  		for (String character : characters)
  		{
  			newWord += character;
  		}
  		
  		scrambledWordsCard = new JPanel();
    	Font font = new Font(("SansSerif"), Font.BOLD,27); 
    	scrambledWordsCard.setFont(font);
    	   
    	JLabel questionLabel = new JLabel(question);
    	questionLabel.setFont(font);
    	
    	JLabel scrambledWord = new JLabel(newWord);
    	scrambledWord.setFont(font);
    	
    	scrambledWordsCard.add(questionLabel);
    	scrambledWordsCard.add(scrambledWord);
    	scrambledWordsUserAnswer = new JTextField(10);
    	scrambledWordsCard.add(scrambledWordsUserAnswer);
  		
	}
	 
	 public JPanel getScrambledWordsCard()
	 {
		 return scrambledWordsCard;
	 }
	 
	 public JTextField getScrambledWordsUserAnswer()
	 {
		 return scrambledWordsUserAnswer;
	 }
	 
	 public String getOriginalWord()
	 {
		 return originalWord;
	 }
	 
}
