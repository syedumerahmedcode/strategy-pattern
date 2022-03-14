package com.umer.simulation;

public class Program {

	public static void main(String[] args) throws Exception {

//		Scanner input = new Scanner(System.in);
//		System.out.println("Please enter your name:");
//		String personName = input.nextLine();
//		
//		System.out.println("Hi, "+personName);

		Simulation simulation = new Simulation();
		String result=simulation.run();
		System.out.println(result);
	}
}
