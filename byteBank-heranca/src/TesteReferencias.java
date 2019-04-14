
public class TesteReferencias {

	public static void main(String[] args) {
		// Funcionário é abstrato
		// Funcionario f = new Funcionario();

		Funcionario g = new Gerente();
		g.setNome("Marcos");
		g.setSalario(5000.0);

		Funcionario e = new EditorVideo();
		e.setSalario(2500.0);

		Funcionario d = new Designer();
		d.setSalario(2000.0);

		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g);
		controle.registra(e);
		controle.registra(d);

		System.out.println(controle.getSoma());
	}

}
