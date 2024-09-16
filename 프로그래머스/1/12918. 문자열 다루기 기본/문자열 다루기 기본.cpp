#include<bits/stdc++.h>

using namespace std;

bool solution(string s) {
    bool ret = 1;
    if(s.size() != 4 && s.size() != 6) ret = 0;
    for(char c : s) if(!('0' <= c && c <= '9')) ret = 0;
    return ret;
}