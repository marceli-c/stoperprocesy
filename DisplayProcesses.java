package procesy; 

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DisplayProcesses {
	public static String result;
	public static String result2;
	
	public static void Display(List processes) {
		
		
		result="";
		int p=0;
		Iterator<String> it = processes.iterator();
		int i = 0;
		while (it.hasNext()) {
			
			result += it.next() +"\n";
			i++;
			//if (i==12) {
			//		result += "\n";
			//		i = 0;
			//}
		}
		
		
		
	}
	public static String Display2(List processes) {
		
		//Collections.sort(processes);
		//java.util.Collections.sort(processes);
		result2="";
		int p=0;
		Iterator<String> it = processes.iterator();
		int i = 0;
		while (it.hasNext()) {
			
			result2 += it.next() +" , ";
			i++;
			if (i==12) {
					result2 += "\n";
					i = 0;
			}
		}
		return result2;
	}
	
	public static String getResult(){
		return result;
	}
}
