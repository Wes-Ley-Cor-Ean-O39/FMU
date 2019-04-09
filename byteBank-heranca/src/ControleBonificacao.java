
public class ControleBonificacao {

	private double soma;

	public double getSoma() {
		return soma;
	}

	public void registra(Funcionario f) {
		double boni = f.getBonificacao();
		this.soma = soma + boni;
	}

}
