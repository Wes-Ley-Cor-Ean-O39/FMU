package br.com.alura.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	static List<Empresa> lista = new ArrayList<>();

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresa() {
		return Banco.lista;
	}

	static {
		Empresa alura = new Empresa();
		alura.setNome("Alura");
		Empresa caelum = new Empresa();
		caelum.setNome("Caelum");
		lista.add(alura);
		lista.add(caelum);
	}

}
