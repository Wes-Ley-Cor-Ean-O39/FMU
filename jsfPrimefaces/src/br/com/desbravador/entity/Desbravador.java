package br.com.desbravador.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the desbravador database table.
 * 
 */
@Entity
@NamedQuery(name = "Desbravador.findAll", query = "SELECT d FROM Desbravador d")
public class Desbravador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String associacao;

	private String cargo;

	private String clube;

	private String unidade;

	private String nome;

	private String regiao;

	private String uniao;

	public Desbravador() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssociacao() {
		return this.associacao;
	}

	public void setAssociacao(String associacao) {
		this.associacao = associacao;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getClube() {
		return this.clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return this.regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getUniao() {
		return this.uniao;
	}

	public void setUniao(String uniao) {
		this.uniao = uniao;
	}

}