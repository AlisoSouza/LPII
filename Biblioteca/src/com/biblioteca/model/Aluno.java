package com.biblioteca.model;

public class Aluno extends Usuario {
    public Aluno(int matricula, String nome, String curso){
        super(matricula, nome, curso);
    }
    @Override
    public int getPrazoDias() {
        return 7;
    }
}
