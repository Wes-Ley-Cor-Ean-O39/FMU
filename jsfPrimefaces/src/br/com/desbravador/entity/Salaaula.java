package br.com.desbravador.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salaaula database table.
 * 
 */
@Entity
@NamedQuery(name="Salaaula.findAll", query="SELECT s FROM Salaaula s")
public class Salaaula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="salaaula")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Escola
	@ManyToOne
	@JoinColumn(name="idEscola")
	private Escola escola;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="idPeriodo")
	private Periodo periodo;

	public Salaaula() {
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

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setSalaaula(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setSalaaula(null);

		return aluno;
	}

	public Escola getEscola() {
		return this.escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}