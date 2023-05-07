//시간초과
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n,m;
string s;
vector<string> v;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin>>n>>m;
    for(int i=0;i<n;i++){
        cin>>s;
        v.push_back(s);
    }
    for(int i = 0;i<m;i++){
        cin>>s;
        if(atoi(s.c_str())==0){
            for(int i=0;i<v.size();i++){
                if(s==v[i]) cout<<i+1<<'\n';
            }
        }else{
            cout<<v[atoi(s.c_str())-1];
        }
        
    }

    return 0;
}
// 큰돌풀이
#include <bits/stdc++.h>
using namespace std;
int n,m;
string s;
map<string,int> mp;
map<int,string> mp2;
string a[100004];
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> s;
        mp[s] = i + 1;
        mp2[i + 1] = s;
        a[i + 1] = s;
    }
    for(int i = 0; i < m; i++){
        cin >> s;
        if(atoi(s.c_str()) == 0){
            cout << mp[s] <<'\n';
        }else{
            cout << a[atoi(s.c_str())] << '\n';
            //cout << mp2[atoi(s.c_str())] << '\n';
        }
    }

    return 0;
}

/*
1.map의 사용방법 
2.map의 활용
3. 두개의 자료구조를 사용하여 빡센 시간제한을 뚫는다.
*/