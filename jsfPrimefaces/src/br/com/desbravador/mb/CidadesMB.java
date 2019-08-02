package br.com.desbravador.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.desbravador.dao.CidadeDao;
import br.com.desbravador.entity.Cidade;
import br.com.desbravador.entity.Estado;

@ManagedBean(name = "cidadesMB")
@ViewScoped
public class CidadesMB {
	private Cidade cidade = new Cidade();
	private Estado estado = new Estado();
	private List<Cidade> listCidades = new ArrayList<Cidade>();
	private List<Estado> listEstado = new ArrayList<Estado>();

	@PostConstruct
	public void init() {
		consultaEstados();
	}

	public void buscaCidadeByEstado() {
		CidadeDao cidadeDao = new CidadeDao();
		listCidades = cidadeDao.consultaCidadesByEstado(cidade.getSiglaEstado());
		System.out.println("Total" + listCidades.size());
	}

	public void consultaEstados() {
		CidadeDao cidadeDao = new CidadeDao();
		List<Estado> list = cidadeDao.consultaEstados();
		System.out.println("Total" + listEstado.size());
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<Estado> listEstado) {
		this.listEstado = listEstado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<Cidade> listCidades) {
		this.listCidades = listCidades;
	}

}
