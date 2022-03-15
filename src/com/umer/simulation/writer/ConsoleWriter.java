package com.umer.simulation.writer;

public class ConsoleWriter implements Writer {

	@Override
	public void write(String result) {
		System.out.println("Writes " + result + " on the screen.");
	}

}
