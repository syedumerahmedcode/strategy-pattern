package com.umer.simulation;

import java.util.Random;

public class Simulation {
	Random rnd = new Random();

	public String run() {
			/*
			 * flip a coin and 
			 * return heads 50% of the time and 
			 * tails 50% of the time.
			 */
			String result = this.rnd.nextDouble() <= 0.5 ? "Heads" : "Tails";
			return result;
		
	}
}
