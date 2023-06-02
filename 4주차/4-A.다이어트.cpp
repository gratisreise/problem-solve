#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, mp, mf, ms, mv, ret = INF;
int p, f, s, v, c;
map<int, vector<vector<int>>> mp1;
struct A {
    int mp, mf, ms, mv, cost;
}a[16];
int main(){
    cin >> n >> mp >> mf >> ms >> mv;
    for(int i = 0; i < n; i++){
        cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;
    }
    for(int i = 1; i < (1 << n); i++){ // 재료없는 경우는 제외 0001부터 시작
        p = f = s = v = c = 0;
        vector<int> vv;
        for(int j = 0; j < n; j++){
            if(i & (1 << j)){
                vv.push_back(j + 1);
                p += a[j].mp;
                f += a[j].mf;
                s += a[j].ms;
                v += a[j].mv;
                c += a[j].cost;
            }
        }
        if(c <= ret && p >= mp && f >= mf && s >= ms && v >= mv){
            ret = c;
            mp1[c].push_back(vv); // ret키에 벡터 저장
        }
    }
    if(ret == INF) cout << -1 << '\n';
    else{
        sort(mp1[ret].begin(), mp1[ret].end()); //오름차순 정렬
        cout << ret << '\n'; 
        for(int i : mp1[ret][0]) cout << i << ' '; // ret값중 사전순 첫 번째
    }
    return 0;
}
//맵
/*
비트 연산자 이용한 반복 돌리기 부분 잘 모름 -> j이용하기 -> 있다없다 정해주니깐

Q1. 맵은 자동 오름차순 정렬 아닌가??

*/