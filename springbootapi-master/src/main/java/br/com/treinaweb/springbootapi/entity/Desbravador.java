package br.com.treinaweb.springbootapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Desbravador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String nome;

	private String cargo;

	private String clube;

	private String regiao;

	private String associacao;

	private String uniao;

	private String unidade;

}
