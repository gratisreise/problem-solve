#include<bits/stdc++.h>

using namespace std;

vector<string> split(const string& input, string delimiter){
    vector<string> ret;
    auto start = 0;
    auto end = input.find(delimiter);
    while(end != string::npos){
        ret.push_back(input.substr(start, end - start));
        start = end + delimiter.size();
        end = input.find(delimiter, start);
    }
    ret.push_back(input.substr(start));
    return ret;
}

vector<string> solution(string my_string) {
    return split(my_string, " ");
}