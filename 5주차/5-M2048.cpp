#include<bits/stdc++.h>
using namespace std;
int ret, n;
// 이동 및 회전에 대한 연산
struct Board{
    int a[24][24];
    //회전 연산
    void _rotate90(){
        int temp[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = a[n - j - 1][i]; //j,i 생각하고  n-1추가
            }
        }
        memcpy(a, temp, sizeof(a));
    }
    // 왼쪽부터 0이 아닌 수를 찾으면서 이전 수와 같은지 확인하여 같으면 2배 아니면 넘어가기
    void _move(){
		int temp[24][24];
		for(int i = 0; i < n; i++){
			int c = -1, d = 0;
			for(int j = 0; j < n; j++){
				if(a[i][j] == 0) continue;
				if(d && a[i][j] == temp[i][c]) temp[i][c] *= 2, d = 0;
				else temp[i][++c] = a[i][j], d = 1;
			}
			for(c++; c < n; c++) temp[i][c] = 0; // 기억해주셈
		}
		memcpy(a, temp, sizeof(a));
	}
    // 최대치를 구함
    void get_max(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret = max(ret, a[i][j]);
            }
        }
    }
};
// 재귀적으로 이동하면서 5번의 이동 후에 가장 큰 값 구함
void go(Board c, int here){ // 무브하고 로테이트
    if(here == 5){
        c.get_max();
        return;
    }
    for(int i = 0; i < 4; i++){
        Board d = c;
        d._move();
        go(d, here + 1);
        c._rotate90();
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    Board c;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> c.a[i][j];
        }
    }
    go(c, 0);
    cout << ret << "\n";
    return 0;
}
/*

*/