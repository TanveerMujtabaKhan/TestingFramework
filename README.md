# TestingFramework

I have created this maven testing framework based on Page objected basis where I have created a class for every page and adding necessary methods in that class.

In Test Folder, I have created 2 TC classes from where I call the methods of nnecessary action.

In config.properties file , I have listed website URL, browser and even customer details & Payment Details ( Due to time constraints I couldn't able to use test data excell to get the Data).

I have used TestNG testing framework, I have created an testng.xml where i have put the testcase to run.


Cross Browser :

Change the browser name in config.properties file ( src\main\java\configurations\config.properties) and change the browser to either chrome or firefox

For Google Chrome ----- chrome
For FireFox ------------ firefox


Directory Details :
1- Config.properties currently has application url and execution Platform

Location : src\main\java\configurations\config.properties


2- Base class contains generic method like initialization Driver, browser and
other selenium action which is extended across different classes


Location : src\main\java\base\Base.java


3- Methods are placed based on page object model where the page name is
class name.


Location : src\main\java\pages


4- Test folder has main test case where we are calling other methods.


Location : src\test\java\dkatalis\Test_TanveerMujtabaKhan

Steps to run using command :

How to Install & run :

1- Import the project as Maven project and install the maven dependencies by
doing “Maven Install” from the IDE

or

using terminal, go inside the product and do "mvn install"


2- Once installation is complete, there will be zero errors.
Run testing.xml which has test classes to run by 2 way:
1- right click on xml and run as TestNG
2- using command prompt with the command

“mvn clean test -DsuiteXmlFile=testing.xml”


Even you can run by going to the particular test class and run as TestNG

Test class Name :
1- TC_01successPurchaseFlow
2- TC_02FailedPurchaseFlow

Extent Report:

Once you run testng.xml,

you will get the html report in project directory ./
