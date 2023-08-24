#include<bits/stdc++.h>
using namespace std;
#define y1 noah
int n, m, x1, y1, x2, y2;
int visited[301][301]; char a[301][301];
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
queue<int> q;
int main(){
    // 입력
    scanf("%d %d", &n, &m); 
    scanf("%d %d %d %d", &y1, &x1, &y2, &x2);
    // 0부터 시작하게 처리
    y1--, x1--, y2--, x2--;
    //string으로 배열 받기
    for(int i = 0; i < n; i++) scanf("%s", a[i]);
    // 숫자로 간단하게 처리
    q.push(1000 * y1 + x1);
    visited[y1][x1] = 1; 
    int cnt = 0; // cnt는 뭘위해 선언??
    while(a[y2][x2] != '0'){ // 범인이 주난의 난을 당하면 0으로 만들기
        cnt++; //점프횟수
        queue<int> temp; // 다음에 돌릴 q를 임시저장
        while(q.size()){
            int y = q.front() / 1000; 
            int x = q.front() % 1000;
            q.pop();
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >=m || visited[ny][nx]) continue;
                visited[ny][nx] = cnt; // 난이 끼친 곳은 방문배열 cnt로 점프횟수 표현
                if(a[ny][nx] != '0'){ // 1을 만나 멈춘지점이 다음 점프에서 다시 시작
                    a[ny][nx] = '0';
                    temp.push(1000 * ny + nx);
                }
                else q.push(1000 * ny + nx); // 태생이 0인 애들은 통과
            }
        }
        q = temp; // 점프가 일어난 곳을 다시 q에 저장
    }
    printf("%d\n", visited[y2][x2]);
}
/*
1. bfs
2. 2차원의 또다른 표현
3. 큐를 2개 선언해서 문제풀기
4. 
*/