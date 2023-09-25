# DemoSelenium

# Requirements
## Installations
1. JAVA https://www.oracle.com/java/technologies/downloads/
2. JDK https://docs.oracle.com/en/java/javase/20/install/overview-jdk-installation.html 
3. MAVEN https://maven.apache.org/download.cgi
4. IntelliJ IDEA Community Edition https://www.jetbrains.com/idea/download/
5. Mozilla Firefox https://www.mozilla.org/en-US/firefox/new/
6. Chrome https://www.google.com/chrome/

## Configurations
1. JDK configuration in Intellij https://www.jetbrains.com/help/idea/sdk.html#define-sdk
2. Update "apiKey" in src/main/java/methods/base/BaseAPI.java (Please register in https://rapidapi.com/apidojo/api/yahoo-finance1/ and save your own apiKey)

## Test environment
In order to demonstrate cross browser testing, please execute tests in MacOS and/or Windows devices.

## Test Execution
1. Build project (Go to Build > Build Project)
2. From terminal go to your project folder and execute "mvn clean install"

## Test Report
1. After test execution is completed, you can reach test report in target/surefire-reports/emailable-report.html
   
