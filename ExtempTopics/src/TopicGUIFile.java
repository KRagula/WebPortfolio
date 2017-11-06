/**<h1>Topic Chooser for Extemporaneous Speaking</h1>
 * 
 * Randomly selects a topic to speak on from a list of questions.  Questions are unique until every question in the list has been exhausted.
 * 
 * @author Kanishka Ragula
 * @version 1.5.0
 * @since 11/06/2017
 * 
 */


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class TopicGUIFile {
	
	private ReadTopics fileRead;
	private JFrame entry, mainScr;
	private JComboBox choices;
	private JButton retEnt, loadTopics, loadNewTopics;
	private JLabel headerEnt, headerMain;
	private String[] questions;
	private JPanel qPanel;
	
	public static void main(String[] args) {
		TopicGUIFile gui = new TopicGUIFile();
	}
	
	/**Main constructor.  Creates an instance of the class and displays the UI
	 * 
	 */
	public TopicGUIFile(){
		setup();
		prepareGUI();
	}
	
	/**Display's the GUI.  Has to be run after setup.
	 * 
	 */
	private void prepareGUI(){
		entry.setVisible(true);
	}
	
	/**Sets up every aspect of the user interface.  
	 * 
	 */
	private void setup(){
		
		//Initialize different panels and arrays
		final String[] areas = {"Combined", "National", "Foreign"};
		fileRead = new ReadTopics();
		JPanel temp = new JPanel();
		JPanel temp2 = new JPanel();
		questions = new String[3];
		qPanel = new JPanel();
		
		//Setup of the header for the entry sccreen
		headerEnt = new JLabel("Choose a Topic Area");
		headerEnt.setHorizontalAlignment(JLabel.CENTER);
		headerEnt.setFont(new Font("Calibri", Font.PLAIN, 23));
		
		//Set up the entry window
		entry = new JFrame("Topic Area");
		entry.setSize(200, 300);
		entry.setLayout(new GridLayout(4,1));
		entry.setResizable(false);
		entry.add(headerEnt);
		entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JCombo Box for selecting area
		choices = new JComboBox(areas);
		temp.add(choices);
		entry.add(temp);
		
		//Button to accept selected value and call appropriate file
		loadTopics = new JButton("Load Questions");
		loadTopics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				entry.dispose();
				mainScr.setVisible(true);
				fileRead.init((String) choices.getSelectedItem());
				String[] temp = fileRead.request();
				//Display value of questions when main screen is rendered
				qPanel.add(new JLabel("<html>"+temp[0] + "<br>"+temp[1] + "<br>"+temp[2] + "</html>"));
			}
		});
		temp2.add(loadTopics);
		entry.add(temp2);
		
		

		//Set up main screen
		mainScr = new JFrame("Topics");
		mainScr.setLayout(new GridLayout(4,1));
		mainScr.setSize(850, 400);
		mainScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScr.setResizable(false);
		
		//Set up the header for the main screen
		headerMain = new JLabel("Questions:");
		headerMain.setHorizontalAlignment(JLabel.CENTER);
		headerMain.setFont(new Font("Calibri", Font.PLAIN, 23));
		
		//Button to return back to entry
		retEnt = new JButton("Return to Area Chooser");
		retEnt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				qPanel.removeAll();
				mainScr.dispose();
				entry.setVisible(true);
				
			}
		});
		
		//Refresh the page to get three new unique questions
		loadNewTopics = new JButton("Get New Topics");
		loadNewTopics.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String[] temp = fileRead.request();
				qPanel.removeAll();
				qPanel.add(new JLabel("<html>"+temp[0] + "<br>"+temp[1] + "<br>"+temp[2] + "</html>"));
				qPanel.revalidate();
				qPanel.repaint();
			}
		});
		
		
		//Add final touches to main screen
		mainScr.add(headerMain);
		mainScr.add(qPanel);
		mainScr.add(retEnt);
		mainScr.add(loadNewTopics);
		
	}
}