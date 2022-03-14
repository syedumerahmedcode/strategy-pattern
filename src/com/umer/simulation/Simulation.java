package com.umer.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
	Random rnd = new Random();

	public List run() {
		List results=new ArrayList<String>();
		for(int i=0;i<10;i++) {
			/*
			 * flip a coin and 
			 * return heads 50% of the time and 
			 * tails 50% of the time.
			 */
			String result = this.rnd.nextDouble() <= 0.5 ? "Heads" : "Tails";
			results.add(result);
		}
			return results;
		
	}
}
