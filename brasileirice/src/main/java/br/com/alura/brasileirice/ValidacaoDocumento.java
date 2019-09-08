package br.com.alura.brasileirice;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.Validator;

public class ValidacaoDocumento {

	public static void main(String[] args) {
		String cpf = "48976421833";
		CPFValidator validadorCPF = new CPFValidator();
		try {
			validadorCPF.assertValid(cpf);
			System.out.println("CPF VALIDO TIW!");
		} catch (InvalidStateException e) {
			System.out.println("CPF INVALIDO! " + e.getMessage());
		}
		String cnpj = "82588641000173";
		CNPJValidator validadorCNPJ = new CNPJValidator();
		try {
			validadorCNPJ.assertValid(cnpj);
			System.out.println("CNPJ VALIDO!");
		} catch (Exception e) {
			System.out.println("CNPJ INVALIDO! " + e.getMessage());
		}
		String tituloEleitor = "417453530116";
		TituloEleitoralValidator validadorTitulo = new TituloEleitoralValidator();
		try {
			validadorTitulo.assertValid(tituloEleitor);
			System.out.println("TITULO DE ELEITOR VALIDO!");
		} catch (Exception e) {
			System.out.println("Titulo de Eleitor INVALIDO! " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	private static void validorDocumentosBrasil(Validator<String> validador, String documento) {
		validador.assertValid(documento);
	}

}
