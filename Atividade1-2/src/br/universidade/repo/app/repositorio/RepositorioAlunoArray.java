package br.universidade.repo.app.repositorio;
import br.universidade.repo.app.modelo.Aluno;
import java.util.Arrays;
import java.util.Objects;


public class RepositorioAlunoArray implements Repositorio{
    private int capacidade = 10;
    private int quantidade = 0;
    private Aluno[] alunos = new Aluno[capacidade];

    public int getQuantidade(){
        return this.quantidade;
    }

    private void alocaEspaco(){
        this.alunos = Arrays.copyOf(this.alunos, this.capacidade + 10);
    }

    private boolean podeAdicionar(){
        return this.quantidade < (this.capacidade - 1);
    }

    @Override
    public void adicionar(Object obj) {
        if (!(obj instanceof Aluno)) {
            System.err.println("Erro: O objeto precisa ser do tipo: Aluno.");
            return;
        }

        Aluno aluno = (Aluno) obj;

        if (this.podeAdicionar()) {
            this.alunos[this.quantidade] = aluno;
            this.quantidade++;
        } else {
            this.alocaEspaco();
            this.alunos[this.quantidade] = aluno;
            this.quantidade++;
        }
    }

    @Override
    public Aluno[] listar(){
        int count = 0;
        for (Aluno aluno : this.alunos) {
            if (aluno != null){
                System.out.println(aluno);
                count++;
            }
        }
        return Arrays.copyOfRange(this.alunos, 0, count);
    }

    @Override
    public Object buscar(String chave) {
        for (Aluno aluno : this.alunos) {
            if (aluno == null){
                continue;
            }
            if (Objects.equals(aluno.getMatricula(), chave)){
                return aluno;
            }
        }
        return null;
    }

    public int buscaIndice(String chave) {
        for(int i=0; i<this.quantidade; i++){
            if (this.alunos[i] == null){
                continue;
            }
            if (Objects.equals(this.alunos[i].getMatricula(), chave)){
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
            this.alunos[i] = this.alunos[i + 1];
        }
        this.alunos[this.quantidade - 1] = null;
        this.quantidade--;
    }
}
