public class Conta {

	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", agencia=" + agencia + ", numero=" + numero + ", titular=" + titular + "]";
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

}