package br.com.alura.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/NovaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Empresa...");
		 String nomeEmpresa = request.getParameter("nome");
	        Empresa empresa = new Empresa();
	        empresa.setNome(nomeEmpresa);

	        Banco banco = new Banco();
	        banco.adiciona(empresa);

	        PrintWriter writer = response.getWriter();
	        writer.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
		System.out.println("Empresa Cadastrada com Sucesso");
		writer.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresa();
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<ul>");
		for (Empresa empresa : lista) {
			writer.println("<li> " + empresa.getNome() + " </li>");
		}
		writer.println("</ul>");
		writer.println("");
	}

}
