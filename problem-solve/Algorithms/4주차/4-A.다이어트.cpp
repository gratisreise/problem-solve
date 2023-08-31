#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, mp, mf, ms, mv, p, f, s, v, c, ret = INF;
map<int, vector<vector<int>>> ret_v; // 자료구조 map으로
struct A{
    int mp, mf, ms, mv, cost;
}a[16];
int main(){
    cin >> n >> mp >> mf >> ms >> mv;
    for(int i = 0; i < n; i++){
        cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;
    }
    for(int i = 1; i < (1 << n); i++){ // 비트마스킹 경우의 수 따지기
        p = f = s = v = c = 0; //0초기화
        vector<int> vv; // 재료번호 조합 저장
        for(int j = 0; j < n; j++){ //부분집합 만들어짐
            if(i & (1 << j)){
                vv.push_back(j + 1);
                p += a[j].mp;
                f += a[j].mf;
                s += a[j].ms;
                v += a[j].mv;
                c += a[j].cost;
            }
            if( c <= ret && p >= mp && f >= mf && s >= ms && v >= mv){
                ret = c; // 가격 저장
                ret_v[ret].push_back(vv); // 저장된 가격에서 푸쉬
            }
        }
    }
    if(ret == INF) cout << -1 << '\n'; // 갱신 안됬을 때
    else{ // 갱신되면
        sort(ret_v[ret].begin(), ret_v[ret].end());
        cout << ret << '\n';
        for(int i : ret_v[ret][0]) cout << i << ' ';
    }
}
//맵
/*
ret 에다가 c를 넣어주고 그 다음 push_back()을 해주는게 맞다.
*/