package taskManager.util; 

/** 
* MyLogger: Double checking locked Singleton debugger
* @author Alex Valera
*/
public class MyLogger
{
	private volatile static MyLogger instance; 
	private int debugLevel; 
	/**Single private constructor that gets called in getInstance()*/
	private MyLogger()
	{
		debugLevel = 0; 

	}
	/**Level setter*/
	public void setLevel(int level)
	{
		debugLevel = level; 

	}
	/** 
	* Double checking locked method that returns the same instance of MyLogger
	* @return MyLogger - same instance of class
	*/
	public static MyLogger getInstance()
	{
		if (instance == null)
		{
			synchronized (MyLogger.class)
			{
				if (instance == null)
				{
					instance = new MyLogger(); 

				}
			}
		}
		return instance; 

	}
	/** 
	* Outputs debug messsage, but first checking if the debug level and level passed are the same
	*/
	public void printToStdOut(String message, int level)
	{
		if (debugLevel == level)
		{
			System.out.println(message); 

		}

	}


}