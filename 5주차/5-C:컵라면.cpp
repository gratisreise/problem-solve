#include<bits/stdc++.h>
using namespace std;
int n, a, b, ret;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a >> b; v.push_back({a, b});
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < n; i++){
        ret += v[i].second;
        pq.push(v[i].second);
        while(pq.size() > v[i].first){ //현재까지 먹을 수 있는 라면 중에서 보상이 적은 것을 제외
            ret -= pq.top();
            pq.pop();
        }
    }
    cout << ret << '\n';
    return 0;
}

// ret을 for문 안에 넣어서 while 줄여버리기 가능
