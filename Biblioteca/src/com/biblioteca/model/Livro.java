package com.biblioteca.model;

public class Livro {

    private String titulo;
    private String autor;
    private int ano;
    private int quantidade;

    @Override
    public String toString() {
        return "[" + "Titulo: " + titulo + ", Autor: " + autor + ", Ano: " + ano + ", Quandidade: " + quantidade + "]";
    }

    public Livro(String titulo, String autor, int ano, int quantidade){
        this.ano = ano;
        this.quantidade = quantidade;
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public int getAno(){
        return this.ano;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
}
