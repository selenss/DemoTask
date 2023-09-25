# DemoSelenium

# Requirements
## Installations
1. JAVA  https://www.oracle.com/java/technologies/downloads/)https://www.oracle.com/java/technologies/downloads/ 
2. JDK   https://docs.oracle.com/en/java/javase/20/install/overview-jdk-installation.html 
3. MAVEN https://maven.apache.org/download.cgi 
4. chromedriver
   4.1. If Chrome version is 115 or newer --> https://googlechromelabs.github.io/chrome-for-testing/#stable
   4.2. If Chrome version is 114 or older --> https://chromedriver.chromium.org/downloads
5. IntelliJ IDEA Community Edition ( https://www.jetbrains.com/idea/download/ ) 

## Configurations
1. JDK configuration in Intellij https://www.jetbrains.com/help/idea/sdk.html#define-sdk
2. "apiKey" in src/main/java/methods/base/BaseAPI.java (Please register in https://rapidapi.com/apidojo/api/yahoo-finance1/ and save your own apiKey)
3. chromedriver file (downloaded in the section Installations, Step #4) path should be added to src/main/java/methods/base/BaseTest.java. 
4. This project uses chromedriver (for MACOS and Chrome V.117) as src/main/java/drivers/chromedriver and it does not require any action.
5. If you would like to continue another chromedriver file, you can upload the file to src/main/java/drivers folder and change the path as;
   System.setProperty("webdriver.chrome.driver", "<your_path_to_chromedriver_file>");

## Test Execution
1. Build project (Go to Build > Build Project)
2. From terminal go to your project folder and execute "mvn clean install"

## Test Report
1. After test execution is completed, you can reach test report in target/surefire-reports/emailable-report.html
   
