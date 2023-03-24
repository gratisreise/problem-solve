#include<bits/stdc++.h>
using namespace std;
#define sz(x) ((int)(x).size())
#define f first
#define s second
typedef unsigned long long ll;
int t, n;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> n;
        int ret2 = 0, ret5 = 0;
        for(int j = 2; i <= n; j *= 2){
            ret2 += (n / j); 
        }
        for(int j = 5; i <= n; j *= 5){
            ret5 += (n / j);
        }
        cout << min(ret2, ret5) << '\n';
    }
    return 0;
}
/*
숫자를 작은 케이스에서 나열하면서 규칙성 찾기 훈련필요!!
*/