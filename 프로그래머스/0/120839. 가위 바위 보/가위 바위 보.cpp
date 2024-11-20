#include<bits/stdc++.h>

using namespace std;
map<char, char> mp;
string solution(string rsp) {
    mp['2'] = '0';
    mp['0'] = '5';
    mp['5'] = '2';
    string ret = "";
    for(char c : rsp) ret += mp[c];
    return ret;
}