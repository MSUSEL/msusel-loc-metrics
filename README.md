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

## Building the module
This module's build management is handled by Maven. Thus to currently build and package the JAR files associated
with this project one need only enter the following command:

`mvn clean package -Dmaven.test.skip=true`

(NOTE: the addition of the `-Dmaven.test.skip=true`, this is required as the tests are not yet written)

This will produce a `target` directory in which two JAR files will appear. Both JAR files are executable but
only one will have all the dependencies compiled into the JAR (it is marked in an obvious way).

## Deploying to the Maven Repository on BitBucket
As this module evolves it will need to be placed in the SparQLine Analytics, LLC bitbucket maven repository.
This can be accomplished by simply executing the following command (for the main brach of the git only):

`mvn deploy -Dmaven.test.skip=true`

(NOTE: the addition of the `-Dmaven.test.skip=true`, this is required as the tests are not yet written)
