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

import br.com.treinamento.dao.AlunoDao;
import br.com.treinamento.entity.Aluno;
import br.com.treinamento.entity.Escola;
import br.com.treinamento.entity.Nota;
import br.com.treinamento.entity.Salaaula;

@ManagedBean(name = "alunoMB")
@ViewScoped
public class AlunoMB {

	private static Aluno aluno = new Aluno();

	private Nota nota = new Nota();

	private List<Aluno> listAluno = new ArrayList<Aluno>();

	private static List<Nota> listNotas = new ArrayList<Nota>();

	private List<Salaaula> listSalaAula = new ArrayList<Salaaula>();

	private List<Escola> listEscola = new ArrayList<Escola>();

	private static Escola escola = new Escola();

	private Salaaula salaaula = new Salaaula();

	private List<Aluno> selecionadosAluno;

	private static List<Nota> selecionadosNotas = new ArrayList<Nota>();;

	@PostConstruct
	public void init() {
		consultarAllAluno();
		consultarAllEscolas();
	}

	public void salvarAluno(ActionEvent actionEvent) {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.insertAluno(aluno);
		consultarAllAluno();
		addMessage("Aluno Salvo com Sucesso!");
	}

	public void salvarNota(ActionEvent actionEvent) {
		AlunoDao alunoDao = new AlunoDao();
		nota.setAluno(aluno);
		alunoDao.insertNota(nota);
		listNotas = alunoDao.buscaNotasByIdAluno(aluno.getId());
		nota = new Nota();
		addMessage("Nota Salva com Sucesso!");
	}

	public void excluirFromGrid(ActionEvent event) {
		System.out.println("entrei no botao gerar");
		// FacesContext ctx = FacesContext.getCurrentInstance();
	}

	public void excluirAluno(ActionEvent actionEvent) {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.excluirAluno(aluno);
		consultarAllAluno();
		aluno = new Aluno();
		listNotas = new ArrayList<Nota>();
		addMessage("Aluno Excluído com Sucesso!");
	}

	public static void excluirNotaList(ActionEvent actionEvent) {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.excluirNotas((ArrayList<Nota>) selecionadosNotas);
		listNotas = AlunoDao.buscaNotasByIdAluno(aluno.getId());
		addMessage("Nota (s) Excluída com Sucesso!");
	}
	

	public void excluirFromGridNota(ActionEvent event) {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.excluirAlunoList(selecionadosAluno);
		consultarAllAluno();
		addMessage("Aluno(s) Excluído(s) com Sucesso!");
	}

	public void buscaSalaAulaByEscola() {
		AlunoDao alunoDao = new AlunoDao();
		salaaula.setEscola(escola);
		aluno.setSalaaula(salaaula);
		listSalaAula = alunoDao.consultaSalaAulaByIdEscola(escola.getId());
		// listSalaAula =
		// alunoDao.consultaSalaAulaByIdEscola(String.valueOf(escola.getId()));
	}

	public void consultaNotasByIdAluno() {
		AlunoDao alunoDao = new AlunoDao();
	}

	public void consultarAllEscolas() {
		AlunoDao alunoDao = new AlunoDao();
		listEscola = alunoDao.consultaAllEscola();
	}

	public void consultarAllAluno() {
		AlunoDao alunoDao = new AlunoDao();
		listAluno = alunoDao.consultarAllAluno();
		// INSIRA AQUI O METÓDO DE CONSULTA DE ESCOLA E SALA DE AULA FEITOS NO DAO!!!
	}

	public static List<String> complete(String query) {
		AlunoDao alunoDao = new AlunoDao();
		List<String> listReturn = new ArrayList<String>();
		listReturn = alunoDao.complete(query, escola.getId());
		return listReturn;
	}

	public void onItemSelect(SelectEvent event) {
		String nomeId = event.getObject().toString();
		String id = nomeId.substring((nomeId.indexOf("#") + 1), nomeId.length());
		AlunoDao alunoDao = new AlunoDao();
		aluno = alunoDao.buscaAlunoById(Integer.parseInt(id));
		salaaula = aluno.getSalaaula();
		listNotas = alunoDao.buscaNotasByIdAluno(Integer.parseInt(id));
		System.out.println("total de notas" + listNotas.size());
		System.out.println("idAluno" + id);
	}

	public void buscaCep(AjaxBehaviorEvent event) {
		Document doc;
		try {
			doc = Jsoup.connect(
					"https://solutioin.com/toth/services/cepservice/consultarcep/" + aluno.getCep().replaceAll("-", ""))
					.get();
			Elements links = doc.getAllElements();
			aluno.setEndereco(links.get(8).text());
			aluno.setCidade(links.get(9).text());
			aluno.setEstado(links.get(10).text());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limparFormulario(ActionEvent actionEvent) {
		aluno = new Aluno();
		salaaula = new Salaaula();
	    escola = new Escola();
		listNotas.clear();
	}

	public static void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowSelectBO(SelectEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String bean = ctx.getExternalContext().getRequestParameterMap().get("paramMB");
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListAluno() {
		return listAluno;
	}

	public void setListAluno(List<Aluno> listAluno) {
		this.listAluno = listAluno;
	}

	public List<Aluno> getSelecionadosAluno() {
		return selecionadosAluno;
	}

	public void setSelecionadosAluno(List<Aluno> selecionadosAluno) {
		this.selecionadosAluno = selecionadosAluno;
	}

	public List<Nota> getListNotas() {
		return listNotas;
	}

	public void setListNotas(List<Nota> listNotas) {
		this.listNotas = listNotas;
	}

	public List<Nota> getSelecionadosNotas() {
		return selecionadosNotas;
	}

	public void setSelecionadosNotas(List<Nota> selecionadosNotas) {
		this.selecionadosNotas = selecionadosNotas;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public List<Escola> getListEscola() {
		return listEscola;
	}

	public void setListEscola(List<Escola> listEscola) {
		this.listEscola = listEscola;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		AlunoMB.escola = escola;
	}

	public List<Salaaula> getListSalaAula() {
		return listSalaAula;
	}

	public void setListSalaAula(List<Salaaula> listSalaAula) {
		this.listSalaAula = listSalaAula;
	}

	public Salaaula getSalaaula() {
		return salaaula;
	}

	public void setSalaaula(Salaaula salaaula) {
		this.salaaula = salaaula;
	}

}
