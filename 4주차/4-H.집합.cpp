#include <bits/stdc++.h>
using namespace std;
int n, m, x;
char s[11];
int main() {
    scanf(" %d", &m);
    for (int i = 0; i < m; i++) {
        scanf(" %s %d", &s, &x); 
        if (s[0] == 'a' && s[1] == 'd') n |= (1 << x);
        else if (s[0] == 'r') n &= ~(1 << x);
        else if (s[0] == 'c') printf("%d\n", (n & (1 << x)) == 0 ? 0 : 1);
        else if (s[0] == 't') n ^= (1 << x);
        else if (s[0] == 'a' && s[1] == 'l') n = (1 << 21) - 1;
        else n = 0;
    }
}
/*
받는 문자들 중 앞글자로만 구분함.
각 문자에 해당하는 연산을 해준다.
*/
