package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {

		PrintStream ps = new PrintStream("lorem2.txt");
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		ps.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

		ps.close();
	}
}
