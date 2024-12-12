#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_NOME 50
#define MAX_AMIGOS 100

int main() {
    char amigos[MAX_AMIGOS][MAX_NOME];
    char novosAmigos[MAX_AMIGOS][MAX_NOME];
    char nomeIndicado[MAX_NOME];
    int qtdAmigos = 0;
    int qtdNovosAmigos = 0;

    // Lê a lista de amigos de Luiggy
    char *token;
    char linha[MAX_AMIGOS * MAX_NOME];
    fgets(linha, sizeof(linha), stdin);
    token = strtok(linha, " ");
    while (token != NULL && qtdAmigos < MAX_AMIGOS) {
        strcpy(amigos[qtdAmigos], token);
        qtdAmigos++;
        token = strtok(NULL, " ");
    }

    // Lê a nova lista de amigos de Luiggy
    fgets(linha, sizeof(linha), stdin);
    token = strtok(linha, " ");
    while (token != NULL && qtdNovosAmigos < MAX_AMIGOS) {
        strcpy(novosAmigos[qtdNovosAmigos], token);
        qtdNovosAmigos++;
        token = strtok(NULL, " ");
    }

    // Lê o nome do amigo que receberá a nova lista como indicação de amigos
    fgets(nomeIndicado, sizeof(nomeIndicado), stdin);
    nomeIndicado[strcspn(nomeIndicado, "\n")] = 0; // Remove o caractere de nova linha

    // Verifica se o nome do amigo é "nao"
    if (strcmp(nomeIndicado, "nao") == 0) {
        // Adiciona os novos amigos ao fim da lista de amigos
        for (int i = 0; i < qtdNovosAmigos; i++) {
            strcpy(amigos[qtdAmigos], novosAmigos[i]);
            qtdAmigos++;
        }
    } else {
        // Procura o nome do amigo na lista de amigos
        int indiceAmigo = -1;
        for (int i = 0; i < qtdAmigos; i++) {
            if (strcmp(amigos[i], nomeIndicado) == 0) {
                indiceAmigo = i;
                break;
            }
        }

        // Se o nome do amigo for encontrado, adiciona os novos amigos antes dele
        if (indiceAmigo != -1) {
            for (int i = qtdAmigos; i > indiceAmigo; i--) {
                strcpy(amigos[i], amigos[i - 1]);
            }
            for (int i = 0; i < qtdNovosAmigos; i++) {
                strcpy(amigos[indiceAmigo + i + 1], novosAmigos[i]);
            }
            qtdAmigos += qtdNovosAmigos;
        }
    }

    // Imprime a nova lista de amigos de Luiggy
    for (int i = 0; i < qtdAmigos; i++) {
        printf("%s ", amigos[i]);
    }
    printf("\n");

    return 0;
}