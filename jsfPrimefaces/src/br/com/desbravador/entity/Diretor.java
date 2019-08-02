package br.com.desbravador.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the diretor database table.
 * 
 */
@Entity
@Table(name="Diretor")
@NamedQuery(name="Diretor.findAll", query="SELECT d FROM Diretor d")
public class Diretor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	@Column(name = "nome")
	private String nome;

	//bi-directional many-to-one association to Escola
	@OneToMany(mappedBy="diretor")
	private List<Escola> escolas;

	public Diretor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Escola> getEscolas() {
		return this.escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Escola addEscola(Escola escola) {
		getEscolas().add(escola);
		escola.setDiretor(this);

		return escola;
	}

	public Escola removeEscola(Escola escola) {
		getEscolas().remove(escola);
		escola.setDiretor(null);

		return escola;
	}

}