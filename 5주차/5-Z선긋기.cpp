#include<bits/stdc++.h>
using namespace std; 
typedef pair<int, int> P;
P L[1000004];
int n, l, r, ret; 
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0); 
    cin >> n; 
    // 직선들의 시작점과 끝점 정보를 입력 받음
    for(int i = 0; i < n; i++){ 
        cin >> L[i].first >> L[i].second;
    }
    // 직선들의 시작점을 기준으로 정렬
    sort(L, L + n); 
    // 첫 번째 직선을 누적 선분으로 설정
    l = L[0].first; r = L[0].second; 
    // 두 번째 직선부터 끝까지 반복하며 누적된 선분 정보 업데이트
    for(int i = 1; i < n; i++){
        // 누적된 선분과 다음 선분이 겹치지 않으면 누적된 길이에 현재까지 누적된 길이를 더하고 새로운 선분으로 업데이트 
        if(r < L[i].first){ 
            ret += (r - l); 
            l = L[i].first; r = L[i].second;
        }
        // 누적된 선분과 다음 선분이 겹치면 누적된 선분을 연장하여 업데이트
        else if(L[i].first <= r && L[i].second >= r){ 
            r = L[i].second;
        }
    }
    ret += r - l; // 마지막 누적된 선분 길이 추가
    cout << ret << '\n';
}