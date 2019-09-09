package br.com.alura.brasileirice.formater;

import java.io.IOException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

public class CEP {

	public static void main(String[] args) {

		ViaCEPClient cliente = new ViaCEPClient();
		try {
			ViaCEPEndereco endereco = cliente.getEndereco("06435030");
			System.out.println(endereco.getCep());
			System.out.println(endereco.getLogradouro());
			System.out.println(endereco.getBairro());
			System.out.println(endereco.getLocalidade());
			System.out.println(endereco.getUf());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
