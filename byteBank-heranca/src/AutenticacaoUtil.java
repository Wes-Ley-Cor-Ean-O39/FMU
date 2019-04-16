
public class AutenticacaoUtil {

	private int senha;
	private String login;

	public void setSenha(int senha) {
		this.senha = senha;
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

}
