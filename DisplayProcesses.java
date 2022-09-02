package procesy; 

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DisplayProcesses {
	public static String result;
	
	
	public static void Display(List processes) {
		
		
		result="";
		int p=0;
		Iterator<String> it = processes.iterator();
		int i = 0;
		while (it.hasNext()) {
			
			result += it.next() +" , ";
			i++;
			if (i==12) {
					result += "\n\n";
					i = 0;
			}
		}
		
		
	}
	
	public static String getResult(){
		return result;
	}
}
