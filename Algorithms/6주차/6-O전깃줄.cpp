#include <bits/stdc++.h>
using namespace std;
int n, a, b, len, lis[504];
vector<pair<int, int>> v;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	cin >> n;
	for(int i = 0; i < n; i++){
        cin >> a >> b;
        v.push_back({a, b});
	}
	sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++){
        auto it = lower_bound(lis, lis + len, v[i].second);
        if(*it == 0) len++;
        *it = v[i].second;
    }
    cout << n - len << "\n";
    return 0;
}
