package br.com.alura.java.io.teste;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TesteArqCFG {

	public static void main(String[] args) throws IOException {

		Properties props = new Properties();
		props.setProperty("login", "alura"); // chave, valor
		props.setProperty("senha", "alurapass");
		props.setProperty("endereco", "www.alura.com.br");

		props.store(new FileWriter("conf.properties"), "algum Comentario");
		props.load(new FileReader("conf.properties"));

		String login = props.getProperty("login");
		String senha = props.getProperty("senha");
		String endereco = props.getProperty("endereco");
		
		System.out.println(login + ", "  + "\n" + senha + ", " + "\n"  + endereco);
		
	}

}
