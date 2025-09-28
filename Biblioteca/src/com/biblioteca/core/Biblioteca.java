package com.biblioteca.core;

import com.biblioteca.model.*;

import java.util.*;

public class Biblioteca {
    Comparator<Livro> comparadorPorTitulo = Comparator.comparing(Livro::getTitulo);
    Comparator<Usuario> comparadorPorMatricula = Comparator.comparing(Usuario::getMatricula);

    private Set<Livro> livros = new TreeSet<>(comparadorPorTitulo);
    private Set<Usuario> usuarios = new TreeSet<>(comparadorPorMatricula);

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private List<Emprestimo> emprestimosFinalizados = new ArrayList<Emprestimo>();

    public void cadastrarLivro(String titulo, String autor, int ano, int quantidade) {
        Livro livro = new Livro(titulo = titulo, autor = autor, ano = ano, quantidade = quantidade);
        livros.add(livro);

    }

    public void cadastrarUsuario(int matricula, String nome, String curso, String tipo) {
        if (tipo.equalsIgnoreCase("aluno")) {
            Usuario usuario = new Aluno(matricula, nome, curso);
            this.usuarios.add(usuario);
            return;
        }
        Usuario usuario = new Professor(matricula, nome, curso);
        this.usuarios.add(usuario);
    }

    public Optional<Emprestimo> realizarEmprestimo(int matricula, String titulo, String autor, int ano){
        Optional<Usuario> resultadoUsuario = this.getUsuario(matricula);
        Optional<Livro> resultadoLivro = this.getLivro(titulo, autor, ano);

        if (resultadoUsuario.isEmpty()) {
            System.out.println("Usuário com matrícula: " + matricula + " não encontrado");
            return Optional.empty();
        }
        if (resultadoLivro.isEmpty()) {
            System.out.println("Livro: " + titulo + " não encontrado");
            return Optional.empty();
        }

        Livro livro = resultadoLivro.get();
        if (livro.getQuantidade() == 0){
            System.out.println("Não foi possivel realizar emprestimo, não há livros disponíveis");
        }

        Usuario usuario = resultadoUsuario.get();
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        return Optional.of(emprestimo);
    }

    public void finalizarEmprestimo(Emprestimo emprestimo){
        emprestimo.devolverLivro();
        emprestimosFinalizados.add(emprestimo);
        emprestimos.remove(emprestimo);
    }

    public void imprimeEmprestimos(){
        System.out.println("=========================Emprestimos=========================");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Emprestimo realizado por: " + emprestimo.getUsuario().getNome() + ", Livro: " + emprestimo.getLivro().getTitulo() + ", Data prevista de entrega: " + emprestimo.getDataPrevista());
        }
        System.out.println("=========================================================");
    }

    public void imprimeEmprestimosFinalizados(){
        System.out.println("=========================Emprestimos Finalizados=========================");
        for (Emprestimo emprestimo : emprestimosFinalizados) {
            System.out.println("Emprestimo realizado por: " + emprestimo.getUsuario().getNome() + ", Livro: " + emprestimo.getLivro().getTitulo() + ", Data prevista de entrega: " + emprestimo.getDataPrevista() + ", Data de entrega: " + emprestimo.getDataDevolucao());
        }
        System.out.println("=========================================================");
    }


    public Set<Livro> getLivros() {
        return livros;
    }

    public Optional<Usuario> getUsuario(int matricula){
        Usuario[] arrayUsuarios = this.usuarios.toArray(new Usuario[0]);
        int indice = Algoritimos.buscaBinaria(arrayUsuarios, matricula);
        if(indice == -1){
            return Optional.empty();
        }
        return Optional.of(arrayUsuarios[indice]);
    }

    public Optional<Livro> getLivro(String titulo, String autor, int ano){
        Livro[] arrayLivros = this.livros.toArray(new Livro[0]);
        int indice = Algoritimos.buscaBinaria(arrayLivros, titulo, autor, ano);
        if(indice == -1){
            return Optional.empty();
        }
        return Optional.of(arrayLivros[indice]);
    }

    public void printEstoque(){
        System.out.println("=========================Estoque=========================");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
        System.out.println("=========================================================");
    }

    public List<Emprestimo> getEmprestimos(){
        return this.emprestimos;
    }
}
