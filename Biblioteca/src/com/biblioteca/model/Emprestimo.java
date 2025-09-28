package com.biblioteca.model;

import java.time.LocalDateTime;

public class Emprestimo {
    public static int _id = 1;

    private int id;
    private Usuario usuario;
    private Livro livro;

    private LocalDateTime data_emprestimo;
    private LocalDateTime data_prevista;
    private LocalDateTime data_devolucao;

    public Emprestimo(Usuario usuario, Livro livro){
        LocalDateTime data = LocalDateTime.now();
        this.usuario = usuario;
        this.livro = livro;
        this.data_emprestimo = data;
        this.data_prevista = data.plusDays(usuario.getPrazoDias());
        livro.setQuantidade(livro.getQuantidade()-1);
        this.id = _id++;
    }

    public int getId(){
        return this.id;
    }

    public void devolverLivro(){
        this.data_devolucao = LocalDateTime.now();
        this.livro.setQuantidade(livro.getQuantidade()+1);
    }

    public Livro getLivro(){
        return this.livro;
    }

    public String getDataPrevista(){
        return this.data_prevista.toString();
    }

    public String getDataDevolucao(){
        return this.data_devolucao.toString();
    }

    public Usuario getUsuario(){
        return usuario;
    }
}
