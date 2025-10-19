package br.universidade.repo.app.modelo;

public class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor){
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "[" + "Titulo: " + this.titulo + ", Autor: " + this.autor + "]";
    }
}
