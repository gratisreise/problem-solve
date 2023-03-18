#include <bits/stdc++.h>
using namespace std;
int n;
string s,pre,suf,ori_s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    cin >> ori_s;
    int pos = ori_s.find('*');
    pre = ori_s.substr(0,pos);
    suf = ori_s.substr(pos+1);
    for(int i = 0; i < n; i++){
        cin>>s;
        if(pre.size() + suf.size() > s.size()){
            cout << "NE\n";
        }else{
            if(pre == s.substr(0, pre.size()) && suf == s.substr(s.size() - suf.size())) cout << "DA\n";
            else cout << "NE\n";
        }
    }
    return 0;
}
/*
1.substr의 특징 이용 숫만 넣으면 그 포함해서 끝까지
2.반례찾기
3.접두,접미

*/