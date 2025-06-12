package estruturas.naolineares.dinamicas.arvorebinaria;

public interface INoArvoreBinaria<T> {

    public T obterDado();

    public INoArvoreBinaria<T> obterNoEsquerdo();

    public void definirNoEsquerdo(INoArvoreBinaria<T> noEsquerdo);

    public INoArvoreBinaria<T> obterNoDireito();

    public void definirNoDireito(INoArvoreBinaria<T> noDireito);

    public int tamanho();

    public int altura();

    public int grau();

}
