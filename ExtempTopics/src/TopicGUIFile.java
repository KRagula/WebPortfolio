import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class TopicGUIFile {
	private JFrame entry, mainScr;
	private JComboBox choices;
	private JButton loadMain, loadTopics;
	private String[] qOptions = {"Domestic","International","Both"};
	private JLabel headerEnt, headerMain;
	
	public TopicGUIFile(){
		setup();
		prepareGUI();
	}
	
	private void prepareGUI(){
		
	}
	
	private void setup(){
		entry = new JFrame("Topic Area");
		entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainScr = new JFrame("Topics");
		mainScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadMain = new JButton("Choose Area");
		loadMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				entry.dispose();
				mainScr.setVisible(true);
			}
		});
		
		
		loadTopics = new JButton("Get Topics");
		loadTopics.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}