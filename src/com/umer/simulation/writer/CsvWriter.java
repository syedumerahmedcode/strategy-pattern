package com.umer.simulation.writer;

public class CsvWriter implements Writer{
	
	@Override
	public void write(String result) {
		System.out.println("Writes " + result + " in the csv file.");
	}

}
