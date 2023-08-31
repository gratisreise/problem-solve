#include<bits/stdc++.h>
using namespace std;
int n, l, ret; 
int a[104][104], b[104][104]; //a: 가로방향, b: 세로방향
void solve(int a[104][104]){ // 경사롤 설치여부 확인
    for(int i = 0; i < n; i++){
        int cnt = 1; //현재 위치부터 시작해서 몇 개의 길이 연속된 칸이  경사로 설치 가능한지
        int j; // 현재 탐색중인 열또는 행에서의 위치
        for(j = 0; j < n - 1; j++){ //
            if(a[i][j] == a[i][j + 1]) cnt++; // 인접합 칸 같은경우 
            else if(a[i][j] + 1 == a[i][j + 1] && cnt >= l) cnt = 1;
            // 오르막 cnt 값이 l이상이어야 경사로를 설치 가능하므로 1로 초기화, 각보고 공사치기
            else if(a[i][j] - 1 == a[i][j + 1] && cnt >= 0) cnt = -l + 1;
            // 내리막 cnt 값이 0보다 크거나 같으면 경사로를 설치 가능 -> -l + 1로 초기화, 미리 공사친다음 빼주기
            else break; // 통과 불가능이니깐 어차피 고려해줄 필요가 없다.
        }
        if(j == n - 1 && cnt >= 0) ret++;
    }
    return;
}
int main(){
    scanf("%d %d", &n, &l);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            scanf("%d", &a[i][j]);
            b[j][i] = a[i][j]; // 가로 세로 팀섹 빙행을 y랑 x의 방향을전환시킴
        }
    }
    solve(a); solve(b);
    printf("%d\n", ret);
    return 0;
}
/*
1. 경사로 내려갈 때 미리 내려놓고 ++하는걸로  상쇄하는 전략
2. a와 b로 가로세로 전환전략 -> 코드를 더 써야하는걸 그냥 생략해버림
3. 
*/