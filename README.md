#servicejectmodel-#API Automation #TestNG
prerequisite: Java is installed, IDE-eclipse/IntelliJ
API http://api.openweathermap.org/data/3.0/stations

conventions:- Above mention API is implemented in a microservices way, so model name and other naming conventions has been donein the same way

clone the project and can be run from command line or editor- mvn clean test
#Note:A Folder has been created as src/test/java/resourcesc.Ideally it should be src/test/resources.
#Technologies/Tools used in building the framework
- Eclipse - IDE
- Maven - Build automation tool
- Java - Programming language
- API library for automationRestAssurred
- TestNG - Test Management library
-Allure reports
#Framework is being implemented using best practices as describe below
POJO classes implementation of the services.--com.gk.openweather.station.model
Services has been implemented--com.gk.openweather.station.service
TestRunner- you can run the tests from com.gk.openweather.station.test==OpenweatherTestRunnerE2E.
JSON data handler has been defined on the runner class and data can be fetched from json to tests
JSON path usage to capture Attributes
-----------------------------------------------------------------------------------------------
Below are the few methods has been implemented-get()/post()/delete() apart from this there are six more tests
validateUserShouldableToCreatStation()- to create a station on openmaps.
validateUserIsAbleToDeleteStation()-To delete the latest station created
public void ValidateUserIsAbleToRunTherequestandGetsSuccessstatusCode.

Each method is being implemented as severity with allure feature 
How To use the Framework-
1)If you want to add any endpints- Naviagte to Class EndPoints & define it there and define method in OpenMapsStationApihelper
2)OR To write any new test case .Just call the helper class method in test for existing services or new.
rite the method in the test class.
After running the test allure results filder should generate
-------------------------------
#How to Generate Allure Reports
===============================
download https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.13.0/ for mac or windows
allure --version
Navigate to project directory & run allure serve allure-results

In order to generate a report, we should install Allure command-line interpreter.

Download the latest version as a zip archive from bintray.
Then, click the Files tab and then download the .zip file for windows. For Linux, you can download .tgz file. For Mac use brew to install allure.
Unpack the archive to allure-commandline directory.[C:\automationsoftware\allure-2.13.0\bin]

Navigate to bin directory.
Add allure to system PATH.

NOTE:-After importing the project you may see the error- Cannot switch on a value of type String for source level below 1.7. Only convertible int values or enum variables are permitted- please select the quickfix.(jre 1.7 & above]
-
