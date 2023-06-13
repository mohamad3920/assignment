# An Expense Tracker

This is Expense Tracker that helps to manage expenses.

You can define categories with expense limitation and then put all your related expenses to them, and the app warn you when your limit has reached.

It is able to work with multiple users with their own uniq category and expenses.

First you need to sign up in app with calling /createUser service with username and password to create user, then you have to call /authenticate to login. this service gives you jwt token for calling all other services.  

All those services provided with swagger.

This app uses h2 for storing data on disk.
### Prerequisites
JDK (17)

Maven

### Installation and Usage

1- Clone the repository

2- Run mvn package to build the project

3- Run the project itself or run java -jar target/application-0.0.1-SNAPSHOT.jar to run the application