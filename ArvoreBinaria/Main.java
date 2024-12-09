package ArvoreBinaria;

public class Main
{
    
}

class No
{
    // Atributos
    public int elemento;
    public No dir;
    public No esq;

    // Construtores
    public No()
    {
        this(-1);
    }
    public No(int elemento)
    {
        this.elemento = elemento;
        this.dir = null;
        this.esq = null;
    }
    public No(int elemento, No dir, No esq)
    {
        this.elemento = elemento;
        this.dir = dir;
        this.esq = esq;
    }
}

class ArvoreBinaria
{
    // Atributos
    public No raiz;

    // Construtores
    public ArvoreBinaria()
    {
        this.raiz = null;
    }
    public ArvoreBinaria(No raiz)
    {
        this.raiz = raiz;
    }

    // Inserir
    No inserir(int x)
    {
        return inserir(x, raiz);
    }
    No inserir(int x, No i)
    {
        if(i == null)
        {
            i = new No(x);
        } 
        else if(x < i.elemento)
        {
            i.esq = inserir(x, i.esq);
        } 
        else if(x > i.elemento)
        {
            i.dir = inserir(x, i.dir);
        } 
        else
        {
            System.out.println("Não foi possível inserir os elemento.");
        }
        return i;
    }

    // Pesquisar
    boolean pesquisar(int x)
    {
        return pesquisar(x, raiz);
    }
    boolean pesquisar(int x, No i)
    {
        boolean res = false;
        if(x == i.elemento)
        {
            res = true;
        }
        else if(x < i.elemento)
        {
            res = pesquisar(x, i.esq);
        }
        else if(x > i.elemento)
        {
            res = pesquisar(x, i.dir);
        }
        else
        {
            System.out.println("Elemento não encontrado.");
        }
        return res;
    }
}