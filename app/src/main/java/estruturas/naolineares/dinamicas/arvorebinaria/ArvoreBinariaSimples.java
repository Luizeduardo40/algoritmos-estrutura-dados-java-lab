package estruturas.naolineares.dinamicas.arvorebinaria;

import java.util.function.Consumer;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaSimples<T> implements IArvoreBinaria<T> {

    private INoArvoreBinaria<T> noRaiz;

    public ArvoreBinariaSimples() {}

    public ArvoreBinariaSimples(INoArvoreBinaria<T> noRaiz) {
        this.noRaiz = noRaiz;
    }

    @Override
    public INoArvoreBinaria<T> obterNoRaiz() {
        return this.noRaiz;
    }

    @Override
    public void definirNoRaiz(INoArvoreBinaria<T> noRaiz) {
        this.noRaiz = noRaiz;
    }

    @Override
    public int tamanho() {
        if (this.estaVazia()) {
            return 0;
        }

        return this.obterNoRaiz().tamanho();
    }

    @Override
    public int altura() {
        if (this.estaVazia()) {
            return -1;
        }

        return this.obterNoRaiz().altura();
    }

    @Override
    public int grau() {
        if (this.estaVazia()) {
            return 0;
        }

        return encontrarGrauMaximo(this.obterNoRaiz());
    }

    private int encontrarGrauMaximo(INoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        int grauDoNoAtual = no.grau();
        int grauMaximoEsquerda = encontrarGrauMaximo(no.obterNoEsquerdo());
        int grauMaximoDireita = encontrarGrauMaximo(no.obterNoDireito());
        return Math.max(grauDoNoAtual, Math.max(grauMaximoEsquerda, grauMaximoDireita));
    }

    @Override
    public int arestas() {
        if (this.estaVazia()) {
            return 0;
        }

        return this.tamanho() - 1;
    }

    @Override
    public int nivelNo(T dado) {
        return encontrarNivel(this.obterNoRaiz(), dado, 0);
    }

    private int encontrarNivel(INoArvoreBinaria<T> no, T dado, int nivelAtual) {
        if (no == null) {
            return -1;
        }

        if (no.obterDado().equals(dado)) {
            return nivelAtual;
        }

        int nivelEncontrado = encontrarNivel(no.obterNoEsquerdo(), dado, nivelAtual + 1);

        if (nivelEncontrado != -1) {
            return nivelEncontrado;
        }

        nivelEncontrado = encontrarNivel(no.obterNoDireito(), dado, nivelAtual + 1);

        return nivelEncontrado;
    }

    @Override
    public void percorrerPreOrdem(Consumer<T> acao) {
        percorrerPreOrdem(this.noRaiz, acao);
    }

    private void percorrerPreOrdem(INoArvoreBinaria<T> no, java.util.function.Consumer<T> acao) {
        if (no == null) return;
        acao.accept(no.obterDado());
        percorrerPreOrdem(no.obterNoEsquerdo(), acao);
        percorrerPreOrdem(no.obterNoDireito(), acao);
    }

    @Override
    public void percorrerEmOrdem(Consumer<T> acao) {
        percorrerEmOrdem(this.obterNoRaiz(), acao);
    }

    private void percorrerEmOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null) {
            return;
        }

        percorrerEmOrdem(no.obterNoEsquerdo(), acao);

        acao.accept(no.obterDado());

        percorrerEmOrdem(no.obterNoDireito(), acao);
    }

    @Override
    public void percorrerPosOrdem(Consumer<T> acao) {
        percorrerPosOrdem(this.obterNoRaiz(), acao);
    }

    private void percorrerPosOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null) {
            return;
        }

        percorrerPosOrdem(no.obterNoEsquerdo(), acao);

        percorrerPosOrdem(no.obterNoDireito(), acao);

        acao.accept(no.obterDado());
    }

    @Override
    public void percorrerEmOrdemNivel(Consumer<T> acao) {
        if (this.estaVazia()) {
            return;
        }

        Queue<INoArvoreBinaria<T>> fila = new LinkedList<>();
        fila.add(this.obterNoRaiz());

        while (!fila.isEmpty()) {
            INoArvoreBinaria<T> noAtual = fila.poll();

            acao.accept(noAtual.obterDado());

            if (noAtual.obterNoEsquerdo() != null) {
                fila.add(noAtual.obterNoEsquerdo());
            }

            if (noAtual.obterNoDireito() != null) {
                fila.add(noAtual.obterNoDireito());
            }
        }
    }

}
