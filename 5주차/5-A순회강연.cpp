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
    for(int i = 0; i < n; i++){
        pq.push(v[i].second); // 강연료를 우선순위 큐에 저장
        // 우선순위 큐의 크기가 마감일보다 크면 강연료가 가장 적은 강연을 뺌
        if(pq.size() > v[i].first){ // 오름차순으로 
            pq.pop();
        }
    }
    //남아있는 강연료를 더함
    while(pq.size()){
        ret += pq.top(); pq.pop();
    }
    cout << ret << '\n';
} 