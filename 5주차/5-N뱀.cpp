#include<bits/stdc++.h>
using namespace std;  
#define time ff
// ret : 게임종료시간, idx : 다음 이동 명령의 인덱스, dir : 현재 뱀의 진행방향(0 : 위, 1:오른쪽, 2:아래, 3: 왼쪽)
int n, k, l, y, x, t, ret, idx, dir = 1;
int a[104][104], visited[104][104], time; 
char c; 
deque<pair<int, int>> dq; // 뱀의 위치를 저장하는 덱 
vector<pair<int, int>> _time; // 이동명령 저장하는 벡터(현재시간, 방향(1:오,3:왼)
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1}; 
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> k; 
    for(int i = 0; i < k; i++){
        cin >> y >> x; 
        a[--y][--x] = 1; //기준이 1더 크게 되어있으므로
    }
    cin >> l; 
    for(int i = 0; i < l; i++){
        cin >> t >> c;   
        if(c == 'D') _time.push_back({t, 1});
        else _time.push_back({t, 3}); 
    } 
    dq.push_back({0, 0}); 
    while(dq.size()){ 
        time++; 
        tie(y, x) = dq.front();
        int ny = y + dy[dir]; 
        int nx = x + dx[dir]; 
        if(ny >= n || ny < 0 || nx >= n || nx < 0 || visited[ny][nx]) break;
        if(!a[ny][nx]){ 
            visited[dq.back().first][dq.back().second] = 0;  
            dq.pop_back(); 
        }else a[ny][nx] = 0; 

        visited[ny][nx] = 1;  
        dq.push_front({ny, nx}); 
        if(time == _time[idx].first){
            dir = (dir + _time[idx].second) % 4; // 방향전환을 위해 있는 코드
            idx++; 
        }    
    }
    cout << time << "\n"; 
    return 0;
}
/*
1. 입력
- 보드의 크기 n과 사과의 개숫 k를 입력
- 사과의 위치를 입력받아 a배열에 저장
- 이동 명령의 개수 i를 입력받음
- 이동 명령을 _time 배열에 저장

2. 뱀의 초기 상태 설정
- dq(덱)에 뱀의 초기 위치(0, 0)를 저장
- visited 배열에 현재 뱀의 머리(0, 0)를 방문한 것으로 표시

3. 뱀 이동
- 현재 방향(dir)에 따라 다음 위치(ny, nx)를 계산합니다.
- 만약 다음 위치가 보드 밖이거나, 이미 방문한 위치라면 게임을 종료합니다.
- 다음 위치에 사과가 있으면 사과를 먹고, 없으면 꼬리를 자릅니다.
- 다음 위치를 dq의 맨 앞에 추가하고, visited 배열에 방문한 것으로 표시합니다.
- 현재 시간(time)과 이동 명령의 시간(_time[idx].first)을 비교해 방향을 바꿀 
    시간이 되었다면 방향을 바꿔줍니다.

4.결과 출력
-게임 종료 시간인 time을 출력
*/