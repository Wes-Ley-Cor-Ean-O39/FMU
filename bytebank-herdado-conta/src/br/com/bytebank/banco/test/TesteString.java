package br.com.bytebank.banco.test;

public class TesteString {

	public static void main(String[] args) {

		String nome = "Alura"; // objeto literal
		// String outro = new String("Alura");// má prática, sempre prefere a sintaxe
		// literal

		// String novo = nome.toLowerCase(); // caixa baixa
		String novo = nome.toUpperCase(); // caixa alta
		System.out.println(novo);

		// String novo = nome.replace("A", "a");
		System.out.println(nome);

		char c = nome.charAt(3); // saber qual é o caractere que ocupa uma posição específica
		System.out.println(c);

		int pos = nome.indexOf("a");// pega qual é posicao dessa String
		System.out.println(pos);

		String sub = nome.substring(0); // resulta a posicao p frente diante do parametro
		System.out.println(sub);

		for (int i = 0; i < nome.length(); i++) { // tamanho
			System.out.println(nome.charAt(i));
		}

		String vazio = "";
		String outroVazio = "                  a  l  ";

		String trimzado = outroVazio.trim(); // tira os espaços

		System.out.println(vazio.isEmpty()); // verifica se é vazio ou nao
		System.out.println(outroVazio.isEmpty());// verifica se é vazio ou nao

		System.out.println(trimzado);

		String con = "Wesley";

		System.out.println(con.contains("i")); // verifica se uma String possui uma sub-String

		System.out.println(con.length()); // tamanho

		String frase = "nome;teste;10";
		String array[] = new String[3];

		array = frase.split(";"); // quebra a string em partes

		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);

	}

}
