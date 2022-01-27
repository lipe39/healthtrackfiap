package br.com.fiap.healthtrack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.PesoBO;
import br.com.fiap.healthtrack.UsuarioBO;

/**
 * Servlet implementation class cadastrarPesoController
 */
@WebServlet("/CadastrarPesoController")
public class CadastrarPesoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPesoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valorPeso = request.getParameter("valorPeso");
		UsuarioBO usuarioBO = (UsuarioBO)request.getSession().getAttribute("usuario");
		PesoBO pesoBO = new PesoBO();
		pesoBO.setValor_peso(Double.parseDouble(valorPeso));
		
		pesoBO.cadastrar(usuarioBO);

		RequestDispatcher rd = request.getRequestDispatcher("PesoListarController");
		rd.forward(request, response);
	}

}
