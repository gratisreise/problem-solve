#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, k, cnt; // cnt: 뽐아야 하는 프러그 갯수
int a[104], visited[104]; // a:전기용품의 순서, visited: 멀티탭에 꽂혀있는 용품인지 확안
vector<int> v; // 멀티탭에 꽂혀있는 전기 용품의 리스트
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> k >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < n; i++){
        if(!visited[a[i]]){ // 해당용품이 꽂혀있지 않으면
            if(v.size() == k){ // 멀티탭 꽉 차있으면
                int last_idx = 0, pos; // 가장 나중에 쓸 전기 용품의 위치와 번호를 담을 변수
                for(int _a : v){ // 멀티탭에 꽂혀있는 전기 용품 리스트를 순회하며
                    int here_pick = INF; // 해당 용품이 언제 다시 사용되는지 체크할 변수, 초기값은 INF
                    for(int j = i + 1; i < n; j++){ // 현재 위치부터 용품 순서 끝까지 순회하며
                        if(_a == a[j]){ // 해당 용품이 다시 사용되는 경우
                            here_pick = j; break; // 사용되는 위치를 저장하고 종료
                        }
                    }
                    if(last_idx < here_pick){ // 가장 나중에 사용되는 용품이면
                        last_idx = here_pick; // 가장 나중에 사용되는 위치 저장
                        pos = _a; // 해당 용품의 번호 저장
                    }
                }
                visited[pos] = 0; // 해당 용품을 멀티탭에서 뽑는다
                cnt++;  // 뽑는 용품의 갯수를 증가
                v.erase(find(v.begin(), v.end(), pos)); // 멀티탭 리스트에서 해당 용품을 제거한다
            }
            v.push_back(a[i]); // 현재 용품을 멀티탭에 꽂는다
            visited[a[i]] = 1; // 해당 용품이 멀티탭에 꽂혀있음을 체크한다.
        }
    }
    cout << cnt << '\n'; 
    return 0;
}