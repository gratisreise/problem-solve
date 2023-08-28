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
    for(int i = 0; i < (1 << n); i++){
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
            mp1[c].push_back(vv);
        }
    }
    if(ret == INF) cout << -1 << '\n';
    else{
        sort(mp1[ret].begin(), mp1[ret].end());
        cout << ret << '\n';
        for(int i : mp1[ret][0]) cout << i << ' ';
    }
}
