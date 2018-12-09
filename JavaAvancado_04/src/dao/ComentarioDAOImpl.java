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

import model.Comentario;
import model.Topico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nessk
 */
public class ComentarioDAOImpl implements ComentarioDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Comentario> comentarios(int id)
    {
        List<Comentario> todos = new ArrayList<>();
        try
        {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
            String sql = "SELECT * FROM comentario where id_topico = ?;";
            
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, Integer.toString(id));
            
            ResultSet rs = stm.executeQuery();
            TopicoDAO tp = new TopicoDAOImpl();
            UsuarioDAO us = new UsuarioDAOImpl();
            
            while(rs.next())
            {
                Comentario co = new Comentario();
                co.setComentario(rs.getString("comentario"));
                co.setUsuario(us.recuperar(rs.getString("login")));
                Topico t = tp.recuperarTopico(rs.getInt("id_topico"));
                co.setTopico(t);
                todos.add(co);
            }
        } catch(SQLException e) {
         //TODO Autopgenerated catch block
         throw new RuntimeException("Não foi possível executar o acesso", e); 
         
        }
        return todos;
    }

    
    @Override
    public void inserirComentario(Comentario co) {
        try
       {
             
        	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?);";
              PreparedStatement stm = c.prepareStatement(sql);
              UsuarioDAO us = new UsuarioDAOImpl();
              
              //co.getUsuario().setPontos(co.getUsuario().getPontos()+3);
              us.adicionarPontos(co.getUsuario().getLogin(), 3);
              stm.setString(1, co.getComentario());
              stm.setString(2, co.getUsuario().getLogin());
              stm.setInt(3, co.getTopico().getId_topico());
             
              stm.executeUpdate();
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
    }


    
    
    }
