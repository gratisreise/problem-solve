#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> v;
int main(){
    int n;
    cin>>n;
    int x,y;
    for(int i=0;i<n;i++){
        cin>>x>>y;
        v.push_back({x,y});
    }
    sort(v.begin(),v.end());
    for(int i=0;i<n;i++) cout<<v[i].first<<" "<<v[i].second<<'\n';
    
    return 0;
}
//vector와 pair을 이용한 정렬하기