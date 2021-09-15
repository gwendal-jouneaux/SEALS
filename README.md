# SEALS: A framework for building Self-Adaptive Virtual Machines

## Prerequisites

- Running on Linux
- Download [GraalVM CE (Java 8)](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-20.3.3)
- Install Maven
- Install the `cloc` command (see [here](http://cloc.sourceforge.net/))
- Install Jupyter Notebook
- Clone this repository


## Setup GraalVM as the default JVM

To setup GraalVM as the default JVM, you need to :
1. Uncompress the archive (see prerequisites)
2. Set the JAVA_HOME variable
3. Add the bin folder to the PATH

Example :
```bash
tar xvfz graalvm-ce-java8-linux.tar.gz
export JAVA_HOME="path/to/graalvm-ce-java8-linux/folder"
export PATH="$JAVA_HOME/bin:$PATH"
```


## Install and configure Ibex (for the ChocoSolver)
```bash
wget https://github.com/ibex-team/ibex-lib/archive/ibex-2.8.8.tar.gz
tar xvfz ibex-2.8.8.tar.gz
mv ibex-lib-ibex-2.8.8/ ibex-2.8.8
cd ibex-2.8.8
chmod -R 777 *
./waf configure --lp-lib=soplex
./waf install
cd plugins/
wget https://github.com/ibex-team/ibex-java/archive/1.0.0.tar.gz
tar xvfz 1.0.0.tar.gz
mv ibex-java-1.0.0/ ibex-java
cd ..
./waf configure --enable-shared --with-jni --java-package-name=org.chocosolver.solver.constraints.real
./waf install
./waf configure --enable-shared --with-jni --java-package-name=org.chocosolver.solver.constraints.real
./waf install
./waf install
```

## Build the artifacts

Place yourself at the root of the cloned repository and type 'mvn install'.
This command should build all the artifacts needed to produce the results.

## Compute the lines of code

To generate the summary of lines of code for each VM, run `./loc-computer.sh` at the root of the repository. It will generate a file named `LinesOfCode.md` with the number of lines of code (Java & Xtend) for the VMs developed with and without the framework.

## Benchmark the Virtual Machines

To benchmark the VMs we provide a script to launch the experiment. This script is used as follows :
```bash
./benchmark.sh LANG TYPE TRY
```

LANG is the language to benchmark (HTML, RobLANG, MiniJava)

TYPE is the type of the VM (Framework or Handcraft)

TRY is the number of the batch (I, II, III)

For each VM (pair LANG and TYPE) we performed 3 TRY (I, II, III), and the computer was rebooted before each benchmark.

Then, the `./preprocess.sh` script will transform the raw data to something exploitable in the `analysis/data` folder.

## Analyzing the benchmark results

To analyze the results we provide a Jupyter Notebook in the analysis folder.
This notebook performs the analysis of the benchmark results for all the VMs with three TRY each.