package controller;

import java.beans.JavaBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The dado. */
	JavaBeans dado = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			dados(request, response);
		} else if (action.equals("/insert")) {
			novoDado(request, response);
		} else if (action.equals("/select")) {
			listarDados(request, response);
		} else if (action.equals("/update")) {
			editarDado(request, response);
		} else if (action.equals("/delete")) {
			removerDado(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		// testando conexao
		// dao.testeConexao();
	}

	/**
	 * Dados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// listar dados
	protected void dados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarDados();
		// Encaminhar a lista ao documento estacionamento.js
		request.setAttribute("dadoss", lista);
		RequestDispatcher rd = request.getRequestDispatcher("estacionamento.jsp");
		rd.forward(request, response);

		/*
		 * o "for" irá exibir no console os dados armazenados no banco de dados //teste
		 * de recebimento da lista for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getId());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getTelefone());
		 * System.out.println(lista.get(i).getCpf());
		 * System.out.println(lista.get(i).getModeloVeiculo());
		 * System.out.println(lista.get(i).getMarcaVeiculo());
		 * System.out.println(lista.get(i).getPlacaVeiculo()); }
		 */

	}

	/**
	 * Novo dado.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// novo dado
	protected void novoDado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulario
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("telefone"));
		 * System.out.println(request.getParameter("cpf"));
		 * System.out.println(request.getParameter("modeloVeiculo"));
		 * System.out.println(request.getParameter("marcaVeiculo"));
		 * System.out.println(request.getParameter("placaVeiculo"));
		 */
		// setar as variaveis javabeans
		dado.setNome(request.getParameter("nome"));
		dado.setTelefone(request.getParameter("telefone"));
		dado.setCpf(request.getParameter("cpf"));
		dado.setModeloVeiculo(request.getParameter("modeloVeiculo"));
		dado.setMarcaVeiculo(request.getParameter("marcaVeiculo"));
		dado.setPlacaVeiculo(request.getParameter("placaVeiculo"));
		// invocar o metodo inserirDado passando o objeto dado
		dao.inserirDado(dado);
		// redirecionando para o documento estacionamento.jsp
		response.sendRedirect("main");
	}

	/**
	 * Listar dados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// editar dados
	protected void listarDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do dado que será editado
		String id = request.getParameter("id");

		// setando a variavel javabeans
		dado.setId(id);

		// executando o metodo selecionardado (dao)
		dao.selecionarDado(dado);

		// teste de recebimento
		/*
		 * System.out.println(dado.getId()); System.out.println(dado.getNome());
		 * System.out.println(dado.getTelefone()); System.out.println(dado.getCpf());
		 * System.out.println(dado.getModeloVeiculo());
		 * System.out.println(dado.getMarcaVeiculo());
		 * System.out.println(dado.getPlacaVeiculo());
		 */
		// setar os atributos do formulario com o conteudo javabeans
		request.setAttribute("id", dado.getId());
		request.setAttribute("nome", dado.getNome());
		request.setAttribute("telefone", dado.getTelefone());
		request.setAttribute("cpf", dado.getCpf());
		request.setAttribute("modeloVeiculo", dado.getModeloVeiculo());
		request.setAttribute("marcaVeiculo", dado.getMarcaVeiculo());
		request.setAttribute("placaVeiculo", dado.getPlacaVeiculo());

		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar dado.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarDado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis javabeans
		dado.setId(request.getParameter("id"));
		dado.setNome(request.getParameter("nome"));
		dado.setTelefone(request.getParameter("telefone"));
		dado.setCpf(request.getParameter("cpf"));
		dado.setModeloVeiculo(request.getParameter("modeloVeiculo"));
		dado.setMarcaVeiculo(request.getParameter("marcaVeiculo"));
		dado.setPlacaVeiculo(request.getParameter("placaVeiculo"));
		// executar o metodo alterar dado
		dao.alterarDado(dado);
		// redirecionar para o documento estacionamento.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}
	
	/**
	 * Remover dado.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerDado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recebimento do id do dado a ser excluido (validador.js)
		String id = request.getParameter("id");
		//setar a variavel id javabeans
		dado.setId(id);
		//executar o metodo deletarDado (dao) passando o objeto dado
		dao.deletarDado(dado);
		// redirecionar para o documento estacionamento.jsp (atualizando as alterações)
				response.sendRedirect("main");
	}
}
