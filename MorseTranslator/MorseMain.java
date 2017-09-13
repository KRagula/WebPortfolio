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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MorseMain {
	
	//Declare variables
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
		
		//Set up JFrame
		chooseFrame = new JFrame("Welcome to Morse Translator");
		chooseFrame.setLayout(new GridLayout(3,1));
		chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFrame.setSize(400, 200);
		
		//Create items to add to JFrame
		JLabel welcome = new JLabel("Please choose to translate To or From Morse Code");
		String[] options = {"Morse To English","English to Morse"};
		final JComboBox<String> jc = new JComboBox<String>(options);
		jc.setSelectedIndex(1);
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int index = jc.getSelectedIndex();
				//Either choose Morse or English translator
				if(index == 0) {
					setupEngToMor(false);
				} else {
					setupEngToMor(true);
				}
				chooseFrame.dispose();
			}
		});
		
		//Add everything to JFrame
		chooseFrame.add(welcome);
		chooseFrame.add(jc);
		chooseFrame.add(next);
		chooseFrame.setVisible(true);
	}
	
	/** Creates window for translating Text.  JTextArea used to take input
	 * and return output.  Button can be pressed to return to option switch.
	 *  @param Boolean value to determine if going to Morse code or going to English
	 *  	true = Morse-> English
	 *  	false = English -> Morse
	 */
	public void setupEngToMor(final boolean toMor) {
		
		//Set up JFrame
		mainFrame = new JFrame("Morse Code Translator");
		mainFrame.setSize(400,500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(2,1));
		
		//JLabels to add to Frame
		if(toMor) {
			returnHelp = new JLabel("Return Morse Code");
			entryHelp = new JLabel("Enter English");
		} else {
			returnHelp = new JLabel("Return English");
			entryHelp = new JLabel("Enter Morse Code");
		}
		
		//Set up the panels and TextAreas and add labels
		controlPanel = new JPanel();
		returnText = new JTextArea(10,34);
		returnText.setLineWrap(true);
		returnText.setEditable(false);
		controlPanel.add(returnHelp);
		controlPanel.add(returnText);
		textEntry = new JPanel();
		entryText = new JTextArea(8,34);
		
		//Button to translate
		JButton translate = new JButton("Translate");
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(toMor) {
					entryText.selectAll();
					returnText.append(translateEng(entryText.getSelectedText()));
					returnText.selectAll();
					returnText.setCaretPosition(returnText.getSelectedText().length());
				} else {
					entryText.selectAll();
					returnText.append(breakString(entryText.getSelectedText()));
					returnText.selectAll();
					returnText.setCaretPosition(returnText.getSelectedText().length());
				}
			}
			
		});
		
		//Button to go back to selector
		JButton returnHome = new JButton("Switch Function");
		returnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				mainFrame.dispose();
				setupEntry();
			}
		});
		
		//Add last items to panels
		textEntry.add(entryHelp);
		textEntry.add(entryText);
		textEntry.add(translate);
		controlPanel.add(returnHome);
		
		//Add panels to frame
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
		
		//Remove the Whitespace
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
