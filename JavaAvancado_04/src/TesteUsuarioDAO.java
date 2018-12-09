import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Usuario;

public class TesteUsuarioDAO {

	JdbcDatabaseTester jdt;
	UsuarioDAO us = new UsuarioDAOImpl();
	
	@Before
	
	public void setUp() throws Exception{
		jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/coursera", "root", "root");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void recuperaLogin() {
			
		Usuario user = us.recuperar("gitirana");
		assertEquals("Alexandre Gitirana", user.getNome());
		
	}
	
	@Test
	public void autenticar() throws Exception {
			
		String nome = us.autenticar("yuri.cesar", "yuri");
		assertEquals("Yuri Cesar", nome);
		
	}
	
	@Test
	public void inserirUsuario() throws Exception {
			
		Usuario novo = new Usuario();
		novo.setLogin("karina.melo");
		novo.setNome("Karina Melo");
		novo.setEmail("karina.melo@solutis.com.br");
		novo.setSenha("Karina");
		novo.setPontos(1500);
		
		us.inserir(novo);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("usuario");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/VerificaUsuario.xml");
		
		ITable expectedTable = expectedDataset.getTable("usuario");
		Assertion.assertEquals(expectedTable, currentTable);
		
		
	}
	
	@Test
	public void adicionarPontos() throws Exception {
			
		String login = "jean.carvalho";
		int pontos = 1400;
		
		us.adicionarPontos(login, pontos);
		Usuario user = us.recuperar(login);
		
		assertEquals(1500, user.getPontos());
		
	}
	
	@Test
	public void ranking() throws Exception {
			
		String login_primeiro = "jean.carvalho";
		int pontos_primeiro = 1500;
		
		String login_segundo = "gitirana";
		int pontos_segundo = 1200;
		
		String login_terceiro = "alex.silva";
		int pontos_terceiro = 1000;
		
		us.adicionarPontos(login_primeiro, pontos_primeiro);
		us.adicionarPontos(login_segundo, pontos_segundo);
		us.adicionarPontos(login_terceiro, pontos_terceiro);
			
		List<Usuario> ranking = us.ranking();
		
		assertEquals("Jean Carvalho", ranking.get(0).getNome());
		assertEquals("Alexandre Gitirana", ranking.get(1).getNome());
		assertEquals("Alex Silva", ranking.get(2).getNome());
		
		
	}
	
	
	
	
	

}
