#include <bits/stdc++.h>
using namespace std; 
int n, m, a[10][10], temp[10][10], ret = 1e9; 
vector<pair<int, int>>v; 
const int dy[] = {-1, 0, 1, 0}; 
const int dx[] = {0, 1, 0, -1}; 
vector<pair<int, int>> extendCCTV(int here, int dir){
    vector<pair<int, int>> _change; 
    int y = v[here].first; 
    int x = v[here].second; 
    if(a[y][x] == 1){
        while(true){
            int ny = y + dy[dir]; 
            int nx = x + dx[dir]; 
            if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
                if(a[ny][nx] == 0){
                    a[ny][nx] = 8; // 숫자 중요 -> 탐색 표현 숫자는 범위 밖에서 하기
                    _change.push_back({ny, nx});
                }
                y = ny; 
                x = nx; 
            }else break;
        }
    }else if(a[y][x] == 2){
        for(int i = 0; i <= 2; i +=2){
            int _y = y;
            int _x = x;
            while(true){
                int ny = _y + dy[(dir + i) % 4];
                int nx = _x + dx[(dir + i) % 4]; 
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
                    if(a[ny][nx] == 0){a[ny][nx] = 8;_change.push_back({ny, nx});}
                    _y = ny;
                    _x = nx;
                }else break;
            }
        }
    }else if(a[y][x] == 3){
        for(int i = 0; i < 2; i++){
            int _y = y;
            int _x = x;
            while(true){
                int ny = _y + dy[(dir + i) % 4];
                int nx = _x + dx[(dir + i) % 4];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
                    if(a[ny][nx] == 0){a[ny][nx] = 8;_change.push_back({ny, nx});}
                    _y = ny;
                    _x = nx;
                }else break;
            }
        }
    }else if(a[y][x] == 4){
        for(int i = 0; i < 3; i++){
            int _y = y;
            int _x = x;
            while(true){
                int ny = _y + dy[(dir + i) % 4];
                int nx = _x + dx[(dir + i) % 4];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
                    if(a[ny][nx] == 0){a[ny][nx] = 8;_change.push_back({ny, nx});}
                    _y = ny;
                    _x = nx;
                }else break;
            }
        }
    }else if(a[y][x] == 5){
        for(int i = 0; i < 4; i++){
            int _y = y;
            int _x = x;
            while(true){
                int ny = _y + dy[(dir + i) % 4];
                int nx = _x + dx[(dir + i) % 4]; 
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6){
                    if(a[ny][nx] == 0){a[ny][nx] = 8;_change.push_back({ny, nx});}
                    _y = ny;
                    _x = nx;
                }else break;
            }
        }
    }
    return _change; 
}
void dfs(int here){
    if(here == v.size()){
        int cnt = 0; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0)cnt++;
            }
        }
        ret = min(cnt, ret); 
        return;
    }
    for(int k = 0; k < 4; k++){
        vector<pair<int, int>> _change = extendCCTV(here, k); 
        dfs(here + 1); 
        for(auto b : _change) a[b.first][b.second] = 0; ㄷ//원복    
    }
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] != 6 && a[i][j] != 0)v.push_back({i, j});
        }
    }
    dfs(0);
    cout << ret << "\n";

    return 0;
}
/*
이 코드는 DFS(깊이 우선 탐색)을 이용하여 CCTV를 하나씩 선택하면서 
각 CCTV가 감시할 수 있는 영역을 8로 채우고, 다음 CCTV를 선택하는 과정을 반복합니다.
모든 CCTV를 선택한 후에는 감시되지 않은 영역(0)의 개수를 세어서 최소값을 갱신합니다. 
이때, 선택한 CCTV들이 감시한 영역을 다시 0으로 바꾸어 주어야 합니다.
주요 함수인 extendCCTV 함수는 선택한 CCTV의 종류에 따라서 감시할 수 있는 영역을 모두 
8로 채우고, 감시한 영역의 좌표를 _change 벡터에 저장합니다. 이후에 _change 벡터에 
저장된 좌표들을 이용하여 감시한 영역을 다시 0으로 바꾸어 주는 역할을 합니다.
*/