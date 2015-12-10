package taskManager.driver; 
import taskManager.observers.*; 
import taskManager.subject.*; 
import taskManager.util.*; 
import java.io.*; 
import java.util.ArrayList; 
import java.util.HashMap;

/** 
* Driver: Runs the entire program, reads file and sends data to listeners/observers. 
* @author Alex Valera
*/
public class Driver
{
	
	public static void main(String [] args)
	{
		/*
		Create tabs for the user/performance, and processes
		*/
		String[] data; 
		ArrayList<String> lines = new ArrayList<String>(); 
		ArrayList<Integer> tabs = new ArrayList<Integer>(); 
		UsersTab userT = new UsersTab(); 
		PerformanceTab performanceT = new PerformanceTab(); 
		ProcessesTab processesT = new ProcessesTab(); 

		/*Create Dashboard (subject) and File Processor*/
		DashboardSubject dashboard = new DashboardSubject(); 
		FileProcessor fp = new FileProcessor(); 

		/*Create MyLogger instance*/
		MyLogger mylogger = null; 
		mylogger = mylogger.getInstance(); 


		/*Register observers to dashbaord*/
		dashboard.registerObserver((Observer)userT,"Users");
		dashboard.registerObserver((Observer)performanceT, "Performance"); 
		dashboard.registerObserver((Observer)processesT, "Processes"); 


		/*Open file and then read each line one by on*/
		try
		{

			String fileName = args[0]; //get file path of input

			/*Set debug level*/
			int debugLevel = Integer.parseInt(args[1]); 
			mylogger.setLevel(debugLevel); 


			FileReader fr = new FileReader(fileName); 
			BufferedReader reader = new BufferedReader(fr); 
			String line = null; 
			String filter = null; 
			while ((line = reader.readLine()) != null)
			{
				data = line.split("\\*"); 
				tabs.add(data.length); 
				for (int i = 0; i < data.length; i++)
				{
					lines.add(data[i]);
				}

			}

			fp.writeToFile("---TAB(s) BEGIN---");
			mylogger.printToStdOut("Tab Begin", 3); 
	
			int tabIt = 0; 
			int count = 0; 
			int linesUntilSeperate = tabs.get(tabIt);

			for (int i = 0; i < lines.size(); i++)
			{
				dashboard.notifyObs(lines.get(i)); 
				count+=1; 
				if(count == linesUntilSeperate && (i != lines.size()-1))
				{

					fp.writeToFile("---TAB(s) END---");
					mylogger.printToStdOut("Tab End", 3); 
					fp.writeToFile("---TAB(s) BEGIN---");
					mylogger.printToStdOut("Tab Begin", 3); 
					tabIt+=1; 
					count = 0;
					linesUntilSeperate = tabs.get(tabIt); 

				}
			}
			fp.writeToFile("---TAB(s) END---");
			mylogger.printToStdOut("Tab End", 3); 



		}

		catch (Exception e)
		{
			e.printStackTrace(); 

		}

	}	
}
