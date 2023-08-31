#include<bits/stdc++.h>
using namespace std;
int n, x, y;
int main(){
    cin >> n;
    vector<pair<int, int>> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i].first >> v[i].second;
    }
    for(int i = 0; i < n; i++){
        int cnt = 1;
        for(int j = 0; j < n; j++){
            if(v[i].first < v[j].first && v[i].second < v[j].second){
                cnt++;
            }
        }
        cout << cnt << ' ';
        cnt = 1;
    }
}