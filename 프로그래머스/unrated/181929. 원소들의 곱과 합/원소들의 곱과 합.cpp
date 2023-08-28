#include<bits/stdc++.h>


using namespace std;
int sum = 0;
int multi = 1;
int ret;
int solution(vector<int> num_list) {
    for(int i : num_list) sum += i;
    sum = sum * sum;
    for(int i : num_list) multi *= i;
    if(multi < sum) ret = 1;
    else ret = 0;
    return ret;
}