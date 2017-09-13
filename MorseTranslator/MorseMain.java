/** Morse Code Converter
 * 
 * Application that can convert to and from Morse Code.  Results can be copied and pasted
 * from the return and double checked in the other side.
 * Any punctuation or symbols that don't have a morse code translation are returned as a _.
 * All upper-case letters are reduced to lower case.
 * Relies on MorseRepo Enum.
 * 
 * @author Kanishka Ragula
 * @version 1.0.2
 * @since 12/09/2017
 * 
 * 
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class MorseMain {
	JFrame mainFrame, chooseFrame;
	JPanel textEntry, controlPanel;
	JTextField textBox;
	JTextArea returnText, entryText;
	JLabel entryHelp, returnHelp;
	
	/** Constructor of Morse Main
	 * Sets up the welcome screen
	 * 
	 * @param none
	 * @return nothing
	 */
	public MorseMain() {
		setupEntry();
	}
	
	/**Main static method.  Creates a new MorseMain class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MorseMain mm = new MorseMain();
	}
	
	/** Setup entry creates a new welcome screen and adds all necessary buttons and
	 * components.  Calls either the method for English to Morse or the method for
	 * Morse to English 
	 */
	public void setupEntry() {
		chooseFrame = new JFrame("Welcome to Morse Translator");
		chooseFrame.setLayout(new GridLayout(3,1));
		chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFrame.setSize(400, 200);
		
		JLabel welcome = new JLabel("Please choose to translate To or From Morse Code");
		String[] options = {"Morse To English","English to Morse"};
		final JComboBox jc = new JComboBox(options);
		jc.setSelectedIndex(1);
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int index = jc.getSelectedIndex();
				if(index == 0) {
					setupMorToEng();
				} else {
					setupEngToMor();
				}
				chooseFrame.dispose();
			}
		});
		chooseFrame.add(welcome);
		chooseFrame.add(jc);
		chooseFrame.add(next);
		chooseFrame.setVisible(true);
	}
	
	/** Creates window for translating English to Morse.  JTextArea used to take input
	 * and return output.  Button can be pressed to return to option switch.
	 * 
	 */
	public void setupEngToMor() {
		mainFrame = new JFrame("Morse Code Translator");
		mainFrame.setSize(400,500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(2,1));
		
		JLabel returnHelp = new JLabel("Return Morse Code");
		JLabel entryHelp = new JLabel("Enter English");
		
		controlPanel = new JPanel();
		returnText = new JTextArea(10,34);
		returnText.setLineWrap(true);
		returnText.setEditable(false);
		controlPanel.add(returnHelp);
		controlPanel.add(returnText);
		
		textEntry = new JPanel();
		entryText = new JTextArea(8,34);
		
		JButton translate = new JButton("Translate");
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entryText.selectAll();
				returnText.append(translateEng(entryText.getSelectedText()));
				returnText.selectAll();
				returnText.setCaretPosition(returnText.getSelectedText().length());
			}
			
		});
		
		JButton returnHome = new JButton("Switch Function");
		returnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				mainFrame.dispose();
				setupEntry();
			}
		});
		
		textEntry.add(entryHelp);
		textEntry.add(entryText);
		textEntry.add(translate);
		
		controlPanel.add(returnHome);

		
		mainFrame.add(textEntry);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}
	
	/** Creates window for translating Morse to English.  JTextArea used to take input
	 * and return output.  Button can be pressed to return to option switch.
	 * 
	 */
	public void setupMorToEng() {
		mainFrame = new JFrame("Morse Code Translator");
		mainFrame.setSize(400,500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(2,1));
		
		JLabel returnHelp = new JLabel("Return English");
		JLabel entryHelp = new JLabel("Enter Morse");
		
		controlPanel = new JPanel();
		returnText = new JTextArea(10,34);
		returnText.setLineWrap(true);
		returnText.setEditable(false);
		controlPanel.add(returnHelp);
		controlPanel.add(returnText);
		
		textEntry = new JPanel();
		entryText = new JTextArea(8,34);
		//textBox = new JTextField(34);
		JButton translate = new JButton("Translate");
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entryText.selectAll();
				returnText.append(breakString(entryText.getSelectedText()));
				returnText.selectAll();
				returnText.setCaretPosition(returnText.getSelectedText().length());
			}
			
		});
		
		JButton returnHome = new JButton("Switch Function");
		returnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				mainFrame.dispose();
				setupEntry();
			}
		});
		
		controlPanel.add(returnHome);
		
		textEntry.add(entryHelp);
		textEntry.add(entryText);
		textEntry.add(translate);
		

		
		mainFrame.add(textEntry);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}
	
	/**Method to take Morse input and break into individual letters.
	 * Uses getNormalVal to get English character.
	 * Combines letter array to make phrase.
	 * 
	 * @param toBreak String to convert into English
	 * @return English translation
	 */
	private String breakString(String toBreak) {
		String[] splitString = toBreak.split("/");
		String returnVal = "";
		for(String val: splitString) {
			returnVal += getNormalVal(val);
		}
		return returnVal;
	}
	
	/**Converts English to Morse Values
	 * Clears any white space to prevent errors
	 * Adds up the array into Morse code.
	 * 
	 * @param toBreak String to convert to Morse
	 * @return Morse Translation
	 */
	private String translateEng (String toBreak) {
		String newText = toBreak;
		String newText2 = newText.toLowerCase();
		newText2 = newText2.replaceAll("\\s", "");
		
		String[] values = new String[newText2.length()];
		for(int i=0; i<newText2.length(); i++) {
			values[i] = String.valueOf(newText2.charAt(i));
		}
		
		String returnVal = "";
		for(String engVal: values) {
			returnVal += getMorseVal(engVal) + "/";
		}
		
		return returnVal;
	}
	
	/**Converts a Morse code value into the corresponding
	 * String char value.  
	 * 
	 * @param morseVal Value to be converted
	 * @return Character corresponding to Morse value, _ if not found
	 */
	private String getNormalVal(String morseVal) {
		for(MorseRepo mRep: MorseRepo.values()) {
			if(mRep.morseVal().equals(morseVal)) {
				return mRep.text();
			}
		}
		return "_";
	}
	/**Converts a character value into the corresponding
	 * Morse Code Equivalent 
	 * 
	 * @param morseVal Value to be converted
	 * @return Character corresponding to English value, _ if not found
	 */
	private String getMorseVal(String engVal) {
		for(MorseRepo mRep: MorseRepo.values()) {
			if(mRep.text().equals(engVal)) {
				return mRep.morseVal();
			}
		}
		return "_";
	}
	
}
