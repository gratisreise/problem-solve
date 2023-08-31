#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    int a,b;
    a = n/5;
    while(1){
        if(a<0){
            cout<<"-1"<<'\n';
            return 0;
        }
        if((n-(5*a))%3==0){
            b = (n-(5*a))/3;
            break;
        }
        a--;
    }
    cout<<a+b;
    return 0;
}