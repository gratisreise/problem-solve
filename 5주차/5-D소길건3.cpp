#include<bits/stdc++.h>
using namespace std;
int n;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    vector<pair<int, int>> a(n);
    for(int i = 0; i < n; i++) cin >> a[i].first >> a[i].second; 
    // 시작 시간 순으로 정렬
    sort(a.begin(), a.end()); 
    // 초기 시간 설정
    int realTime = a[0].first + a[0].second; 
    //순서대로 일 처리하기 
    for(int  i = 1; i < a.size(); i++){
        // 현재 일을 시작할 수 있는 시간이 되면 시작
        realTime = max(realTime, a[i].first);
        realTime += a[i].second;
    }
    //결과 출력
    cout << realTime << '\n';
    return 0;
}
/*
goal : 소가 길은 건너는 최소시간
조건1 : 한 번에 한 마리만 검문가능
1. 
*/