#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=0;
    for(int sum=2;sum<=n;i++){
        sum +=6*i; //규칙성을 통한 등비수열의 합
    }
    if(n==1) i=1;
    cout<<i<<'\n';

    return 0;
}
/*
등비수열의 합을 이용하여 구한다.
*/