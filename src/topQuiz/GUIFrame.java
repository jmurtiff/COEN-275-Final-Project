package topQuiz;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GUIFrame {
	
	private GenerateCards allCards;
	private JFrame guiFrame;
	
	public GUIFrame()
	{
		allCards = new GenerateCards();
		guiFrame = new JFrame();
	}
		
	public void showGUI()
	{
		guiFrame.setTitle("TopQuiz Application");
		guiFrame.setSize(500,500);
		guiFrame.setLocationRelativeTo(null);
	    guiFrame.setLayout(new BorderLayout());
	    guiFrame.add(allCards.getCardPanel(),BorderLayout.CENTER);
	    guiFrame.setVisible(true);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		GUIFrame quizWindow = new GUIFrame();
		quizWindow.showGUI();
	}

}
