import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadTopics {
	
	//Values for the class
	private int ticker = 0;
	private String[] questions, rquestions;
	private ArrayList<Integer> nums;

	public void init(String file) {
		//Create an array to return later on.  Initialized here just in case file error needs to be described.
		rquestions = new String[3];
		
		/**Try BufferedReader.  If file doesn't exist, will throw an error and given accordingly in rquestions.
		 * 
		 */
		try {
			BufferedReader questionReader = new BufferedReader(new FileReader("bin//" + file + ".txt"));
			String str = null;
			List<String> list = new ArrayList<String>();
			
			//Reads the file
			while ((str = questionReader.readLine()) != null) {
				list.add(str);

			}
			
			//Converts the ArrayList to a String Array
			questions = list.toArray(new String[list.size()]);
			
			//Creates a randomized list of numbers and assignment values.
			nums = new ArrayList<Integer>(list.size());
			for (int i = 0; i < list.size(); i++) {
				nums.add(i);
			}
			Collections.shuffle(nums);
			
			//Get the first set of questions
			rquestions[0] = questions[nums.get(0)];
			rquestions[1] = questions[nums.get(1)];
			rquestions[2] = questions[nums.get(2)];

		} catch (IOException ie) {
			//If file cannot be found.
			rquestions = new String[3];
			rquestions[0] = "Error";
			rquestions[1] = "Reading";
			rquestions[2] = "File";
		}
	}
	
	/**Method to return three questions from the list.  Calling consecutively will return different
	 *  questions.  Once all questions have been exhausted, question list shuffled
	 * @return Three random questions
	 */
	public String[] request() {
		
		//If the question list has been exhausted, reset and reshuffle
		if(nums.size() == 0) {
			return rquestions;
		} else if(ticker+2>=nums.size()) {
			ticker = 0;
			Collections.shuffle(nums);
		}
		
		//Set the values to be returned
		rquestions[0] = questions[nums.get(ticker)];
		rquestions[1] = questions[nums.get(ticker+1)];
		rquestions[2] = questions[nums.get(ticker+2)];
		ticker+=3;
		
		
		return rquestions;
	}

}