package procesy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Procesy {

	public static List listRunningProcesses() {
		List<String> processes = new ArrayList<String>();
		try {
		String line;
		Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
		BufferedReader input = new BufferedReader
		(new InputStreamReader(p.getInputStream()));
		while ((line = input.readLine()) != null) {
		if (!line.trim().equals("")) {
		// keep only the process name
		processes.add(line.substring(0, line.indexOf("  ")));
		}


		}
		input.close();
		}
		catch (Exception err) {
		err.printStackTrace();
		}
		return processes;
		}
	
}