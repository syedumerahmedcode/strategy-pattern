package com.umer.simulation.writer;

public interface Writer {
	/**
	 * This method can be used to either write on the command line, or write in a
	 * csv file, or in memory
	 * 
	 * @param result The result to write.
	 */
	public void write(String result);

}
