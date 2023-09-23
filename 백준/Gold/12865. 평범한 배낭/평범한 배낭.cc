#include<bits/stdc++.h>
using namespace std;
int dp[100001];
int n, k, w, v;
int main(){
    // 물품의수, 버틸 수 있는 무게
    scanf("%d %d", &n, &k);
    while(n--){
        // n개의 경우에서 물건 무게와 가치
        scanf("%d %d", &w, &v);
        //물건마다 1개 제한 오른쪽부터 dp
        for(int j = k; j >= w; j--){
            //최대의 가치를 가지는
            dp[j] = max(dp[j], dp[j - w] + v);
        }
    }
    printf("%d\n", dp[k]);
    return 0;
}