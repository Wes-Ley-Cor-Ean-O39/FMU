package br.com.bytebank.banco.modelo;

public class ContaPoupanša extends Conta {

	public ContaPoupanša(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;

	}

	@Override
	public String toString() {
		return "ContaPoupanša: Numero = " + getNumero() + ", Agencia = " + getAgencia();
	}
}
