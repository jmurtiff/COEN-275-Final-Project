package topQuiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 

	public class BarChart2 {
		
		private ChartPanel chartPanel;
	   
	   public BarChart2(String chartTitle) 
	   {      
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Student Name",            
	         "Quiz Score",            
	         createDataset(),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	         
	      chartPanel = new ChartPanel(barChart);        
	      chartPanel.setPreferredSize(new java.awt.Dimension(800 , 800));         
	   }
	   
	   public CategoryDataset createDataset() 
	   {
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		  
		  try {
				File inputScores = new File("src/TopQuiz/FinalScores.txt");
				Scanner myReader = new Scanner(inputScores);
			     while (myReader.hasNextLine()) 
			     {
			       String name = myReader.nextLine();
			       String finalScore = myReader.nextLine();
			       double finalScoreNum = Double.parseDouble(finalScore);
			       String finalQuizScore = "Quiz Score";
			       dataset.addValue(finalScoreNum, finalQuizScore, name);   
			     }
			     myReader.close();
			     

			} 
		  catch (FileNotFoundException e) 
		  {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		         
             
	      return dataset; 
	   }
	   
	   public ChartPanel getChartPanel()
	   {
		   return chartPanel;
	   }
}

