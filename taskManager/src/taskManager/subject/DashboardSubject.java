package taskManager.subject;
import java.net.*; 
import java.io.*; 
import java.util.ArrayList;
import java.util.List;  
import java.util.HashMap; 
import taskManager.observers.*; 
import taskManager.subject.Subject; 
/** 
* Dashboard that implements the subject interface and registers observers and deregisters them as well
* as dispersing information through notify
* task manager
* @author Alex Valera
*/
public class DashboardSubject implements Subject
{
	private Observer[] observers; 
	private HashMap<String, String> filters; 
	/*Create tab filters*/
	private UsersTabFilterImpl usersFilter;
	private PerformanceTabFilterImpl performanceFilter;
	private ProcessesTabFilterImpl processesFilter;
	private int observerAmt; 
	public DashboardSubject()
	{
		observers = new Observer[3];
	    filters = new HashMap<String, String>();

		/*Create tab filters*/
		usersFilter = new UsersTabFilterImpl(); 
		performanceFilter = new PerformanceTabFilterImpl(); 
		processesFilter = new ProcessesTabFilterImpl(); 
		observerAmt = 0; 
	}
	/**Registers the observer and it's filter*/
	public void registerObserver(Observer obs, String filter)
	{
		observers[observerAmt] = obs; 
		observerAmt+=1; 
	}
	/**Deregisters an observer*/
	public void deregisterObserver(Observer obs, String filter)
	{
		observerAmt-=1;
	}
	/** Notifies the observers appropriate by using the filter implementations to check if the observer needs the information
	* @param String line- entire line read from file processor in driver
	*/
	public void notifyObs(String line)
	{

		if (usersFilter.check(line))
		{

			observers[0].update(line);


		}

		else if (performanceFilter.check(line))
		{
			observers[1].update(line);



		}

		else if (processesFilter.check(line))
		{
			observers[2].update(line);

		}
		 
	}

	
}
