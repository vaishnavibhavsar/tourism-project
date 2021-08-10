package projectGraph;

import java.util.*;

public class Tour_Feel extends TimerTask {
	ArrayList<String> traversal; // variable to store traversal

	Tour_Feel(ArrayList<String> a) {
		traversal = a;
	}

	int i = 0; // variable to keep count of spots crossed
	Timer spot_disp = new Timer(); // Timers to display spots and following paths
	Timer line1 = new Timer();
	Timer line2 = new Timer();
	
	@Override
	public void run() {
		
		System.out.println("\t                                                     >>>>> Current Stop: "
				+ traversal.get(i) + " <<<<<");
		// Timer scheduled after spot display
		spot_disp.schedule(new TimerTask() {
			@Override
			public void run() {
				if (i <= (traversal.size() - 1)) {
					System.out.println("\t\t\t\t                                              |");
				}
			}
		}, 1500);

		// Scheduling timers for line path display
		line1.schedule(new TimerTask() {
			@Override
			public void run() {
				if (i <= (traversal.size() - 1)) {
					System.out.println("\t\t\t\t                                              |");
				}
			}
		}, 1900);

		line2.schedule(new TimerTask() {
			@Override
			public void run() {
				if (i <= (traversal.size() - 1)) {
					System.out.println("\t\t\t\t                                              |");
				}
			}
		}, 2300);

		i++;
		// condition to cancel and close all timers
		if (i == traversal.size()) {
			    System.out.println("\n====================================================================================================================================================================================================================================================================");
				System.out.println("\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/");
				System.out.println("/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\");
				System.out.println("====================================================================================================================================================================================================================================================================");
				System.out.println("\t\t\t\t\t\t\tकिन्तु फ़िलहाल घर पर रहें, सुरक्षित रहें");
			cancel();
			line1.cancel();
			line2.cancel();
			spot_disp.cancel();
			System.exit(0);
		}
	}// End of function

}
