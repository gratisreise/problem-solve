#include<bits/stdc++.h>
using namespace std;
int n, d, p, ret;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int> > pq;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){ 
        cin >> p >> d; v.push_ba ck({d, p});
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < n; i++){
        ret += v[i].second;
        pq.push(v[i].second);
        while(pq.size() > v[i].first){ // pq사이즈가 날짜기준이 된다.
            ret -= pq.top(); pq.pop(); // 각 날짜의 최고의 임금만 남기기
        }
    }  
    cout << ret << '\n';
}
/*
1. 날짜에 대해 오름차순으로 정렬
2. 돈에 대해 오름차정렬하고 
3. pq사이즈 기준으로 합을 구해준다.
*/
<실수 리스트>
1. pq에 가격이 아닌 날짜를 푸쉬
2. 