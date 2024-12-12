#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_AMIGOS 100
#define MAX_NOME 50

void ler_lista_de_amigos(char amigos[][MAX_NOME], int *tamanho) {
    char linha[MAX_AMIGOS * MAX_NOME];
    fgets(linha, sizeof(linha), stdin);
    linha[strcspn(linha, "\n")] = 0; // remover o caractere de nova linha

    char *token = strtok(linha, " ");
    int i = 0;
    while (token != NULL && i < MAX_AMIGOS) {
        strcpy(amigos[i], token);
        token = strtok(NULL, " ");
        i++;
    }
    *tamanho = i;
}

void ler_nova_lista_de_amigos(char novos_amigos[][MAX_NOME], int *tamanho) {
    char linha[MAX_AMIGOS * MAX_NOME];
    fgets(linha, sizeof(linha), stdin);
    linha[strcspn(linha, "\n")] = 0; // remover o caractere de nova linha

    char *token = strtok(linha, " ");
    int i = 0;
    while (token != NULL && i < MAX_AMIGOS) {
        strcpy(novos_amigos[i], token);
        token = strtok(NULL, " ");
        i++;
    }
    *tamanho = i;
}

void ler_amigo_indicado(char *amigo_indicado) {
    fgets(amigo_indicado, MAX_NOME, stdin);
    amigo_indicado[strcspn(amigo_indicado, "\n")] = 0; // remover o caractere de nova linha
}

void atualizar_lista_de_amigos(char amigos[][MAX_NOME], int tamanho_amigos, char novos_amigos[][MAX_NOME], int tamanho_novos_amigos, char *amigo_indicado) {
    if (strcmp(amigo_indicado, "nao") == 0) {
        // Se não quiser indicar, adicionar os novos amigos ao fim da lista
        for (int i = 0; i < tamanho_novos_amigos; i++) {
            strcpy(amigos[tamanho_amigos + i], novos_amigos[i]);
        }
        tamanho_amigos += tamanho_novos_amigos;
    } else {
        // Se o amigo indicado está na lista, adicionar os novos amigos antes dele
        int indice_amigo_indicado = -1;
        for (int i = 0; i < tamanho_amigos; i++) {
            if (strcmp(amigos[i], amigo_indicado) == 0) {
                indice_amigo_indicado = i;
                break;
            }
        }
        if (indice_amigo_indicado != -1) {
            for (int i = tamanho_amigos; i > indice_amigo_indicado; i--) {
                strcpy(amigos[i + tamanho_novos_amigos], amigos[i]);
            }
            for (int i = 0; i < tamanho_novos_amigos; i++) {
                strcpy(amigos[indice_amigo_indicado + i], novos_amigos[i]);
            }
            tamanho_amigos += tamanho_novos_amigos;
        } else {
            // Se o amigo indicado não está na lista, adicionar os novos amigos ao fim da lista
            for (int i = 0; i < tamanho_novos_amigos; i++) {
                strcpy(amigos[tamanho_amigos + i], novos_amigos[i]);
            }
            tamanho_amigos += tamanho_novos_amigos;
        }
    }
}

void imprimir_lista_de_amigos(char amigos[][MAX_NOME], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        printf("%s ", amigos[i]);
    }
    printf("\n");
}

int main() {
    char amigos[MAX_AMIGOS][MAX_NOME];
    int tamanho_amigos;
    ler_lista_de_amigos(amigos, &tamanho_amigos);

    char novos_amigos[MAX_AMIGOS][MAX_NOME];
    int tamanho_novos_amigos;
    ler_nova_lista_de_amigos(novos_amigos, &tamanho_novos_amigos);

    char amigo_indicado[MAX_NOME];
    ler_amigo_indicado(amigo_indicado);

    atualizar_lista_de_amigos(amigos, tamanho_amigos, novos_amigos, tamanho_novos_amigos, amigo_indicado);
    imprimir_lista_de_amigos(amigos, tamanho_amigos + tamanho_novos_amigos);
    return 0;
}