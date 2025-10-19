package br.universidade.repo.app.modelo;


public class Aluno {
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "[" + "Nome: " + this.nome + ", Matricula: " + this.matricula + "]";
    }
}
