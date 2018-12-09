package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComentarioDAO;
import dao.ComentarioDAOImpl;
import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Comentario;
import model.Topico;

@WebServlet("/visualizarTopico")

public class VisualizarTopicoController extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TopicoDAO tp = new TopicoDAOImpl();
		ComentarioDAO cc = new ComentarioDAOImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		Topico topico = tp.recuperarTopico(id);
		UsuarioDAO us = new UsuarioDAOImpl();
		
		List<Comentario> comentarios = cc.comentarios(id);
		HttpSession sessao = req.getSession();
		String login = (String) sessao.getAttribute("login_usuario");
		
		
		req.setAttribute("topico", topico);
		req.setAttribute("comentarios", comentarios);
		req.setAttribute("usuario", us.recuperar(login));
        req.getRequestDispatcher("/visualizarTopico.jsp").forward(req, resp);

	}
}
