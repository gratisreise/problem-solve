#include<bits/stdc++.h>
using namespace std;
int R, C, ret, visited[30];
char a[21][21];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void go(int y, int x, int cnt){
    ret = max(ret, cnt);
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
        int next = (int)(a[ny][nx] - 'A'); // 다음에 어떤 알파벳이 나오는지 탐색 next로 간편하게 해줌
        if(visited[next] == 0){ //방문되지 않았다면 
            visited[next] = 1; // 칠해주기
            go(ny, nx, cnt + 1); // cnt++을 해주면서 칸수세기
            visited[next] = 0; //원복 
        }
    }
    return;
}
int main(){
    cin >> R >> C;
    for(int i  =0; i < R; i++){ //그냥 들어가지네 ㅎㅎ 붙어있어도
        for(int j = 0; j < C; j++){
            cin >> a[i][j];
        }
    }
    visited[(int)a[0][0] - 'A'] = 1;
    go(0, 0, 1);
    cout << ret << '\n';
    return 0;
}