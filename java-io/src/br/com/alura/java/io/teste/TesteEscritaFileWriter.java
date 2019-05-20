package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {

		// FileWriter fw = new FileWriter("wvs051.txt");
		// BufferedWriter bw = new BufferedWriter(fw);

		long ini = System.currentTimeMillis();

		BufferedWriter bw = new BufferedWriter(new FileWriter("processado.txt"));

		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		// bw.write(System.lineSeparator());
		bw.newLine();
		bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

		bw.close();

		long fim = System.currentTimeMillis();

		System.out.println("Passaram " + (fim - ini) + " milisegundos");
	}
}
