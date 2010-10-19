#!/bin/bash
CLASSPATH='-cp .:lib/core.jar:lib/controlP5.jar'
javac $CLASSPATH PS4.java
java $CLASSPATH PS4
