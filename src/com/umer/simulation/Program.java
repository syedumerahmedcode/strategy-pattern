package com.umer.simulation;

import java.util.Scanner;

import com.umer.simulation.writer.CsvWriter;
import com.umer.simulation.writer.Writer;

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
