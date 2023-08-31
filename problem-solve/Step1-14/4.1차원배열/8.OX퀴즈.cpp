#include <bits/stdc++.h>
using namespace std;
int ox(string &s){
    int sum=0,cum=0;
    for(char &v:s){
        if(v =='O'){
            cum++;
            sum+=cum;
        }
        else{
            cum=0;
        }
    }
    return sum;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n;
    cin>>n;
    string s;
    for(int i=0;i<n;i++){
        cin>>s;
        cout<<ox(s)<<"\n";
    }
}
//1. 스트링 s가 입력받을 함수를 설정
//2. 문자열 s의 누적합을 출력해줄 메인함수설정