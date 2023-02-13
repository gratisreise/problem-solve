#include <bits/stdc++.h>
using namespace std;
int fact(int n){
    if(n==1 || n==0)return 1;
    return n*fact(n-1);
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin>>n;
    cout<<fact(n)<<'\n';

    return 0;
}