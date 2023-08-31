#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int a,m,n,max=0;
    for(int i=1;i<=9;i++){
        for(int j=1;j<=9;j++){
            cin>>a;
            if(a>max){
                max=a;
                m=i;
                n=j;
            }
        }
    }
    cout<<max<<'\n';
    cout<<m<<' '<<n<<'\n';

    return 0;
}