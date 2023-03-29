#include<bits/stdc++.h>
using namespace std;
const int mx = 200000;
int visited[mx + 4];
long long cnt[mx + 4];
int main(){
    int n, m;
    cin >> n >> m;
    if(n == m){ // 반례 있거나 없거나 최대최소 같거나 다르거나!!!
        puts("0"); puts("1"); //puts 문자열 출력함수
        return 0;
    }
    visited[n] = 1;
    cnt[n] = 1;
    queue<int> q;
    q.push(n);
    while(!q.empty()){ //큐가 비어있진 않으면
        int now = q.front(); //now = 앞에있는 큐
        q.pop(); // 큐내보내기
        for(int next : {now - 1, now + 1, now * 2}){ //연산선언
            if(0 <= next && next <= mx){ // 언,옵제한
                if(!visited[next]){ //최소로 해줘야 하니깐
                    q.push(next);  // empty
                    visited[next] = visited[now] + 1; //최소의 시간
                    cnt[next] += cnt[now]; // 경우의 수 
                }else if(visited[next] == visited[now] + 1){ // 최단경우 아닌 경우 제외
                    cnt[next] += cnt[now];
                }
            }
        }
    }
    cout << visited[m] - 1 << '\n'; //시간이니깐 - 1해줌
    cout << cnt[m] << '\n'; // 경우의 수
}
/*
수빈이링 동생 사이의 가중치가 같네, 최소의 시간과 경우의 수네 -> bfs
직선 상이니깐 배열이용, 반례는 있거나 없거나 최대 최소
경우의 수는 각 노드에서 정해진 숫자의 더하기
*/