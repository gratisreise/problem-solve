#include<bits/stdc++.h>
using namespace std;
int n, 
    ret = 1e9; // 최소에서 최대
int p[20][20], // 
    v[20][20]; // 
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
bool check(int y, int x){

    if(v[y][x]) return 0;
    for(int  i = 0 ; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(v[ny][nx]) return 0;
    }
    return 1;
}
int setFlower(int y, int x){
    v[y][x] = 1;
    int s = p[y][x];
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        v[ny][nx] = 1;
        s += p[ny][nx];
    }
    return s;
}

void eraseFlower(int y, int x){
    v[y][x] = 0;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        v[ny][nx] = 0;
    }
    return;
}

void flower(int cnt, int hap){
    if(cnt == 3){
        ret = min(ret, hap);
        return;
    }
    for(int i = 1; i < n-1; i++){
        for(int j = 1; j < n-1; j++){
            if(check(i, j)){
                flower(cnt + 1, hap + setFlower(i, j));
                eraseFlower(i, j);
            }
        }
    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> p[i][j];
        }
    }
    flower(0, 0);
    cout << ret << '\n';
    return 0;
}