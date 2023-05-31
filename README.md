# Big data consumer with Spring

## Description 
This is a small project to practice consuming Kafka events with Spring.

Mind the mess! This project is meant to be a sandbox for experiments, not an example of clean code... yet.

Hints and feedback are much appreciated!

## Requirements
- Java 1.8
- Maven
- Docker
- Apache Kafka

## Installation
You need Apache kafka running on port 9092 on your local machine (customizable).

There is a `docker-compose.yaml` (disclaimer! not my creation!) in the root of the project, so you can use
`docker compose up -d`.

After that, it is as simple as running a Spring boot application
`mvn spring-boot:run`

## How to use
The application starts consuming events right before starting