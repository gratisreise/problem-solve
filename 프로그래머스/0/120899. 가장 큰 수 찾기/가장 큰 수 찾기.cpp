#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array) {
    vector<int> ret;
    ret.push_back(-1);
    ret.push_back(-1);
    for(int i = 0; i < array.size(); i++){
        if(array[i] > ret[0]){
            ret[0] = array[i];
            ret[1] = i;
        }
    }
    return ret;
}
/*


*/