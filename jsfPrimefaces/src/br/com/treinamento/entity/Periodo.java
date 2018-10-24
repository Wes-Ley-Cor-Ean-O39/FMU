package br.com.treinamento.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Salaaula
	@OneToMany(mappedBy="periodo")
	private List<Salaaula> salaaulas;

	public Periodo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Salaaula> getSalaaulas() {
		return this.salaaulas;
	}

	public void setSalaaulas(List<Salaaula> salaaulas) {
		this.salaaulas = salaaulas;
	}

	public Salaaula addSalaaula(Salaaula salaaula) {
		getSalaaulas().add(salaaula);
		salaaula.setPeriodo(this);

		return salaaula;
	}

	public Salaaula removeSalaaula(Salaaula salaaula) {
		getSalaaulas().remove(salaaula);
		salaaula.setPeriodo(null);

		return salaaula;
	}

}