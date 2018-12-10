import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import dao.ComentarioDAO;
import dao.ComentarioDAOImpl;
import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Comentario;
import model.Usuario;

public class TesteComentarioDAO {

	JdbcDatabaseTester jdt;
	ComentarioDAO co = new ComentarioDAOImpl();
	TopicoDAO tp = new TopicoDAOImpl();
	UsuarioDAO us = new UsuarioDAOImpl();

	
	@Before
	
	public void setUp() throws Exception{
		jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/coursera", "root", "root");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicioComentario.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void comentarios() {
		List<Comentario> c = co.comentarios(4);
		assertEquals("alex.silva", c.get(0).getUsuario().getLogin());
		
	}
	
	@Test
	public void inserirComentario() throws SQLException, Exception {
		
		Comentario c = new Comentario();
		c.setComentario("Morbi tempor ut urna a blandit. Phasellus at libero cursus, vulputate nisl ut, tristique nisl. Praesent a eros dignissim, semper libero sed, maximus felis. Quisque odio eros, faucibus a dolor a, pulvinar feugiat lectus. Pellentesque laoreet fringilla dolor quis scelerisque. Nullam finibus nec lectus consectetur bibendum. Suspendisse sed tempor lorem. Etiam et imperdiet lectus, vel laoreet tortor. Nullam auctor velit at dolor ornare hendrerit. Quisque rhoncus, velit ac commodo hendrerit, lacus leo cursus est, vitae scelerisque est quam ac elit. Fusce dui nulla, cursus vel dolor sed, sodales bibendum neque. Nulla facilisi. Quisque quam dui, fermentum in malesuada id, varius quis ante. Mauris quam ligula, rhoncus dapibus aliquet nec, tristique ac enim.");
		c.setTopico(tp.recuperarTopico(1));
		c.setUsuario(us.recuperar("marcos.lazaro"));
		
		co.inserirComentario(c);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("comentario");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/VerificaComentario.xml");
		
		ITable expectedTable = expectedDataset.getTable("comentario");
		Assertion.assertEquals(expectedTable, currentTable);
		
	}
	

}
