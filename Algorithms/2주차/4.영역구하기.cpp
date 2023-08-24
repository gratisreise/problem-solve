#include<bits/stdc++.h>
using namespace std;
#define y1 Noah
int n, m,k, y1, x1, y2, x2, a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
vector<int> v;
int dfs(int y, int x){
    visited[y][x] = 1;
    int ret = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
        if(a[ny][nx] == 1 || visited[ny][nx] == 1) continue;
        ret += dfs(ny, nx);
    }
    return ret;
}
int main(){
    cin >> m >> n >> k;
    while(k--){
        cin >> x1 >> y1 >> x2 >> y2;
        for(int x = x1; x < x2; x++){
            for(int y = y1; y < y2; y++){
                a[y][x] = 1;
            }
        }
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(a[i][j] == 0 && visited[i][j] == 0){
                v.push_back(dfs(i, j));
            }
        }
    }
    if(!v.size()) cout << 0 << '\n';
    else{
        sort(v.begin(), v.end());
        cout << v.size() << '\n';
        for(int i : v) cout << i << ' ';
    }
}