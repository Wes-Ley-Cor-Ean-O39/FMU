
public abstract interface Autenticavel {

	public void setSenha(int senha);

	public boolean autentica(int senha);

	boolean autentica(String login, int senha);

}
