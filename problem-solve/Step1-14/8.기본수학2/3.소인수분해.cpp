#include <bits/stdc++.h>
using namespace std;
int n;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    cin>>n;
    for(int i=2;i<=n;i++){
    
        while(n%i==0){
            cout<<i<<'\n';
            n=n/i;
        }
    }
    return 0;
}