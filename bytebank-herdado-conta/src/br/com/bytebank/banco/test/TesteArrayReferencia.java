package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupança;

public class TesteArrayReferencia {

	public static void main(String[] args) {

		// alterando o tipo
		Object[] contas = new Object[5];
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		contas[0] = cc1;

		// cria instância de ContaPoupanca
		ContaPoupança cc2 = new ContaPoupança(22, 22);
		contas[1] = cc2;

		System.out.println(((Conta) contas[1]).getNumero());

		// alterou o tipo, realizando o cast
		ContaCorrente ref = (ContaCorrente) contas[0];
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());
	}
}