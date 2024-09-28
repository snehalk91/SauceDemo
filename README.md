# SauceDemo-Automation

# Overview
This repository contains an automation framework built using TestNG to test the SauceDemo web application. It includes tests for functionalities like checkout processes, sorting features, and price sorting.

# Prerequisites
Before you can run the tests locally, ensure you have the following installed:

Java JDK: Version 8 or higher.
Maven: For managing dependencies and running the tests.
Browser:
Firefox (make sure to have the latest stable version).
GeckoDriver (for Chrome and Firefox, respectively) compatible with your browser version.

# Setup Instructions
1. Clone the Repository
   First, clone the repository to your local machine:
   git clone https://github.com/snehalk91/SauceDemo-Automation.git
2. Navigate to the Project Directory
   Change your working directory to the cloned repository:
   cd SauceDemo-Automation
3. Build the Project
   To compile the project and download the necessary dependencies, execute the following command:
   mvn clean install
4. Configuration
   Ensure that the WebDriver executables (GeckoDriver) are properly set in your system path or specify their location in your test scripts.

# Running Tests
Using TestNG XML
To run the tests defined in the testng.xml file, execute the following command:
mvn test

# Test Execution Logs/Reports
After running the tests, you can find the generated reports in the target/surefire-reports directory. These reports contain detailed information about each test execution.

# Conclusion
This automation framework provides a structured approach to testing the SauceDemo web application using TestNG. Follow the setup instructions to run the tests locally and explore the generated reports.

# Repository Access
This repository is publicly accessible for review and collaboration.
