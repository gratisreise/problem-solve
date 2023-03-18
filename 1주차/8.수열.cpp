//시간초과
#include <bits/stdc++.h>
using namespace std;
int n,k,sum1;
int num[100001];
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> k;
    for(int i = 0; i<n;i++){
        cin>>num[i];
    }
    int max=-99999;
    for(int i = 0; i < n-k; i++){
        for(int j = i; j < i + k; j++){
            sum1 += num[j];
        }
        if(sum1 > max) max = sum1; 
        sum1 = 0;     
    }
    cout << max << '\n';

    return 0;
}

//큰돌
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, k, temp, psum[100001], ret = -1000000;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> k;
    for(int i = 1; i <= n; i++){
        cin >> temp; psum[i] = psum[i - 1]+temp;
    }
    for(int i = k;i <= n; i++){
        ret = max(ret, psum[i] - psum[i - k]);
    }
    cout << ret <<'\n';
    return 0;
}

/*
1. 구간합,누적합 개념이용
2. 
*/
