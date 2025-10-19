package br.universidade.repo.app.repositorio;

public interface Repositorio {
    void adicionar(Object obj);
    void remover(String chave);
    Object buscar(String chave);
    Object[] listar();
}
