#include<bits/stdc++.h>
using namespace std;
#define next aaaa
const int mx = 200004; //제한범위 왜 이렁헤 한지 모르겠다.
int n, k, ret, next; //
int visited[mx], prev[mx]; //
vector<int> v; // prev의 위치 넣어주길 위해 선언
queue<int> q;
int main(){
    cin >> n >> k; 
    visited[n] = 1;  // bfs 왜냐하면 최소의 시간
    q.push(n); 
    while(q.size()){
        int here = q.front(); q.pop();
        if(here == k) break;
        for(int next : {here + 1, here - 1, here * 2}){
            // pair<int, int> d[] = {{1, 1}, {1, -1}, {2, 0}};
            // for(int i = 0; i < 3; i++){
            // int nx = here * d[i].first + d[i].second;
            // }
            if(next >= mx || next < 0 || visited[next]) continue;
            visited[next] = visited[here] + 1;
            prev[next] = here;
            q.push(next);
        }
    }
    for(int i = k; i != n; i = prev[i]){ // 동생위치부터 수빈이 위치까지 prev
        v.push_back(i);
    }
    // v.push_back(n);
    reverse(v.begin(), v.end());
    cout << ret - 1 << '\n';
    for(int i : v) cout << i << ' ';
    return 0;
}

/*
등호 여부에 따라 탐색의 차이가 뭔지 잘 모르겠다.
숨바꼭질은 묶어서 보자
trace는 prev[next] = here; -> here의 값을 불러와서 추적시킨다.
최소의 시간 bfs를 이용 직선 상이니깐 배열을 이용해서 선언한다.
*/