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

import br.com.treinamento.dao.ClienteDao;
import br.com.treinamento.entity.Cliente;

@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteMB {
	
	private Cliente cliente = new Cliente();

	private List<Cliente> listCliente = new ArrayList<Cliente>();

	private List<Cliente> selecionadosCliente = new ArrayList<Cliente>();;

	@PostConstruct
	public void init() {
		consultarAllCliente();
	}

	public void salvarCliente(ActionEvent actionEvent) {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.insertCliente(cliente);
		cliente = new Cliente();
		addMessage("Cliente Salvo com Sucesso!");
	}

	public void excluirCliente(ActionEvent actionEvent) {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.excluirCliente(cliente);
		cliente = new Cliente();
		consultarAllCliente();
		addMessage("Cliente Excluído com Sucesso!");
	}

	public void consultarAllCliente() {
		ClienteDao clienteDao = new ClienteDao();
		listCliente = clienteDao.consultaAllCliente();
	}

	public static List<String> complete(String query) {
		ClienteDao clienteDao = new ClienteDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = clienteDao.complete(query);
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String nomeId = event.getObject().toString();
		String id = nomeId.substring((nomeId.indexOf("#") + 1), nomeId.length());
		ClienteDao clienteDao = new ClienteDao();
		cliente = clienteDao.buscaClienteById(Integer.parseInt(id));
	}

	public void buscaCep(AjaxBehaviorEvent event) {
		Document doc;
		try {
			doc = Jsoup.connect("https://solutioin.com/toth/services/cepservice/consultarcep/"
					+ cliente.getCep().replaceAll("-", "")).get();
			Elements links = doc.getAllElements();
			cliente.setEndereco(links.get(8).text());
			cliente.setCidade(links.get(9).text());
			cliente.setBairro(links.get(7).text());
			cliente.setEstado(links.get(10).text());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limparFormulario(ActionEvent actionEvent) {
		cliente = new Cliente();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getparameter(Cliente cliente) {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idColuna");
		System.out.println("id:" + cliente.getId());
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirClienteList(ActionEvent event) {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.excluirClienteList(selecionadosCliente);
		consultarAllCliente();
		addMessage("Cliente(es) Excluído(s) com Sucesso!");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public List<Cliente> getSelecionadosCliente() {
		return selecionadosCliente;
	}

	public void setSelecionadosCliente(List<Cliente> selecionadosCliente) {
		this.selecionadosCliente = selecionadosCliente;
	}

}
