#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, k, ret;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> k;
    vector<pair<ll, ll>> v(n); // 무게랑 가치
    vector<ll> vv(k); // 가방무게
    for(int i  = 0; i < n; i++){ // 무게 가치 벡터에 넣기
        cin >> v[i].first >> v[i].second; // 무게 >> 가치
    }
    for(int i = 0; i < k; i++) cin >> vv[i]; // 가방의 무게 입력받기
    sort(v.begin(), v.end());  // 오름차 정렬
    sort(vv.begin(), vv.end()); // 오름차 정렬
    priority_queue<ll> pq; // 우선순위 큐선언 -> 기본이 내림차라 가치 큰 것부터

    int j = 0; //
    for(int i = 0; i < k; i++){
        // 보석가치 큰 것부터 차례로 우선순위큐에 넣기
        while(j < n &&  v[j].first <= vv[i]) pq.push(v[j++].second);
        if(pq.size()){
            ret += pq.top(); pq.pop();
        }
    }
    cout << ret << '\n';
    return 0;
}
/*
보석과 가방을 무게순으로 정렬
가방 무게가 작은 것부터 시작하여 담을 수 있는 보석들 중 가장
가치가 높은 보석을 선택
시간복받도 크지 않나??

*/