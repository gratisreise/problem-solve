#include <bits/stdc++.h>
using namespace std;
int from, to, n, ret = 1;  
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    vector<pair<int, int>> v; //회의 시간 정보를 저장할 벡터
    for(int i = 0; i < n; i++){
        cin >> from >> to;
        v.push_back({to, from}); // 회의 끝, 시작 시간순서 pair 저장
    }
    sort(v.begin(), v.end()); // 끝나는 시간 기준으로 오름차 정렬
    from = v[0].second; // 첫 회의 시작시간
    to = v[0].first; // 첫 회의 끝시간
    for(int i = 1; i < n; i++){ 
        if(v[i].second < to) continue; // 현재 회의의 시작시간이 이전 회의의 끝시간보다 작으면 회의를 진행할 수 없으므로 넘어감
        from = v[i].second; //현재회의 시작 from에 저장
        to = v[i].first;  // 현재회의 끝 to에 저장
        ret++; // 진행 가능한 회의 개수 1증가
    } 
    cout << ret << '\n'; 
    return 0;
}
/*
끊기고 다시 시작되어 더해지니깐
ret을 저장할 자료구조가 필요하지 않나??
*/