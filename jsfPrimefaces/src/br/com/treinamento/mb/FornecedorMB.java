package br.com.treinamento.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.primefaces.event.SelectEvent;

import br.com.treinamento.dao.FornecedorDao;
import br.com.treinamento.entity.Fornecedor;

@ManagedBean(name = "fornecedorMB")
@ViewScoped
public class FornecedorMB {

	private Fornecedor fornecedor = new Fornecedor();

	private List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();

	private Fornecedor selectedFornecedor;// = new Fornecedor();

	private Fornecedor[] selectedFornecedorArray;

	private List<Fornecedor> selecionadosFornecedor = new ArrayList<Fornecedor>();;

	@PostConstruct
	public void init() {
		consultarAllFornecedor();
	}

	public void salvarFornecedor(ActionEvent actionEvent) {
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.insertFornecedor(fornecedor);
		addMessage("Fornecedor Salvo com Sucesso!");
	}

	public void excluirFornecedor(ActionEvent actionEvent) {
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.excluirFornecedor(fornecedor);
		fornecedor = new Fornecedor();
		consultarAllFornecedor();
		addMessage("Fornecedor Excluído com Sucesso!");
	}

	public void consultarAllFornecedor() {
		FornecedorDao fornecedorDao = new FornecedorDao();
		listFornecedor = fornecedorDao.consultaAllFornecedor();
	}

	public static List<String> complete(String query) {
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = fornecedorDao.complete(query);
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String razaoSocialId = event.getObject().toString();
		String id = razaoSocialId.substring((razaoSocialId.indexOf("#") + 1), razaoSocialId.length());
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedor = fornecedorDao.buscaFornecedorById(Integer.parseInt(id));
	}

	public void buscaCep(AjaxBehaviorEvent event) {
		Document doc;
		try {
			doc = Jsoup.connect("https://solutioin.com/toth/services/cepservice/consultarcep/"
					+ fornecedor.getCep().replaceAll("-", "")).get();
			Elements links = doc.getAllElements();
			fornecedor.setEndereco(links.get(8).text());
			fornecedor.setCidade(links.get(9).text());
			fornecedor.setBairro(links.get(7).text());
			fornecedor.setEstado(links.get(10).text());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limparFormulario(ActionEvent actionEvent) {
		fornecedor = new Fornecedor();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getparameter(Fornecedor fornecedor) {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idColuna");
		System.out.println("id:" + fornecedor.getId());
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirFornecedorList(ActionEvent event) {
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.excluirFornecedorList(selecionadosFornecedor);
		consultarAllFornecedor();
		addMessage("Fornecedor(es) Excluído(s) com Sucesso!");
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getListFornecedor() {
		return listFornecedor;
	}

	public void setListFornecedor(List<Fornecedor> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}

	public Fornecedor getSelectedFornecedor() {
		return selectedFornecedor;
	}

	public void setSelectedFornecedor(Fornecedor selectedFornecedor) {
		this.selectedFornecedor = selectedFornecedor;
	}

	public Fornecedor[] getSelectedFornecedorArray() {
		return selectedFornecedorArray;
	}

	public void setSelectedFornecedorArray(Fornecedor[] selectedFornecedorArray) {
		this.selectedFornecedorArray = selectedFornecedorArray;
	}

	public List<Fornecedor> getSelecionadosFornecedor() {
		return selecionadosFornecedor;
	}

	public void setSelecionadosFornecedor(List<Fornecedor> selecionadosFornecedor) {
		this.selecionadosFornecedor = selecionadosFornecedor;
	}

}
