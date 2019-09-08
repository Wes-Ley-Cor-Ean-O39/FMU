package br.com.alura.brasileirice.formater;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class Dinheiro {

	public static void main(String[] args) {

		CurrencyUnit moeda = Monetary.getCurrency("BRL");
		MonetaryAmount valorDaParcela = Money.of(75, moeda);
		System.out.println(valorDaParcela);
		MonetaryAmount valorTotal = valorDaParcela.multiply(12);
		System.out.println(valorTotal);
	}

}
