package br.com.treinamento.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.treinamento.dao.DesbravadorDao;
import br.com.treinamento.entity.Desbravador;

@ManagedBean(name = "desbravadorMB")
@ViewScoped
public class DesbravadorMB {

	private Desbravador desbravador = new Desbravador();

	private List<Desbravador> listDesbravador = new ArrayList<Desbravador>();

	private Desbravador selectedDesbravador;// = new Fornecedor();

	private Desbravador[] selectedDesbravadorArray;

	private List<Desbravador> selecionadosDesbravador = new ArrayList<Desbravador>();;

	@PostConstruct
	public void init() {
		consultarAllDesbravador();
	}

	public void salvarDesbravador(ActionEvent actionEvent) {
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		desbravadorDao.insertDesbravador(desbravador);
		addMessage("Desbravador Salvo com Sucesso!");
	}

	public void excluirDesbravador(ActionEvent actionEvent) {
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		desbravadorDao.excluirDesbravador(desbravador);
		desbravador = new Desbravador();
		consultarAllDesbravador();
		addMessage("Desbravador Excluído com Sucesso!");
	}

	public void consultarAllDesbravador() {
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		listDesbravador = desbravadorDao.consultaAllDesbravador();
	}

	public static List<String> complete(String query) {
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = desbravadorDao.complete(query);
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String nomeId = event.getObject().toString();
		String id = nomeId.substring((nomeId.indexOf("#") + 1), nomeId.length());
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		desbravador = desbravadorDao.buscaDesbravadorById(Integer.parseInt(id));
	}

	public void limparFormulario(ActionEvent actionEvent) {
		desbravador = new Desbravador();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getparameter(Desbravador desbravador) {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idColuna");
		System.out.println("id:" + desbravador.getId());
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirDesbravadorList(ActionEvent event) {
		DesbravadorDao desbravadorDao = new DesbravadorDao();
		desbravadorDao.excluirDesbravadorList(selecionadosDesbravador);
		consultarAllDesbravador();
		addMessage("Desbravador(es) Excluído(s) com Sucesso!");
	}

	public Desbravador getDesbravador() {
		return desbravador;
	}

	public void setDesbravador(Desbravador desbravador) {
		this.desbravador = desbravador;
	}

	public List<Desbravador> getListDesbravador() {
		return listDesbravador;
	}

	public void setListDesbravador(List<Desbravador> listDesbravador) {
		this.listDesbravador = listDesbravador;
	}

	public Desbravador getSelectedDesbravador() {
		return selectedDesbravador;
	}

	public void setSelectedDesbravador(Desbravador selectedDesbravador) {
		this.selectedDesbravador = selectedDesbravador;
	}

	public Desbravador[] getSelectedDesbravadorArray() {
		return selectedDesbravadorArray;
	}

	public void setSelectedDesbravadorArray(Desbravador[] selectedDesbravadorArray) {
		this.selectedDesbravadorArray = selectedDesbravadorArray;
	}

	public List<Desbravador> getSelecionadosDesbravador() {
		return selecionadosDesbravador;
	}

	public void setSelecionadosDesbravador(List<Desbravador> selecionadosDesbravador) {
		this.selecionadosDesbravador = selecionadosDesbravador;
	}

}
