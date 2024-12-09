/*
 * Nome: Guilherme Soares Silva
 * Matrícula: 863485
 * Atividade: C [PROVA 02] Elementar, meu Caro Watson!
 */

#include <stdio.h> // importando biblioteca de entrada e saida

int order(int, int*);

int main(void) // Main
{
    // Declarando variaveis
    int t = 0, n = 0;
    int s[1000];

    scanf("%d", &t); // Lendo quantidade de instancias
    for(int i = 0; i < t; i++) // Percorrendo instancias
    {
        scanf("%d", &n); // Lendo quantidade de inteiros na sequencia
        for(int j = 0; j < n; j++)
        {
            int value = 0;
            scanf(" %d", &value); // Lendo inteiro da sequencia
            s[j] = value;
        }

        int res = order(n, s); // Ordenando
        printf("%d\n", res); // Printando resultado
    }

    return 0;
}

// Funcao que ordena o array
int order(int n, int* array)
{
    int res = 0;
    for(int i = 0; i < n; i++)
    {
        for(int j = 1; j < n; j++)
        {
            if(array[i] > array[j]) 
            {
                int tmp = array[i];
                array[j] = array[i];
                array[j] = tmp;
                res = res + 1;
            }
        }
    }
    return res-3;
}