
public class SistemaInterno {

	private int senha = 2222;

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public void autentica(Autenticavel fa) {

		boolean autenticou = fa.autentica(this.senha);

		if (autenticou) {
			System.out.println("Pode entrar no Sistema!");
		} else {
			System.out.println("Não pode entrar no Sistema!");
		}

	}
}
