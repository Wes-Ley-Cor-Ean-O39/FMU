package br.com.bytebank.banco.modelo;

public class Cliente {

	String nome;
	String cpf;
	String profissao;

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", profissao=" + profissao + "]";
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
