package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupança;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException {
		// classe abstrata
		// Conta c = new Conta();

		ContaCorrente cc = new ContaCorrente(11, 2);
		cc.deposita(10000.0);

		ContaPoupança cp = new ContaPoupança(222, 222);
		cp.deposita(100.0);

		cc.transfere(100000.0, cp);
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());

	}

}
