#include <bits/stdc++.h>
using namespace std;
//1.
int main(){
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    int a[28];
    for(int i = 0;i<28;i++) cin>>a[i];// 배열 입력
    sort(a,a+27);
    for(int i =0; i<28; i++){
        if((a[i+1]-a[i])==2){
            cout<<a[i]+1<<"\n";
        }
        else if((a[i+1]-a[i])==3){
            cout<<a[i]+1<<"\n";
            cout<<a[i]+2<<"\n";
        }
    }
}
//2.bool을 이용한 참거짓 판단으로 결정
int main() {
 
    int a;
 
    bool check[31]={0,};        
 
    for(int i=1; i<=28; i++){   
        cin>>a;
        check[a]=1;             
    }                               
 
    for(int j=1; j<=30; j++){
        if(check[j]==0){
            cout<<j<<"\n";
        }
    }
}

