#include<bits/stdc++.h>
using namespace std;
int R, C, ret;
char a[21][21];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void go(int y, int x, int num, int cnt){
    ret = max(ret, cnt);
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= R  || nx >= C) continue;
        int _next = (1 << (int)(a[ny][nx] - 'A'));
        if((num & _next) == 0) go(ny, nx, num | _next, cnt + 1);
    }
    return;
}
int main(){
    cin >> R >> C;
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cin >> a[i][j];
        }
    }
    go(0, 0, 1 <<(int)(a[0][0] - 'A'), 1);
    cout << ret << '\n';
    return 0;
}
/*
1. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀있음
2. 좌측 상단에 말 시작
3. 지금까지 지나온 알파벳과 달라야 함
4. 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지 구하는 프로그램 작성
*/