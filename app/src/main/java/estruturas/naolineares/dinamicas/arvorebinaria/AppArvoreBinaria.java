package estruturas.naolineares.dinamicas.arvorebinaria;

public class AppArvoreBinaria {

    public static void main(String[] args) {
        INoArvoreBinaria<String> raiz = new NoArvoreBinaria<>("A");
        INoArvoreBinaria<String> noB = new NoArvoreBinaria<>("B");
        INoArvoreBinaria<String> noC = new NoArvoreBinaria<>("C");
        INoArvoreBinaria<String> noD = new NoArvoreBinaria<>("D");
        INoArvoreBinaria<String> noE = new NoArvoreBinaria<>("E");
        INoArvoreBinaria<String> noF = new NoArvoreBinaria<>("F");
        INoArvoreBinaria<String> noG = new NoArvoreBinaria<>("G");
        INoArvoreBinaria<String> noH = new NoArvoreBinaria<>("H");

        raiz.definirNoEsquerdo(noB);
        raiz.definirNoDireito(noC);
        noB.definirNoEsquerdo(noE);
        noB.definirNoDireito(noD);
        noC.definirNoDireito(noF);
        noF.definirNoEsquerdo(noG);
        noF.definirNoDireito(noH);

        IArvoreBinaria<String> arvore = new ArvoreBinariaSimples<>(raiz);

        System.out.println("Tamanho de um nó: " + noC.tamanho());
        System.out.println("Altura de um nó: " + noC.altura()); 
        System.out.println("Grau de um nó: " + noC.grau());  
        System.out.println("Vazia? " + arvore.estaVazia());

        arvore.percorrerEmOrdemNivel(System.out::print);
    }

}
