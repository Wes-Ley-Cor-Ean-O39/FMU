package br.com.alura.brasileirice.formater;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class NumeroPorExtenso {

	public static void main(String[] args) {
		
		//NumericToWordsConverter conversor = new NumericToWordsConverter(new InteiroSemFormato()); NUMERO INTEIRO
		//double valor = 75.00;
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		BigDecimal valor = new BigDecimal("75.99");
		String valorPorExtenso = conversor.toWords(valor.doubleValue());
		System.out.println(valorPorExtenso);
		
	}
	
	
}
