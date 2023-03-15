package topQuiz;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GenerateCards extends JFrame{
	
	
    private CardLayout cards;
    private JPanel cardPanel;
    private List<JPanel> totalCards;
    private int totalScore;
    private List<ButtonGroup> allButtonGroups;
    private List<String> allSolutions;
    private List<JTextField> allFillInSolutions;
    private JTextField fillInSelectedAnswer;
    private int currentQuestionNumber;
	
	public GenerateCards()
	{
		currentQuestionNumber = 0;
	    allButtonGroups = new ArrayList<>();
	    allSolutions = new ArrayList<>();
	    allFillInSolutions = new ArrayList<>();
	    totalCards = new ArrayList<>();
		totalScore = 0;
		cards = new CardLayout();
        cardPanel = new JPanel();
         // set the card layout
         cardPanel.setLayout(cards);
		 try 
		 {
			 System.getProperty("user.dir");
		     File myObj = new File("src/TopQuiz/QuizQuestions&Answers.txt");
		     Scanner myReader = new Scanner(myObj);
		     while (myReader.hasNextLine()) 
		     {
		       String data = myReader.nextLine();
		        
		       if(data.equalsIgnoreCase("Multiple Choice Question"))
		       {
		    	   List<String> possibleAnswers = new ArrayList<>();
		    	   String question = myReader.nextLine();
		    	   System.out.println(question);
		    	   String numOfChoices = myReader.nextLine();
		    	   int numOfChoicesNum = Integer.valueOf(numOfChoices);
		    	   for (int i = 0; i < numOfChoicesNum; i++)
		    	   {
		    		   String possibleAnswer = myReader.nextLine();
		    		   possibleAnswers.add(possibleAnswer);
		    	   }
		    	   myReader.nextLine();
		    	   String solution = myReader.nextLine();
		    	   allSolutions.add(solution);
		    	   allFillInSolutions.add(null);
		    	   
	        	   JPanel newCard = new JPanel();
	        	   Font font = new Font(("SansSerif"), Font.BOLD,27); 
	        	   newCard.setFont(font);
	        	   
	        	   JLabel questionLabel = new JLabel(question);
	        	   questionLabel.setFont(font);
	        	   newCard.add(questionLabel,BorderLayout.NORTH);
	        	   
	        	   JLabel emptySpace = new JLabel("");
	        	   questionLabel.setFont(font);
	        	   newCard.add(emptySpace,BorderLayout.NORTH);
	        	   
	        	   ButtonGroup group = new ButtonGroup();
		    	   
		           for(int i = 0; i <possibleAnswers.size(); i++)
		           {
		        	   //JPanel newCard = new JPanel();
		        	   //JRadioButton answerChoice = new JRadioButton(possibleAnswers.get(i));
		        	   
		        	   //group.add(answerChoice);
		        	   JRadioButton newButton = addRadioButton(newCard, possibleAnswers.get(i));
		        	   newButton.setFont(font);
		        	   
		        	   //Need to add button to submit and check answer 
		        	   group.add(newButton);
		        	   
		        	   //Need to add button to submit answer and check if answer is right or not as well 
		        	   //as move to the next card in the panel.
		        	   
		        	   //cardPanel.add(answerChoice);
		           }
		           allButtonGroups.add(group);
		           JButton submitButton = new JButton("Submit Answer");
		           submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
		           MultiChoiceButtonEventHandler handler = new MultiChoiceButtonEventHandler();
		           submitButton.addActionListener(handler);
		           newCard.add(submitButton, BorderLayout.SOUTH);
		           
		           
	        	   //cardPanel.add(newCard);
		           totalCards.add(newCard);
		           
	        	   //JLabel firstNameLabel = new JLabel(question);
	        	   //newCard.add(firstNameLabel);
		        	
		        }
		        
		        else if(data.equalsIgnoreCase("Fill In The Blank Question"))
		        {
		        	String question = myReader.nextLine();
			    	System.out.println(question);
			    	myReader.nextLine();
			    	String solution = myReader.nextLine();
			    	
			    	allSolutions.add(solution);
			    	allButtonGroups.add(null);
			    	
			    	JPanel newCard = new JPanel();
		        	Font font = new Font(("SansSerif"), Font.BOLD,27); 
		        	newCard.setFont(font);
		        	   
		        	JLabel questionLabel = new JLabel(question);
		        	questionLabel.setFont(font);
		        	newCard.add(questionLabel);
		        	fillInSelectedAnswer = new JTextField(10);
		        	newCard.add(fillInSelectedAnswer);
		        	allFillInSolutions.add(fillInSelectedAnswer);
		        	//cardPanel.add(newCard);
		        	
		        	
		        	JButton submitButton = new JButton("Submit Answer");
			        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
			           
			        FillInBlankButtonEventHandler handler = new FillInBlankButtonEventHandler();
			        submitButton.addActionListener(handler);
			        newCard.add(submitButton);
		        	//cardPanel.add(newCard);
		        	totalCards.add(newCard);
			        
		        }
		        else if(data.equalsIgnoreCase("Scrambled Words Question"))
		        {
		        	String question = myReader.nextLine();
			    	System.out.println(question);
			    	String originalWord = myReader.nextLine();
			    	String originalWordLowerCase = originalWord.toLowerCase();
			    	
			    	List<String> characters = Arrays.asList(originalWordLowerCase.split(""));
			 		Collections.shuffle(characters);
			  		String newWord = "";
			  		for (String character : characters)
			  		{
			  			newWord += character;
			  		}
			  		
			    	allSolutions.add(originalWord);
			    	allButtonGroups.add(null);
			    	
			    	JPanel newCard = new JPanel();
		        	Font font = new Font(("SansSerif"), Font.BOLD,27); 
		        	newCard.setFont(font);
		        	   
		        	JLabel questionLabel = new JLabel(question);
		        	questionLabel.setFont(font);
		        	
		        	JLabel scrambledWord = new JLabel(newWord);
		        	scrambledWord.setFont(font);
		        	
		        	newCard.add(questionLabel);
		        	newCard.add(scrambledWord);
		        	fillInSelectedAnswer = new JTextField(10);
		        	newCard.add(fillInSelectedAnswer);
		        	allFillInSolutions.add(fillInSelectedAnswer);
		        	//cardPanel.add(newCard);
		        	
		        	
		        	JButton submitButton = new JButton("Submit Answer");
			        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
			           
			        FillInBlankButtonEventHandler handler = new FillInBlankButtonEventHandler();
			        submitButton.addActionListener(handler);
			        newCard.add(submitButton);
		        	//cardPanel.add(newCard);
		        	totalCards.add(newCard);
		        }
		        
		      }
		      myReader.close();
		    } 
		 catch (FileNotFoundException e) 
		 {
		      System.out.println("An error occurred, database file with questions and answers not found.");
		      e.printStackTrace();
		   }
		 for (int i = 0; i < allButtonGroups.size(); i++) {
		      System.out.println(allButtonGroups.get(i) + " ");
		    }
		 
		 for (int i = 0; i < allSolutions.size(); i++) {
		      System.out.println(allSolutions.get(i) + " ");
		    }
		 
		 //Insert a for loop that goes through the List of cards that have been shuffled and add them to the CardPanel JFrame.
		 long seed = System.nanoTime();
		 Collections.shuffle(totalCards, new Random(seed));
		 Collections.shuffle(allButtonGroups, new Random(seed));
		 Collections.shuffle(allSolutions, new Random(seed));
		 Collections.shuffle(allFillInSolutions, new Random(seed));
		 
		 //HOW ABOUT HERE WE ADD QUESTION NUMBERS HERE, WE JUST TAKE EACH ELEMENT IN THE totalCards ARRAY AND WE ADD A NEW JLABEL
		 //WITH A STIRNG THAT IS THE QUESTION NUMBER (WE HAVE TO KNOW THE NUMBER OF QUESTION AHEAD OF TIME
		 //IF WE USE totalCards.size() or totalCards.length() that gives us the total number of questions we have. 
		 
		 //Have a previous question and next question button on the bottom of the GUI (since these are static elements, 
		 //we can add them pretty easily and have them be Borderlayout on the bottom of the screen). The only problem 
		 //is when we get to the score screen since this screen should not have a previous question, submit answer, 
		 //and next question buttons (maybe we can remove or dispose of these somehow????)
		 
		 for(int i = 0; i < totalCards.size(); i++)
		 {
			//cardPanel.add(totalCards.get(i));
			 cardPanel.add(totalCards.get(i),BorderLayout.SOUTH);
			//cardPanel.add(totalCards.get(i));  
		 }
	}
	
	
	String getSelectedButton(ButtonGroup group)
	{  
	    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) {
	                return button.getText();
	        }
	    }
	    return null;
	}
	
	//WHEN HITTING THE SUBMIT BUTTON, OPEN NEW WINDOW SAYING IF ANSWER IS RIGHT OR WRONG, THEN IF CLICK OKAY 
	//ON WINDOW THEN CLOSES NEW WINDOWS AND MOVES TO NEXT QUESTION
	class MultiChoiceButtonEventHandler implements ActionListener { 	
   		public void actionPerformed(ActionEvent event)
   		{
   			
   			String selectedAnswer = getSelectedButton(allButtonGroups.get(currentQuestionNumber));
   			if(selectedAnswer.equalsIgnoreCase(allSolutions.get(currentQuestionNumber)))
   			{
   				totalScore++;
   				System.out.println(totalScore);
   			}
   			else
   			{
   				if(totalScore == 0)
   				{
   					totalScore = 0;
   					System.out.println(totalScore);
   				}
   				else
   				{
   					totalScore = totalScore - 1;
   					System.out.println(totalScore);
   				}
   			}
   			currentQuestionNumber++;
   			
   			if(currentQuestionNumber == 6)
   			{
   				//JFrame newFrame = new JFrame();
   				JPanel newCard = new JPanel();
	        	Font font = new Font(("SansSerif"), Font.BOLD,27); 
	        	newCard.setFont(font);
	        	
	        	String finalScore = "Your final score is " + totalScore + " points.";
	        	JLabel finalScoreLabel = new JLabel(finalScore);
	        	finalScoreLabel.setFont(font);
	        	
	        	newCard.add(finalScoreLabel);
   				cardPanel.add(newCard);
	        	
	        	JButton endQuizButton = new JButton("Press Here to End Quiz");
	        	endQuizButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
	        	EndingQuizButtonEventHandler handler = new EndingQuizButtonEventHandler();
		        endQuizButton.addActionListener(handler);
		        newCard.add(endQuizButton);
	        	
   				
   	   			CardLayout c1 = (CardLayout)(cardPanel.getLayout());
   	   			c1.next(cardPanel);
   				
   			}
   			else
   			{
   	   			CardLayout c1 = (CardLayout)(cardPanel.getLayout());
   	   			c1.next(cardPanel);
   			}
   		}
	}
	
	//WHEN HITTING THE SUBMIT BUTTON, OPEN NEW WINDOW SAYING IF ANSWER IS RIGHT OR WRONG, THEN IF CLICK OKAY 
	//ON WINDOW THEN CLOSES NEW WINDOWS AND MOVES TO NEXT QUESTION
	class FillInBlankButtonEventHandler implements ActionListener { 	
   		public void actionPerformed(ActionEvent event)
   		{
   			String selectedAnswer = allFillInSolutions.get(currentQuestionNumber).getText();
   			if (selectedAnswer.equalsIgnoreCase(allSolutions.get(currentQuestionNumber)))
   			{
   				totalScore++;
   				System.out.println(totalScore);
   			}
   			else
   			{
   				if(totalScore == 0)
   				{
   					totalScore = 0;
   					System.out.println(totalScore);
   				}
   				else
   				{
   					totalScore = totalScore - 1;
   					System.out.println(totalScore);
   				}
   			}
   			currentQuestionNumber++;
   			
   			if(currentQuestionNumber == 6)
   			{
   				//JFrame newFrame = new JFrame();
   				JPanel newCard = new JPanel();
	        	Font font = new Font(("SansSerif"), Font.BOLD,27); 
	        	newCard.setFont(font);
	        	
	        	String finalScore = "Your final score is " + totalScore + " points.";
	        	JLabel finalScoreLabel = new JLabel(finalScore);
	        	finalScoreLabel.setFont(font);
	        	
	        	newCard.add(finalScoreLabel);
   				cardPanel.add(newCard);
	        	
	        	JButton endQuizButton = new JButton("Press Here to End Quiz");
	        	endQuizButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
	        	EndingQuizButtonEventHandler handler = new EndingQuizButtonEventHandler();
		        endQuizButton.addActionListener(handler);
		        newCard.add(endQuizButton);
   				
   	   			CardLayout c1 = (CardLayout)(cardPanel.getLayout());
   	   			c1.next(cardPanel);
   				
   			}
   			else
   			{
   	   			CardLayout c1 = (CardLayout)(cardPanel.getLayout());
   	   			c1.next(cardPanel);
   			}
   		}
	}
	
	class EndingQuizButtonEventHandler implements ActionListener { 	
   		public void actionPerformed(ActionEvent event)
   		{
   			System.exit(0);
   			//Still need to write score data and name to a database (in this case a text file).
   		
   		}
	}

	
		 public JPanel getCardPanel()
		 {
			 return cardPanel;
		 }
		 
		 private JRadioButton addRadioButton(Container parent, String name)
		 {
			 	JRadioButton newlyAdded = new JRadioButton(name);
			 	//newlyAdded.setActionCommand(name);
		        parent.add(newlyAdded);
		        return newlyAdded;
		 }
		 
	
	
	
	public static void main(String[] args) {
		GenerateCards cards = new GenerateCards();
		JFrame guiFrame = new JFrame();
		guiFrame.setTitle("Quiz In Progress");
	    guiFrame.setSize(400,300);
	    guiFrame.setLocationRelativeTo(null);
        guiFrame.setLayout(new BorderLayout());
		guiFrame.add(cards.getCardPanel(),BorderLayout.CENTER);
		guiFrame.setVisible(true);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
