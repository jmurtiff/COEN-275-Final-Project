package topQuiz;

//Import file and scanner libraries.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Since I am using JFreeChart for creating my bar graph visualization, 
//I need to import all the libraries associated with creating a bar chart.
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 

//The BarChart class generates a "ChartPanel" object that contains
//all the final scores of all students who attempted the Quiz in the form
//of a bar chart. 
public class BarChart {
		
	//Instance variable of type "ChartPanel".
	private ChartPanel chartPanel;

	//Constructor of class BarChart. Create a ChartPanel by first 
	//creating a JFreeChart, and then calling the createBarChart() function
	//in the ChartFactory class. The barChart object will then be passed as 
	//a parameter for the ChartPanel constructor.
	public BarChart(String chartTitle) 
	{
		//The JFreeChart will have a title (passed to the BarChart constructor)
		//as well as labels for the X axis (Student name), the Y axis (Quiz Score)
		//the dataSet itself, and the plot orientation (in this case the columns of the 
		//Bar Chart will be up and down instead of left to right). The last three boolean
		//values are for legend, tooltips, and urls. Since we set the "legened" boolean to be 
		//true, the bar chart will show a legend. 
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				"Student Name",            
				"Quiz Score",            
				createDataset(),          
				PlotOrientation.VERTICAL,           
				true, true, false);
		chartPanel = new ChartPanel(barChart);        
		chartPanel.setPreferredSize(new java.awt.Dimension(800,800));         
	}
	   
	//This function reads through the FinalScore.txt files and reads each
	//score, the student that got the score, and then adds the given values
	//as columns to the bar chart. The X axis of the bar chart will have the 
	//student's name, and the Y axis will have the student's score value. 
	public CategoryDataset createDataset() 
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try 
		{
			File inputScores = new File("src/TopQuiz/FinalScores.txt");
			Scanner myReader = new Scanner(inputScores);
			while (myReader.hasNextLine()) 
			{
				String name = myReader.nextLine();
				String finalScoreString = myReader.nextLine();
				double finalScoreNum = Double.parseDouble(finalScoreString);
				String finalQuizScore = "Quiz Score";
				dataset.addValue(finalScoreNum, finalQuizScore, name);   
			}
			myReader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return dataset; 
	}
	
	//Getter method that we will use in the FinalScoreCard class in order to add the 
	//bar chart visualization to the final score card.
	public ChartPanel getChartPanel()
	{
		return chartPanel;
	}
}

