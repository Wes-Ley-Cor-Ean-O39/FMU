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
		return "ContaPoupanša [saldo=" + saldo + ", toString()=" + super.toString() + ", getSaldo()=" + getSaldo()
				+ ", getNumero()=" + getNumero() + ", getAgencia()=" + getAgencia() + ", getTitular()=" + getTitular()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
