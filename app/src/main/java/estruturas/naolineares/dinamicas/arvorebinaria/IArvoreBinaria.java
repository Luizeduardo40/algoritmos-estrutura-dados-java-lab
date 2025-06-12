package estruturas.naolineares.dinamicas.arvorebinaria;

public interface IArvoreBinaria<T> {

    public INoArvoreBinaria<T> obterNoRaiz();

    void definirNoRaiz(INoArvoreBinaria<T> noRaiz);

    default boolean estaVazia() {
        return this.obterNoRaiz() == null;
    }

    public int tamanho();

    public int altura();

    public int grau();

    public int arestas();

    public int nivelNo(T dado);

    void percorrerPreOrdem(java.util.function.Consumer<T> acao);

    void percorrerEmOrdem(java.util.function.Consumer<T> acao);

    void percorrerPosOrdem(java.util.function.Consumer<T> acao);

    void percorrerEmOrdemNivel(java.util.function.Consumer<T> acao);

}
