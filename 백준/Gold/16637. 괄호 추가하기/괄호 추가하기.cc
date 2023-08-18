#include<bits/stdc++.h>
using namespace std;
int n, ret = -1e9;
string s;
vector<int> num;
vector<char> oper_str;
int oper(char a, int b, int c){
    int ret = 0;
    if(a == '+') ret =  b + c;
    if(a == '*') ret =  b * c;
    if(a == '-') ret =  b - c;
    return ret;
}
void go(int here, int _num){
    if(here == num.size() - 1){
        ret = max(ret, _num);
        return;
    }
    go(here + 1, oper(oper_str[here], _num, num[here + 1]));
    if(here + 2 <= num.size() - 1){
        int temp = oper(oper_str[here + 1], num[here + 1], num[here + 2]);
        go(here + 2, oper(oper_str[here], _num, temp));
    }
    return;
}
int main(){
    cin >> n >> s;
    for(int i = 0; i < s.size();i++){
        if(i % 2 == 0) num.push_back(s[i] - '0');
        else oper_str.push_back(s[i]);
    }
    go(0, num[0]);
    cout << ret << "\n";
}