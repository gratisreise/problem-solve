#include<bits/stdc++.h>
using namespace std; 
int n, m, x1, y1, x2, y2;
int visited[301][301]; char a[301][301];
int dy[4] = {-1, 0, 1, 0}; 
int dx[4] = {0, 1, 0, -1};
queue<int> q;
int main(){
    scanf("%d %d", &n, &m);
    scanf("%d %d %d %d", &y1, &x1, &y2, &x2);
    y1--, x1--, y2--, x2--; // x,y범위가 1부터 시작하니깐 0부터 시작으로 맞출려고
    for(int i = 0; i < n; i++){ 
        scanf("%s", a[i]); 
    }  
    q.push(1000 * y1 + x1); // 2차원을 1차원으로 표현해주는 방법
    visited[y1][x1] = 1; 
    int cnt = 0; 
    while(a[y2][x2] != '0'){ 
        cnt++; //q가 사이즈가 1에서 멈췄다가 사이즈를 다시 받고 시작하니깐
        queue<int> temp; // a의 값이 1인 곳이 잠깐 머무는 곳
        while(q.size()){
            int y = q.front() / 1000; //주의할 점은 큰값으로 해야한다.
            int x = q.front() % 1000;  
            q.pop();  
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i]; 
                int nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue; 
                visited[ny][nx] = cnt;  
                if(a[ny][nx] != '0'){
                    a[ny][nx] = '0'; 
                    temp.push(1000 * ny + nx); // 다음에 탐색해줄 포인트
                }
                else q.push(1000 * ny + nx); 
            }
        }
        q = temp;  
    }
    printf("%d\n", visited[y2][x2]); 
}
/*
1.bfs
2. 2차원의 또다른 표현
3. 큐를 2개 선언해서 문제풀기
4. 
*/