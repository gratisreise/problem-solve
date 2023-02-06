#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    vector<string> cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    string s;
    cin>>s;
    for(int i=0; i<cro.size();i++){
        while(1){
            int idx = s.find(cro[i]);
            if(idx==string::npos) break;
            s.replace(idx,cro[i].length(),"#");
        }
    }
    cout<<s.length()<<"\n";
}