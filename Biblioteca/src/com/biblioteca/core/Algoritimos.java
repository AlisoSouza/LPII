package com.biblioteca.core;

import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;

public class Algoritimos {
    public static int buscaBinaria(Livro[] arrayLivros, String titulo, String autor, int ano) {
        int esquerda = 0;
        int direita = arrayLivros.length - 1;
        int indiceLivro = -1;

        while (esquerda <= direita){
            int meio = esquerda + (direita - esquerda) / 2;

            Livro livro = arrayLivros[meio];

            int comparacaoLivro = livro.getTitulo().compareToIgnoreCase(titulo);

            if (comparacaoLivro == 0){
                indiceLivro = meio;
                break;
            } else if (comparacaoLivro < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        if (indiceLivro  == -1){
            return indiceLivro;
        }

        Livro livro = arrayLivros[indiceLivro];
        if (livro.getAutor().equalsIgnoreCase(autor) && livro.getAno() == ano) {
            return indiceLivro;
        }

        for (int i = indiceLivro - 1; i >= 0; i--) {
            Livro livroEsquerda = arrayLivros[i];
            if (!livroEsquerda.getTitulo().equalsIgnoreCase(titulo)) {
                break;
            }
            if (livroEsquerda.getAutor().equalsIgnoreCase(autor) && livroEsquerda.getAno() == ano) {
                return i;
            }
        }

        for (int i = indiceLivro + 1; i < arrayLivros.length; i++) {
            Livro livroDireita = arrayLivros[i];
            if (!livroDireita.getTitulo().equalsIgnoreCase(titulo)) {
                break;
            }
            if (livroDireita.getAutor().equalsIgnoreCase(autor) && livroDireita.getAno() == ano) {
                return i;
            }
        }

        return 1;
    }

    public static int buscaBinaria(Usuario[] arrayUsuarios, int matricula) {
        int esquerda = 0;
        int direita = arrayUsuarios.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            Usuario usuario = arrayUsuarios[meio];
            int userMatricula = usuario.getMatricula();

            if (userMatricula == matricula) {
                return meio;
            }
            if (matricula < userMatricula) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }
        }
        return -1;
    }
}
