public class Doidona {
    private No raiz;

    // Método principal de pesquisa
    public boolean pesquisar(String nome) {
        char letra = nome.charAt(0);
        No noEncontrado = pesquisarArvore(letra, raiz); // Pesquisa na árvore binária

        if (noEncontrado == null) {
            return false; // Não encontrou o nó correspondente ao primeiro caractere
        }

        // Pesquisa na T1
        if (pesquisarT1(noEncontrado.t1, nome)) {
            return true; // A palavra foi encontrada em T1
        }

        // Se não encontrado em T1, verificar T2
        return pesquisarT2(noEncontrado.t1.t2, nome);
    }

    // Pesquisa na árvore binária
    public No pesquisarArvore(char letra, No raiz) {
        if (raiz == null) {
            return null; // Não encontrou o nó
        }
        if (letra == raiz.caracter) {
            return raiz; // Encontrou o nó
        } else if (letra < raiz.caracter) {
            return pesquisarArvore(letra, raiz.esq); // Percorre subárvore esquerda
        } else {
            return pesquisarArvore(letra, raiz.dir); // Percorre subárvore direita
        }
    }

    // Pesquisa na T1
    private boolean pesquisarT1(T1 t1, String nome) {
        int indice = hashT1(nome.charAt(nome.length() - 1), t1.palavras.length);

        // Tentar a posição de índice da tabela T1
        if (t1.palavras[indice] != null && t1.palavras[indice].equals(nome)) {
            return true; // Palavra encontrada em T1
        }

        // Se houver colisão, tentamos com a função de rehash
        indice = rehashT1(nome.charAt(nome.length() - 1), t1.palavras.length);
        if (t1.palavras[indice] != null && t1.palavras[indice].equals(nome)) {
            return true; // Palavra encontrada após rehash
        }

        return false; // Palavra não encontrada em T1
    }

    // Pesquisa na T2
    private boolean pesquisarT2(T2 t2, String nome) {
        int indice = hashT2(nome.length(), t2.celulast2.length);

        // Verificar a lista na célula da tabela T2
        CelulaT2 celula = t2.celulast2[indice];
        Celula atual = celula.inicio;

        // Percorrer a lista de palavras ordenadas
        while (atual != null) {
            if (atual.palavra.equals(nome)) {
                return true; // Palavra encontrada na lista da T2
            }
            atual = atual.prox;
        }

        return false; // Palavra não encontrada em T2
    }

    // Função hash para T1
    private int hashT1(char x, int tam1) {
        return x % tam1;
    }

    // Função de rehash para T1
    private int rehashT1(char x, int tam1) {
        return (++x) % tam1;
    }

    // Função hash para T2
    private int hashT2(int x, int tam2) {
        return x % tam2;
    }
}

// --------------------------------------------------------------------------------------

