package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayEstadosBrasleiros {

	public static void main(String[] args) {

		ArrayList<String> listaEstado = new ArrayList<String>(26);

		listaEstado.add("Acre");
		listaEstado.add("Alagoas");
		listaEstado.add("Amapá");
		listaEstado.add("Amazonas");
		listaEstado.add("Bahia");
		listaEstado.add("Ceará");
		listaEstado.add("Distrito Federal");
		listaEstado.add("Espiríto Santo");
		listaEstado.add("Goiás");
		listaEstado.add("Maranhão");
		listaEstado.add("Mato Grosso");
		listaEstado.add("Mato Grosso do Sul");
		listaEstado.add("Minas Gerais");
		listaEstado.add("Pará");
		listaEstado.add("Paraná");
		listaEstado.add("Pernambuco");
		listaEstado.add("Piauí");
		listaEstado.add("Rio de Janeiro");
		listaEstado.add("Rio Grande do Norte");
		listaEstado.add("Rio Grande do Sul");
		listaEstado.add("Rondônia");
		listaEstado.add("Roraima");
		listaEstado.add("Santa Catarina");
		listaEstado.add("São Paulo");
		listaEstado.add("Sergipe");
		listaEstado.add("Tocantins");

		ArrayList<String> nova = new ArrayList<String>(listaEstado);

		System.out.println(nova.get(13));
		

	}

}
