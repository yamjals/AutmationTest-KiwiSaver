# AutmationTest-KiwiSaver

# Description

This Test Automation Framework is created using Java + Selenium Web Driver + TestNG + Maven Project. 

# Features
1. Page Modeling with Scripts
2. Object oriented Architecture
3. Rich TestNG test framework support [ http://testng.org/doc/index.html ]
4. Maven Support - Software project management and comprehension tool [ http://maven.apache.org/ ]
5. Support execution on latest firefox and Google Chrome and Internet Explorer browsers [windows only]

# Prerequisites Software/Tools
1. Git [ http://git-scm.com/downloads ]
2. Maven [ http://maven.apache.org/ ]
3. Java Development Kit 8
4. Java Runtime Environment 8
5. IDE [ Eclipse or IntelliJ IDEA ]

# Getting Started
1. Open the Git bash and clone the project using below command on the target directory: git clone https://github.com/yamjals/AutmationTest-KiwiSaver.git
2. Clone and import the project as existing Maven project in any Java IDE. You can run the program using any IDE like Eclipse or IntelliJ or from Jenkins but ensure Maven plugin is available.
3. There are 2 xml files    
   3a. TestNG.xml - This will run all the test sequentially and browser will close on every test complete.    
   3b. UserStories.xml - This will run based on the selected package i.e Test User Story1 or Test User Story2 or both. Test execution will run in parallel. Browsers will close only after finishing all the test.
4. pom.xml is defaulted to TestNG.xml. Please configure the pom.xml file based on how you want to run the test.
5. Open the windows command prompt and navigate to the project directory.
6. Run **mvn test** command to start the test (this command will clean, compile and run the test).
 
# Screenshot:
getScreenshot() is used to indicate driver to capture a screenshot and store it in '/"user.dir"/reports/' folder.

# Reporting:
The framework produce index.html report. It resides in the same '/"user.dir"/reports/' folder. This gives the link to all the different components of the TestNG reports like Groups & Reporter Output. This will display detailed description of executions.
