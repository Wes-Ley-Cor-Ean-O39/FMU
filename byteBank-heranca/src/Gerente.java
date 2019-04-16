
public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}

	@Override
	public boolean autentica(String login, int senha) {
		return this.autenticador.autentica(login, senha);
	}

	public double getBonificacao() {
		return super.getSalario();
	}

	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

}
