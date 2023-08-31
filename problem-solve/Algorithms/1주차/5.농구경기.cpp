//내풀이
#include <bits/stdc++.h>
using namespace std;
int n,cnt[26],bod;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>s;
        cnt[s[0]-'a']++;
    }
    for(int i=0;i<26;i++){
        if(cnt[i]>=5) {
            cout<<char(i+'a');
            bod++;
        }

    }
    if(bod==0) cout<<"PREDAJA"<<'\n';

    return 0;
}

//큰돌풀이
#include<bits/stdc++.h>
using namespace std;
int n, cnt[26];
string s, ret;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s;
        cnt[s[0] - 'a']++;
    }
    for(int i = 0; i < 26; i++)if(cnt[i] >= 5) ret+=  i + 'a';
    if(ret.size()) cout << ret << "\n";
    else cout << "PREDAJA" << "\n";
}