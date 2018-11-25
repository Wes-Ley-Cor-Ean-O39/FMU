
public class TestaDiaDaSemana {

	public static void main(String[] args) {

		String diaDaSemana = "Sexta-Feira";

		switch (diaDaSemana) {
		case "Segunda-Feira":
			System.out.println("O DIA DA SEMANA É SEGUNDA-FEIRA");
			break;
		case "Terça-Feira":
			System.out.println("O DIA DA SEMANA É TERÇA-FEIRA");
			break;
		case "Quarta-Feira":
			System.out.println("O DIA DA SEMANA É QUARTA-FEIRA");
			break;
		case "Quinta-Feira":
			System.out.println("O DIA DA SEMANA É QUINTA-FEIRA");
		case "Sexta-Feira":
			System.out.println("O DIA DA SEMANA É SEXTA-FEIRA");
			break;
		default:
			System.out.println("Dia da Semana Inválida!");
			break;
		}

	}

}
