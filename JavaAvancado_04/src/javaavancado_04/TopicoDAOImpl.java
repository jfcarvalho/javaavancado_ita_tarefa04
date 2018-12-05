package javaavancado_04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            while(rs.next())
            {
                Topico t = new Topico();
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("conteudo"));
                t.setCriador(rs.getString("criador"));
                todos.add(t);
            }
        } catch(SQLException e) {
         //TODO Autopgenerated catch block
         throw new RuntimeException("Não foi possível executar o acesso", e); 
         
        }
        return todos;
    }
    
    @Override
    public List<Comentario> comentarios()
    {
        List<Comentario> todos = new ArrayList<>();
        try
        {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
            String sql = "SELECT * FROM comentario;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Comentario co = new Comentario();
                co.setConteudo(rs.getString("conteudo"));
                co.setCriador(rs.getString("criador"));
                co.setTopico(rs.getInt("topico"));
                todos.add(co);
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
              int numero = this.topicos().size()+1;
        	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "INSERT INTO topico(titulo, conteudo, criador, numero) VALUES (?, ?, ?, ?);";
              PreparedStatement stm = c.prepareStatement(sql);
              
              stm.setString(1, t.getTitulo());
              stm.setString(2, t.getConteudo());
              stm.setString(3, t.getCriador());
              stm.setInt(4, numero);
              
              
             
              stm.executeUpdate();
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
    }
    
    @Override
    public void inserirComentario(Comentario co) {
        try
       {
              int numero = this.comentarios().size()+1;
        	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "INSERT INTO topico(titulo, conteudo, criador, numero) VALUES (?, ?, ?, ?);";
              PreparedStatement stm = c.prepareStatement(sql);
              
              stm.setString(1, co.getConteudo());
              stm.setString(2, co.getCriador());
              stm.setInt(3, co.getTopico());
              
              stm.executeUpdate();
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
    }


    
    
    }
