#include <bits/stdc++.h>
using namespace std;
//1.왜 틀렸습니다 라고 나올까? 발상자체는 틀리지 않는데
int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);
    int a[29]={0,};
    for(int i = 1;i<=28; i++) cin>>a[i];// 배열 입력
    sort(a,a+29);
    for(int i =1; i<=28; i++){
        if((a[i]-a[i-1])==2){
            cout<<a[i-1]+1<<"\n";
        }
        else if((a[i]-a[i-1])==3){
            cout<<a[i-1]+1<<"\n";
            cout<<a[i-1]+2<<"\n";
        }
    }
    return 0;
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

