package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Topico;
import model.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nessk
 */
public class TopicoDAOImpl implements TopicoDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TopicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Topico> topicos()
    {
        List<Topico> todos = new ArrayList<>();
        try
        {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
            String sql = "SELECT * FROM topico;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            UsuarioDAO us = new UsuarioDAOImpl();
            
            while(rs.next())
            {
                Topico t = new Topico();
                t.setId_topico(rs.getInt("id_topico"));
                System.out.println(rs.getInt("id_topico"));
                
                System.out.println(rs.getString("titulo"));
                t.setTitulo(rs.getString("titulo"));
                System.out.println(rs.getString("conteudo"));
                t.setConteudo(rs.getString("conteudo"));
                System.out.println(rs.getString("login"));
                Usuario user = us.recuperar(rs.getString("login"));
                t.setUsuario(user);
                todos.add(t);
            }
        } catch(SQLException e) {
         //TODO Autopgenerated catch block
         throw new RuntimeException("Não foi possível executar o acesso", e); 
         
        }
        return todos;
    }
    


    @Override
    public void inserir(Topico t) {
        try
       {
             
        	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?);";
              PreparedStatement stm = c.prepareStatement(sql);
              UsuarioDAO us = new UsuarioDAOImpl();
              
              us.adicionarPontos(t.getUsuario().getLogin(), 10);
              stm.setString(1, t.getTitulo());
              stm.setString(2, t.getConteudo());
              stm.setString(3, t.getUsuario().getLogin());
             
              
              
             
              stm.executeUpdate();
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
    }
    
    @Override
    public Topico recuperarTopico(int id) {
    	Topico t = new Topico();
    	
    	try
       {
             
        	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "SELECT * FROM topico WHERE id_topico = ? ;";
              PreparedStatement stm = c.prepareStatement(sql);
              stm.setInt(1, id);
              ResultSet rs = stm.executeQuery();
              
              UsuarioDAO us = new UsuarioDAOImpl();
              
              while(rs.next()) {
                t.setConteudo(rs.getString("conteudo"));
                t.setTitulo(rs.getString("titulo"));
                t.setId_topico(rs.getInt("id_topico"));
                t.setUsuario(us.recuperar(rs.getString("login")));
                
               
              }
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
        return t;
    }
    


    
    
    }
