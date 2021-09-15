#!/bin/bash

if [ ! -d "analysis/data" ];
then 
    cd analysis
	mkdir data
    cd ..
fi

for file in $(ls results)
do 
    grep -o "real.*" results/$file | sed 's/real\t0m\([0-9.]*\)s/\1/' > analysis/data/$file
done