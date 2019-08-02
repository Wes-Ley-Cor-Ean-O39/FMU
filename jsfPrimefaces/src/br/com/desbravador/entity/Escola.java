package br.com.desbravador.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escola database table.
 * 
 */
@Entity
@NamedQuery(name="Escola.findAll", query="SELECT e FROM Escola e")
public class Escola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String cep;

	private String cidade;

	private String endereco;

	private String estado;

	private String nome;

	//bi-directional many-to-one association to Diretor
	@ManyToOne
	@JoinColumn(name="idDiretor")
	private Diretor diretor;

	//bi-directional many-to-one association to Salaaula
	@OneToMany(mappedBy="escola")
	private List<Salaaula> salaaulas;

	public Escola() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Diretor getDiretor() {
		return this.diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public List<Salaaula> getSalaaulas() {
		return this.salaaulas;
	}

	public void setSalaaulas(List<Salaaula> salaaulas) {
		this.salaaulas = salaaulas;
	}

	public Salaaula addSalaaula(Salaaula salaaula) {
		getSalaaulas().add(salaaula);
		salaaula.setEscola(this);

		return salaaula;
	}

	public Salaaula removeSalaaula(Salaaula salaaula) {
		getSalaaulas().remove(salaaula);
		salaaula.setEscola(null);

		return salaaula;
	}

}