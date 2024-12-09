package AVL;

public class Main
{
    public static void main(String args[])
    {

    }
}

class NoAVL
{
    // Atributos
    public int elemento;
    public int fator;
    public NoAVL dir;
    public NoAVL esq;

    // Construtores
    public NoAVL()
    {
        this(-1);
    }
    public NoAVL(int elemento)
    {
        this(elemento, 1, null, null);
    }
    public NoAVL(int elemento, int fator)
    {
        this(elemento, fator, null, null);
    }
    public NoAVL(int elemento, int fator, NoAVL dir, NoAVL esq)
    {
        this.elemento = elemento;
        this.fator = fator;
        this.dir = dir;
        this.esq = esq;
    }
}

class ArvoreAVL
{
    public NoAVL raiz;
    
}