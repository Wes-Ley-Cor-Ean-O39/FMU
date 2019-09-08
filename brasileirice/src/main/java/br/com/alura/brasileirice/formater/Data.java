package br.com.alura.brasileirice.formater;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Data {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyyy hh:mm");
		System.out.println(agora.format(formatadorHora));
		DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(agora.format(formatadorCurto));
		//DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
	    System.out.println(agora.minusHours(5));
	    System.out.println(agora.plusHours(5));
	}

}
