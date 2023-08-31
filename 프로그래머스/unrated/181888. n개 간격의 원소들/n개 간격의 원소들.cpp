#include<bits/stdc++.h>
using namespace std;
vector<int> ret;
vector<int> solution(vector<int> num_list, int n) {
    
    for(int i = 0; i < num_list.size(); i++){
        
        if(i % n == 0) ret.push_back(num_list[i]);
    }
    
    return ret;
}