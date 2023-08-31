#include <bits/stdc++.h>
using namespace std;
vector<pair<int,int>> v;
int main(){
    int n;
    cin>>n;
    int x,y;
    for(int i=0;i<n;i++){
        cin>>x>>y;
        v.push_back({y,x});
    }
    sort(v.begin(),v.end());
    for(auto it:v) cout<<it.second<<' '<<it.first<<'\n';

    return 0;
}
//1.위치만 바꿔줘서 출력하면 굳~~