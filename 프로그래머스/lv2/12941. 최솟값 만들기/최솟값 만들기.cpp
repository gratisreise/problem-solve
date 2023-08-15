#include <bits/stdc++.h>
using namespace std;
int ret;
int solution(vector<int> A, vector<int> B)
{
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), greater<int>());
    
    for(int i = 0; i < A.size(); i++){
        ret += A[i] * B[i];
    }
    
    return ret;
}