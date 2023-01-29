#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);cin.tie(NULL);

    double a[1001];//배열에 들어오는 수의 타입이 실수
    double b,c; // 최종계산에서 입력받는 것이 실수 형태여야함
    int n;
    int M = -1;
    cin>>n;
    for(int i =0; i<n;i++){
        cin>>c; //입력       
        if(c>M){
            M=c;
        }
        b+=c;
    }
    
    
    cout<<(b/(M*n))*100<<"\n";

    return 0;
}
