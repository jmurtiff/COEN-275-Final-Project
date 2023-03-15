package topQuiz;

import java.awt.*;
import javax.swing.*;

public class WelcomeScreenCard {

	private JPanel welcomeCard;
	private JLabel firstNameLabel,lastNameLabel, errorLabel;
	private JTextField firstNameTextField, lastNameTextField;
	
	public WelcomeScreenCard()
	{
	 //super("TopQuiz Application");

     //First panel with 2 labels and 2 text fields to 
	 //enter in name
	 welcomeCard = new JPanel();
     
     Font font = new Font(("SansSerif"), Font.BOLD,27); 
     welcomeCard.setFont(font);
     
     //Labels that read First and Last Name
     firstNameLabel = new JLabel("First Name:");
     firstNameLabel.setFont(font);
     lastNameLabel = new JLabel("Last Name:");
     lastNameLabel.setFont(font);
     //firstNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
     //firstNameLabel.setForeground(Color.BLACK);
     //lastNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
     //lastNameLabel.setForeground(Color.BLACK);
     
     //Two text fields, one to enter in first name and the
     //other to enter in last name
     firstNameTextField = new JTextField(10);
     lastNameTextField = new JTextField(10);
     
     //This panel is for printing out a warning if the user
     //does not enter in a name.
     //nameCheckerPanel = new JPanel();
     //nameCheckerPanel.setPreferredSize(new Dimension(100, 100));

     errorLabel = new JLabel("");
     errorLabel.setFont(new Font("Georgia", Font.ITALIC, 20));
     
     
     
     welcomeCard.add(firstNameLabel);
     welcomeCard.add(firstNameTextField, BorderLayout.CENTER);
     welcomeCard.add(lastNameLabel, BorderLayout.CENTER);
     welcomeCard.add(lastNameTextField, BorderLayout.CENTER);
     welcomeCard.add(errorLabel, BorderLayout.CENTER);
	
               
	}
	
	public JPanel getCard()
	{
		return welcomeCard;
	}
	
	public JTextField getFirstNameTextField()
	{
		return firstNameTextField;
	}
	
	public JTextField getLastNameTextField()
	{
		return lastNameTextField;
	}
	
	public JLabel getErrorLabel()
	{
		return errorLabel;
	}
	
	
}
