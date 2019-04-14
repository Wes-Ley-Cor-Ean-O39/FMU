
public class Gerente extends Funcionario implements Autenticavel {

	private int senha;
	private String login;

	public Gerente() {

	}

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

	// sobrecarga de método
	public boolean autentica(String login, int senha) {
		if (this.login == login && this.senha == senha) {
			System.out.println("Logado com Sucesso");
			return true;
		} else {
			System.out.println("Login ou Senha Incorreto! Tente Novamente");
			return false;
		}
		// implementacao omitida
	}

	public double getBonificacao() {
		return super.getSalario();
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

}
