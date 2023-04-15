#include<bits/stdc++.h>
using namespace std;
int n, p, d, ret;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> p >> d; v.push_back({d, p}); // 마감일 firrst, 강연료 second저장
    }
    sort(v.begin(), v.end()); // 마감일 기준 오름차 정렬
    // for(int i = 0; i < n; i++){
    //     pq.push(v[i].second); // 강연료를 우선순위 큐에 오름차로 저장
    //     // 같은 마감일의 적은 가격 빼주기 위해 사이즈로 비교하면서 
    //     if(pq.size() > v[i].first){ // 오름차순으로 
    //         pq.pop();
    //     }
    // }
    //남아있는 강연료를 더함
    while(pq.size()){
        ret += pq.top(); pq.pop();
    }
    cout << ret << '\n';
} 
/*
돈에 대한 내림차의 로직을 구현못함!!
*/