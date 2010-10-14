#1/bin/bash
CLASSPATH='-cp .:lib/core.jar:lib/controlP5.jar:lib/jl1.0.jar:lib/jsminim.jar:lib/minim-spi.jar:lib/minim.jar:lib/mp3spi1.9.4.jar:lib/tritonus_aos.jar:lib/tritonus_share.jar'
javac $CLASSPATH GUI.java
java $CLASSPATH GUI
