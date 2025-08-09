package estruturas.naolineares.dinamicas.arvorebinariabusca;

// Importações corretas baseadas na sua classe pai
import estruturas.naolineares.dinamicas.arvorebinaria.INoArvoreBinaria;
import estruturas.naolineares.dinamicas.arvorebinaria.NoArvoreBinaria;

public class ArvoreBinariaBuscaComDuplicatas<T extends Comparable<T>> extends ArvoreBinariaBusca<T> {

    @Override
    public void inserir(T dado) {
        // Usa o método definirNoRaiz, que é herdado e público/protegido
        this.definirNoRaiz(inserirRecursivo(this.obterNoRaiz(), dado));
    }

    private INoArvoreBinaria<T> inserirRecursivo(INoArvoreBinaria<T> no, T dado) {
        if (no == null) {
            // Usa a mesma classe de Nó que a classe pai
            return new NoArvoreBinaria<>(dado);
        }
        if (dado.compareTo(no.obterDado()) <= 0) {
            no.definirNoEsquerdo(inserirRecursivo(no.obterNoEsquerdo(), dado));
        } else {
            no.definirNoDireito(inserirRecursivo(no.obterNoDireito(), dado));
        }
        return no;
    }
    
    public int contarOcorrencias(T dado) {
        // Usa o método obterNoRaiz, herdado da "avó" ArvoreBinariaSimples
        return contarOcorrenciasRecursivo(this.obterNoRaiz(), dado);
    }

    private int contarOcorrenciasRecursivo(INoArvoreBinaria<T> no, T dado) {
        if (no == null) {
            return 0;
        }
        int comparacao = dado.compareTo(no.obterDado());
        if (comparacao < 0) {
            return contarOcorrenciasRecursivo(no.obterNoEsquerdo(), dado);
        } else if (comparacao > 0) {
            return contarOcorrenciasRecursivo(no.obterNoDireito(), dado);
        } else { // comparacao == 0
            return 1 + contarOcorrenciasRecursivo(no.obterNoEsquerdo(), dado);
        }
    }
    
    @Override
    protected boolean validarArvoreBinariaBusca(INoArvoreBinaria<T> no, T minimo, T maximo) {
        if (no == null) {
            return true;
        }
        T dadoAtual = no.obterDado();
        // A lógica de validação que implementamos antes continua correta
        if (minimo != null && dadoAtual.compareTo(minimo) <= 0) {
            return false;
        }
        if (maximo != null && dadoAtual.compareTo(maximo) > 0) {
            return false;
        }
        return validarArvoreBinariaBusca(no.obterNoDireito(), dadoAtual, maximo) &&
               validarArvoreBinariaBusca(no.obterNoEsquerdo(), minimo, dadoAtual);
    }
}