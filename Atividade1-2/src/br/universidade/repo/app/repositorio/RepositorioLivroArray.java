package br.universidade.repo.app.repositorio;


import br.universidade.repo.app.modelo.Livro;

import java.util.Arrays;

public class RepositorioLivroArray implements Repositorio{
    private int capacidade = 10;
    private int quantidade = 0;
    private Livro[] livros = new Livro[capacidade];

    private boolean podeAdicionar(){
        return this.quantidade < (this.capacidade - 1);
    }

    private void alocaEspaco(){
        this.livros = Arrays.copyOf(this.livros, this.capacidade + 10);
    }

    @Override
    public void adicionar(Object obj) {
        if (!(obj instanceof Livro)) {
            System.err.println("Erro: O objeto precisa ser do tipo: Livro.");
            return;
        }

        Livro livro = (Livro) obj;

        if (this.podeAdicionar()) {
            this.livros[this.quantidade] = livro;
            this.quantidade++;
        } else {
            this.alocaEspaco();
            this.livros[this.quantidade] = livro;
            this.quantidade++;
        }
    }

    @Override
    public Livro[] listar(){
        int count = 0;
        for (Livro livro : this.livros) {
            if (livro != null){
                System.out.println(livro);
                count++;
            }
        }
        return Arrays.copyOfRange(this.livros, 0, count);
    }

    @Override
    public Object buscar(String chave) {
        for (Livro livro : this.livros) {
            if (livro == null){
                continue;
            }
            if (livro.getTitulo().equalsIgnoreCase(chave)){
                return livro;
            }
        }
        return null;
    }

    public int buscaIndice(String chave) {
        for(int i=0; i<this.quantidade; i++){
            if (this.livros[i] == null){
                continue;
            }
            if (this.livros[i].getTitulo().equalsIgnoreCase(chave)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void remover(String chave) {
        int indice = this.buscaIndice(chave);
        if (indice == -1){
            return;
        }
        for (int i = indice; i < (this.quantidade - 1); i++) {
            this.livros[i] = this.livros[i + 1];
        }
        this.livros[this.quantidade - 1] = null;
        this.quantidade--;
    }
}
