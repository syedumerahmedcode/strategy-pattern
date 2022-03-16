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

The aim of this project is to show case how can one use strategy pattern to describe a bunch of algorithms, put each of them into a separate class, and make their objects interchangeable. 

In simple words, it allows us to change the algorithm independently without changing the client using it.


## Out Of Scope

Since the main idea is to implement strategy method pattern in code, tests are out of scope of this project. 

## Explanation Strategy Pattern

**Background**

* Inheritance cases in which not all methods must be implemented in child classes: While inheritance is great at sharing behavior of parent class with its sub classes, there are time when it is not desired to implement methods in child classes. Please consider the following scenario:

We have a parent class: 
- **Duck** which has the following methods: _display()_ and _fly()_. Here, the methods do exactly what they are named.

Now, we create a child class:
**CityDuck** and it can also override _display()_ and _fly()_ without any problems.

Additionally, we can also create a child class:
**WildDuck** and it can also override _display()_ and _fly()_ without any problems.

However, if we create a child class:
**RubberDuck** then we have a problem as _display()_ method is overridden without any problems but if does not make any sense to override _fly()_ method as a rubber duck does not fly. Unfortunately, we must do it (probably with an empty implementation) as we are required by inheritance to do so. 

Also, in the future, if a method to Duck class is introduced, it must be implemented in all of its sub classes regardless of the fact it makes sense or not.

Another interesting scenario is that sometimes there are certain methods(or behaviors) which are shared across _some_ child classes but _not all_ child classes.  
  
This is where using strategy pattern makes sense as described below.

**Reasons for using strategy method pattern:**

- strategy pattern uses composition. Due to this nature, we can extract out the behavior into separate interfaces, create multiple classes which implement these methods(can also be considered as algorithms) and inject them into the client class. 

So, for the example in previous section, we will create: 
_IDisplayBehavior_ containing _display()_ method and with concrete implementations: _CityDuckDisplay_ and _RubberDuckDisplay_ classes.

However, for _IFlyBehavior_ with _fly()_ method, we only create one concrete implementation, namely _CityDuckDisplay_ class.

At runtime, we will _inject_ the necessary behaviors in the modified Duck class and initialize it in the constructor. For more information/better explanation, please check the primary video resource in the reference section.

A general class diagram for this design pattern is as follows:

- TODO: Insert general diagram--> Time stamp: 33:17 in resource [1]. 

The **scenario used in this project** is as follows:

- TODO: Describe scenario!
- TODO: Create a rough UML diagram and adapt to the simulation solution implemented in the code.

**Solution:**

- TODO: describe solution with the help of code.

## Explanation Other Important Points

Using strategy pattern has the following advantages:

- One can isolate the implementation details of an algorithm from the code that uses it.
- We can swap the algorithms used inside an object at runtime.
- By using this design pattern, we replace inheritance with composition.
- Open/Closed principle of SOLID is upheld i.e. we can introduce new strategies without having to change the context.

## Technologies Used

- Java 11

## Prerequisities

None

## Commands

- TODO: Describe this part.

## Contribution

Feature requests, issues, pull requests and questions are welcome.

## References

- [1](https://www.youtube.com/watch?v=v9ejT8FO-7I): Strategy Pattern – Design Patterns (ep 1) **(Youtube)** **[Primary Video resource for this project]**
- [2](https://www.youtube.com/watch?v=slfeCvztnT4): Strategy Pattern (in real life) Screencast – OO Design Patterns Screencasts (ep 2)
 **(Youtube)**
- [3](https://www.youtube.com/watch?v=13nftsQUUE0): Strategy Pattern Screencast – OO Design Patterns Screencasts (ep 1) **(Youtube)**
- [4](https://refactoring.guru/design-patterns/strategy): Design Patterns / Behavioral Patterns / Strategy
- [5](https://www.go4expert.com/articles/design-patterns-simple-examples-t5127/#strategy): Design Patterns in Simple Examples


## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)



