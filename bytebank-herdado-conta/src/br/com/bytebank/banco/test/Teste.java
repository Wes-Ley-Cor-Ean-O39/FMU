package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupan�a;

public class Teste {

	public static void main(String[] args) {

		Object contaCorrente = new ContaCorrente(111, 7843);
		Object contaPoupanca = new ContaPoupan�a(234, 9743);

		System.out.println(contaCorrente);
		System.out.println(contaPoupanca);

	}

}
