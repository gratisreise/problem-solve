#include<bits/stdc++.h>
using namespace std;
const int mx = 1501;
const int  dy[4] = {1, 0, -1, 0};
const int  dx[4] = {0, 1, 0, -1};
int visited_swan[mx][mx], visited[mx][mx]; char a[mx][mx];
int R, C, day, swanY, swanX, y, x;
queue<pair<int, int> waterQ, water_tmepQ, swanQ, swan_tempQ;
string s;
void Qclear(queue<pair<int, int>> &q){
    queue<pair<int, int>> empqy;
    swap(q, empty);
}
void water_melting(){ //물녹이는 로직
    while(waterQ.size()){
        tie(y, x) = waterQ.fornt();
        waterQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx]) continue;
            if(a[ny][nx] == 'X'){
                visited[ny][nx] = 1;
                water_tempQ.push({ny, nx});
                a[ny][nx] = '.';
            }
        }
    }
}
bool move_swan(){ //로직의 원리
    while(swanQ.size())[
        tie(y, x) = swanQ.front(); swanQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx]) continue;
            if(a[ny][nx] = '.') swanQ.push({ny, nx});
            else if(a[ny][nx] == 'X') swan_tempQ.psuh({ny, nx});
            else if(a[ny][nx] == 'L') return true;
        }
    ]
    return false;
}
int main(){ // 내가 쓴 로직에대한 의도 
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> R >> C;
    for(int i = 0; i < R; i++){
        cin >> s;
        for(int j = 0; j < C; j++){
            a[i][j] = s[j];
            if(a[i][j] == 'L'){swanY = i; swanX = j;}
            if(a[i][j] == '.' || a[i][j] == 'L') visited[i][j] = 1, waterQ.push({i, j});
        }
    }
    swanQ.push({swanY, swanX});
    visited_swan[swanY][swanX] = 1;
    while(true){
        if(move_swan())break;
        water_melting();
        waterQ = water_tempQ;
        swanQ = swan_tempQ;
        Qclear(water_tempQ);
        Qclear(swan_tempQ);
        day++;
    }
    cout << day << '\n';
}
/*
1. 문제의 단순화 -> 하나의 로직으로 구현가능한가>
2. 
*/