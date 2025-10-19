package br.universidade.repo.app;

import br.universidade.repo.app.modelo.Aluno;
import br.universidade.repo.app.modelo.Livro;
import br.universidade.repo.app.repositorio.RepositorioAlunoArray;
import br.universidade.repo.app.repositorio.RepositorioLivroArray;

public class Main {
    public static void main(String[] args) {

        RepositorioAlunoArray repoAluno = new RepositorioAlunoArray();
        RepositorioLivroArray repoLivro = new RepositorioLivroArray();

        System.out.println("!!!!!!!!!!!!!!!!!!!!Teste Aluno!!!!!!!!!!!!!!!!!!!!");

        // Adicionar Aluno
        Aluno aluno1 = new Aluno("Alisson", "20180106845");
        Aluno aluno2 = new Aluno("Beatriz", "20180106846");
        Aluno aluno3 = new Aluno("Carlos", "20190217351");
        Aluno aluno4 = new Aluno("Daniela", "20190134987");
        Aluno aluno5 = new Aluno("Eduardo", "20200256789");
        Aluno aluno6 = new Aluno("Fernanda", "20200112345");
        Aluno aluno7 = new Aluno("Gabriel", "20210298765");
        Aluno aluno8 = new Aluno("Helena", "20210145678");
        Aluno aluno9 = new Aluno("Igor", "20220265432");
        Aluno aluno10 = new Aluno("Juliana", "20220178901");
        Aluno aluno11 = new Aluno("Lucas", "20230123456");

        repoAluno.adicionar(aluno1);
        repoAluno.adicionar(aluno2);
        repoAluno.adicionar(aluno3);
        repoAluno.adicionar(aluno4);
        repoAluno.adicionar(aluno5);
        repoAluno.adicionar(aluno6);
        repoAluno.adicionar(aluno7);
        repoAluno.adicionar(aluno8);
        repoAluno.adicionar(aluno9);
        repoAluno.adicionar(aluno10);
        repoAluno.adicionar(aluno11);

        // Listar Alunos
        System.out.println("-----------------Listar-----------------");
        repoAluno.listar();
        System.out.println("---------------------------------------");

        // Buscar alunos
        System.out.println("-----------------Buscar: 20220178901-----------------");
        Object resultadoBusca = repoAluno.buscar("20220178901");
        if (resultadoBusca != null){
            System.out.println(resultadoBusca);
        }
        System.out.println("---------------------------------------");
        System.out.println("-----------------Remover: 20180106846-----------------");
        repoAluno.remover("20180106846");
        repoAluno.listar();
        Object resultadoBuscaNull = repoAluno.buscar("20180106846");
        if (resultadoBuscaNull == null){
            System.out.println("20180106846 Removido");
        }
        System.out.println("-----------------------------------------");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        System.out.println("!!!!!!!!!!!!!!!!!!!!Teste Livro!!!!!!!!!!!!!!!!!!!!");
        // Adicionar livro
        Livro livro = new Livro("Capitães da Areia", "Jorge Amado");
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis");
        Livro livro2 = new Livro("Grande Sertão: Veredas", "João Guimarães Rosa");
        Livro livro3 = new Livro("A Hora da Estrela", "Clarice Lispector");
        Livro livro4 = new Livro("Vidas Secas", "Graciliano Ramos");
        Livro livro5 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez");
        Livro livro6 = new Livro("1984", "George Orwell");
        Livro livro7 = new Livro("O Apanhador no Campo de Centeio", "J.D. Salinger");
        Livro livro8 = new Livro("Crime e Castigo", "Fiódor Dostoiévski");
        Livro livro9 = new Livro("O Processo", "Franz Kafka");
        Livro livro10 = new Livro("Ensaio sobre a Cegueira", "José Saramago");

        repoLivro.adicionar(livro);
        repoLivro.adicionar(livro1);
        repoLivro.adicionar(livro2);
        repoLivro.adicionar(livro3);
        repoLivro.adicionar(livro4);
        repoLivro.adicionar(livro5);
        repoLivro.adicionar(livro6);
        repoLivro.adicionar(livro7);
        repoLivro.adicionar(livro8);
        repoLivro.adicionar(livro9);
        repoLivro.adicionar(livro10);

        System.out.println("-----------------Listar-----------------");
        repoLivro.listar();
        System.out.println("---------------------------------------");

        // Buscar livros
        System.out.println("-----------------Buscar: Capitães da Areia-----------------");
        Object resultadoBuscaLivro = repoLivro.buscar("Capitães da Areia");
        if (resultadoBuscaLivro != null){
            System.out.println(resultadoBuscaLivro);
        }
        System.out.println("---------------------------------------");

        System.out.println("-----------------Remover: Capitães da Areia-----------------");
        repoLivro.remover("Capitães da Areia");
        repoLivro.listar();
        Object resultadoBuscaLivroNull = repoLivro.buscar("Capitães da Areia");
        if (resultadoBuscaLivroNull == null){
            System.out.println("Capitães da Areia removido");
        }
        System.out.println("-----------------------------------------");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
