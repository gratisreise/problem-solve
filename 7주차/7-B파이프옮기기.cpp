#include<bits/stdc++.h>
using namespace std;
int n, a[24][24], dp[24][24][3], ret;
bool check(int y, int x, int d){
    if(d == 0 || d == 2){ 
        // 벽없어?? 그럼 ㄱㄱ
        if(!a[y][x]) return true; 
    }else if(d == 1){  
        if(a[y][x] == 0 && a[y - 1][x] == 0 && a[y][x - 1] == 0) return true;
    }
    return false; 
}
int main(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> a[i][j];
        }
    }
    dp[1][2][0] = 1; 
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(check(i, j + 1, 0)) dp[i][j + 1][0] += dp[i][j][0];
            if(check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][0];

            if(check(i + 1, j, 2)) dp[i + 1][j][2] += dp[i][j][2];
            if(check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][2];

            if(check(i, j + 1, 0)) dp[i][j + 1][0] += dp[i][j][1];
            if(check(i + 1, j, 2)) dp[i + 1][j][2] += dp[i][j][1];
            if(check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][1];
        }
    }
    
    for(int i = 0; i < 3; i++){
        ret += dp[n][n][i];
    }

    cout << ret << '\n';
    return 0;
}
/*
체크함수랑 계산 방법 -> 마지막지점의 경우의수를 다 더해주면 된다.
기저사례가 뭐야?
메모이제이션으로 뭘했어?
로직이 뭐야??
초기화는 어떻게 돼?
어떤 상태값을 저장하고 어떻게 탐색을 할거야??
*/