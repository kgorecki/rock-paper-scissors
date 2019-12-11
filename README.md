# Rock-Paper-Scissors-Lizard-Spock
Simple Rock-Paper-Scissors like game with 2 variants: traditional and inspired by The Big Bang Theory

## Installing
mvn clean install

## Testing
mvn test

## Running
Binaries created by Maven:  
java -jar target/rock-paper-scissors-lizard-spock-0.0.1-SNAPSHOT.jar  
There are also pre-built binaries:  
java -jar binaries/rock-paper-scissors-lizard-spock-0.0.1-SNAPSHOT.jar

## Usage:
Server runs at port 8080 (configurable by server.port property in application.properties) and provides 2 endpoints:
* /api/rock-paper-scissors
* /api/rock-paper-scissors-lizard-spock

Both endpoints requires the same parameter: choice.  
Both endpoint are supporting GET, POST and PUT methods, so you can play for example with your browser, example: http://localhost:8080/api/rock-paper-scissors-lizard-spock?choice=spock
