package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Usuario;


@WebServlet(urlPatterns = {"/Ranking"})

public class RankingController extends HttpServlet {
	
	 
	 
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UsuarioDAO us = new UsuarioDAOImpl();
			List<Usuario> usuarios = us.ranking();
			
			req.setAttribute("usuarios", usuarios);
			
			
	        req.getRequestDispatcher("/visualizarRanking.jsp").forward(req, resp);

		}
	 

}
