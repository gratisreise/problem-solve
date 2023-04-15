#include<bits/stdc++.h>
using namespace std;
int ret, n;
struct Board{
    int a[24][24];
    // 시계방향 회전
    void _rotate90(){
        int temp[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = a[n - j - 1][i];
            }
        }
        memcpy(a, temp, sizeof(a));
    }
    //숫자들을 밀어주는 함수
    void _move(){
        int temp[24][24]; // 임시 배열 temp 선언
        for(int i = 0; i < n; i++){ // 각 행에 대해 반복
            int c = -1, d = 0; // 배열 temp에서 사용할 인덱스 c와 값이 합쳐졌는지를 나타낼 변수 d 초기화
            for(int j = 0; j < n; j++){ // 각 열에 대해 반복
                if(a[i][j] == 0) continue; // 현재 위치에 0이 저장되어있는 경우, 다음 위치로 이동
                if(d && a[i][j] == temp[i][c]) // 이전 칸에서 값이 합쳐진 경우, 현재 칸의 값이 temp[i][c]와 같으면
                    temp[i][c] *= 2, d = 0; // temp[i][c]에 저장된 값이 두 배가 되고, d를 0으로 설정하여 다음 칸에서 합치지 않도록 함
                else // 이전 칸에서 값이 합쳐지지 않은 경우, 현재 칸의 값을 temp 배열의 다음 칸에 저장
                    temp[i][++c] = a[i][j], d = 1;
            }
            for(c++; c < n; c++) temp[i][c] = 0; // 배열 temp에서 현재 행의 값을 모두 저장한 후, 남은 칸은 0으로 초기화
        }
            memcpy(a, temp, sizeof(a)); // 임시 배열 temp의 값을 원래 배열 a에 복사
    }


    void get_max(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret = max(ret, a[i][j]);
            }
        }
    }
};

void go(Board c, int here){
    if(here == 5){ // 움직일 수 있는 횟수 다 사용했으 때
        c.get_max(); // 최댓값 구하고 리턴
        return;
    }
    for(int i = 0; i < 4; i++){ // 4방향에 대해
        Board d = c; //현재 보드를 복사
        d._move(); // 복사된 보드 움직임 -> 
        go(d, here + 1); // 재귀 -> 움직였으니깐 다시불러서 쓰는거지 뭐
        c._rotate90(); // 회전
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    Board c; // 보드 상태 입력
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> c.a[i][j];
        }
    }
    go(c, 0);
    cout << ret << '\n';
}