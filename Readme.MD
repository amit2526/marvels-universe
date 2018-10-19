# Welcome to Marvels Universe

This is a Single Player Console based role playing game.
Where the universe is in danger and different planet is captured by different enemies. 
As a user you have to play game, fight with enemies and save the universe
 
For more details see story.txt in src/main/resources, or
Run game in story mode.

## Assumptions
* This game is designed for Single player.
* Player have to create a Character if he has to start new game.
* Once Enemy encountered while exploring, player have no options other then fighting.
* Player can not exit while fighting game.
* This game does not contains levels(Stages) for now.

## Requirements
* git
* jdk 1.8
* gradle 4.5

## Build
To build the project please execute the following command
```
$ git clone "https://github.com/amits2526/marvels-universe.git"
$ cd marvels-universe
$ gradle build
```

## Run
After the project is built please run the following command to launch the game
```
$ java -cp ./build/libs/marvels-universe-1.0-SNAPSHOT.jar org.game.rpg.Launcher
```
