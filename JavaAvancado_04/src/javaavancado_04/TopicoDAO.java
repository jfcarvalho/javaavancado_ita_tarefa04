package javaavancado_04;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nessk
 */
public interface TopicoDAO {
   
   //insere um novo usuário no banco de dados
   public void inserir(Topico t);
   
   //retorna a lista de usuários ordenada por pontos (maior primeiro)
   public List<Topico> topicos();
   
   
 //insere um novo usuário no banco de dados
   public void inserirComentario(Comentario co);
   
   //retorna a lista de usuários ordenada por pontos (maior primeiro)
   public List<Comentario> comentarios();
   
}