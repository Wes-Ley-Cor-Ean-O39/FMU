package br.com.trabalho.MB;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.trabalho.Cadastro;
import br.com.trabalho.DAO.CadastroDao;

@ManagedBean(name = "cadastroMB")
@ViewScoped
public class CadastroMB {

	private Cadastro cadastro = new Cadastro();

	private List<Cadastro> listCadastro = new ArrayList<Cadastro>();

	private Cadastro selectedCadastro;

	private Cadastro[] selectedCadastroArray;

	private List<Cadastro> selecionadosCadastro = new ArrayList<Cadastro>();;

	@PostConstruct
	public void init() {
		consultarAllCadastro();
	}

	public void salvarCadastro(ActionEvent actionEvent) {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.insertCadastro(cadastro);
		addMessage("Cadastro Salvo com Sucesso!");
	}

	public void excluirCadastro(ActionEvent actionEvent) {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.excluirCadastro(cadastro);
		cadastro = new Cadastro();
		consultarAllCadastro();
		addMessage("Cadastro Excluído com Sucesso!");
	}

	public void consultarAllCadastro() {
		CadastroDao cadastroDao = new CadastroDao();
		listCadastro = cadastroDao.consultaAllCadastro();
	}

	public static List<String> complete(String query) {
		CadastroDao cadastroDao = new CadastroDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = cadastroDao.complete(query);
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String empresaId = event.getObject().toString();
		String id = empresaId.substring((empresaId.indexOf("#") + 1), empresaId.length());
		CadastroDao cadastroDao = new CadastroDao();
		cadastro = cadastroDao.buscaCadastroById(Integer.parseInt(id));
	}

	public void limparFormulario(ActionEvent actionEvent) {
		cadastro = new Cadastro();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getparameter(Cadastro cadastro) {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idColuna");
		System.out.println("id:" + cadastro.getId());
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirCadastroList(ActionEvent event) {
		CadastroDao cadastroDao = new CadastroDao();
		cadastroDao.excluirCadastroList(selecionadosCadastro);
		consultarAllCadastro();
		addMessage("Cadastro(as) Excluído(s) com Sucesso!");

	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Cadastro> getListCadastro() {
		return listCadastro;
	}

	public void setListCadastro(List<Cadastro> listCadastro) {
		this.listCadastro = listCadastro;
	}

	public Cadastro getSelectedCadastro() {
		return selectedCadastro;
	}

	public void setSelectedCadastro(Cadastro selectedCadastro) {
		this.selectedCadastro = selectedCadastro;
	}

	public Cadastro[] getSelectedCadastroArray() {
		return selectedCadastroArray;
	}

	public void setSelectedCadastroArray(Cadastro[] selectedCadastroArray) {
		this.selectedCadastroArray = selectedCadastroArray;
	}

	public List<Cadastro> getSelecionadosCadastro() {
		return selecionadosCadastro;
	}

	public void setSelecionadosCadastro(List<Cadastro> selecionadosCadastro) {
		this.selecionadosCadastro = selecionadosCadastro;
	}


}