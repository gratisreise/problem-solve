#include<bits/stdc++.h>
using namespace std;
int n, m, d[54][54]; string s;
char b[54][54]; // 2차원 배열 받기
bool check[54][54]; // 오나 안 오나 체크
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
bool in(int aa, int bb){
    return (1 <= aa && aa <= n && 1 <= bb && bb <= m);
}
int down(int y, int x){
    // 보드 바깥 || 홀, 기저사례
    if(!in(y, x) || b[y][x] == 'H') return 0;
    if(check[y][x]){ // 사이클이 생기면 -1
        cout << - 1 << '\n';
        exit(0);
    }
    
    // 메모이제이션
    int &ret = d[y][x]; // 
    if(ret) return ret; // 겹치는 부분문제 리턴

    //
    check[y][x] = 1; // 
    int value = (int)b[y][x] - '0';
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i] * value;
        int nx = x + dx[i] * value;
        // 갈때마다 +1
        ret = max(ret, down(ny, nx) + 1);
    }
    // 다음경우의 수 영향 없게 원복
    check[y][x] = 0;
    return ret;
}
int main(){
    cin >> n >> m;
    // 입력
    for(int i = 1; i <= n; i++){
        cin >> s;
        for(int j = 1; j <= m; j++){
            b[i][j] = s[j - 1];
        }
    }
    cout << down(1, 1) << '\n'; // 왼쪽 위에서 시작
}