#include<bits/stdc++.h>

using namespace std;
const int INF = 987654321;
int a[104][104], ret = INF, n = 10;
map<int, int> mp; //색종이 얼마나 썻는지 카운트

bool check(int y, int x, int cnt){ //색종이가 칠해질 수 있는지 탐색하며 체크
    if(y + cnt > n || x + cnt > n) return false; //배열의 인덱스 범위르 넘는지 체크하는 로직
    for(int i = y; i < y + cnt; i++){ 
        for(int j = x; j < x + cnt; j++){
            if(a[i][j] == 0) return false;
        }
    }
    return true;
}

void draw(int y, int x, int cnt, int value){ //색칠하는 로직
    for(int i = y; i < y+ cnt; i++){
        for(int j = x; j < x + cnt; j++){
            a[i][j] = value;
        }
    }
}

void dfs(int y, int x, int cnt){
    if(cnt >= ret) return; // 최소값 찾는건데 ret보다 커버리면 소용이 없다.
    if(x == n){ // y + 1하면서 탐색
        dfs(y + 1, 0, cnt);
        return;
    }
    if(y == n){ // 끝까지 도달 하면 return
        ret = min(cnt, ret);
        return;
    }
    if(a[y][x] == 0){ // 값이 0인 곳은 탐색할 필요가 없으니 패스
        dfs(y, x + 1, cnt); return;
    }
    for(int _size = 5; _size >= 1; _size--){ //색종이 큰 것부터 붙이는 로직
        if(mp[_size] == 5) continue; // 색종이 다써버리면 쩔수다.
        if(check(y, x, _size)){ //색종이가 칠해질 수 있는지 체크
            mp[_size]++;
            draw(y, x, _size, 0);
            dfs(y, x + _size, cnt + 1);
            draw(y, x, _size, 1);
            mp[_size]--;
        }
    }
    return;
}
int main(){
    fast();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    dfs(0, 0, 0); //dfs들어간다
    cout << (ret == INF ? -1 : ret) << '\n'; //ret은 마지막에 출력할 무언가
    return 0;
}