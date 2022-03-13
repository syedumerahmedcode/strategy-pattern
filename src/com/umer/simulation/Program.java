package com.umer.simulation;

import java.util.Scanner;


public class Program {

	public static void main(String[] args) throws Exception {
		/**
		 * This user input takes place of a GUI drop down, so that we can keep the
		 * implementation simple and focus on the implementation and usage of Factory
		 * pattern
		 * 
		 * Helps us in determining what type of server does the user wants to resolve?
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name:");
		String personName = input.nextLine();
		
		System.out.println("Hi, "+personName);
	}
}
