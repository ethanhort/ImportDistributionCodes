package importDistributionCodes;

import java.util.HashMap;
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class AdminReport {
	HashMap<String, Double> map;
	
	public AdminReport(String filePath, int RCAP_col, int hours_col) {
		map = new HashMap<>(); 
	}
	
	public HashMap<String, Double> getHashMap() {
		return map; 
	}
}
