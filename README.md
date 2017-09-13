* TOC
{:toc}


# Programming II Portfolio

## Projects

### Virus Champion


![alt text](https://kragula.github.io/Programming-II-Portfolio/VirusChampion/Screenshots/TitleScreen.png "Title Screen")
![alt text](https://kragula.github.io/Programming-II-Portfolio/VirusChampion/Screenshots/InstructionScreen.png "Instructions Screen")

Simulate a white blood cell eliminating the bacteria in order to prevent them from splitting in two and harming the host.  WASD for movement and control.  Mouse to fire.  Mitosis launches a smaller white blood cell at the bacteria, killing on impact.

Features:
<ul>
<li> Vertical Scroller</li>
<li> Progressively Harder Levels</li>
<li> Score Counter</li>
<li> Educational Screens on each Infection</li>
</ul>

![alt text](https://kragula.github.io/Programming-II-Portfolio/VirusChampion/Screenshots/Cellsgame.png "Gameplay")
![alt text](https://kragula.github.io/Programming-II-Portfolio/VirusChampion/Screenshots/Cellsend.png "Game Over")


Download Instructions:

1. Go to link [here](https://drive.google.com/open?id=0ByM0es_F6i1FekhHdDZrZEtseEU)
2. Download File
3. Unzip Enclosed Folder
4. Double Click .exe file

[Source Code](https://github.com/KRagula/Programming-II-Portfolio/tree/master/VirusChampion/src)

### Empirical Formula Solver

The empirical formula of a molecule is the relative number of elements in a molecule.  
This program will take in the values of percents of atoms in an unknown molecule, calculate the amount of each atom in the molecule, and then return the Empirical Formula of the molecule.

Currently, I will be using an enum for the elements created by @felixdivo

The Program takes in the number of elements the user wants to calculate for (max 5).  

![alt text](https://kragula.github.io/Programming-II-Portfolio/EmpiricalFormulaSolver/Screenshots/EmpirFormEntry.png)

The user enters values for elements and percents and the compound is returned to the user.  

![alt text](https://kragula.github.io/Programming-II-Portfolio/EmpiricalFormulaSolver/Screenshots/CalculatorScreen.png)

The option to see the steps taken to get to the final result is available after a calculation has been done.

![alt text](https://kragula.github.io/Programming-II-Portfolio/EmpiricalFormulaSolver/Screenshots/InstructionsCalc.png)

This will be displayed using Swing.  All numbers will be estimates to the best the program can do.

Steps to Download
1. [Download File Here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/EmpiricalFormulaSolver/EmpirFormulaSolver.zip)
2. Unzip folder
3. Open index.html and choose option (note: Video of Product too large to zip into GitHub.

Repo [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/EmpiricalFormulaSolver)

### Tanker Truck Calculator

This program was my first attempt in the 2016-17 School Year at creating a standalone application using Java Swing.  This program was the testing
This program takes the estimated lifetime, amount of water drunk per day, and name of a user to return how many 11,000 gallon tanker trucks of water the user will drink in their lifetime.  

![alt text](https://kragula.github.io/Programming-II-Portfolio/TankerTruckGUI/Screenshots/TankerCalc.png)
![alt text](https://kragula.github.io/Programming-II-Portfolio/TankerTruckGUI/Screenshots/ResultsTanker.png)

Steps to Run
1. [Download File Here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/TankerTruckGUI/TankerTruck.jar)
2. Run jar

Repo [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/TankerTruckGUI)

### World Population

This program This program simulates the population of earth every fifty years
during either a time of peace or during a zombie apocalypse with the user
playing as God.

![alt text](https://kragula.github.io/Programming-II-Portfolio/WorldPopulation/Screenshots/WorldPopScreen.png "Display")

This interactive console application stores the current world population in millions and then asks the user if it is a zombie apocalpyse or a time of peace.  The population is then changed accordingly.

![alt text](https://kragula.github.io/Programming-II-Portfolio/WorldPopulation/Screenshots/EndScreen.png "Display")

Steps to run:
1. Download .class file [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/WorldPopulation/WorldPopulation.class)
2. Open command line and navigate to downloads directory
3. Enter the following command: **java WorldPopulation**

Repo [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/WorldPopulation)

### Flood Map
This class reads terrain values and a water level value and determines which terrain will be above the water or flooded.

A Map is randomly generated with terrain of different altitudes.

![alt text](https://kragula.github.io/Programming-II-Portfolio/FloodMap/Screenshots/FloodMapAlt.png "Display")

The map is then slowly flooded in increments of 10 until it is full.

![alt text](https://kragula.github.io/Programming-II-Portfolio/FloodMap/Screenshots/FloodMapPartial.png "Partial")

![alt text](https://kragula.github.io/Programming-II-Portfolio/FloodMap/Screenshots/FloodMapFull.png "Display")

(The altitudes and displays are from two different runs of the application)

Steps to run:
1. Download .class file [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/FloodMap/FloodMap.class)
2. Open command line and navigate to downloads directory
3. Enter the following command: **java FloodMap**

Repo [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/FloodMap)

### Roaches Viewers

A collection of two different displays for simulating a population of cockroaches.

The first class, RoachPopulationViewer, displays an interactive GUI to modify and change the values of the population of
roaches.  It also has an exterminator come every 10 seconds to kill 10% of the population

GUI

![alt text](https://kragula.github.io/Programming-II-Portfolio/Roaches/Screenshots/RoachViewerStart.png)

![alt text](https://kragula.github.io/Programming-II-Portfolio/Roaches/Screenshots/RoachViewerDouble.png)

The second class, RoachSimulation visualizes the growth of a roach population over a timeframe of 10 generations.  A timer waits
1/2 of a second before either doubling the population or killing a portion of the population.  The simulation lasts 10 seconds.

Start:

![alt text](https://kragula.github.io/Programming-II-Portfolio/Roaches/Screenshots/RoachesPartial.png)

End:

![alt text](https://kragula.github.io/Programming-II-Portfolio/Roaches/Screenshots/RoachesFinal.png)

Instructions to download:
1. Visit links here for [RoachPopulationViewer](https://github.com/KRagula/Programming-II-Portfolio/blob/master/Roaches/RoachPopulationViewer.jar) or [RoachSimulation](https://github.com/KRagula/Programming-II-Portfolio/blob/master/Roaches/RoachSimulation.jar)
2. Download jar file
3. Run jar file

Repo [here](https://github.com/KRagula/Programming-II-Portfolio/blob/master/Roaches)

<footer>
    		<ul>
        		<li><a href="mailto:k.ragula1@gmail.com">Contact Me</a></li>
        		<li><a href="https://github.com/KRagula">My Github Profile</a></li>
            
