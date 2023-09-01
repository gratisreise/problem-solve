#include<bits/stdc++.h>
using namespace std;
int n, m, dp[54][54]; string s;
char a[54][54]; bool check[54][54];
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
bool in(int aa, int bb){
    return (0 <= aa && aa <= n-1 && 0 <= bb && bb <= m-1);
}
int go(int y, int x){
    if(!in(y, x) || a[y][x] == 'H') return 0;
    if(check[y][x]){
        cout << -1 << '\n';
        exit(0);
    }
    int &ret = dp[y][x];
    if(ret) return ret;

    check[y][x] = 1; 
    int value = a[y][x] - '0';
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i] * value;
        int nx = x + dx[i] * value;
        ret = max(ret, go(ny, nx) + 1);
    }
    check[y][x] = 0;
    return ret;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }
    cout << go(0, 0) << '\n';
}