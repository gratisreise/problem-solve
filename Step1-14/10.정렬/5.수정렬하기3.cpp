#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    int t;
    cin>>t;
    int arr[10001]={0,};

    for(int i=0;i<t;i++){
        int a;
        cin>>a;
        arr[a]++;
    }
    for(int i=1;i<=10000;i++){
        for(int j=0;j<arr[i];j++)
            cout<<i<<'\n';
    }

    return 0;
}