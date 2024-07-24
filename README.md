# strategy-pattern

## Table of content
- [Introduction](#introduction)
- [Out Of Scope](#out-of-scope)
- [Explanation Strategy Pattern](#explanation-strategy-pattern)
- [Explanation Other Important Points](#explanation-other-important-points)
- [Technologies Used](#technologies-used)
- [Prerequisities](#prerequisities)
- [Commands](#commands)
- [Contribution](#contribution)
- [References](#references)
- [Contact Information](#contact-information)

## Introduction

The aim of this project is to showcase how can one use strategy pattern to describe a bunch of algorithms, put each of them into a separate class, and make their objects interchangeable. 

In simple words, it allows us to change the algorithm independently without changing the client using it. Strategy pattern can be seen as another name for dependency injection.--


## Out Of Scope

Since the main idea is to implement strategy method pattern in code, tests are out of scope of this project. 

## Explanation Strategy Pattern

**Background**

**Inheritance cases in which not all methods must be implemented in child classes:** 

While inheritance is great at sharing behavior of parent class with its sub classes, there are time when it is not desired to implement methods in child classes. Please consider the following scenario:

We have a parent class: 
- **Duck** which has the following methods: _display()_ and _fly()_. Here, the methods do exactly what they are named.

Now, we create a child class:
- **CityDuck** and it can also override _display()_ and _fly()_ without any problems.

Additionally, we can also create a child class:
- **WildDuck** and it can also override _display()_ and _fly()_ without any problems.

However, if we create a child class:
- **RubberDuck** then we have a problem as _display()_ method is overridden without any problems but if does not make any sense to override _fly()_ method as a rubber duck does not fly. Unfortunately, we must do it (probably with an empty implementation) as we are required by inheritance to do so. 

Also, in the future, if a method to Duck class is introduced, it must be implemented in all of its sub classes regardless of the fact it makes sense or not.

Another interesting scenario is that sometimes there are certain methods(or behaviors) which are shared across <ins>_some_</ins> child classes but <ins>_not all_</ins> child classes.  
  
This is where using strategy pattern makes sense as described below.

**Strategy Pattern**

The definition of Strategy pattern from `Gang of Four` is as follows:

```text

"Define a family of algorithms, encapsulate each one, and make them interchangeable. 
Strategy lets the algorithm vary independently from clients that use it."

```

Strategy pattern uses composition. Due to this nature, we can extract out the behavior into separate interfaces, create multiple classes which implement these methods(can also be considered as algorithms) and inject them into the client class. 


So, for the example in previous section, we will create: 
_IDisplayBehavior_ containing _display()_ method and with concrete implementations: _CityDuckDisplay_ and _RubberDuckDisplay_ classes.

However, for _IFlyBehavior_ with _fly()_ method, we only create one concrete implementation, namely _CityDuckDisplay_ class.

At runtime, we will _inject_ the necessary behaviors in the modified Duck class and initialize it in the constructor. For more information/better explanation, please check the primary video resource in the reference section.

A general class diagram for this design pattern is as follows:

![StrategyPatternInGeneral.jpg](https://github.com/syedumerahmedcode/strategy-pattern/blob/master/src/main/resources/StrategyPatternInGeneral.jpg)

**Scenario of the example project:** 

The scenario used in this project is as follows:

We have a simulation program that simulates the a coin flipper and returns and return heads 50% of the time and tails 50% of the time. Now, we want to write the results of the coin flip in different forms such as either writing it on the terminal, saving the result in a CSV file or in a memory. In other words, we have **different strategies** to display the results in **different classes** and we want to use them as per the need of the program. The logic for writing the output of the coin flipper is where we intend to use strategy pattern. 

How is it solved using Strategy pattern? We create a `Writer` Interface which defines the method definition `write()` as follows:

```java

public interface Writer {
	/**
	 * This method can be used to either write on the command line, or write in a
	 * csv file, or in memory
	 * 
	 * @param result The result to write.
	 */
	public void write(String result);

}

```
 
Next, we create two two implementations `ConsoleWriter` and `CsvWriter` which implement this interface.

```java

public class ConsoleWriter implements Writer {

	@Override
	public void write(String result) {
		System.out.println("Writes " + result + " on the screen.");
	}

}


```

and


```java

public class CsvWriter implements Writer {
	String path;

	public CsvWriter(String path) {
		this.path = path;
	}

	@Override
	public void write(String result) {
		/**
		 * Code is kept simple on purpose.
		 */
		System.out.println("Writes " + result + " to " + path);
	}

}

```

In the `Simulation` class, the writer is injected(passed as a parameter) in the constructor as shown below: 

```java


public class Simulation {
	// constants
	private static final String TAILS = "Tails";
	private static final String HEADS = "Heads";
	// Variables 
	Writer writer;
	int numberOfRuns;
	Random rnd;

	//constructor
	// Here, writer is passed as a parameter
	public Simulation(int numberOfRuns, long seed, Writer writer) {
		this.writer = writer;
		this.numberOfRuns = numberOfRuns;
		this.rnd = new Random(seed);
	}

	// run the simulation
	public void run() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < numberOfRuns; i++) {
			String result = executeSimulation();
			results.add(result);
		}
		// display results from the stream
		results.stream()
			.forEach((currentResult) -> 
						this.writer
							.write((String) currentResult));

	}


```

Finally, we defined in `Program` class which _logic_ to use to write the result. In the current scenario, we are writing to a csv file but this can easily be switched to console terminal.

```java

public class Program {

	private static final String PLEASE_ENTER_THE_INITIAL_SEED_VALUE = "Please enter the initial seed value:";
	private static final String PLEASE_ENTER_THE_NUMBER_OF_RUNS = "Please enter the number of runs:";
	private static final String DUMMY_OUTPUT_FILE_PATH = "output.txt";

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		
		System.out.println(PLEASE_ENTER_THE_NUMBER_OF_RUNS);
		int numberOfRuns = Integer.parseInt(input.nextLine());

		System.out.println(PLEASE_ENTER_THE_INITIAL_SEED_VALUE);
		long seed = Long.parseUnsignedLong(input.nextLine());

		//		Writer writer=new ConsoleWriter();
		String path = DUMMY_OUTPUT_FILE_PATH;
		Writer writer = new CsvWriter(path);
		
		Simulation simulation = new Simulation(numberOfRuns, seed, writer);
		simulation.run();
		
		input.close();
	}
}

```

The advantage is that `Simulation` does not need to know about the specific writer since an interface is passed. Now, in the future, if we want to create some other concrete implementation of `Writer` interface, we can do that, pass it as a parameter from `Program` class and there will be no change in the `Simulation` class.  

![StrategyPatternForWriter.jpg](https://github.com/syedumerahmedcode/strategy-pattern/blob/master/src/main/resources/StrategyPatternForWriter.jpg)


## Explanation Other Important Points

**Possible symptoms of when to use strategy pattern:** 

If there is something that one feels is hard-coded in a place where it should not be hard-coded, one can almost always dependency inject that thing. One can always encapsulate it, put it in a class, give it a name and them delegate it to the method that would execute that particular piece of logic.

**Using strategy pattern has the following advantages:**

- One can isolate the implementation details of an algorithm from the code that uses it.
- We can swap the algorithms used inside an object at runtime.
- By using this design pattern, we replace inheritance with composition.
- Open/Closed principle of SOLID is upheld i.e. we can introduce new strategies without having to change the context.
- Design pattern open up new avenues of abstraction or to put in more elegantly, how it can make your code base afford particular types of change requests very cheaply.

## Technologies Used

- Java 11

## Prerequisities

None

## Commands

In order to run the project, open project in an IDE ---> Navigate to com.umer.simulation package ---> Right click on  `Program.java` ---> Run As ---> Java Application ---> Enter appropriate input

## Contribution

Feature requests, issues, pull requests and questions are welcome.

## References

- [1](https://www.youtube.com/watch?v=v9ejT8FO-7I): Strategy Pattern – Design Patterns (ep 1) **(Youtube)** **[Primary Video resource for this project]**
- [2](https://www.youtube.com/watch?v=slfeCvztnT4): Strategy Pattern (in real life) Screencast – OO Design Patterns Screencasts (ep 2)
 **(Youtube)**  **[Primary Video resource for this project]**
- [3](https://www.youtube.com/watch?v=13nftsQUUE0): Strategy Pattern Screencast – OO Design Patterns Screencasts (ep 1) **(Youtube)**
- [4](https://refactoring.guru/design-patterns/strategy): Design Patterns / Behavioral Patterns / Strategy
- [5](https://www.go4expert.com/articles/design-patterns-simple-examples-t5127/#strategy): Design Patterns in Simple Examples
- [6](https://springframework.guru/gang-of-four-design-patterns/strategy-pattern/): Strategy Pattern


## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). 
