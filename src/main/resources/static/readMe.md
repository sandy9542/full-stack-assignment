# test-service

## Functionalities
- create scholarships, update,get list, delete

## Requirements
For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Building the application locally
- Run the command below in your **_terminal/command prompt_**
```shell
mvn --settings=settings.xml clean package
```

## Running the application locally
- First goto the application class and start the main method but in this project I am not given any data connection application can't be start 

### Using Intellij Run Configuration
- Update the profile in **_bootstrap.yml_** and change the config uri to _**localhost:8888**_
- Run/Debug the application by using Intellij Run Configuration.

### Spring Boot Maven Plugin 
- Run the command below in your **_terminal/command prompt_**
```shell
mvn --settings=settings.xml spring-boot:run
```

## Copyright
Copyright © 2022 ACE ONLINE. All rights reserved.