#include<bits/stdc++.h>
using namespace std;
int n, m, d[54][54]; string s;
char b[54][54]; bool check[54][54];
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
bool in(int aa, int bb){
    return (1 <= aa &&  aa <= n && 1 <= bb && bb <= m);
}
int down(int y, int x){
    if(!in(y, x) || b[y][x] == 'H') return 0;
    if(check[y][x]){
        cout << -1 << '\n';
        exit(0);
    }
    int &ret = d[y][x];
    if(ret) return ret;

    check[y][x] = 1;
    int value = (int)b[y][x] - '0';
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i] * value;
        int nx = x + dx[i] * value;
        ret = max(ret, down(ny, nx) + 1);
    }
    check[y][x] = 0;
    return ret;
}
int main(){
    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        cin >> s;
        for(int j = 1; j <= m; j++){
            b[i][j] = s[j - 1];
        }
    }
    cout << down(1, 1) << '\n';
}