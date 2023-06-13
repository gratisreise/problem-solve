#include <bits/stdc++.h>
using namespace std; 
vector<int> ret[14]; //레벨에 해당하는 벡터
int n, a[1030];
void go(int s, int e, int level){ 
    if(s > e) return;  //구간 쪼개서 하는 코드에서 필수적인 코드
    if(s == e){ // 시작과 끝이 같아지는 지점
        ret[level].push_back(a[s]);  //각레벨에다 푸쉬해줌
        return;
    }
    int mid = (s + e) / 2; // 
    ret[level].push_back(a[mid]); //
    go(s, mid - 1, level + 1); 
    go(mid + 1, e, level + 1); 
    return;
}
int main(){
    cin >> n;
    // 입력을 받음
    int _end = (int)pow(2, n) - 1; 
    for(int i = 0; i < _end; i++){
        cin >> a[i];
    }
    go(0, _end, 1);
    for(int i = 1; i <= n; i++){
        for(int j : ret[i]){
            cout << j << " ";
        }
        cout << "\n";
    }
    return 0;
}