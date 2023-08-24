#include <bits/stdc++.h>
using namespace std;
int a,b,v;
int cnt = 0;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    cin>>a>>b>>v;
    int day =1;       //a를 빼줬기 때문에 기본적으로 하루를 일단 더해야함
    day += (v-a)/(a-b);
    if((v-a)%(a-b)!=0) day++; //0이 아닌 경우 하루가 더 걸리므로 추가
    if(a>=v) cout<<"1"<<'\n'; //a가 v보다 크면 어차피 하루걸림
    else cout<<day<<'\n';     //  나머지는 그냥 하루가 더 추가된 day를 추가
    return 0;
}
