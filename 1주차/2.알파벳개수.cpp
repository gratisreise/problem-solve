#include <bits/stdc++.h>
using namespace std;
int main(){
    string s;
    cin>>s;
    int a[26]={0,};
    for(int i = 0;i<s.size();i++){
        a[int(s[i])-97]++;
    }
    for(int i = 0;i<26;i++){
        cout<<a[i]<<" ";
    }
}
#include <bits/stdc++.h>
using namespace std;
int cnt[26];
string str;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin>>str;
    for(char a:str) cnt[a-'a']++;
    for(int i : cnt) cout<<i<<' ';
    cout<< '\n';
    return 0;
}