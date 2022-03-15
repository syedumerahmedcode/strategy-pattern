package com.umer.simulation;

import com.umer.simulation.writer.CsvWriter;
import com.umer.simulation.writer.Writer;

public class Program {

	public static void main(String[] args) throws Exception {

		
		
		int numberOfRuns=10;
		long seed=2L;
//		Scanner input = new Scanner(System.in);
//		System.out.println("Please enter your name:");
//		String personName = input.nextLine();
//		
//		System.out.println("Hi, "+personName);
//		Writer writer=new ConsoleWriter();
		String path = "output.txt";
		Writer writer = new CsvWriter(path);
		Simulation simulation = new Simulation(numberOfRuns, seed, writer);
		simulation.run();
	}
}
