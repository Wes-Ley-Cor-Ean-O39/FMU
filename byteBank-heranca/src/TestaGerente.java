
public class TestaGerente {

	public static void main(String[] args) {

		Gerente gerente = new Gerente();

		gerente.setNome("Wesley Azevedo");
		gerente.setCpf("45687632/98");
		gerente.setSalario(9000.00);

		System.out.println(gerente.getNome());
		System.out.println(gerente.getCpf());
		System.out.println(gerente.getSalario());

		// gerente.setSenha(123);
		boolean autenticou = gerente.autentica(null, 98);

		System.out.println(autenticou);

		System.out.println(gerente.getBonificacao());
		
	}

}
