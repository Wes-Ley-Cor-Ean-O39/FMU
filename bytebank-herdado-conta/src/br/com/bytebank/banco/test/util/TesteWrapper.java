package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapper {

	public static void main(String[] args) {

		Integer ref = Integer.valueOf("3");
		ref++;
		System.out.println(ref);

		String diaAniversario = "22";
		Integer.parseInt(diaAniversario);
		System.out.println("Usando método parseInt: " + diaAniversario);

		Integer iParseado1 = Integer.valueOf("42"); // parseando e devolvendo referencia
		int iParseado2 = Integer.parseInt("44"); // parseando e devolvendo primitivo

		System.out.println(iParseado1); // 42
		System.out.println(iParseado2); // 44
		///////////////////////////////////////////////////////////////
		Integer idadeRef = 29;// autoBoxing, é criado um objeto do tipo Integer
		int primitivo = new Integer(29);// unBoxing, que loucura!!

		List<Integer> lista = new ArrayList<>();
		lista.add(idadeRef);// ok
		lista.add(primitivo);// autoBoxing

		int i1 = lista.get(0);// unBoxing
		Integer i2 = lista.get(1);// ok

		System.out.println(i1);
		System.out.println(i2);

		Integer valorRef = Integer.valueOf(33); // delegando a criação para método valueOf
		int valorPri = valorRef.intValue(); // desembrulhando, pegando o valor primitivo do objeto wrapper

		System.out.println(valorPri); // 33
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		

	}

}
