package topQuiz;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import topQuiz.StartWindow.ButtonEventHandler;

public class GenerateCards extends JFrame{
	
    private CardLayout cards;
    private JPanel cardPanel;
    private List<JPanel> totalCards;
    private int totalScore;
	
	public GenerateCards()
	{
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
		    	   if (numOfChoices == "") {
		    		    break;
		    		}
		    	   int numOfChoicesNum = Integer.valueOf(numOfChoices);
		    	   for (int i = 0; i < numOfChoicesNum; i++)
		    	   {
		    		   String possibleAnswer = myReader.nextLine();
		    		   possibleAnswers.add(possibleAnswer);
		    	   }
		    	   myReader.nextLine();
		    	   String solution = myReader.nextLine();
		    	   
	        	   //ButtonGroup group = new ButtonGroup();
	        	   JPanel newCard = new JPanel();
	        	   Font font = new Font(("SansSerif"), Font.BOLD,27); 
	        	   newCard.setFont(font);
	        	   
	        	   JLabel firstNameLabel = new JLabel(question);
	        	   firstNameLabel.setFont(font);
	        	   newCard.add(firstNameLabel);
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
		           JButton submitButton = new JButton("Submit Answer");
		           submitButton.setActionCommand("Starting Quiz");
		           submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		           
		           ButtonEventHandler handler = new ButtonEventHandler();
		           submitButton.addActionListener(handler);
		           newCard.add(submitButton);
		           
		           
	        	   cardPanel.add(newCard);
	        	   //JLabel firstNameLabel = new JLabel(question);
	        	   //newCard.add(firstNameLabel);
		        	
		        }
		        
		        else if(data.equalsIgnoreCase("Fill In The Blank Question"))
		        {
		        	System.out.println("Fill In The Blank Question");
		        }
		        else if(data.equalsIgnoreCase("Scrambled Words Question"))
		        {
		        	System.out.println("Scrambled Words Question");
		        }
		        
		      }
		      myReader.close();
		    } 
		 catch (FileNotFoundException e) 
		 {
		      System.out.println("An error occurred, database file with questions and answers not found.");
		      e.printStackTrace();
		    }
		 
		 //Insert a for loop that goes through the List of cards that have been shuffled and add them to the CardPanel JFrame.
	}
	
	
	class ButtonEventHandler implements ActionListener { 	
   		public void actionPerformed( ActionEvent event )
   		{
   			//If answer is correct, increment score and move to next question
   			if ( (firstNameTextField.getText().equals("")) || (lastNameTextField.getText().equals("")))
   			{
   				errorLabel.setForeground(Color.RED);
   				errorLabel.setText("Name not entered, please enter in your first and last name.");
   			}
   			//If answer is incorrect decrement score and move to next question
   			else 
   			{
	
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
		guiFrame.setTitle("CardLayout Example");
	    guiFrame.setSize(400,300);
		guiFrame.add(cards.getCardPanel(),BorderLayout.CENTER);
		guiFrame.setVisible(true);
		
		
	}

}
