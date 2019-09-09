package br.com.alura.brasileirice.formater;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class Dinheiro {

	public static void main(String[] args) {

		CurrencyUnit moeda = Monetary.getCurrency("BRL");
		MonetaryAmount valorDaParcela = Money.of(75, moeda);
		System.out.println(valorDaParcela);
		MonetaryAmount valorTotal = valorDaParcela.multiply(12);
		System.out.println(valorTotal);
		MonetaryAmount desconto = valorTotal.with(MonetaryOperators.percent(10));
		System.out.println(desconto);
		NumberValue descontoSemMoeda = desconto.getNumber();
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		String valorPorExtenso = conversor.toWords(descontoSemMoeda.doubleValue());
		System.out.println("Olá, Aluno. Ganhe " + valorPorExtenso + " ouvindo nosso podcast. LINK");
	
	}

}
