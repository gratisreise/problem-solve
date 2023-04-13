#include<bits/stdc++.h>
using namespace std;
int n;
double temp;
priority_queue<double> pq;
vector<double> v;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> temp;
        if(pq.size() == 7){ // 칠무해니깐
            pq.push(temp); pq.pop(); // 이거 순서 바꾸면 틀리지?? 
        }else pq.push(temp);
    } 
    while(pq.size()){ // 어차피 크기를 줄여놔서 괜찮
        v.push_back(pq.top()); pq.pop();  
    }
    // reverse(v.begin(), v.end());  // 기본적으로 내림차로 구성되어있어서
    // for(double i : v) printf("%.3lf\n", i);  // lf 더블, .3으로 자릿수 제한
    return 0;
}