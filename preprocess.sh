#!/bin/bash

for file in $(ls results)
do 
    grep -o "real.*" results/$file | sed 's/real\t0m\([0-9.]*\)s/\1/' > analysis/data/$file
done