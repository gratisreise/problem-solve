#include <bits/stdc++.h>
using namespace std;
    int a[100][100];
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    for(int i=0; i<100;i++){
        for(int j=0;j<100;j++){
            a[i][j]=0;
        }
    }
    int t,m,n,sum=0;
    cin>>t;
    for(int i=0;i<t;i++){
        cin>>m>>n;
        for(int j=m;j<m+10;j++){
            for(int k=n;k<n+10;k++){
                a[j][k]++;
            }
        }
    }
    for(int i=0; i<100;i++){
        for(int j=0;j<100;j++){
            if(a[i][j]>0) sum++;
        }
    }
    
    cout<<sum<<'\n';
}