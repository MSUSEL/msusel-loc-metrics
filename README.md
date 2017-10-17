# MSUSEL LoC Metrics

## Introduction
This module provides a language independent method of collecting LoC measures for a variety of LoC metrics.

Currently we include the following LoC counts:

* SLOC - Source Lines of Code
* BLOC - Blank Lines of Code
* CLOC - Comment Lines of Code
* CSLOC - Comment and Source Lines of Code

Although the code is written in a language independent way, it does require the construction of profiles for
each language it can support. Currently the following languages are included in the default set of profiles:

* Java
* C#
* C++
* C
* Bourne Shell
* Ruby

## Goals
The main goal is to provide the capability to analyze the following metrics:

* SLOC - Source Lines of Code
* BLOC - Blank Lines of Code
* CLOC - Comment Lines of Code
* CSLOC - Comment and Source Lines of Code
* DCLOC - Documentation Comment Lines of Code
* HCLOC - Header Comment Lines of Code
* HCWORD - Header Comment Words
* SLOC-L - Source Lines of Code - Executable Logical
* SLOC-P - Source Lines of Code - Executable Physical

For the top 100 programming languages as identified by the TIOBE and PYPL indexes.

The second goal is to provide not only the ability to analyze a single file or group of files,
but to simply analyze any provided text. We have met this goal.

## Installing Maven

This project uses the Maven wrapper so that you do not need to install maven manually.
The first time you go to build this project, simply execute the following command:

```
./mvnw clean install -Dmaven.test.skip=true
```
or for windows:
```
.\mvnw.cmd clean package -Dmaven.test.skip=true
```

## Building

This project can be built using the following command:

```
./mvnw clean package -Dmaven.test.skip=true
```

This project can be compile, tested, or packaged with the following commands:

```
./mvnw clean compile
./mvnw clean test
./mvnw clean package
```