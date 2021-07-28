package importDistributionCodes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UIHandler {

	private JFrame frame;
	private String adminPath, distCodePath;  
	private boolean finished; 

	public UIHandler() {
		
		//initialize UI window
		frame = new JFrame("Loan Payment Bridge"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		finished = false; 

		//create top level panel to contain all other UI components
		JPanel panel = new JPanel(); 
		frame.add(panel); 
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		//create UI elements and add them to top-level panel 
		panel.add(createAdminFileBrowser());
		panel.add(createRCAPFileBrowser()); 
		panel.add(submitPanel()); 
		
		

		frame.setVisible(true);
	}

	public JPanel createAdminFileBrowser() {
		JPanel browserPanel = new JPanel(); 
		browserPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Admin Allocation Report"));

		//initialize file chooser, button, and label to choose report from NLS and display filepath
		JFileChooser pathChooser = new JFileChooser(); 
		JButton browseButton = new JButton("Browse"); 
		JLabel pathLabel = new JLabel(""); 

		//set file chooser so user can only choose excel spreadsheets
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
		pathChooser.setFileFilter(filter); 

		//action listener for file browser button
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//chosen = APPROVE_OPTION only if a file is chosen in the browser
				int chosen = pathChooser.showOpenDialog(null);

				//get path of chosen file and display in UI
				if (chosen == JFileChooser.APPROVE_OPTION) {
					adminPath = pathChooser.getSelectedFile().getAbsolutePath();
					pathLabel.setText(adminPath); 
				}
			}
		});
		
		browserPanel.add(pathLabel); 
		browserPanel.add(browseButton); 
		return browserPanel; 
	}
	
	public JPanel createRCAPFileBrowser() {
		JPanel browserPanel = new JPanel(); 
		browserPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "RCAP Distribution Codes"));

		//initialize file chooser, button, and label to choose report from NLS and display filepath
		JFileChooser pathChooser = new JFileChooser(); 
		JButton browseButton = new JButton("Browse"); 
		JLabel pathLabel = new JLabel(""); 

		//set file chooser so user can only choose excel spreadsheets
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
		pathChooser.setFileFilter(filter); 

		//action listener for file browser button
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//chosen = APPROVE_OPTION only if a file is chosen in the browser
				int chosen = pathChooser.showOpenDialog(null);

				//get path of chosen file and display in UI
				if (chosen == JFileChooser.APPROVE_OPTION) {
					distCodePath = pathChooser.getSelectedFile().getAbsolutePath();
					pathLabel.setText(distCodePath); 
				}
			}
		});
		
		browserPanel.add(pathLabel); 
		browserPanel.add(browseButton); 
		return browserPanel; 
	}
	
	public JPanel submitPanel() {
		JPanel submit = new JPanel(); 
		JButton submitButton = new JButton("Submit");
		JLabel submitLabel = new JLabel(""); 
		submitLabel.setForeground(Color.red);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (adminPath != null && distCodePath != null) {
					finished = true; 
					frame.dispose();
				} else {
					submitLabel.setText("Please ensure both files have been selected.");
				}
			}
		});
		
		
		submit.add(submitLabel);
		submit.add(submitButton); 
		return submit; 
	}
	
	public boolean isFinished() {
		return finished; 
	}
	
	public String getAdminPath() {
		return adminPath;
	}
	
	public String getDistCodePath() {
		return distCodePath;
	}
}
