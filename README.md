# JGroup Leader Election
This project implenets a distrubted nodes which may run in same or diffirenet machines. 
Distrubuted system is implemented by jGroup using multicast protocol. Leader election method is implemented by getting first joined node to cluster.

### How to run

There is a runnable app in ```/dist``` folder. Unzip ```leader-election-1.0.0.zip file``` file and run ```./leader-election``` for linux and mac os or ```leader-election.bat``` for windows.


This will start a node in current network

### Build Manual

You can build project by ```./gradlew clean build```

### Quality
Test are written in groovy spcok. Findbug and Checkstyle are integrated as gradle plugin.