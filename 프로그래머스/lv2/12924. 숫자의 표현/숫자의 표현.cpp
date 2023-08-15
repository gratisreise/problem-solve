#include<bits/stdc++.h>
using namespace std;

int ret = 0;
int solution(int n) {
    for(int i = 1; i <= n; i++){
        int sum = 0;
        for(int j = i; j <= n; j++){
            sum += j;
            if(sum == n){ret++; break;}
            else if(sum > n) break;
        }
    }
    return ret;
}