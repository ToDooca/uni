#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define TEXT_S 64
#define TASK_S 66

typedef struct task {
    char text[TEXT_S];
    char prio;
    char isdone;
} task_t;

typedef struct node {
    task_t task;
    struct node *next;
} node_t;


void writeTask(FILE *fp, task_t t);

void writeTasks(node_t *first);

void readTasks(node_t *list);

void addToList(node_t *first, node_t *item);

void removeFromList(node_t *first, int index);

void printList(node_t *first);

void promptToAdd(node_t *first);

void removeNewLine(char *string);

void promptToRemove(node_t *first);

void finishTask(node_t *first, int index);

void promptToFinish(node_t *first);

void printHeader();

int isListInitialized = 0;

int main() {
    // Napravi fajl ako ne postoji
    FILE *fp = fopen("tasks.txt", "a+");
    fclose(fp);
    node_t *list = calloc(1, sizeof(node_t));

    readTasks(list);
    char cmd[10];
    while (1) {
        printf("\nKomanda(add, del, fin, list, quit): ");
        scanf("%s", &cmd);
        if (strncmp(cmd, "quit", 4) == 0) {
            exit(0);
        } else if (strncmp(cmd, "add", 3) == 0) {
            promptToAdd(list);
            writeTasks(list);
            printList(list);
        } else if (strncmp(cmd, "list", 4) == 0) {
            printList(list);
        } else if (strncmp(cmd, "del", 3) == 0) {
            promptToRemove(list);
            writeTasks(list);
            printList(list);
        } else if (strncmp(cmd, "fin", 3) == 0) {
            promptToFinish(list);
            writeTasks(list);
            printList(list);
        } else {
            printf("Komanda ne postoji\n");
        }
    }
}

void printHeader() {
    // Koristi cls komandu ako se projekat pokrece na windowsu, i clear na mac-u i linux-u
#ifdef WINDOWS
    system("cls");
#else
    system("clear");
#endif
    printf("Br|%-63s|[%s][%s]\n", "Zadatak", "P", "Z");
    for (int i = 0; i < TASK_S + 7; i++) {
        printf("-");
    }
    printf("\n");
}

void printList(node_t *first) {
    printHeader();
    int i = 1;
    if (isListInitialized == 1) {
        node_t *currentnode = first;
        while (currentnode != NULL) {
            printf("%d.|%-63s|[%d][%c]\n", i, currentnode->task.text, currentnode->task.prio,
                   currentnode->task.isdone == 1 ? 43 : 45);
            currentnode = currentnode->next;
            i++;
        }
    }
}

void promptToRemove(node_t *first) {
    char index[4];
    printf("Unesite redni br. obaveze za brisanje: ");
    scanf("%s", index);
    removeFromList(first, atoi(index));
}

void removeFromList(node_t *first, int index) {
    node_t *currentnode = first;
    node_t *previousnode = NULL;
    int i = 1;
    while (currentnode != NULL) {
        if (index == i) {
            // U slucaju da hocemo da obrisemo prvi node.
            if (previousnode == NULL) {
                node_t newfirstnode = {
                        currentnode->next->task,
                        currentnode->next->next,
                };
                *first = newfirstnode;
                break;
            }
                // U slucaju da hocemo da obrisemo bilo koji node u sredini.
            else if (currentnode->next != NULL) {
                previousnode->next = currentnode->next;
                break;
            }
                // U slucaju da hocemo da obrisemo poslednji node.
            else {
                previousnode->next = NULL;
                break;
            }
        }
        previousnode = currentnode;
        currentnode = currentnode->next;
        i++;
    }

}

void finishTask(node_t *first, int index) {
    node_t *currentnode = first;
    int i = 1;
    while (currentnode != NULL) {
        if (index == i) {
            currentnode->task.isdone = 1;
            break;
        }
        currentnode = currentnode->next;
        i++;
    }
}

void promptToFinish(node_t *first) {
    char index[4];
    printf("Unesite redni br. obaveze koju ste zavrsili: ");
    scanf("%s", index);
    finishTask(first, atoi(index));
}

// Funkcija koja zamenjuje '\n' koje kreira funkcija fgets sa '\0' 
void removeNewLine(char *string) {
    char *newline;
    newline = strrchr(string, '\n');
    if (newline) {
        *newline = '\0';
    }
}

void promptToAdd(node_t *first) {
    getchar();
    node_t *item;
    task_t input;
    char prio[4];
    item = (node_t *) calloc(1, sizeof(node_t));
    memset(input.text, 32, TEXT_S);
    printf("Zadatak: ");
    fgets(input.text, TEXT_S, stdin);
    removeNewLine(input.text);

    printf("Prioritet: ");
    scanf("%s", &prio);
    input.prio = atoi(prio) < 10 ? atoi(prio) : 9;

    input.isdone = 0;
    item->task = input;
    addToList(first, item);
}

void addToList(node_t *first, node_t *item) {
    node_t *currentnode = first;
    if (isListInitialized == 0) {
        memset(first->task.text, 0, TEXT_S);
        strncpy(first->task.text, item->task.text, TEXT_S - 1);
        first->task.prio = item->task.prio;
        first->task.isdone = item->task.isdone;
        isListInitialized = 1;
    } else {
        while (currentnode->next != NULL) {
            currentnode = currentnode->next;
        }
        currentnode->next = item;
    }
}

void writeTasks(node_t *first) {
    FILE *fp = fopen("tasks.txt", "w");
    node_t *currentnode = first;
    while (currentnode != NULL) {
        writeTask(fp, currentnode->task);
        currentnode = currentnode->next;
    }
    fclose(fp);
}

void writeTask(FILE *fp, task_t t) {
    fprintf(fp, "%-64s%d%d\n", t.text, t.prio, t.isdone);
}

void readTasks(node_t *list) {
    FILE *fp = fopen("tasks.txt", "r");
    char buf[TASK_S + 1];
    int prio, isdone;
    while (fgets(buf, TASK_S + 1, fp) != NULL) {
        if (strlen(buf) <= 2) {
            continue;
        }
        task_t t;

        strncpy(t.text, buf, TEXT_S - 1);
        removeNewLine(t.text);

        prio = buf[64] - 48;
        isdone = buf[65] - 48;

        t.prio = prio;
        t.isdone = isdone;

        node_t *item = (node_t *) calloc(1, sizeof(node_t));
        item->task = t;
        item->next = NULL;
        addToList(list, item);
        memset(&t, 0, sizeof(task_t));
        memset(buf, 32, TASK_S * sizeof(char));
    }
    printf("Zadaci ucitani\n");
    fclose(fp);
}