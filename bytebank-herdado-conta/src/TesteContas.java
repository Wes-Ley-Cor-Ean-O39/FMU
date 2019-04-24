
public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException {
		// classe abstrata
		// Conta c = new Conta();

		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);

		ContaPoupança cp = new ContaPoupança(222, 222);
		cp.deposita(100.0);

		cc.transfere(10.0, cp);
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());

	}

}
