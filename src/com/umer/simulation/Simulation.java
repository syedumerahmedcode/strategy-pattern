package com.umer.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.umer.simulation.writer.Writer;

public class Simulation {
	private static final String TAILS = "Tails";
	private static final String HEADS = "Heads";
	Writer writer;
	int numberOfRuns;
	Random rnd;

	public Simulation(int numberOfRuns, long seed, Writer writer) {
		this.writer = writer;
		this.numberOfRuns = numberOfRuns;
		this.rnd = new Random(seed);
	}

	public void run() {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < numberOfRuns; i++) {
			String result = executeSimulation();
			results.add(result);
		}
		results.stream()
			.forEach((currentResult) -> 
						this.writer
							.write((String) currentResult));

	}

	/**
	 * flip a coin and return heads 50% of the time and tails 50% of the time.
	 * 
	 * @return The result of the simulation. In the case, the result of the coin
	 *         flip.
	 */
	private String executeSimulation() {
		String result = this.rnd.nextDouble() <= 0.5 ? HEADS : TAILS;
		return result;
	}
}
