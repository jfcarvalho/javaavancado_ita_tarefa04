import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import dao.TopicoDAO;
import dao.TopicoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Topico;
import model.Usuario;

public class TesteTopicoDAO {

	JdbcDatabaseTester jdt;
	TopicoDAO tp = new TopicoDAOImpl();
	UsuarioDAO us = new UsuarioDAOImpl();
	
	@Before
	
	public void setUp() throws Exception{
		jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/coursera", "root", "root");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicioTopico.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void recuperaTopico() {
		Topico topic = tp.recuperarTopico(3);
		assertEquals("Aliquam erat lectus", topic.getTitulo());
		Topico topic2 = tp.recuperarTopico(1);
		assertEquals("Curabitur vel hendrerit justo", topic2.getTitulo());
	
	}
	
	@Test
	public void insere() throws SQLException, Exception {
		
		Topico topico = new Topico();
		
		
		topico.setConteudo("Sed porta placerat neque, ac ullamcorper urna tempor eu. Etiam non viverra augue. Phasellus facilisis ligula nunc, id efficitur erat varius eu. Quisque in malesuada mauris, quis cursus nulla. Etiam convallis, nulla ut sodales volutpat, nisl neque consequat augue, at egestas elit metus eu tellus. Fusce blandit purus bibendum, fermentum tortor in, elementum justo. Ut ullamcorper rutrum consequat. Mauris id scelerisque turpis. Sed quam tortor, hendrerit facilisis semper vel, bibendum ac nunc. Pellentesque at tellus vestibulum, imperdiet odio non, tempus magna. Nam iaculis nisl nibh, vel malesuada justo ornare at. Nunc a volutpat erat. Nullam vel iaculis diam.");
		topico.setId_topico(5);
		topico.setTitulo("Nullam vel iaculis diam");
		topico.setUsuario(us.recuperar("marcos.lazaro"));
		
		
		tp.inserir(topico); 
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("topico");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/VerificaTopico.xml");
		
		ITable expectedTable = expectedDataset.getTable("topico");
		Assertion.assertEquals(expectedTable, currentTable);
		
	}
	
	@Test
	public void topicos() {
		
		List<Topico> topicos = tp.topicos();
		assertEquals(4, topicos.size());

		
	}

}
