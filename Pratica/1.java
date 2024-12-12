class No {
    public int elemento;
    public No esq, dir;

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
}

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // Método para calcular a quantidade de nós na árvore
    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        // Contamos o nó atual + os nós à esquerda + os nós à direita
        return 1 + contarNos(no.esq) + contarNos(no.dir);
    }

    // Método para calcular a altura da árvore
    public int altura(No no) {
        if (no == null) {
            return -1; // Se o nó for nulo, altura é -1 (base da recursão)
        }
        // A altura é o maior valor entre as subárvores esquerda e direita + 1
        return 1 + Math.max(altura(no.esq), altura(no.dir));
    }

    // Método que implementa a lógica para verificar se a altura da árvore é no máximo "valor * log2(nos)"
    public boolean isMax(double valor) {
        // Primeiro, calcular o número de nós da árvore
        int numNos = contarNos(raiz);
        
        // Calcular o valor máximo permitido para a altura
        double log2Nos = Math.log(numNos) / Math.log(2); // log2(N)
        double alturaMaxima = valor * log2Nos;

        // Agora, calcular a altura da árvore
        int alturaArvore = altura(raiz);

        // Verificar se a altura da árvore é menor ou igual à altura máxima calculada
        return alturaArvore <= alturaMaxima;
    }
}
