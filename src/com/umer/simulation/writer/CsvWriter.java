package com.umer.simulation.writer;

public class CsvWriter implements Writer {
	String path;

	public CsvWriter(String path) {
		this.path = path;
	}

	@Override
	public void write(String result) {
		/**
		 * Code is kept simple on purpose.
		 */
		System.out.println("Writes " + result + " to " + path);
	}

}
