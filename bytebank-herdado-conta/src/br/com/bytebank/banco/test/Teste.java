package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupança;

public class Teste {

	public static void main(String[] args) {

		Object contaCorrente = new ContaCorrente(111, 7843);
		Object contaPoupanca = new ContaPoupança(234, 9743);

		System.out.println(contaCorrente);
		System.out.println(contaPoupanca);

	}

}
