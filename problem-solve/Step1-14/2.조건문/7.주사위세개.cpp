#include <bits/stdc++.h>
using namespace std;
int main(){
    int a,b,c; 
    int m; //각 조건에서 나온 최댓값을 변수로 선언하여 출력하는 타자를 줄여줌
    cin>>a>>b>>c;
    if(a!=b && b!=c && c!=a){ //3개 다른 눈
        if(a>b){ 
            if(a>c) {m=a;} //a가 최대
            else    {m=c;} //c가 최대
        }
        else{
            if(b>c) {m=b;} //b최대
            else    {m=c;} //c 최댖
        }
    cout<<m*100<<"\n";
    }
    else if(a==b && b==c && c==a){ //c==a조건 굳이 안써줘도 됨
        cout<<10000+1000*a<<"\n";
    }
    else{
        if(a==b||a==c) {cout<<1000+100*a<<"\n";} //실수한 부분->a랑c랑 같은경우를 생각안함
        else     {cout<<1000+100*b<<"\n";}
    }
}

/*

1. 서로다른 3개의 눈 조건 선언하고 그 조건에서 크기비교하여 최댓값 구함
2. 다 같을 때 조건 선언하고 그때의 값 출려
3. 2개 같을 때 조건 선언하고 경우 나눈 후 계산 값 출력!

*/