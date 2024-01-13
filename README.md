# FizzBuzz Challenge Project

This project is a solution to the FizzBuzz challenge, implemented as a Spring Boot application with a RESTful API.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [Endpoints](#endpoints)
    - [Examples](#examples)
- [Testing](#testing)
- [Built With](#built-with)

## Introduction

The FizzBuzz challenge is a classic programming problem often used in coding interviews. This project provides a simple and scalable solution to generate FizzBuzz sequences and track statistics.

## Features

- **Generate FizzBuzz Sequences:** Create FizzBuzz sequences based on input parameters.
- **Statistics:** Track and retrieve statistics on generated FizzBuzz sequences.


## Getting Started

### Prerequisites

- Java 17
- Maven
- Git

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/fizzBuzz.git
    ```

2. Navigate to the project directory:

    ```bash
    cd fizzBuzz
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

## Usage

### Endpoints

- **Generate FizzBuzz Sequence:**
    - `GET /fizzbuzz/generate?int1={}&int2={}&limit={}&str1={}&str2={}`

- **Statistics:**
    - `GET /fizzbuzz/statistics`

### Examples

#### Generate FizzBuzz Sequence:

```bash
curl -X GET "http://localhost:8080/fizzbuzz/generate?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz"
```
#### Statistics
```bash
curl -X GET "http://localhost:8080/fizzbuzz/statistics"
```

### Testing

The project includes unit tests to ensure the correctness of the implementation. Run the tests using:
```bash
mvn test
```
## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java-based enterprise applications.
- [Maven](https://maven.apache.org/) - Dependency management and build tool.
- [JUnit](https://junit.org/junit5/) - Testing framework.
