
public class TesteTributaveis {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.00);

		SeguroVida seguro = new SeguroVida();

		CalculadorImposto calc = new CalculadorImposto();
		calc.registra(cc);
		calc.registra(seguro);

		System.out.println(calc.getTotalImposto());

	}

}
