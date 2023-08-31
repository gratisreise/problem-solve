#include <bits/stdc++.h>
using namespace std;
vector<string> v;
bool cmpWith(string a, string b){
    if(a.length()==b.length()) return a<b;
    return a.length()<b.length();
}
int main(){
    int n;
    vector<string> v;
    cin>>n;
    string s;
    for(int i=0;i<n;i++){
        cin>>s;
        if(find(v.begin(),v.end(),s)==v.end())
            v.push_back(s);
    }
    sort(v.begin(),v.end(),cmpWith);
    
    for(int i=0; i<v.size();i++) cout<<v[i]<<'\n';
}