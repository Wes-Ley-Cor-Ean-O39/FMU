package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayEstadosBrasleiros {

	public static void main(String[] args) {

		ArrayList<String> listaEstado = new ArrayList<String>(26);

		listaEstado.add("Acre");
		listaEstado.add("Alagoas");
		listaEstado.add("Amap�");
		listaEstado.add("Amazonas");
		listaEstado.add("Bahia");
		listaEstado.add("Cear�");
		listaEstado.add("Distrito Federal");
		listaEstado.add("Espir�to Santo");
		listaEstado.add("Goi�s");
		listaEstado.add("Maranh�o");
		listaEstado.add("Mato Grosso");
		listaEstado.add("Mato Grosso do Sul");
		listaEstado.add("Minas Gerais");
		listaEstado.add("Par�");
		listaEstado.add("Paran�");
		listaEstado.add("Pernambuco");
		listaEstado.add("Piau�");
		listaEstado.add("Rio de Janeiro");
		listaEstado.add("Rio Grande do Norte");
		listaEstado.add("Rio Grande do Sul");
		listaEstado.add("Rond�nia");
		listaEstado.add("Roraima");
		listaEstado.add("Santa Catarina");
		listaEstado.add("S�o Paulo");
		listaEstado.add("Sergipe");
		listaEstado.add("Tocantins");

		ArrayList<String> nova = new ArrayList<String>(listaEstado);

		System.out.println(nova.get(13));
		

	}

}
