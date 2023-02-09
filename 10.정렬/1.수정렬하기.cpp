#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main(){
    int n,a;
    cin>>n;
    for(int i =0; i<n;i++){
        cin>>a;
        v.push_back(a);
    }
    sort(v.begin(),v.end());
    for(int i:v) cout<<i<<'\n';

    return 0;
}