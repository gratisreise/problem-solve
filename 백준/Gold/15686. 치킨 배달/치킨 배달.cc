#include<bits/stdc++.h>
using namespace std;
int a[51][51], n, m, result = 1e9;
vector<pair<int, int>> H, C;
vector<vector<int>> CI;
void combi(int start, vector<int> &v){
    if(v.size() == m){
        CI.push_back(v);
    }
    for(int i = start + 1; i < C.size(); i++){
        v.push_back(i);
        combi(i, v);
        v.pop_back();
    }
    return;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
            if(a[i][j] == 1) H.push_back({i, j});
            if(a[i][j] == 2) C.push_back({i, j});
        }
    }
    vector<int> v;
    combi(-1, v);

    for(auto ci : CI){
        int ret = 0; 
        for(auto h : H){
            int _min = 1e9;
            for(int c : ci){
                int _dist = abs(h.first - C[c].first) + abs(h.second - C[c].second);
                _min = min(_min, _dist); 
            }
            ret += _min; 
        }
        result = min(result, ret); 
    }
    cout << result << '\n';
}