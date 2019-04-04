
public class TestaFuncionario {

	public static void main(String[] args) {

		Funcionario nico = new Funcionario();

		nico.setNome("Nico Alura");
		nico.setCpf("4896745897/09");
		nico.setSalario(2600.00);

		System.out.println(nico.getNome());
		System.out.println(nico.getBonificacao());
	}

}
