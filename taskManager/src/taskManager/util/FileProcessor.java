package taskManager.util;
import java.io.*;
import java.util.*; 
  
/** 
* File Processor: A class that writes to an output file defaulted to output.txt
* task manager
* @author Alex Valera
*/
public class FileProcessor
{
	private String path; 
	private int lineNum; 
	private String[] lines; 
	private PrintWriter out; 
	/** 
	* Method that writes to file and goes to the next line after writing.
	* Opens and closes file as well automatically. 
	* @param STring line = hold string that is meant to be written to the output. 
	* @throws IOException if the file cannot be opened
	*/
	public void writeToFile(String line)
	{
		try
		{
			this.out = new PrintWriter(new BufferedWriter(new FileWriter("src/taskManager/output.txt",true))); 
			this.out.println(line); 
			this.out.close(); 

		}

		catch (IOException e)
		{
			e.printStackTrace(); 
			System.out.println("Problem opening output.txt");
		}
		
	}
	/**
	* Method that writes to to the file, same as writeToFile(String line), however output is printed on the same line
	* @param String line - hold string that is meant to be written to the ouput. 
	* @throws IOException - if the file cannot be opened
	*/
	public void writeToFileSL(String line) 
	{
		try
		{
			this.out = new PrintWriter(new BufferedWriter(new FileWriter("src/taskManager/output.txt",true))); 
			this.out.print(line); 
			this.out.close(); 

		}

		catch (IOException e)
		{
			e.printStackTrace(); 
			System.out.println("Problem opening output.txt");
		}

	}



}