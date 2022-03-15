package com.umer.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.umer.simulation.writer.Writer;

public class Simulation {
	Writer writer;
	
	Random rnd = new Random();
	
	public Simulation(Writer writer) {
		this.writer=writer;
	}

	public void run() {
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
		results.stream()
		.forEach((currentResult)
				-> this.writer.write((String) currentResult));
		
	}
}
