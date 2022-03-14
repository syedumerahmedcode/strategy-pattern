# rough notes[TO BE DELETED LATER]

- Strategy pattern can be seen as another name for dependency injection.

- We have an input configuration as follows:
 ** We have a distribution of a number of variables.
 ** We sample these distributions.
 ** And some computation is done on them.
 ** In our example, we will flip the coin randomly and then print the results in some way.
 
 Each simulation represents a world which we want to run. So, if there is a for loop which runs 10 times then, there are 10 worlds which we simulation. In each of which, the coin flip produces random results.
 
 - The logic for writing the output of the coin flipper is where we intend to use startegy pattern. 
 
- Current time stamp: 08:13