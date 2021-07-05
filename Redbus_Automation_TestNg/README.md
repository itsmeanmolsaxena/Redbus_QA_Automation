## Redbus Automation Project

Hello, greetings of the day, hope you are doing well. I have created a Maven Project
in Eclipse IDE using java. Here is a step by step guide of this project. 

I will tell you how one can create the same project by following this README file.


##### @Introduction
We are going to automate 20 scenarios on redbus site. The basic framework used is TestNG.
Also, we are using selenium which is a portable framework.

This project will be developed in java and tested on chrome and firefox drivers.

We will read the test data from an excel file, global information will be given 
from the config file. The whole project has been implemented using POM (Page object model ).

##### @Prerequisites
1. Eclipse IDE

2. JDK 8 installed

3. Browsers you want to implement ( I have used firefox and chrome) 

4. Docker desktop installed 

5. Jenkins installed


##### @TestCases
We are gonna test various activities across different pages and in different flows. A basic 
overview of test cases are:-
1. Booking a bus. ----> ( 1 scenario )

2. applying filters. ----> ( 5 scenario )

3. Modifying the booking. ----> ( 4 scenario )

4. Wrong details verification in login (Mandatory validation).  ----> ( 1 scenario )

5. Blank field verification in login (Mandatory validation). ----> ( 1 scenario )

6. Checking offers at homepage. ----> ( 1 scenario )

7. Checking to manage booking button. ----> ( 1 scenario )

8. Redbus care activity in different payment modes. ----> ( 6 scenario )

##### @How to create a maven project
To create a maven project, you can follow this link

* https://www.toolsqa.com/java/maven/create-new-maven-project-eclipse/#:~:text=How%20to%20Create%20a%20New%20Maven%20Project%20in,%E2%80%98%20and%20click%20on%20Next.%20More%20items...%20

after setting maven project, just make below packages and folders where your files will be stored.

@packages :- 1. a package for pages
			 2. a package for test files
		3. a package for utilities

@folders :- 1. a folder for drivers (place driver.exe in this folder )
			 2. a folder for log files
		3. a folder for reports
		4. a folder for screenshots

##### @Testfile overview
1. BaseTest :- All the basic code like browser initilization, reporting, close browser,
loggers initilization and file handeling is done in base test file.

2. Screenshots :- A common method maintained in utility package to take screenshot after test.
 
3. in pages package :- We have located all the elements and corrosponding actions are created using methods.

4. in tests package :- We have written the test cases.	


##### @How to run 
There are many ways to run these tests.
1. For individual test, click the 'Run' button. It is between the @Test tag and method name.

2. To run all the test in a class, click 'Run all' button.It is just above the class name.

3. To run all the test cases in all the classes, go to testng.xml, right click and run as testng suite.

##### @Test Result
After test execution, we can see results in :

1. Log files :- Log files will give us an idea how our test executed.

2. Report :- A HTML report will be gerated after test execution.

3. Screenshot :- We have also added the screenshot to verify the test result.

#### @How to run tests

For a single test :- Click on the 'Run' option which is just below @Test tag.

for all the tests in Test Class - Click on 'Run All' option which is just above the class name.

For all the test cases :- Use Testng.xml to Run all test Classes by right click on Testng File -> Run As -> Testng suite.

##### @Jar file

We have created a reusable library to capture screenshot and imported it as a jar file.

##### @Headless Browsing

What is headless testing?


Headless testing is a technique for testing applications (or individual components
 inside applications) without displaying their visual elements. Generally, 
applications tested operate in a web browser with a graphical user interface, or 
GUI. Headless testing still tests the components, but skips the time- and 
resource-consuming process of rendering a visual display.

For headless mode, you need to update the config file.
Just keep the field true for headless and false for non headless.

##### @TestData.xlsx file 

It is an excel file, we are passing some data from this file.

###### Note :- Filter test cases are test data specific.

If the destination is 'Bareilly' and source is 'Delhi(all locations)', 
then only the test will be passed. Date can be changed in future. But as of now,
date is 16-July-2021 and tests are working fine.

##### @Report 

A HTML file is generated after test excution. Which is saved into Report folder.

##### @Refrenced Library

The reusable libray we have created is inside this folder.

##### @Contact 

For any information or discussion, please contact at

anmol.saxena@nagarro.com

OR


itsmeanmolsaxena@gmail.com

