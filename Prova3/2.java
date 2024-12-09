public boolean pesquisar(String nome)
{
    char letra = nome.charAt(0);
    No i = pesquisarArvore(letra, raiz);
    int pos = 
}

public No pesquisarArvore(char letra, No raiz)
{
    if(letra == i.character)
    {
        return No;
    }
    else if(letra < i.character)
    {
        return pesquisarArvore(letra, i.dir);
    }
    else
    {
        return pesquisarArvore(letra, i.esq);
    }
}

public int pos(char x)
{
    if(T1[hashT1(x)] == null)
    {
        return hashT1(x);
    }
    else if(T1[rehashT1(x)] == null)
    {
        return rehashT1(x);
    }
    else
    {
        return hashT2(x);
    }
}

public hashT1(char x)
{
    return x % tam1;
}

public rehashT1(char x)
{
    return ++x % tam1;
}

public hashT2(char x)
{
    return x % tam2;
}