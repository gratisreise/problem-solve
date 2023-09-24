#include<bits/stdc++.h>
using namespace std;
int n, dp[101], cost[101], happy[101];
double temp;
int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++) scanf("%d", &cost[i]);
    for(int i = 0; i < n; i++) scanf("%d", &happy[i]);
    // 로직부분 (반복되는 부분이 보이네)
    for(int i = 0; i < n; i++){
        for(int j = 100; j > cost[i]; j--){
            // dp가 저장하는 값은 기쁨 인덱스는 가격
            // 오른쪽부터 dp, 체력0되면 안되니깐 cost일때 조건 해당X
            dp[j] = max(dp[j], dp[j - cost[i]] + happy[i]);
        }
    }
    printf("%d\n", dp[100]);
    return 0;
}
/*
1. 최대 기쁨 출력
2. 체력이 0이나 음수면 => 아무런 기쁨 못 느낀 것
3. 
*/