#include <bits/stdc++.h>
using namespace std;
int n,v;
int arr[101];
int main(){
    int cnt = 0;
    cin >> n;
    for(int i = 0; i<n; i++) cin>>arr[i];
    cin >> v;
    for ( int i = 0; i<n; i++) if (arr[i] == v)cnt++;

    cout<<cnt<<"\n";
}