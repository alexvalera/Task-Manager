package taskManager.observers; 
import java.net.*; 
import java.util.*; 
import java.io.*; 
import taskManager.display.DisplayFile; 
import taskManager.util.FileProcessor; 
import taskManager.util.MyLogger; 

/** 
* UsersTab: An observer class dedicated to holding user information of the 
* task manager
* @author Alex Valera
*/
public class UsersTab implements Observer
{	
	/**Hash map that holds the user and filterss*/
	private HashMap<String,String> users;
	/**Holds names of the users only*/
	private ArrayList<String> usernames; 
	/**Hold lines recieved from update*/
	private ArrayList<String> lines; 
	/**debugger*/
	private MyLogger mylogger; 
	/**File Processor instance for writing to file*/
	public FileProcessor fp; 

	/** UserTab class*/
	public UsersTab()
	{
		users = new HashMap<String, String>(); 	
		usernames = new ArrayList<String>(); 
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
		mylogger.printToStdOut("Update called", 2);	 
		line =line.substring(6,line.length());
		String [] segments = line.split("-"); 
		for (int i = 0; i < segments.length; i++)
		{
			addToMap(segments[i]);

		}

		/*Write to file*/
		fp.writeToFile("---USERS---"); 
		String tempStr = ""; 
		for (String name: usernames)
		{
			tempStr = "User: " + name.toString() + "  Status: " + users.get(name).toString(); 
			fp.writeToFile(tempStr); 
			mylogger.printToStdOut(tempStr, 1); 
		}
		this.users.clear(); 
		this.usernames.clear(); 
		fp.writeToFile("");
	}

	/** 
	* toString() method
	*/
	public String toString()
	{
		return "UsersTab";

	}
	/** 
	* Helper method, takes each line seperated at the "-" delimiter and seperates it more
	* with the ":" delimiter. 
	* @param String line - line to be split up more by ":" delimiter
	*/
	public void addToMap(String line)
	{
		mylogger.printToStdOut("Helper method called", 4); 
		String [] tokens = line.split(":"); 
		int index = 0; 
		users.put(tokens[0],tokens[1]);
		usernames.add(tokens[0]);
	
	}

}
