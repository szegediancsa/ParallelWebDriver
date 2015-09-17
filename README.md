#ParallelWebDriver#
“Selenium Grid is a part of the Selenium Suite that specializes on running multiple tests across different browsers, operating systems, and machines in parallel.
Selenium Grid has 2 versions - the older Grid 1 and the newer Grid 2.”

Selenium Grid uses a hub-node concept:
-	Hub: The test are running on a single machine called hub.
-	Node: Different machines called nodes do the execution.

For further information go to
http://code.google.com/p/selenium/wiki/Grid2
http://www.seleniumframework.com/intermediate-tutorial/what-is-selenium-grid/

##Folder Structure##
I used the https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/ page to lead my design.

You should create a similar structure on your drive:
![folderstructure](https://cloud.githubusercontent.com/assets/13963353/9488338/a47b03c6-4bd9-11e5-9243-991e310734c9.png)

##Run the Demo##
Run the testng.xml as TetNG Suite in Eclipse.

##Technology Stack##
-	Java 1.8
-	TestNG 6.9.4
-	Remote WebDriver 2.47.1
-	Eclipse IDE Mars
