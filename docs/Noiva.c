#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int minutos;  // Minutos desde 00:00
    char nome[101];  // Nome do morador
} Relato;

// Função para converter horário "HH:MM" para minutos após meia-noite
int converter_para_minutos(const char* horario) {
    int hora, minuto;
    sscanf(horario, "%d:%d", &hora, &minuto);
    return (hora == 23 ? -1 : 0) + hora * 60 + minuto;  // Se for 23, vai para o intervalo negativo
}

int main() {
    int P, Q;
    scanf("%d %d", &P, &Q);

    // Definir os limites
    int limite_inferior = -P;  // Meia-noite menos P minutos
    int limite_superior = P;   // Meia-noite mais P minutos

    Relato relatos[Q];

    // Lê os relatos
    for (int i = 0; i < Q; i++) {
        char horario[6];
        scanf("%s", horario);
        scanf(" %[^\n]s", relatos[i].nome);  // Lê o nome do morador
        relatos[i].minutos = converter_para_minutos(horario);
    }

    // Ordena os relatos. Primeiro pelos minutos, depois pela ordem de chegada.
    qsort(relatos, Q, sizeof(Relato), [](const void* a, const void* b) -> int {
        int minutos_a = ((Relato*)a)->minutos;
        int minutos_b = ((Relato*)b)->minutos;
        return minutos_a - minutos_b;  // Ordena por minutos
    });

    // Exibe os relatos válidos
    for (int i = 0; i < Q; i++) {
        if (relatos[i].minutos >= limite_inferior && relatos[i].minutos <= limite_superior) {
            printf("%s\n", relatos[i].nome);
        }
    }

    return 0;
}
