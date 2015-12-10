package taskManager.observers; 
import java.util.HashMap; 
import java.util.ArrayList; 
import taskManager.util.FileProcessor; 
import taskManager.util.MyLogger; 

/** 
* Performance Tab: An observer class dedicated to holding performance information of the 
* task manager
* @author Alex Valera
*/

public class PerformanceTab implements Observer 
{
	/**HashMap to hold data about the performance*/
	private HashMap<String,String> performanceData;
	/**Used to write to file*/
	private FileProcessor fp; 
	/**Debugger*/
	private MyLogger mylogger; 

	/**Performance Tab Constructor*/
	public PerformanceTab()
	{
		performanceData = new HashMap<String,String>(); 
		fp = new FileProcessor(); 
		mylogger = mylogger.getInstance(); 
		
	}

	/** 
	* Gets information from subject and processes it, places into DS, then uses 
	* file processor to write to file
	* @param String line - full line sent by subject
	*/
	public void update(String line)
	{
		// System.out.println(line);
		mylogger.printToStdOut("Update called", 2);
		String[] attributes = {"Memory Total", "Memory Used", "Memory  Free", "Memory  Cached", "CPU Idle", "CPU User Level", "CPU System Level"}; 
		fp.writeToFile("---PERFORMANCE---");
		String[] segments = line.split(":"); 
		String tempStr = ""; 
		for (int i =1; i < segments.length; i++)
		{
			performanceData.put(attributes[i-1],segments[i]); 
			// System.out.println("Added " + attributes[i-1] +" and " + segments[i]+ " to performanceData");

		}
		for (int i = 0; i < attributes.length; i++)
		{
			fp.writeToFileSL(attributes[i] + ": " + performanceData.get(attributes[i]) +"  "); 

			tempStr = attributes[i] + ": " + performanceData.get(attributes[i]) +"  ";
			mylogger.printToStdOut(tempStr, 1); 
			tempStr = ""; 

			if ((i %3 == 0) && (i!=0))
			{
				fp.writeToFile("");

			}

		}

		fp.writeToFileSL("\n");
	}

	/**toString method*/
	public String toString()
	{
		return "PerformaceTab";

	}


}
