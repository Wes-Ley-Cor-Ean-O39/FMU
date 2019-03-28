package byteBank;

public class TestaMetodo {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.saldo = 1000;

		conta.deposita(50);

		System.out.println("Saldo da Minha Conta: " + conta.saldo);

		// boolean conseguiuRetitar = conta.saca(20);

		Conta contaDaMarcela = new Conta();

		contaDaMarcela.deposita(1000);

		System.out.println("Saldo da Conta da Marcela: " + contaDaMarcela.saldo);

		if (contaDaMarcela.transfere(50, conta)) {
			System.out.println("Transferencia Efetuada com Sucesso");
		} else {
			System.out.println("Faltou Dinheiro");
		}

		System.out.println("Saldo Atual da Conta da Marcela: " + contaDaMarcela.saldo);

		System.out.println("Minha Conta: " + conta.saldo);

	}

}
