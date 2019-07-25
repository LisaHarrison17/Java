#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java simulation.Simulation scenario.txt 
rm simulation/*.class