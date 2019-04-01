
public class TestaGetESet {

	public static void main(String[] args) {

		Conta conta = new Conta();

		// conta.numero = 1445;
		conta.setNumero(1337);
		conta.setAgencia(1158);
		conta.setSaldo(3500);

		// conta.titular = "Kin";
		// kin.setNome("Wesley");

		Cliente kin = new Cliente();

		conta.setTitular(kin);

		conta.getTitular().setNome("Wesley");
		conta.getTitular().setCpf("489.764.218/33");
		conta.getTitular().setProfissao("Analista de Sistemas Jr");

		System.out.println(conta.getTitular().getNome());
		System.out.println(conta.getTitular().getCpf());
		System.out.println(conta.getTitular().getProfissao());

		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfissao("Programador");

		System.out.println(titularDaConta.getProfissao());
		
		System.out.println(kin);
		System.out.println(conta);

	}

}
