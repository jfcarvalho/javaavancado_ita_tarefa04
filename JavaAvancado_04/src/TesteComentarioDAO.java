import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import dao.ComentarioDAO;
import dao.ComentarioDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Usuario;

public class TesteComentarioDAO {

	JdbcDatabaseTester jdt;
	ComentarioDAO co = new ComentarioDAOImpl();

	
	@Before
	
	public void setUp() throws Exception{
		jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/coursera", "root", "root");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void comentarios() {
		
		
	}
	
	@Test
	public void inserirComentario() {
		
		
	}
	

}
