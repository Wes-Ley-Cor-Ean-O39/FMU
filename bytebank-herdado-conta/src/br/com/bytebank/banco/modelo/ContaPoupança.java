package br.com.bytebank.banco.modelo;

public class ContaPoupan�a extends Conta {

	public ContaPoupan�a(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;

	}

}
