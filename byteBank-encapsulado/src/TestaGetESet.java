
public class TestaGetESet {

	public static void main(String[] args) {

		Conta conta = new Conta(123, 456);
		
		Conta contaDoKin = new Conta(1158, 22791);
		Conta contaDoCorea = new Conta(879, 20019);
		Conta contaDoManoAe = new Conta(2289, 908234);

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
		
		System.out.println(Conta.getTotal());
		
		System.out.println(contaDoCorea);
		System.out.println(contaDoKin);
		System.out.println(contaDoManoAe);

	}

}
