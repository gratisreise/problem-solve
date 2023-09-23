#include<bits/stdc++.h>
using namespace std;
int cost, n, m1, m2, c;
int dp[100004];
int main(){
    while(1){
        // 형식 지정자로 정수부와 소수부 나눠서 받음
        // 실수를 정수처리 해주고 싶어서
        scanf("%d %d.%d", &n, &m1, &m2);
        if(n == 0) break; // 0이면 브레이크
        // 실수를 정수처리해줌 -> 실수형 연산 정확하지 않다.
        int cost = m1 * 100 + m2; 
        memset(dp, 0, sizeof(dp)); //dp배열을 초기화
        // 왼쪽부터 누적하는 dp
        for(int i = 0; i < n; i++){
            scanf("%d %d.%d", &c, &m1, &m2);
            int p = m1 * 100 + m2;
            //왼쪽에서부터 누적하는 dP
            for(int j = p; j <= cost; j++){
                dp[j] = max(dp[j], dp[j - p] + c);
            }
        }
        printf("%d\n", dp[cost]);
    }
}