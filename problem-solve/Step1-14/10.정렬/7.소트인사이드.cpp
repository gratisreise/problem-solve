#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    string n;
    int x;
    int a[10]={0,};
    cin>>n;
    for(int i=0;i<n.size();i++){
        a[i]=n[i]-'0';
    }
    sort(a,a+n.size(),greater<int>());
    for(int i=0;i<n.size();i++){
        cout<<a[i];
    }

    return 0;
}