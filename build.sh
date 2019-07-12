#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java Simulation scenario.txt