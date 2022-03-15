package com.umer.simulation;

import java.util.Scanner;

import com.umer.simulation.writer.CsvWriter;
import com.umer.simulation.writer.Writer;

public class Program {

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Please number of runs:");
		int numberOfRuns = Integer.parseInt(input.nextLine());

		System.out.println("Please initial seed value:");
		long seed = Long.parseUnsignedLong(input.nextLine());

		//		Writer writer=new ConsoleWriter();
		String path = "output.txt";
		Writer writer = new CsvWriter(path);
		
		Simulation simulation = new Simulation(numberOfRuns, seed, writer);
		simulation.run();
		
		input.close();
	}
}
