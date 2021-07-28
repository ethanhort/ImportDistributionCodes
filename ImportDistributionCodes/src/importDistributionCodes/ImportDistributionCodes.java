/**
 * 
 */
package importDistributionCodes;

import java.util.concurrent.TimeUnit; 
import java.util.HashMap; 

/**
 * @author Ethan Horton
 * @version 0.0.1
 * @email ehorton14892@gmail.com, emha2017@mymail.pomona.edu
 *
 * Allocates grants based on percentage of time they have on admin report recorded to RCAP distribution. 
 * In the event that this system breaks while in use at CU, please contact me at the email address(es) above.
 */
public class ImportDistributionCodes { 
	private static final int RCAP_COL = 0; 
	private static final int HOURS_COL = 3; 

	/**
	 * @param args command line args
	 */
	public static void main(String[] args) {
		
		//create ui and get filepaths
		UIHandler ui = new UIHandler(); 
		
		//wait for user to finish selecting filepaths
		while (!ui.isFinished()) {
			try {
				TimeUnit.SECONDS.sleep(1); 				
			} catch (Exception e) {
				
			}
		}
		
		String distCodePath = ui.getDistCodePath();
		String adminPath = ui.getAdminPath(); 
		
		//get hashmap of dist code keys correlated to hours
		HashMap<String, Double> report = new AdminReport(adminPath, RCAP_COL, HOURS_COL).getHashMap(); 
		
		
		
		//testing purposes only
//		System.out.println(adminPath);
//		System.out.println(distCodePath);

	}

}
