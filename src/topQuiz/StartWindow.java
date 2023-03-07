package topQuiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartWindow extends JFrame{
	
	private JPanel namePanel, namePanelButton, nameCheckerPanel;
	private JButton startQuizButton;
	private JLabel firstNameLabel,lastNameLabel, errorLabel;
	private JTextField firstNameTextField, lastNameTextField;
	
	public StartWindow()
	{
	 super("TopQuiz Application");

     //First panel with 2 labels and 2 text fields to 
	 //enter in name
     Container container = getContentPane();
     namePanel = new JPanel();
     namePanel.setLayout(new FlowLayout());
     
     //Labels that read First and Last Name
     firstNameLabel = new JLabel("FirstName");
     lastNameLabel = new JLabel("LastName");
     firstNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
     firstNameLabel.setForeground(Color.BLACK);
     lastNameLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
     lastNameLabel.setForeground(Color.BLACK);
     
     //Two text fields, one to enter in first name and the
     //other to enter in last name
     firstNameTextField = new JTextField(10);
     lastNameTextField = new JTextField(10);
     
     //This panel is for printing out a warning if the user
     //does not enter in a name.
     nameCheckerPanel = new JPanel();
     nameCheckerPanel.setLayout(new FlowLayout());
     nameCheckerPanel.setPreferredSize(new Dimension(100, 100));

     //
     errorLabel = new JLabel("");
     errorLabel.setFont(new Font("Georgia", Font.ITALIC, 20));
     nameCheckerPanel.add(errorLabel);
     
     
     namePanel.add(firstNameLabel);
     namePanel.add(firstNameTextField);
     namePanel.add(lastNameLabel);
     namePanel.add(lastNameTextField);
	
     namePanelButton = new JPanel();
     namePanelButton.setLayout(new FlowLayout());
     //namePanelButton.setPreferredSize(new Dimension(100, 100));
     
     startQuizButton = new JButton("Press Here to Start Quiz");
     startQuizButton.setActionCommand("Starting Quiz");
     startQuizButton.setFont(new Font("Arial", Font.BOLD, 20));
     
     namePanelButton.add(startQuizButton);
     
     container.add(namePanel,BorderLayout.PAGE_START);
     container.add(nameCheckerPanel,BorderLayout.CENTER);
     container.add(namePanelButton,BorderLayout.PAGE_END);
     
     ButtonEventHandler handler = new ButtonEventHandler();
     startQuizButton.addActionListener(handler);
     
     pack();
	 setLocationRelativeTo(null);
	 setVisible(true);
          
	}
	
	class ButtonEventHandler implements ActionListener { 	
   		public void actionPerformed( ActionEvent event )
   		{
   			
   			if ( (firstNameTextField.getText().equals("")) || (lastNameTextField.getText().equals("")))
   			{
   				errorLabel.setForeground(Color.RED);
   				errorLabel.setText("Name not entered, please enter in your first and last name.");
   			}
   			else 
   			{
   				//If they have a name and want to start a quiz, then we have to remove all containers and start the quiz.
   				//Generate all the cards that we will need. 
   				dispose();
   				JFrame guiFrame = new JFrame();
   				GenerateCards cards = new GenerateCards();
   				guiFrame.setTitle("Quiz In Progress");
   			    guiFrame.setSize(700,400);
   			    guiFrame.setLocationRelativeTo(null);
   		        guiFrame.setLayout(new BorderLayout());
   				guiFrame.add(cards.getCardPanel(),BorderLayout.CENTER);
   				guiFrame.setVisible(true);
   				guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   				
   				
   				//namePanel = new JPanel();
   				//namePanel.setLayout(new CardLayout());
   		     
   				//Labels that read First and Last Name
   				//firstNameLabel = new JLabel("FirstName");
   				//namePanel.add(firstNameLabel);
   				//getContentPane().add(namePanel,BorderLayout.PAGE_START);
   				//pack();
   				//setLocationRelativeTo(null);
   				//setVisible(true);
   				
   				
   			}
    	}
   }
	
	public static void createAndShowGUI(){
		StartWindow app = new StartWindow();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
	public static void main(String[] args) {
		//Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
		
	}

}
