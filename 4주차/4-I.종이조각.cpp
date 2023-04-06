#include<bits/stdc++.h>
using namespace std;
int n, m, ret; 
int a[4][4];
int main() { 
    scanf("%d %d",&n,&m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &a[i][j]); 
        }
    } 
    for (int s = 0; s < (1 << (n * m)); s++) {
        int sum = 0; 
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for(int j = 0; j < m; j++) {
                int k = i * m + j;
                if ((s & (1 << k)) == 0) { // 
                    cur = cur * 10 + a[i][j];
                } else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        for (int j = 0; j < m; j++) {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                int k = i * m + j;
                if ((s & (1 << k)) != 0) {
                    cur = cur * 10 + a[i][j];
                }else{
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        ret = max(ret, sum);
    }
    cout << ret << '\n';
    return 0;
}
/*
다음으로 s 변수는 이어붙일 숫자들을 결정하는 비트마스크를 의미합니다. 
이때 2차원 배열 a를 이어붙여서 만들 수 있는 모든 경우의 수를 다 돌아보며 최대값을 구합니다. 
비트마스크를 이용해 0과 1을 표현할 수 있으므로 모든 경우의 수는 (1 << (n * m)) 입니다.

각 경우마다 sum을 초기화하고 2차원 배열 a를 가로로 이어붙일 경우와 세로로 이어붙일 경우를 따로 계산합니다. 
그리고 각 자리마다 이어붙인 숫자를 저장하는 cur를 초기화하고 비트마스크를 이용해 이어붙일 자리를 판단합니다. 
이때 & 연산자를 이용해 해당 자리의 값이 0이면 가로로 이어붙이고 1이면 세로로 이어붙입니다.
*/
