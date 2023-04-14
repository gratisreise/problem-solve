#include<bits/stdc++.h> 
using namespace std; 
int n, k, a, b, ret;
string s[1004];
// 시계방향 또는 반시계방향으로 한 칸 회전하는 함수
void rot(int pos, int dir){
    //시계방향 회전
    if(!dir) rotate(s[pos].begin(), s[pos].begin()+ 1, s[pos].end()); 
    //반시계 방향 회전
    else rotate(s[pos].begin(), s[pos].begin() + s[pos].size() - 1, s[pos].end());
}    
// 현재 위치에서 왼쪽으로 연결되는 톱니 바퀴의 가장 왼쪽 톱니바취 위치 찾는 함수
int findL(int pos){
    for(int i = pos; i >= 1; i--){
        if(s[i][6] == s[i - 1][2]){
            return i;
        }
    }
    return 0;
}
// 현재 위치에서 오른쪽으로 연결되는 톱니바퀴의 가장 오른쪽 톱니바퀴 위치를 찾는 함수
int findR(int pos){
    for(int i = pos; i <= n - 2; i++){
        if(s[i][2] == s[i + 1][6]){ 
            return i;
        }
    }
    return n - 1;
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s[i];
    }
    cin >> k;
    for(int i = 0; i < k; i++){
        cin >> a >> b; a--; 
        b = (b == -1 ? 0 : 1); // 반시계 방향 회전이면 0, 시계방향 회전이면 1로 설정
        int l = findL(a);
        int r = findR(a);  
        int cnt = 0;
        for(int pos = a; pos >= l; pos--){ // 현재 톱니바퀴를 기준으로 왼쪽에 연결된 톱니바퀴들 회전
            rot(pos, cnt % 2 == 0 ? b : !b);
            cnt++;
        } 
        cnt = 1;
        for(int pos = a + 1; pos <= r; pos++){ // 현재 톱니바퀴를 기준으로 오른쪽에 연결된 톱니바퀴들 회전
            rot(pos, cnt % 2 == 0 ? b : !b);
            cnt++;
        }
    }
    for(int i = 0; i < n; i++)if(s[i][0] == '1') ret++; //12시방향이 1인 토비 카운트
    cout << ret << "\n";
    
    return 0;
}