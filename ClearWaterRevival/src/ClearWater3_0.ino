/*
TITLE: ClearWater Controller
Copywright 2/2/2016 Ragula Innovations LLC
## Need and open source license statement here

**********FIND THE CODE HERE *********************
Source code location: put url here
Open source code attributions:
  Name:      URL
************ CODING STYLES ************************
Coding styles: use these general styles. If other styles are used add them to this section as exceptions
 ## Classes: 
 Class names are nouns in UpperCamelCase, with the first letter of every word capitalised. 
 Use whole words avoid acronyms and abbreviations (unless the abbreviation is much more widely used than the long form, such as URL or HTML).  
 
 ## Methods & functions: 
 Methods are verbs in lowerCamelCase; that is, with the first letter lowercase and the first letters of subsequent words in uppercase. 
 
 ## Variables:
 Local variables, instance variables, and class variables are also written in lowerCamelCase, starting with with underscore (_). 
 Variable names should be short yet meaningful. The choice of a variable name should be mnemonic,
 that is, designed to indicate to the casual observer the intent of its use. 
 One-character variable names should be avoided except for temporary "throwaway" variables. 
 
 ## Constants: 
 Written in uppercase characters separated by underscores. 
 Constant names may also contain digits if appropriate, but not as the first character.
 
 ## Readability:
 -In general you are writing this code as a story that a diverse audience must be able to read. 
 -As the author your role is not to encrypt the story, rather to make it highly readable
 -Use #define to define and assign constants using descriptive names
 -Use #define to define and assign ports using descriptive names
 -Do not hard code values or constants rather use variable definitions. 
  -If you have to hard code a variable describe why and how to modify if necessary  
 -Do not use compacted syntax, expand code to make is simpler to read
 -Clearly incidate the opening and closure of conditional structures using comments next to braces  
 -Indent braces under (not inline) flow control structures left justified under the main structures element 
 -Use techniques that are easily understandble by a reader with average coding skills
 -Don't use tricks and techniques that arent necessary, obvious and understandable. If you have to then document as described below 
 -Use comments as psuedocode, comments should tell the story of how the code works, without having to read the code
 -Such as a timeout to describe a difficult area of code to understand
 -Such as a timeout to describe an area of code that had a tough to find bug
 -Such as a timeout to include as descrition of a bug and solution
 -Such as a timeout to describe any area of code that is alogorythmic
 -Such as a timeout to describe any "trick", syntax, technique not recognizable by an average programming skill
 -Such as a timeout to describe a timing dependent area of code
  
  Example:
  If (done == False)
  {  fu was done so do this "trick"
    matrix[MATRIX_EYES].drawBitmap(0, 0,blinkImg[
    (blinkCountdown < sizeof(blinkIndex))? blinkIndex[blinkCountdown] : 00], 8, 8, LED_ON);
     TIMEOUT: the ? in the above statement is the "ternary operator" whose syntac is [condition ? value_if_true : value_if_false].
    embeded in a function call to define the blinkimages drawing matrix array address).
    http://en.wikipedia.org/wiki/%3F:#C.2B.2B
    
  }  fu was not done so do the next statement
 
 
************ START DOCUMENTATION *******************
-----------------------
Architectural definition: describe the logical architecture
 ## What the system is: Describe the blocks that make up the architecture

 ## What the system does: Describe the theory of operation for the blocks and how they iteract
---------------------
Hardware: Describe the physical system
 ## Schematic: 
   Location/tool: location of the schematic source and name of tool used
   Name: Name of project files
   On the schematic inlude for all parts or subassemblies:
      Part Name:
  Part#
  Vendor:
  Speed:
  Purchase URL: 
 ## I/O Wiring: 
  Inputs/Output connections: 
   Analog inputs 
    Signal Name     Port
           Name:    port name
   Digital Outputs:-------------- 
    Signal Name     Port  Function 
           Name:    D?    what is does
    OnboardLED(red) D?    what it does 
  Add standards for BT and wireless hardware interfaces here
 ## Mechanics: Describe any special mechanical interfaces 
----------------
Software Build Process: Describe build software modules and tools
  ## TOOL CHAIN: Describe how the software was built using what tools
    EXAMPLE:
    -The ProTrinket is compatible with the arduino UNO except for missing pin 2 & 7
    -ProTrinket needs to be connected via the FDDI cable for serial console use
    -Uncomment the DEBUG #define to write to the serial console
    IDE: describe the how to build the code using the IDE 
   identify any quirks in using the IDE with the selected microcontroller
  Example
      -Use the aidafruit 1.0.5 version IDE, which is modified for trinkets
      -Will not instantiate a serial port so no need to set up com port and it is greyed out
      -Arduino IDE settings:
        -Programmer: use FDDI
        -Board: select ProTrinket FDDI
        -Errors: will get a compile error on Serial.begin function call if the incorrect board selected
  ## Coding notes: these are general coding notes intended to pass on learnings and techniques
      -Inputs need to be tied low or high otherwise they float (use 10k pulldown or use internal pullups) 
      -Turn on the input pullups by writing to an input port, this makes the inputs a LOW true activation
      Example: digitalWrite(D1, HIGH);       //when you write HIGH to an input pin the  pullup is activated
      -To save memory don't use "if" statements
      -Esc characters: ("\t"),("\n")
  ## Describe Non-volitile (EEPROM) structure:
    ADR    DATA NAME        BYTE
    x00    lower _fu  Low
    x01    upper _fu    High
    x02    lower _fubar   Low
    x03    upper _fubar   High
  ## Add standards for BT and wireless software interfaces here
*/
/* ----------------------
Change log records: describe each change associated with a release number
  Release 1.0:
  Date of release: 1/25/16
  Description of change: Innagural compile with turbidity sensor
  ******
  Release 2.0:
  Date of release: 2/5/16
  Description of change: Integration of Turbidity and pH meter hardware and drivers.
  First version of operational code.
  ******
    
Backlog: describe features/items that are backloged
  
  Expected Release #: 2.1
  Date of discovery: 2/5
  Description of backlog item: Take limit checking out of pH measure function
  ******

*/
//---------------------END DOCUMENTATION -------------------

// =================== START OF CODE =======================
// Includes:
//#include <EEPROM.h>   // for EPROM OPERATIONS
//#include <include name>
#include <SoftwareSerial.h>                           //we have to include the SoftwareSerial library, or else we can't use it
//Define CONSTANTS (format = UPPERCASE)
//#define DEBUG     // uncomment for debugging mode
//#define SIM     // uncomment for simulation mode
#define VERBOSE     // uncomment for console messages

//Structures for inline directives used with the above, copy in line with the code were used

/*
Format for DEBUG directives used in line with code:
#ifdef DEBUG
  //stuff to do in here  
#endif
*/

/*
Format for SIM directives used in line with code:
#ifdef SIM
  //stuff to do in here  
#endif
*/

/*
Format for VERBOSE directives used in line with code:
#ifdef VERBOSE
  //stuff to do in here  
#endif
*/

//set version #
#define VERSION "ClearWaterController 3.0" 

//Port Assignments:
//Define input and output pin #'s

#define TURBIDITYPORT A0 // Turbidity sensor wired (green wire) to A0
#define rx 2                                          //define what pin rx is on, this connects to the EZO transmit 
#define tx 3                                          //define what pin tx is on, this connects to the EZO recieve
  
//  Port Defintions
//#define BADWATERVALVEPORT 6
#define KEEPWATERVALVEPORT 7

  //#define ONBOARD 13   //the onboard led (red on Trinket Pro)

/*Delay constants
    #define DELAY1 1000  //
    #define DELAY2 500
  #define DELAY3 100 
*/
  
//LIBRARY INSTANTIATIONS
 SoftwareSerial myserial(rx, tx);                   //define an instance of the soft serial port  
  
//VARIABLE DEFINITIONS & INITIALIZATIONS
/*General variables (format = _lowerCamelCase)
  int _variableName; 
  byte _eeLowByte;    // byte conversion variables for EEPROM
  byte _eeHighByte;
*/
String inputstring = "";                            //a string to hold incoming data from the PC
String sensorstring = "";                           //a string to hold the data from the Atlas Scientific product
String okresponse = "OK";             // the ack response from the EZO with no error minus the *
String errorresponse = "ER";            // the ack response from the EZO if the command is unknown minus the *
boolean input_string_complete = false;              //have we received all the data from the PC
boolean sensor_string_complete = false;             //have we received all the data from the Atlas Scientific product
float pH;                       //used to hold a floating point number that is the pH
// combine these with the ones below
float pHHigh = 7.00;                //Upper value to test PH against                                         
float pHLow = 5.00;                 //Lower value to test PH against
boolean pHStatus;                 // the status returned when requesting a pH read
int const BADWATERVALVE = 1;            // assign a # to the valve that diverts bad water
int const KEEPWATERVALVE = 2;             // assign a # to the valve that diverts good water
boolean const ON = true;              // define on and off states states
boolean const OFF = false;
float upperGoodTurbidity = 4.00;          // turbidity ranges
float lowerGoodTurbidity = 2.00;
float upperGoodpH = 7.00;
float lowerGoodpH = 2.00;             // pH ranges
boolean goodpHDetected ;              // flags that water meets pH quality
boolean goodTurbDetected ;              // flags that water meets Turbidity quality


// ===================== INITIALIZE =========================

void setup()
{
  #ifdef VERBOSE
  Serial.begin(9600); // setup serial port if in debug mode
  #endif
  //Serial.println("Initializing ....");
  ///Serial.println(VERSION);              // output the version 
//  initializeValves();                 // turn valves off
  myserial.begin(9600);                               //set baud rate for the software serial port to 9600
  inputstring.reserve(10);                            //set aside some bytes for receiving data from the PC
  sensorstring.reserve(30);                           //set aside some bytes for receiving data from Atlas Scientific product
  okresponse.reserve(10);
  errorresponse.reserve(10);
//Initialize I/O  
   //OUTPUTS
  // Set the valve ports as outputs
//   pinMode(BADWATERVALVEPORT, OUTPUT);
   pinMode(KEEPWATERVALVEPORT, OUTPUT);
  /*  
   //Inputs   
   pinMode(PINNAME, INPUT);
   pinMode(PINNAME, INPUT_PULLUP); 
   /* Get values from non-vol for use later
    _eeLowByte = EEPROM.read(0);
    _eeHighByte = EEPROM.read(1);
    _eePromValue=((EELowByte << 0) & 0xFF) + ((EEHighByte << 8) & 0xFF00);
 */
 badWaterValveControl(ON);              // turn on BADWATERVALVE so there is a drain.
 //Serial.println(".......End initilization");
} 
//END SETUP

/*==================== MAIN ==================================
The main executive functions go here
*/

void loop()
{

#ifdef DEBUG
  //if in debug mode do this stuff 
#endif
// GET THE TURBIDITY VALUE
//Serial.println("");
//Serial.println(">... START Read Turbidity ...");
//Serial.println("> Reading Turbidity...");
float turbidity = measureTurbidity(1,false);      // ask for turbidty: take 1 sample, don't display
//Serial.print("> Turbidity returned as = ");
Serial.print(turbidity);
Serial.print(",");
//Serial.println(">... END Read Turbidity ...");
//GET THE pH Value
//Serial.println("");
//Serial.println(">... START Read PH ...");
pHStatus = requestpH();                 // ask for pH
if(pHStatus)
  { // report the waters pH quality 
  //Serial.println("> Keep Water PH");
  }
else
  {
  //Serial.println("> Bad Water PH");
  }
//Serial.print("> pH = ");
Serial.print(pH);
Serial.println(" ");
//Serial.println(">... END Read PH ...");
// decide the water quality
//Serial.println("");
//Serial.println("> Calculating water quality ....");
// calc pH quality
if (pH < upperGoodpH && pH > lowerGoodpH)
  {// pH is good
  //Serial.println("> pH in range");
  goodpHDetected = true;        // set the good water detected flag
  }
else // pH is not good
  {
  //Serial.println("> pH out of range");
  goodpHDetected = false;       // set the good water detected flag
  }
// calc turbidity quality
if (turbidity < upperGoodTurbidity && turbidity > lowerGoodTurbidity)
  {//Turbidity is good
  //Serial.println("> Turbidity in range");
  goodTurbDetected = true;      // set the good water detected flag
  }
else // Turbidity is bad
  {
//Serial.println("> Turbidity out of range");
  goodTurbDetected = false;       // set the good water detected flag
  }
  
// Consolidate water quality flags and then control valves  
if(goodpHDetected && goodTurbDetected)
{
  //Serial.println("");
  //Serial.println("OH YA! GOOD WATER DETECTED");
  //Serial.println(">... Adjusting Valves ...");
  badWaterValveControl(OFF);              // turn off the BADWATERVALVE
  //Serial.println(">... END Adjust Valves ...");
}
else
{
  //Serial.println("");
  //Serial.println(">... Adjusting Valves ...");
  badWaterValveControl(ON);             // turn on the BADWATERVALVE
  //Serial.println(">... END Adjust Valves ...");
}
//Serial.println("");
//Serial.println("> Turning valves off");
//initializeValves();

} //--------------- END MAIN LOOP

// -----------------FUNCTIONS ---------------

/* ================== VALVE CONTROL =====================
Description: turns on or off the BADWATERVALVE and does the inverse to the KEEPWATERVALVE
Pased Paramters: valvestate: true = on, false = off
Return: nothing
*/

void badWaterValveControl(boolean valveState)
{

boolean badWaterState = OFF;
boolean keepWaterState = OFF;
//digitalWrite(BADWATERVALVEPORT, valveState);    // write the valveState (1 or 0) to the valve port
badWaterState = valveState;
keepWaterState = !valveState;           // invert the valvestate as the new KEEPWATER state
                          //if BADWATERVALVER is ON we want KEEPWATERVALVE off and visa versa
digitalWrite(KEEPWATERVALVEPORT, keepWaterState); // if the BADWATER valve is ON turn OFF the KEEPWATERVALVE & visa versa
//Serial.print("BADWATER valve ");
if(badWaterState)
  {
  //Serial.println("ON");
  }
else
  {
  //Serial.println("OFF");
  }
//Serial.print("KEEPWATER valve ");
if(keepWaterState)
  {
  //Serial.println("ON");
  }
  else
  {
  //Serial.println("OFF");
  }


}
/* ================== INITIALIZE VALVES =====================
Description: turns both valves off
Pased Paramters: none
Return: nothing
*/

void initializeValves()
{
//  digitalWrite(BADWATERVALVEPORT,OFF);    // turn both valves off
  digitalWrite(KEEPWATERVALVEPORT,OFF); 
  //Serial.print("BADWATER valve ");
  //Serial.println("OFF");
  //Serial.print("KEEPWATER valve ");
  //Serial.println("OFF");
  return; 
}


/*
 ================== Turbidity) =====================
Description: function that reads the Turbidity sensor
Pased Paramters:
  _measureCycles = # of measurement cycles
  _avgFlag = TRUE takes an average over _measureCycles # of cycles otherwise FALSE takes one measurement
  _display = TRUE prints the results to console
  Returns: Float of the averaage of the measurements, even if there is just one reading   
*/

float measureTurbidity(int _measureCycles,boolean _display)
  {

   float _ntuTotal = 0;
   int _turbiditySensorValue;
   float _turbidityVoltage;
   float _ntu;
   for(int i=1; i <= _measureCycles; i++)
   {
    _turbiditySensorValue = analogRead(TURBIDITYPORT);// read the input on analog pin 0:
    _turbidityVoltage = _turbiditySensorValue * (5.0 / 1024.0); // Convert the analog reading (which goes from 0 - 1023) to a voltage (0 - 5V):
    _ntu = _turbidityVoltage; // make a NTU equal to the voltage for now, need a conversion table.
    delay(50); // settling time
    _ntuTotal = _ntu + _ntuTotal;// update the a cumulative value for averaging
    if(_display == true)
    {// output to console if _diplay is true
    Serial.println(">> Reading turbidity sensor ....");
    Serial.print(">> A/D= ");
    Serial.print(_turbiditySensorValue);
    Serial.print("\t");
    Serial.print("V=");
    Serial.print(_turbidityVoltage); // print out the voltage
    Serial.print("\t");
    Serial.print("NTU = ");
    Serial.println(_ntu);
    Serial.print(">> NTU Cume Total ="); // debug
    Serial.println(_ntuTotal); // debug
    }
   }
  // averaging the readings.
  float _ntuAvg = _ntuTotal/_measureCycles; // takes the average of the readings 
  
  if(_display == true)
  {// output to console if _diplay is true
    Serial.print(">> ... NTU Average =");
    Serial.println(_ntuAvg);
  }
  _ntuTotal = 0;
  return (_ntuAvg); 
  }

/* ================== REQUEST pH =====================
Description: requests a single pH reading from the Atlas Scientific EZO. Stays in this function until a PH reading and OK response from EZO 
Pased Paramters: none
Return: true if the reading is in range of water to be saved, false otherwise. pH is saved in global pH variable.
*/  
    
float requestpH()
{
boolean pHInRange = true;
boolean _cmdResponseReceived;
char inchar;
  //Serial.println(">> Sent \"R\" cmnd to probe ");
  myserial.print("R");                  // send a single reading request "R"
  myserial.print('\r');                 // send a CR endging
  recieveProbeResponse();                 // first get the PH reading from EZO
  //Serial.print(">>> Response from probe = ");
  //Serial.println(sensorstring);
  if (isdigit(sensorstring[0])) 
  { //if the first character in the string is a digit
      pH = sensorstring.toFloat();                        //convert the string to a floating point number so it can be evaluated by the Arduino
      //Serial.print(">> Formatted pH = ");
    //Serial.println(pH);
    if (pH >= pHHigh) 
    {//if the pH is greater than threshold
        //Serial.println(">> pH is high");                    //print "high" this is demonstrating that the Arduino is evaluating the pH as a number and not as a string
      pHInRange = false;
    }
      if (pH <= pHLow) 
    {//if the pH is less than threshold
        //Serial.println(">> pH is low");                     //print "low" this is demonstrating that the Arduino is evaluating the pH as a number and not as a string
      pHInRange = false;
    }
    }
  sensorstring = "";  
  recieveProbeResponse();                 // then get the ack from EZO 
  //Serial.print(">>> Ack from probe = ");
  //Serial.println(sensorstring);
  sensorstring = "";  

 return(pHInRange);
}

/* ================== RECIEVE (GET) PROBE RESPONSE =====================
Description: collects a full response from the EZO (a CR terminated string) and returns 
Pased Paramters: none
Return: none. @return sensorstring holds the response
*/

void recieveProbeResponse()
{
  boolean _cmdResponseReceived = false;             //reset the ack flag for the 'R' command
  while (!_cmdResponseReceived)
  {//stay here until a CR is recieved
    while (myserial.available()) 
      { //stay here receiveing char until a CR detected
      char inchar = (char)myserial.read();              //get the char we just received
      sensorstring += inchar;                           //add the char to the var string called sensorstring
      //Serial.println(inchar);             // debug
      if (inchar == '\r') 
      { //if the incoming character is a <CR> it is the end of the string
        //Serial.print("Response from probe = ");
        //Serial.println(sensorstring);
        //sensorstring = "";                                //clear the input string
        _cmdResponseReceived = true;            //the PH value was received so set the Received flag
        break;                      // 
      }
     }
  }    
  return;
}
  
  
  
  
  
/* ================== SERIAL EVENT =====================
Description: this special function is called after Loop()if the hardware serial port_0 has received a charserialEvent 
Pased Paramters: none
Return: none
*/
void serialEvent() 
{                                             //
  inputstring = Serial.readStringUntil(13);           //read the string until we see a <CR>
  input_string_complete = true;                       //set the flag used to tell if we have received a completed string from the PC
}



/* ================== FUNCTIONS (format = lowerCamelCase) =====================
Description:
Pased Paramters:
void functionName()
{
return;
}
*/

/*Print dump tables template
  Parameters: none
  Return value: none
*/
/*
void dumpLog()
{
    // Print table header
    Serial.println("----START DUMP----");
    Serial.println("***Table title ***");
    Serial.print("Col 1 Title");
    Serial.print("\t");
    Serial.print ("Column2 title");
    Serial.print("\t");
    Serial.println ("Column3 Title");
  // print a record
    Serial.print(variable1);
    Serial.print("\t");
    Serial.print("\t");
    Serial.print(tvariable2);
    Serial.print("\t");
    Serial.print("\t");
    Serial.println(variable3);
    Serial.println("---END DUMP--- ");
    Serial.println ();
  return;
 }
*/
 /* Writing to EEPROM
  // dissasemble word into two bytes for writing to EEPROM
  _eeLowByte=((variable >> 0) & 0xFF);  //get just the lower byte
  _eeHighByte=((variable >> 8)& 0xFF);  //shift to get get the upper byte
  word_value = ((EELowByte << 0) & 0xFF) + ((EEHighByte << 8) & 0xFF00); //reassemble the word
  EEPROM.write(0,EELowByte);  // write to EEPROM in sequence
  EEPROM.write(1,EEHighByte);
*/
  
