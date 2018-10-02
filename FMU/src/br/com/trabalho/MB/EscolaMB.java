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

import br.com.trabalho.Escola;
import br.com.trabalho.DAO.EscolaDao;

@ManagedBean(name = "escolaMB")
@ViewScoped
public class EscolaMB {

	private Escola escola = new Escola();

	private List<Escola> listEscola = new ArrayList<Escola>();

	private Escola selectedEscola; 

	private Escola[] selectedEscolaArray;

	private List<Escola> selecionadosEscola = new ArrayList<Escola>();;

	@PostConstruct
	public void init() {
		consultarAllEscola();
	}

	public void salvarEscola(ActionEvent actionEvent) {
		EscolaDao escolaDao = new EscolaDao();
		escolaDao.insertEscola(escola);
		addMessage("Escola Salva com Sucesso!");
	}

	public void excluirEscola(ActionEvent actionEvent) {
		EscolaDao escolaDao = new EscolaDao();
		escolaDao.excluirEscola(escola);
		escola = new Escola();
		consultarAllEscola();
		addMessage("Escola Excluída com Sucesso!");
	}

	public void consultarAllEscola() {
		EscolaDao escolaDao = new EscolaDao();
		listEscola = escolaDao.consultaAllEscola();
	}

	public static List<String> complete(String query) {
		EscolaDao escolaDao = new EscolaDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = escolaDao.complete(query);
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String nomeId = event.getObject().toString();
		String id = nomeId.substring((nomeId.indexOf("#") + 1), nomeId.length());
		EscolaDao escolaDao = new EscolaDao();
		escola = escolaDao.buscaEscolaById(Integer.parseInt(id));
	}

	public void limparFormulario(ActionEvent actionEvent) {
		escola = new Escola();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getparameter(Escola escola) {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idColuna");
		System.out.println("id:" + escola.getId());
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirEscolaList(ActionEvent event) {
		EscolaDao escolaDao = new EscolaDao();
		escolaDao.excluirEscolaList(selecionadosEscola);
		consultarAllEscola();
		addMessage("Escola(as) Excluído(s) com Sucesso!");

	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Escola> getListEscola() {
		return listEscola;
	}

	public void setListEscola(List<Escola> listEscola) {
		this.listEscola = listEscola;
	}

	public Escola getSelectedEscola() {
		return selectedEscola;
	}

	public void setSelectedEscola(Escola selectedEscola) {
		this.selectedEscola = selectedEscola;
	}

	public Escola[] getSelectedEscolaArray() {
		return selectedEscolaArray;
	}

	public void setSelectedEscolaArray(Escola[] selectedEscolaArray) {
		this.selectedEscolaArray = selectedEscolaArray;
	}

	public List<Escola> getSelecionadosEscola() {
		return selecionadosEscola;
	}

	public void setSelecionadosEscola(List<Escola> selecionadosEscola) {
		this.selecionadosEscola = selecionadosEscola;
	}

}