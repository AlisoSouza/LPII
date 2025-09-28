package com.biblioteca.model;

public class Professor extends Usuario {
    public Professor(int matricula, String nome, String curso){
        super(matricula, nome, curso);
    }
    @Override
    public int getPrazoDias() {
        return 14;
    }
}
