package br.com.bytebank.banco.modelo;

public class ContaPoupan�a extends Conta {

	public ContaPoupan�a(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;

	}

	@Override
	public String toString() {
		return "ContaPoupan�a [saldo=" + saldo + ", toString()=" + super.toString() + ", getSaldo()=" + getSaldo()
				+ ", getNumero()=" + getNumero() + ", getAgencia()=" + getAgencia() + ", getTitular()=" + getTitular()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
