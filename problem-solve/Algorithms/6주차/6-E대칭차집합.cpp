#include<bits/stdc++.h>
using namespace std;
int n, m, temp, cnt;
map<int, int> mp;
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> temp, mp[temp]++;
    for(int i = 0; i < m; i++) cin >> temp, mp[temp]++;
    for(auto it : mp) if(it.second == 1) cnt++;
    cout << cnt << '\n';
}
/*
맵에다가 넣으면서 카운트
배열은 원소수가 너무 커서 인덱스 자체를 숫자로 활용 못함
*/