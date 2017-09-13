/** #Morse Repo Enum
 * 	Stores values of the character and morse code value
 * 
 * @author Kanishka Ragula
 * @version 1.0.1
 * @since 09/13/2017
 */
public enum MorseRepo {
	
	//List of Enum classes
	A("a", ".-"), B("b", "-..."), C("c","-.-."), D("d","-.."), E("e","."), F("f","..-."),
	G("g","--."), H("h","...."), I("i",".."), J("j",".---"), K("k","-.-"), L("l",".-.."),
	M("m","--"), N("n","-."), O("o","---"), P("p",".--."), Q("q","--.-"), R("r",".-."),
	S("s","..."), T("t","-"), U("u","..-"), V("v","...-"), W("w",".--"), X("x","-..-"), 
	Y("y","-.--"), Z("z","--.."), One("1",".----"), Two("2","..---"), Three("3","...--"),
	Four("4","....-"), Five("5","....."), Six("6","-...."), Seven("7","--..."),
	Eight("8","---.."), Nine("9","----."), Zero("0","-----"),
	Apostro("'", ".----."), Comma(",","--..--"), 
	Perio(".",".-.-.-"), Quest("?","..--.."), Empty("", "_"), Empty2("_","");
	
	//Member variables of enum
	private String rVal, morseVal;
	
	/**Default constructor for Enum classes
	 * 
	 * @param rVal Real value in English
	 * @param morseVal Morse code value
	 */
	MorseRepo(String rVal,String morseVal){
		this.rVal = rVal;
		this.morseVal = morseVal;
	}
	
	/**Returns English value
	 * 
	 * @return
	 */
	public String text() {
		return rVal;
	}
	public String morseVal() {
		return morseVal;
	}
}
