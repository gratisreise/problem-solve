#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);
    int n;
    cin>>n;
    for(int i =1; i<=n; i++){
        for(int k = n-i;k>=1;k--){ //변하는 수에 따라서 변하게 만들어 줘야 했음
            cout<<" ";
        }
        for(int j = 1; j<=i; j++){
            cout<<"*";
        }

        cout<<"\n";
    }
}