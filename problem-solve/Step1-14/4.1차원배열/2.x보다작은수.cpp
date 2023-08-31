#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n,x;
    int a[10001];
    cin>>n>>x;
    for(int i=0;i<n;i++){
        cin>>a[i];
        if(a[i]<x){
            cout<<a[i]<<"\n";
        }
    }
}