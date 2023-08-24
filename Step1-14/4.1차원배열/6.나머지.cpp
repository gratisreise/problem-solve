#include <bits/stdc++.h>
using namespace std;
//1.순회하면서 빼준걸 이용해서 
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n;
    int a[42]={0,};
    int c =0;
    for(int i=0;i<10;i++){
        cin>>n;
        for(int j=0;j<42;j++){
            if(j-(n%42)==0){
                a[j]++;
            }
        }
    }
    for(int b:a){
        if(b!=0)
            c++;
    }
    cout<<c<<"\n";
}
//2. 배열 대괄호 안에 조건을 넣고 계산하는 것
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n;
    int a[42]={0,};
    for(int i=0;i<10;i++){
        cin>>n;
        a[n%42]++;
    }
    int cnt = 0;
    for(int b:a){
        if(b>0){
            cnt++;
        }
    }
    cout<<cnt<<"\n";
    return 0;
}