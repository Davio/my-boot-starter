# My Boot Starter
This project demonstrates how to setup your own Spring Boot Starter and how to use it in your services or modules.

## Requirements
- Java 14, you can use any JDK such as AdoptOpenJDK.
- Docker or Podman with either docker-compose or podman-compose

## Build
To build the project, run `mvnw install` to use the Maven wrapper or `mvn install` to use your own Maven

## Usage in applications or modules
To use the provided starter modules in your own application or module, you need to define `my-boot-starter-parent` as the parent of
your application / module. In a regular application, you can add `my-boot-starter` as a dependency and `my-boot-starter-test` as a
test dependency. To use a database, add both `my-boot-starter-data` as a regular dependency and `my-boot-starter-data-test` as a test
dependency.

## Sandbox
This project provides a Sandbox application in module `my-boot-starter-sandbox` to allow you to play around with the included starters.
You can test how they are used in an actual application.