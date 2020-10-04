#include <stdio.h>
#include <string.h>

int main(void){
    int a, b, c;
    char s[10];
    scanf("%d %d", &a, &b);
    c = a * b;
    if ((c % 2) == 0){
        strcpy(s, "Even");
    }
    else
    {
        strcpy(s, "Odd");
    }
    printf("%s\n", s);
    return 0;
}

