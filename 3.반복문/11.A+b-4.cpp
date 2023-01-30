#include <bits/stdc++.h>
using namespace std;
int main(){
    int a,b;

    //풀이1[scanf]
    while(scanf("%d %d", &a, &b) != -1){//
        printf("%d\n", a+b);
    }
    
    //풀이2[cin.eof()]
    while(!(cin>>a>>b).eof()){ //c++표준입력방식,eof()시점 판단하고 짜야함
        cout<<a + b<<"\n";
    }

    //풀이3[cin operator bool]
    while(cin>>a>>b){ //cin이 조건식에 있으면 bool 값이 반환되도록 오버로딩 된 방식 활용
        cout<< a+b<<"\n";
    }

    //풀이4[향샹된 입출력 + cin operator bool] -> 추천
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    while(cin>>a>>b){
        cout<< a+b<<"\n";
    }
    
    return 0;
}
/*
1.eof는 입력받은 후 다음의 값을 받을 때 나온다
2.cin자체가 조건문에 들어갈 때는 연산자 오버로딩으로 인해 bool값으로 변한다.
*/