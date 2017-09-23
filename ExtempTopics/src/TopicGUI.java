import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class TopicGUI {
	private JFrame main;
	private JLabel title, askAreas, askTopics;
	private JPanel area, topic, header, submitArea, status;
	private JTextField areasBox, topicsBox;
	private JButton submit;
	private int numAreas, numTopics;
	
	public TopicGUI(){
		
		main = new JFrame();
		main.setLayout(new GridLayout(5,1));
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(600, 400);
		main.getContentPane().setBackground(new Color(252,251,227));
		
		title = new JLabel("Topic Chooser");
		title.setFont(title.getFont().deriveFont((float) 30));
		askAreas = new JLabel("Number of Topic Areas:");
		askTopics = new JLabel("Number of Topics in each:");
		
		areasBox = new JTextField(2);
		topicsBox = new JTextField(2);
		
		area = new JPanel();
		area.add(askAreas);
		area.add(areasBox);
		area.setBackground(new Color(252,251,227));
		
		topic = new JPanel();
		topic.add(askTopics);
		topic.add(topicsBox);
		topic.setBackground(new Color(252,251,227));
		
		header = new JPanel();
		header.add(title);
		header.setBackground(new Color(252,251,227));
		
		submitArea = new JPanel();
		submit = new JButton("Submit");
		submitArea.add(submit);
		submitArea.setBackground(new Color(252,251,227));
		
		status = new JPanel();
		status.setLayout(new BoxLayout(status, BoxLayout.PAGE_AXIS));
		status.setBackground(new Color(252,251,227));
		
		main.add(header);
		main.add(area);
		main.add(topic);
		main.add(submitArea);
		main.add(status);
		
		main.setVisible(true);
		
	}
	
	public static void main(String[] args){
		TopicGUI screen = new TopicGUI();
		screen.prepareInteract();
	}
	
	
	private class Topic{
		private int area;
		private int quest;
		
		public Topic(int area, int quest){
			this.area = area;
			this.quest = quest;
		}
		
		public int getArea(){
			return area;
		}
		
		public int getQuest(){
			return quest;
		}
		
		public String toString(){
			return "Area: " + area + " Question " + quest;
		}
		
	}
	
	public void prepareInteract(){
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				numAreas = Integer.valueOf(areasBox.getText());
				numTopics = Integer.valueOf(topicsBox.getText());
				ArrayList<Topic> questionList = new ArrayList<Topic>();
				Topic temp = new Topic((int)(Math.random()*numAreas)+1, (int)(Math.random()*numTopics)+1);
				while(questionList.size()<3){
					if(!questionList.contains(temp)){
						questionList.add(temp);
					}
					temp = new Topic((int)(Math.random()*numAreas)+1, (int)(Math.random()*numTopics)+1);
				}
				status.removeAll();
				JLabel tempo;
				//String questVal = "";
				for(Topic t: questionList){
//					questVal += t.toString();
//					questVal += " || ";
					tempo = new JLabel(t.toString());
					tempo.setAlignmentX(Component.CENTER_ALIGNMENT);
					status.add(tempo);
					main.repaint();
				}
				
				//status.add(new JLabel(questVal));
				main.repaint();
				//main.setVisible(false);
				main.setVisible(true);
			}
		});
		

		
	}
	
	
}
