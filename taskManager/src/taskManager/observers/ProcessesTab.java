package taskManager.observers; 
import taskManager.display.DisplayFile; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import taskManager.util.FileProcessor; 
import taskManager.util.MyLogger; 
/** 
* Processes: An observer class dedicated to holding processes information  of the 
* task manager
* @author Alex Valera
*/
public class ProcessesTab implements Observer
{
	/**Holds list of processes*/
	private ArrayList<String> processes;
	/**Writes to file*/
	private FileProcessor fp; 
	/**Debugger*/
	private MyLogger mylogger; 
	/**Processes Tab constructor*/
	public ProcessesTab()
	{
		processes = new ArrayList<String>(); 
		fp = new FileProcessor(); 
		mylogger = mylogger.getInstance(); 
	}

	public String toString()
	{	
		return "ProcessesTab";
	}

	/** 
	* Gets information from subject and processes it, places into DS, then uses 
	* file processor to write to file
	* @param String line - full line sent by subject
	*/
	public void update(String line)
	{
		mylogger.printToStdOut("Update called", 2);
		line = line.substring(10, line.length());
		String[] tokens = line.split("-"); 
		String[] attributes = {"PID", "COMMAND", "USER", "%CPU", "%MEM"};
		fp.writeToFile("---PROCESSES---");
		String tempStr=String.format("%5s %-15s %-8s %s %s",attributes[0], attributes[1],attributes[2],attributes[3],attributes[4]);
		fp.writeToFile(tempStr); 
		
		addToList(tokens);
		int step = 0; 

		for(int i = 0; i < processes.size(); i+=5)
		{
			tempStr = String.format("%5s %-15s %-8s  %s  %s", processes.get(i), processes.get(i+1), processes.get(i+2), processes.get(i+3),  processes.get(i+4));
			fp.writeToFile(tempStr); 
			mylogger.printToStdOut(tempStr, 1); 
			tempStr="";

		}
		fp.writeToFile("");
		processes.clear(); 
	}

	/** 
	* Helper method, that takes a string array and then splits it up more to 
	* smaller tokens by ":" delimiter and adds it to the processes Arraylist
	* @param String[] tokens
	*/
	public void addToList(String[] tokens)
	{
		mylogger.printToStdOut("Helper method called", 4); 
		String[] segments; 
		for(int i = 0; i < tokens.length; i++)
		{
			segments = tokens[i].split(":"); 
			for (int y = 0; y < segments.length; y++)
			{ 
				processes.add(segments[y]);

			}


		}

	}

}
