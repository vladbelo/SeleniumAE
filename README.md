Project Title

Automation Exercise- Selenium

Introduction

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites

Java JDK, Selenium TestNg, and Maven

Installation: 

Step 1: Download and Install JAVA
Step 2: Download and Install Eclipse
Step 3: Download and Install FireBug
Step 4: Download Selenium WebDriver Chrome, Firefox, EdgeDriver
Step 5: Download TestNg
Step 6: Download Maven
Step 7: Jenkins Optional

 If you haven’t used Maven before in Eclipse then you may also need to install the Maven-Eclipse plugin.
You need to click on the Help->Install New Software. Enter http://download.eclipse.org/technology/m2e/releases in ‘Work with’ an click on Add.
Select Maven plugin. Click on Next and then Finish.

![Capture](https://user-images.githubusercontent.com/3719297/56313769-44001700-6108-11e9-84c5-584e7d710697.GIF)



Configuration Example: 

Testng.xml file  Running my test cases in different browsers.




![Capture1](https://user-images.githubusercontent.com/3719297/56313786-4d897f00-6108-11e9-89f7-0ffbc101386e.GIF)

Running the tests

TC_001_Verify_Page_Load_Google
TC_002_Verify_Search_Google_Page
TC_003_Verify_RitchieBros_Page.java

The test cases are executed using TestNG class. This class is the main class for running tests (unit tests) in the TestNg Framework. Select any test case and click ->(Run As)-> TestNg. In the testing framework, we created a class BaseTest. All page object classes will extend BaseTest, and inheriting all the base models. As a Project managing tool Maven is being used to execuite its job it helps to hold all the pieces  together. 

Deployment

Testing your application is a important  part of the deployment cycle. By running through tests before, during, and after deployment, you can improve the quality of your application and ensure a better product.

Usually you will run unit tests in your build, and black box tests  in your release build workflow after your app is deployed usually to QA. 

Built With

Selenium - Test web framework with Page Object style. 
Maven - Dependency Management
Java - language
TestNg - Unit Testing

Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

Authors

Vladimir Belonenko - Initial work 

License

This project is licensed under the MIT License - see the LICENSE.md file for details
