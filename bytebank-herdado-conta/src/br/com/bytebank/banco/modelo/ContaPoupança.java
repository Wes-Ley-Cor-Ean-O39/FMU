package br.com.bytebank.banco.modelo;

public class ContaPoupança extends Conta {

	public ContaPoupança(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;

	}

	@Override
	public String toString() {
		return "ContaPoupança: Numero = " + getNumero() + ", Agencia = " + getAgencia();
	}
}
