class No {
    int valor;
    No esquerdo;
    No direito;

    public No(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }
}

class Arvore {
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // Método para calcular a altura da árvore
    private int calcularAltura(No no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = calcularAltura(no.esquerdo);
        int alturaDireita = calcularAltura(no.direito);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    // Método para contar a quantidade de nós
    private int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return contarNos(no.esquerdo) + contarNos(no.direito) + 1;
    }

    // Método para verificar a condição do problema
    public boolean isMax(double valor) {
        int altura = calcularAltura(raiz);
        int quantidadeNos = contarNos(raiz);

        if (quantidadeNos == 0) { // Evitar divisão por zero ou logaritmo de zero
            return true;
        }

        double limite = valor * (Math.log(quantidadeNos) / Math.log(2));
        return altura <= limite;
    }
}
