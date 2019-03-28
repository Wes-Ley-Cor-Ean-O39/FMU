
public class TestaContaSemCliente {

	public static void main(String[] args) {

		Conta contaDaMarcela = new Conta();

		System.out.println(contaDaMarcela.saldo);

		contaDaMarcela.titular = new Cliente();
		System.out.println(contaDaMarcela.titular);

		contaDaMarcela.titular.nome = "Marcela";
		contaDaMarcela.titular.cpf = "489.764.218/33";
		contaDaMarcela.titular.profissao = "Analista de Sistemas Jr";
		System.out.println(contaDaMarcela.titular.nome);

	}

}
