#include <stdio.h>
#include <string.h>

#define MAX_NAME_LEN 100
#define MAX_CANDIDATES 100

typedef struct {
    char name[MAX_NAME_LEN + 1];
    int power;
    int kills;
    int deaths;
} Candidate;

int main() {
    int N;
    scanf("%d", &N);

    Candidate candidates[MAX_CANDIDATES];

    for (int i = 0; i < N; i++) {
        scanf("%s %d %d %d", candidates[i].name, &candidates[i].power, &candidates[i].kills, &candidates[i].deaths);
    }

    int winnerIndex = 0;
    for (int i = 1; i < N; i++) {
        if (candidates[i].power > candidates[winnerIndex].power) {
            winnerIndex = i;
        } else if (candidates[i].power == candidates[winnerIndex].power) {
            if (candidates[i].kills > candidates[winnerIndex].kills) {
                winnerIndex = i;
            } else if (candidates[i].kills == candidates[winnerIndex].kills) {
                if (candidates[i].deaths < candidates[winnerIndex].deaths) {
                    winnerIndex = i;
                } else if (candidates[i].deaths == candidates[winnerIndex].deaths) {
                    if (strcmp(candidates[i].name, candidates[winnerIndex].name) < 0) {
                        winnerIndex = i;
                    }
                }
            }
        }
    }

    printf("%s\n", candidates[winnerIndex].name);

    return 0;
}
