package com.biblioteca.model;

public abstract class Usuario {
    private int matricula;//USUARIO(matricula, nome, curso)
    private String nome;
    private String curso;

    public String getNome(){
        return this.nome;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public String getCurso(){
        return this.curso;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public Usuario(int matricula, String nome, String curso){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public abstract int getPrazoDias();
}
