
public class TesteReferencias {

	public static void main(String[] args) {

		Gerente g = new Gerente();
		g.setNome("Marcos");
		g.setSalario(5000.0);

		EditorVideo e = new EditorVideo();
		e.setSalario(2500.0);

		Designer d = new Designer();
		d.setSalario(2000.0);

		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g);
		controle.registra(e);
		controle.registra(d);

		System.out.println(controle.getSoma());
	}

}
