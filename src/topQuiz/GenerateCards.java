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
    protected JPanel cardPanel;
    private List<JPanel> totalCards;
    private int totalScore;
    private List<ButtonGroup> allButtonGroups;
    private List<String> allSolutions;
    private List<JTextField> allFillInSolutions;
    private int currentQuestionNumber;
    private WelcomeScreenCard welcome;
	
	public GenerateCards()
	{
		currentQuestionNumber = 1;
	    allButtonGroups = new ArrayList<>();
	    allSolutions = new ArrayList<>();
	    allFillInSolutions = new ArrayList<>();
	    totalCards = new ArrayList<>();
		totalScore = 0;
		cards = new CardLayout();
        cardPanel = new JPanel();
        // set the card layout
        cardPanel.setLayout(cards);
        welcome = new WelcomeScreenCard();
        JButton startQuizButton = new JButton("Press Here to Start Quiz");
        //startQuizButton.setActionCommand("Starting Quiz");
        startQuizButton.setFont(new Font("Arial", Font.BOLD, 20));   
        WelcomeScreenButtonEventHandler handler = new WelcomeScreenButtonEventHandler();
        startQuizButton.addActionListener(handler);
        welcome.getCard().add(startQuizButton, BorderLayout.SOUTH);  
        
	    totalCards.add(welcome.getCard());
	    allButtonGroups.add(null);
	    allSolutions.add(null);
	    allFillInSolutions.add(null);
         
		 try 
		 {
		     File myObj = new File("src/TopQuiz/QuizQuestions&Answers.txt");
		     Scanner myReader = new Scanner(myObj);
		     while (myReader.hasNextLine()) 
		     {
		       String data = myReader.nextLine();
		        
		       if(data.equalsIgnoreCase("Multiple Choice Question"))
		       {
		    	   MultipleChoiceCard multi = new MultipleChoiceCard(myReader);
		    	   allSolutions.add(multi.getSolution());
		    	   allFillInSolutions.add(null);

		           allButtonGroups.add(multi.getButtonGroup());
		           JButton submitButton = new JButton("Submit Answer");
		           submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
		           MultiChoiceButtonEventHandler handler2 = new MultiChoiceButtonEventHandler();
		           submitButton.addActionListener(handler2);
		           multi.getMultiChoiceCard().add(submitButton, BorderLayout.SOUTH);
		          		           
		           
	        	   //cardPanel.add(newCard);
		           totalCards.add(multi.getMultiChoiceCard());
		           
	        	   //JLabel firstNameLabel = new JLabel(question);
	        	   //newCard.add(firstNameLabel);
		        	
		        }
		        
		        else if(data.equalsIgnoreCase("Fill In The Blank Question"))
		        {
		        	FillInTheBlankCard fillIn = new FillInTheBlankCard(myReader);
			    	
			    	allSolutions.add(fillIn.getSolution());
			    	allButtonGroups.add(null);
			    	allFillInSolutions.add(fillIn.getfillInSelectedAnswer());
			    	
		        	
		        	JButton submitButton = new JButton("Submit Answer");
			        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
			           
			        FillInBlankButtonEventHandler handler2 = new FillInBlankButtonEventHandler();
			        submitButton.addActionListener(handler2);
			        fillIn.getFillInTheBlankCard().add(submitButton);
		        	totalCards.add(fillIn.getFillInTheBlankCard());
			        
		        }
		        else if(data.equalsIgnoreCase("Scrambled Words Question"))
		        {
		        	ScrambledWordsCard scrambled = new ScrambledWordsCard(myReader);
			  		
			    	allSolutions.add(scrambled.getOriginalWord());
			    	allButtonGroups.add(null);
			    	
		        	allFillInSolutions.add(scrambled.getScrambledWordsUserAnswer());		        	
		        	
		        	JButton submitButton = new JButton("Submit Answer");
			        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
			           
			        FillInBlankButtonEventHandler handler2 = new FillInBlankButtonEventHandler();
			        submitButton.addActionListener(handler2);
			        
			        scrambled.getScrambledWordsCard().add(submitButton);
			        totalCards.add(scrambled.getScrambledWordsCard());
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
		 
		 //Collections.shuffle(totalCards, new Random(seed));
		 //Collections.shuffle(allButtonGroups, new Random(seed));
		 //Collections.shuffle(allSolutions, new Random(seed));
		 //Collections.shuffle(allFillInSolutions, new Random(seed));
		 Collections.shuffle(totalCards.subList(1, totalCards.size()), new Random(seed));
		 Collections.shuffle(allButtonGroups.subList(1, allButtonGroups.size()), new Random(seed));
		 Collections.shuffle(allSolutions.subList(1, allSolutions.size()), new Random(seed));
		 Collections.shuffle(allFillInSolutions.subList(1, allFillInSolutions.size()), new Random(seed));
		 
		 
		 
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
	    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) 
	    {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) 
	        {
	                return button.getText();
	        }
	    }
	    return null;
	}
	
	class WelcomeScreenButtonEventHandler implements ActionListener 
	{ 	
   		public void actionPerformed( ActionEvent event )
   		{
   			
   			if ( (welcome.getFirstNameTextField().getText().equals("")) || (welcome.getLastNameTextField().getText().equals("")))
   			{
   				welcome.getErrorLabel().setForeground(Color.RED);
   				welcome.getErrorLabel().setText("Name not entered, please enter in your first and last name.");
   			}
   			else 
   			{
   				
   				//If they have a name and want to start a quiz, then we have to remove all containers and start the quiz.
   				//Generate all the cards that we will need. 
   				CardLayout c1 = (CardLayout)(cardPanel.getLayout());
   	   			c1.next(cardPanel);
   			}
    	}
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
   			
   			if(currentQuestionNumber == 7)
   			{
   				//JFrame newFrame = new JFrame();
   				
   				String firstName = welcome.getFirstNameTextField().getText();
   				String lastName = welcome.getLastNameTextField().getText();
   				FinalScoreCard finalScore = new FinalScoreCard(totalScore, firstName, lastName);
   				
   				cardPanel.add(finalScore.getFinalScoreCard());
	        	
	        	JButton endQuizButton = new JButton("Press Here to End Quiz");
	        	endQuizButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
	        	EndingQuizButtonEventHandler handler = new EndingQuizButtonEventHandler();
		        endQuizButton.addActionListener(handler);
		        
		        finalScore.getFinalScoreCard().add(endQuizButton);
   				
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
   			
   			if(currentQuestionNumber == 7)
   			{
   				//JFrame newFrame = new JFrame();
   				
   				String firstName = welcome.getFirstNameTextField().getText();
   				String lastName = welcome.getLastNameTextField().getText();
   				FinalScoreCard finalScore = new FinalScoreCard(totalScore, firstName, lastName);
   				
   				cardPanel.add(finalScore.getFinalScoreCard());
	        	
	        	JButton endQuizButton = new JButton("Press Here to End Quiz");
	        	endQuizButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
	        	EndingQuizButtonEventHandler handler = new EndingQuizButtonEventHandler();
		        endQuizButton.addActionListener(handler);
		        
		        finalScore.getFinalScoreCard().add(endQuizButton);
   				
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
   		
   		}
	}

		 public JPanel getCardPanel()
		 {
			 return cardPanel;
		 }
}
