package com.umer.simulation;

import java.util.List;

public class Program {

	public static void main(String[] args) throws Exception {

//		Scanner input = new Scanner(System.in);
//		System.out.println("Please enter your name:");
//		String personName = input.nextLine();
//		
//		System.out.println("Hi, "+personName);

		Simulation simulation = new Simulation();
		List<String> result=simulation.run();
		result.stream()
				.forEach((currentResult)
						-> System.out.println(currentResult));
	}
}
