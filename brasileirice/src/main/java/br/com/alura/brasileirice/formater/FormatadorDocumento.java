package br.com.alura.brasileirice.formater;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;

public class FormatadorDocumento {

	public static void main(String[] args) {

		String cpf = "862.883.667-57";
		String cnpj = "98.610.832/0001-24";
		String tituloEleitor = "417453530116";
		CPFFormatter formatadorCPF = new CPFFormatter();
		String cpfSemFormatacao = formatadorCPF.unformat(cpf);
		System.out.println(cpf);
		System.out.println(cpfSemFormatacao);
		CNPJFormatter formatadorCNPJ = new CNPJFormatter();
		String cnpjSemFormatacao = formatadorCNPJ.unformat(cnpj);
		System.out.println(cnpj);
		System.out.println(cnpjSemFormatacao);
		TituloEleitoralFormatter formatadorTituloEleitor = new TituloEleitoralFormatter();
		String tituloEleitorFormatado = formatadorTituloEleitor.format(tituloEleitor);
		System.out.println(tituloEleitor);
		System.out.println(tituloEleitorFormatado);
		
	}
}
