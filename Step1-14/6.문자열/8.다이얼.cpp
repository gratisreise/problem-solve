#include <bits/stdc++.h>
using namespace std;
//1.아스키코드 이용
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    string alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int time[26]={3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
    int sum = 0; 
    string s;
    cin>>s;
    for(char v:s){
        int index = (int)v -65;
        sum += time[index];
    }
    cout<<sum<<'\n';
}
//2.문자열로 선언한 풀이
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    string alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int time[26]={3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
    int sum = 0; 
    string s;
    cin>>s;
    for(char v:s){
        sum+=time[alpha.find(v)];
    }
    cout<<sum<<'\n';
}