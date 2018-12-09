package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import model.Topico;

@WebServlet("/listarTopicos")

public class ListarTopicosController extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TopicoDAO tp = new TopicoDAOImpl();
		List<Topico> topicos = tp.topicos();
		
		System.out.println(topicos.size());
		req.setAttribute("topicos", topicos);
        req.getRequestDispatcher("/topicos.jsp").forward(req, resp);

	}
}
