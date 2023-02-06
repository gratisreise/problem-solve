#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n,a[101];
    int sum=0;
    string s;
    cin>>n>>s;
    for(int i=0;i<n;i++){
        a[i]=s[i]-'0';
        sum+=a[i];
    }
    cout<<sum<<'\n';
}
/*
1.문자열로 받고 그 문자열의 캐릭터를 다른 배열에 인트형으로 넣어준다.
*/