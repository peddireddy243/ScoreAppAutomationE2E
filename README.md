# Mobile Automation Testing Framework

This mobile automation testing framework is designed for automating test cases for Android(Not limited to) applications using Appium, Cucumber, TestNG, and Log4j for logging. The framework supports dynamic execution and detailed reporting using ExtentReports including screenshots.


## Prerequisites

### System Requirements
- Java Development Kit (JDK) 11 or higher
- Android SDK
- Xcode (for iOS testing)
- Node.js and npm (for Appium server)
- Appium installed globally (`npm install -g appium`)
- Appium Desktop (optional, for manual inspection and debugging)
- Gradle build tool

### Tools and Libraries
- Appium
- Selenium
- Cucumber
- TestNG
- Log4j
- ExtentReports
- 

### Setup Instructions

1. **Install Java**
    - Download and install JDK 11
    - Set up the `JAVA_HOME` environment variable.

2. **Install Android SDK**
    - Download and install Android Studio
    - Set up the `ANDROID_HOME` environment variable.
    - Add `platform-tools` and `tools` to your PATH.
    - set up Android Emulator Pixel 8 Pro, 13.0 version
   
3. **Install Node.js and npm**
    - Download and install Node.js 

4. **Install Appium Server**
   ```bash
   npm install -g appium
   ```

### Changes Required to Run the Test
- In CapablitiesFile.json located as mentioned below update "**deviceName**", "**deviceVerison**" capability based on your device
    ```bash
   src/test/resources/CapabilitiesFile.Json
   ```
- Alternatively if you are running on a real device and/or have the app installed add these capabilities in addition to the above step
    ```bash
       "appPackage": "com.fivemobile.thescore",
       "appActivity": "com.fivemobile.thescore.ui.MainActivity"
    ```
- Configure testNg by providing suite path navigating to the location below
   ```bash
      src/test/resources/TestNg.xml
   ``` 

### Testing Approach
- Page Object Model (POM): Utilized Page Factory to initialize elements, ensuring a modular and maintainable structure for page objects.
- Cucumber TestNG Annotations: Employed Cucumber and TestNG annotations for setup and teardown processes, streamlining the execution flow.
- Base Objects Class: Reduced code duplication by extending the BaseObjects class. Created a public constructor and used the super() method to initialize objects from the BaseObjects class.
- Logging with Log4j: Implemented Log4j for logging. Configured appenders to log both to the console and ExtentReports, providing comprehensive logging.
- Comprehensive Reporting: Captured console logs, Appium server logs, and detailed step-by-step test execution logs, including screenshots, all stored in the TestOutput folder in the project root.
- Singleton Pattern for Driver Management: Applied the Singleton pattern to instantiate the driver, ensuring a single instance is used throughout the framework, enhancing efficiency and consistency.
### Further potential Enhancements 
- Jira and TestRail/Zephyr Integration: Integrate with Jira and TestRail/Zephyr to log test execution status automatically, improving traceability and test management.
- Jenkins Integration: Set up Jenkins to run scripts on remote devices, enabling continuous integration and delivery (CI/CD) and ensuring tests are run in a controlled and scalable environment.

Repo URL: `https://github.com/peddireddy243/ScoreAppAutomationE2E.git` and  
Repo Directory `https://github.com/peddireddy243/ScoreAppAutomationE2E/tree/main` 

