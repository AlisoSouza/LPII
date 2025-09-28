package com.biblioteca.main;

import com.biblioteca.core.Biblioteca;
import com.biblioteca.model.*;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // CADASTRAR USUARIO
        biblioteca.cadastrarUsuario(678876, "Joana", "Historia", "professor");
        biblioteca.cadastrarUsuario(123312, "Alisson", "TI", "Aluno");
        biblioteca.cadastrarUsuario(9123312, "Jorge", "Geografia", "Aluno");
        biblioteca.cadastrarUsuario(764324, "Alice", "Literatura", "professor");

        Optional<Usuario> resAluno = biblioteca.getUsuario(123312);
        if(resAluno.isPresent()){
            Usuario aluno = resAluno.get();
            System.out.println("A classe real do objeto é: " + aluno.getClass().getName());
            assert aluno instanceof Aluno;
            assert aluno.getMatricula() == 123312;
            assert aluno.getNome().equals("Alisson");
            assert aluno.getCurso().equals("TI");
            assert aluno.getPrazoDias() == 7;
        }

        Optional<Usuario> resProfessor = biblioteca.getUsuario(678876);
        if(resProfessor.isPresent()){
            Usuario professor = resProfessor.get();
            assert professor instanceof Professor;
            assert professor.getMatricula() == 678876;
            assert professor.getNome().equals("Joana");
            assert professor.getCurso().equals("Historia");
            assert professor.getPrazoDias() == 14;
        }

        biblioteca.cadastrarLivro("Macunaíma", "Mário de Andrade", 1928, 7);
        biblioteca.cadastrarLivro("Capitães da Areia", "Jorge Amado", 1937, 2);
        biblioteca.cadastrarLivro("O Quinze", "Raquel de Queiroz", 1915, 5);
        biblioteca.cadastrarLivro("O Hobbit", "Tolkien", 1937, 5);

        Optional<Livro> resLivro = biblioteca.getLivro("Macunaíma", "Mário de Andrade", 1928);
        if(resLivro.isPresent()){
            Livro livro = resLivro.get();
            assert livro.getTitulo().equals("Macunaíma");
            assert livro.getQuantidade() == 7;
            assert livro.getAutor().equals("Mário de Andrade");
            assert livro.getAno() == 1928;
        }

        biblioteca.printEstoque();

        Optional<Emprestimo> emprestimoResultado = biblioteca.realizarEmprestimo(764324, "O quinze", "raquel de queiroz", 1915);

        if (emprestimoResultado.isPresent()) {
            Emprestimo emprestimo = emprestimoResultado.get();
            System.out.println("Emprestimo realizado (" + emprestimo.getId() + ") " + "Livro: " + emprestimo.getLivro().getTitulo() + " Data de devoluçao: " + emprestimo.getDataPrevista());
            biblioteca.printEstoque();
            biblioteca.imprimeEmprestimos();
            biblioteca.finalizarEmprestimo(emprestimo);
        }

        biblioteca.printEstoque();
        biblioteca.imprimeEmprestimosFinalizados();

        Optional<Emprestimo> emprestimoResultado2 = biblioteca.realizarEmprestimo(9123312, "O quinze", "raquel de queiroz", 1915);
        if (emprestimoResultado2.isPresent()) {
            Emprestimo emprestimo = emprestimoResultado2.get();
            System.out.println("Emprestimo realizado (" + emprestimo.getId() + ")" + "Livro: " + emprestimo.getLivro().getTitulo() + " Data de devoluçao: " + emprestimo.getDataPrevista());
        }
    }
}
