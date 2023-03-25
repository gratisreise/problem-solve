#include<bits/stdc++.h>
using namespace std;
#define y1 asfhhadf
int n, m, k, y1, x1, y2, x2, cnt;
int a[101][101], visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
void dfs(int y, int x){ // 1.void dfs이용
    visited[y][x] = 1;
    cnt++;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
        if(a[ny][nx] == 0 && visited[ny][nx] == 0){
            dfs(ny, nx);
        }
    }
}
int dfs(int y, int x){ // 2. int형 dfs
    visited[y][x] = 1;
    int ret = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
        if(a[ny][nx] == 0 && visited[ny][nx] == 0){
            ret += dfs(ny, nx);
        }
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
                dfs(i, j);
                ret.push_back(cnt);
                cnt = 0;
                //ret.push_back(dfs(i, j)); int형
            }
        }
    }
    sort(ret.begin(), ret.end());
    cout << ret.size() << '\n';
    for(int i : ret) cout << i << ' ';
    return 0;
}