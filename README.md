# SEALS: A framework for building Self-Adaptive Virtual Machines

In this artifact submission, we provide the implementation of the three SEALS-based Self-Adaptive Virtual Machines and the three handcrafted Self-Adaptive Virtual Machines (HTML, RobLANG and MiniJava).

This artifact provides a Maven-based build for the artifact as well as scripts to reproduce the benchmarking experiment and the lines of code count.
Additionally, we provide a Jupyter notebook to analyze the results of the benchmarking experiments.

## Prerequisites

- Running on Linux
- Download [GraalVM CE (Java 8)](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-20.3.2)
- Install Maven
- Install the [webots simulator](https://github.com/cyberbotics/webots/releases/tag/R2021b)
- Install the `cloc v1.9` command (from [here](https://github.com/AlDanial/cloc/releases/tag/v1.90))
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
cd plugins/
wget https://github.com/ibex-team/ibex-java/archive/1.2.0.tar.gz
tar xvfz 1.2.0.tar.gz
mv ibex-java-1.2.0/ ibex-java
cd ..
./waf configure --enable-shared --with-jni --java-package-name=org.chocosolver.solver.constraints.real
./waf install
```

## Configure RobLANG interaction with Webots

To ensure the correct build of RobLANG artifacts, you will have to provide the path to the `Controller.jar` file in your webots installation.
If you installed webots from `snap` this path will look like : 
```
/snap/webots/19/usr/share/webots/lib/controller/java/Controller.jar
```
Copy this path in the `webots.controller.lib` property in the `pom.xml` file at the root of the repository.

## Build the artifacts

To build the artifacts, place yourself at the root of the cloned repository and type 'mvn install'.
This command should build all the artifacts needed to produce the results.

## Compute the lines of code

To generate the summary of lines of code for each VM, run `./loc-computer.sh` at the root of the repository. It will generate a file named `LinesOfCode.md` with the number of lines of code (Java & Xtend) for the VMs developed with and without the framework.
The total number of lines of code for each VMs is the sum of the `code` column in the generated report (`LinesOfCode.md`).

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
> For the notebook to work correctly it is mandatory to perform all the benchmark before !
