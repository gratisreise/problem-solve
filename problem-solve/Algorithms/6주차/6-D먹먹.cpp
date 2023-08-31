#include<bits/stdc++.h>
using namespace std;
int t, n, m;
int main(){
    cin >> t;
    while(t--){
        int ret = 0;
        cin >> n >> m;
        vector<int> a(n), b(m); 
        for(int i = 0; i < n; i++) cin >> a[i];
        for(int i = 0; i < m; i++) cin >> b[i];
        sort(b.begin(), b.end());
        sort(a.begin(), a.end());
        for(int i = 0; i < n; i++){ // a를 다르게 하면서
            int pos = lower_bound(b.begin(), b.end(), a[i]) - b.begin();
            ret += pos;
        }
        cout << ret << '\n';
    }
}