package taskManager.observers; 
import taskManager.filter.DashboardFilter; 
import java.io.*; 
import java.util.*; 

public class PerformanceTabFilterImpl implements DashboardFilter
{
	public boolean check(String line)
	{
		String[] segments = line.split(":"); 
		if (segments[0].equals("Performance"))
		{
			return true; 

		}

		else
		{
			return false; 

		}

	}

	

}