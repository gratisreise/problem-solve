#include<bits/stdc++.h>

using namespace std;
vector<int> ret;

vector<int> solution(int start, int end_num) {
    
    for(int i = start; i >= end_num; i--) ret.push_back(i);
    
    
    return ret;
}