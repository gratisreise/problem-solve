#include <bits/stdc++.h>
using namespace std;
int arr[300000];
int n;
int main(){
    while(1){
        int cnt = 0;
        cin >> n;
        for(int i=0; i<=2*n;i++){
            arr[i] = 0;
        }
        if(n==0) break;
        //에레토스테네스의 체
        for(int i=2;i<=2*n;i++){
            if(arr[i]==0){
                arr[i]=0;
            }
            for(int j= i+i;j<=2*n; j+=i){
                if(arr[j]!=1){
                    arr[j] = 1;
                }
            }
        }
        for(int i = n+1; i<=2*n;i++){
            if(arr[i]==0){
                cnt++;
            }
        }
        cout<<cnt<<'\n';
    }

    return 0;
}