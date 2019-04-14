
public class TesteSistema {

	public static void main(String[] args) {

		Autenticavel referenciaG = new Gerente();

		Autenticavel referenciaC = new Cliente();

		Autenticavel referenciaA = new Administrador();

		Gerente g = new Gerente();
		g.setSenha(353563);

		SistemaInterno si = new SistemaInterno();
		si.autentica(g);

	}

}
