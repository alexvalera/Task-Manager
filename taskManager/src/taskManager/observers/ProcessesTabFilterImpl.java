package taskManager.observers; 
import taskManager.filter.DashboardFilter; 
import java.io.*; 
import java.util.*; 

public class ProcessesTabFilterImpl implements DashboardFilter
{
	public boolean check(String line)
	{
		String[] segments = line.split(":"); 
		if (segments[0].equals("Processes"))
		{
			return true; 

		}

		else
		{
			return false; 

		}

	}

}