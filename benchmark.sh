#!/bin/bash

LANG=$1
TYPE=$2
TRY=$3

if [ ! -d "results" ];
then 
	mkdir results
fi

if [ $LANG == "MiniJava" ]; then
    export ADAPTABLE_PERFORMANCE=99
    export ADAPTABLE_ACCURACY=1 
    if [ $TYPE == "Framework" ]; then
        for i in {1..30}
        do
            { time java -jar Framework.languages/MiniJava/execute/target/execute.jar programs/sobel.xmi &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    else
        for i in {1..30}
        do
            { time java -jar Handcraft.languages/MiniJava/selfadaptable-minijava.lang.interpreter.execute/target/execute.jar programs/sobel.xmi &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    fi
fi

if [ $LANG == "RobLANG" ]; then
    export CONF_PATH=/home/gjouneau/Documents/Recherche/SAVM-Framework/RobLANG/webots/Interpreter/controllers/conf.txt
    if [ $TYPE == "Framework" ]; then
        for i in {1..30}
        do
            { time java -jar Framework.languages/RobLANG/standalone/target/RobLANG.standalone-0.0.1-SNAPSHOT-jar-with-dependencies.jar programs/program.rob &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    else
        for i in {1..30}
        do
            { time java -jar Handcraft.languages/RobLANG/standalone/target/Handcraft.RobLANG.standalone-0.0.1-SNAPSHOT-jar-with-dependencies.jar programs/program.rob &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    fi
fi

if [ $LANG == "HTML" ]; then
    export ADAPTABLE_HTML_ACCURACY=50
    export ADAPTABLE_HTML_ENERGY=50
    if [ $TYPE == "Framework" ]; then
        for i in {1..30}
        do
            { time java -jar Framework.languages/HTML/execute/target/HTMLlauncher.jar programs/wikipedia.html &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    else
        for i in {1..30}
        do
            { time html programs/wikipedia.html &> /dev/null; } 2>> "results/${LANG}_${TYPE}_${TRY}.txt"
        done
    fi
fi
