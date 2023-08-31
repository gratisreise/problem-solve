#include<bits/stdc++.h>
using namespace std;
#define time noah
int n, a, b, time, ret = 1;
vector<pair<int, int>> v; // 회의시간 정렬
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a >> b;
        v.push_back({b, a});
    }
    sort(v.begin(), v.end()); // 끝 정렬
    time = v[0].first; // 처음의 끝을 대입
    for(int i = 1; i < n; i++){
        if(v[i].second < time) continue; // 시작이 이전 끝보다 작으면 안됨
        time = v[i].first; // 다음 끝 저장
        ret++; //회의 갯수 ++
    }
    cout << ret << '\n';
}
/*
끊기고 다시 시작되어 더해지니깐
ret을 저장할 자료구조가 필요하지 않나??
*/