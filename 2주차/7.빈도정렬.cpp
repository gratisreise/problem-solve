#include<bits/stdc++.h>
using namespace std;
int n, c, temp;
map<int, int> mp1, mp2;
vector<pair<int, int>> v;
// 빈도 내림차 if(빈도==순서) 순서오름차
bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second){ 
        return mp2[a.first] < mp2[b.first];
    }
    return a.second > b.second; 
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    cin >> n >> c;
    for(int i = 0; i < n; i++){
        cin >> temp; // 임시저장
        mp1[temp]++;
        if(mp2[temp] == 0) mp2[temp] = i + 1;
    }
    for(auto i : mp1) v.push_back({i.first, i.second});
    sort(v.begin(), v.end(), cmp);
    for(auto i : v){
        for(int j = 0 ; j < i.second; j++){
            cout << i.first << ' ';
        }
    }
    cout << '\n';
}
/*
map을 이용해 빈도와 순서를 저장한다.
빈도는 ++로 순서는 참조성질을 이용해서 저장
정렬에서 커스텀함수는 ()호출을 안한다.
*/