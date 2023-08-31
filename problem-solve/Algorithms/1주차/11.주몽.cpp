#include <bits/stdc++.h>
using namespace std;
int n, m, a[15001], cnt;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    if(m > 200000) cout << 0 <<'\n';
    else{
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(a[i] + a[j] == m) cnt++; 
            }
        }
        cout << cnt <<'\n';
    }
    
    return 0;
}   
/*
1. 조합 쓰기 전에 오름차순 정렬 하고 쓰면 좋다
2. 
*/