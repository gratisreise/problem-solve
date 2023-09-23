#include<bits/stdc++.h>
using namespace std; 
int dp[10001];  
int n, k, temp; 
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
	cin >> n >> k;
    dp[0] = 1; // 0원 = > 아무것도 안 넣는 경우 한 가지
	for(int i = 1; i <= n; i++){
        cin >> temp;  
        // 10000보다 큰 숫자는 컨티뉴
        if(temp >= 10001) continue; 
        //이전에 있는 정점으로부터 계속 더해 나가기
        for(int j = temp; j <= k; j++){  
            dp[j] += dp[j - temp];
        }
    }
    cout << dp[k] << "\n";
}

/**
 * 입력범위는 N: 1~ 100, K: 1~ 10000
 * 동전가치 10만보다 작게 입력된다.
 * 
*/