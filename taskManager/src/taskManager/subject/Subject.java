package taskManager.subject;
import taskManager.observers.*;


public interface Subject
{
	public void registerObserver(Observer obs, String filter); 
	public void deregisterObserver(Observer obs, String filter); 
	public void notifyObs(String line);  	

}
