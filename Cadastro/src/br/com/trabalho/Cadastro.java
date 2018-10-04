package br.com.trabalho;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the cadastro database table.
 * 
 */
@Entity
@NamedQuery(name="Cadastro.findAll", query="SELECT c FROM Cadastro c")
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String empresa;

	private String modelo;

	private String motorista;

	private String placa;

	private String veiculo;

	public Cadastro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMotorista() {
		return this.motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

}