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


@WebServlet(urlPatterns = {"/CadastroComentario"})

public class CadastroComentarioController extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException
	 {
	        String comentario = request.getParameter("comentario");
	        int id_topico = Integer.parseInt(request.getParameter("id_topico"));
	        HttpSession sessao = request.getSession();
	        String login = (String) sessao.getAttribute("login_usuario");
	        String nome = (String) sessao.getAttribute("nome_usuario");
	        Comentario co = new Comentario();
	        TopicoDAO tp = new TopicoDAOImpl();
	        UsuarioDAO us = new UsuarioDAOImpl();
	        ComentarioDAO cc = new ComentarioDAOImpl();
	        
	        
	        co.setComentario(comentario);
	        co.setTopico(tp.recuperarTopico(id_topico));
	        co.setUsuario(us.recuperar(login));
	        	        
	        cc.inserirComentario(co);
	        
	        response.sendRedirect("visualizarTopico?id="+id_topico);
	       
	    }
	 
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			TopicoDAO tp = new TopicoDAOImpl();
			ComentarioDAO cc = new ComentarioDAOImpl();
			
			int id = Integer.parseInt(req.getParameter("id_topico"));
			
			Topico topico = tp.recuperarTopico(id);
					
			req.setAttribute("topico", topico);
			
			
	        req.getRequestDispatcher("/cadastroComentario.jsp").forward(req, resp);

		}
	 

}
