
public class TestaDiaDaSemana {

	public static void main(String[] args) {

		String diaDaSemana = "Sexta-Feira";

		switch (diaDaSemana) {
		case "Segunda-Feira":
			System.out.println("O DIA DA SEMANA � SEGUNDA-FEIRA");
			break;
		case "Ter�a-Feira":
			System.out.println("O DIA DA SEMANA � TER�A-FEIRA");
			break;
		case "Quarta-Feira":
			System.out.println("O DIA DA SEMANA � QUARTA-FEIRA");
			break;
		case "Quinta-Feira":
			System.out.println("O DIA DA SEMANA � QUINTA-FEIRA");
		case "Sexta-Feira":
			System.out.println("O DIA DA SEMANA � SEXTA-FEIRA");
			break;
		default:
			System.out.println("Dia da Semana Inv�lida!");
			break;
		}

	}

}
