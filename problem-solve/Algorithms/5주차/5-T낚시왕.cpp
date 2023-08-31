#include <bits/stdc++.h>
using namespace std;
struct Shark {
    int y, x, s, dir, z, death;
}a[100*100];
const int dx[] = {0, 0, 1, -1 };
const int dy[] = {-1, 1, 0, 0 };
int R, C, M, ret;
int temp[100][100], shark[100][100];
int main() {
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> R >> C >> M;
    for (int i = 1; i <= M; i++) {
        cin >> a[i].y >> a[i].x >> a[i].s >> a[i].dir >> a[i].z;
        a[i].y--; a[i].x--; a[i].dir--; // 모듈러 연산때문에 좌표0으로 바꿔줌
		
		if(a[i].dir <= 1) a[i].s %= (2 * (R - 1));
		else a[i].s %= (2 * (C - 1));

        shark[a[i].y][a[i].x] = i;
    }
    for (int t = 0; t < C; t++) {
        for (int y = 0; y < R; y++) { //사람이 움직이면서 돈다
            if (shark[y][t]) {
                a[shark[y][t]].death = 1;
                ret += a[shark[y][t]].z;
                shark[y][t] = 0;
                break;
            }
        }
        memset(temp, 0, sizeof(temp)); //temp배열 0으로 둔다
        for (int i = 1; i <= M; i++) {
            if (a[i].death) continue; 

			int y = a[i].y;
            int x = a[i].x;
            int s = a[i].s;
            int d = a[i].dir; 
			int ny, nx; 

			while (1) {  // 최대2번만 작동하게됨
				ny = y + s * dy[d];
				nx = x + s * dx[d]; 
                if (nx < C && ny < R && ny >= 0 && nx >= 0)break;
				if(d <= 1){
					if(ny < 0){
						s -= y;
						y = 0;
					}else{
						s -= R - 1 - y;
						y = R - 1;
					} 
				}else{ 
					if(nx < 0){
						s -= x;
						x = 0;
					}else{
						s -= C - 1 - x;
						x = C - 1;
					}
				}
				d ^= 1;  
            }
            
			if (temp[ny][nx]) { //상어 크기비교
                if (a[temp[ny][nx]].z < a[i].z) { 
					a[temp[ny][nx]].death = 1; 
					temp[ny][nx] = i; 
				}else a[i].death = 1;
            }else temp[ny][nx] = i;
            
			a[i].y = ny; 
			a[i].x = nx; 
			a[i].dir = d;
        }
		memcpy(shark, temp, sizeof(temp)); 
    }
    cout << ret << "\n";
    return 0;
}
/*
해당 열에서 가장 가까운 상어를 잡습니다. 
(격자판을 위에서부터 순서대로 탐색하여 가장 먼저 찾은 상어를 잡습니다.)
상어들을 이동시킵니다. 상어가 이동하는 방향은 초기 입력값으로 주어진 방향과 속력을
 이용하여 계산합니다. 이때 벽에 부딪히면 방향을 바꿔주는 처리를 해줍니다.
상어들이 이동한 결과 격자판 위에 새로운 상어 배치를 업데이트합니다.

Shark 구조체: 상어의 정보를 저장하는 구조체입니다. 구조체 멤버 변수로는 상어의 위치(y, x), 속력(s), 이동 방향(dir), 크기(z), 상어의 생사 여부(death)가 있습니다.
a: Shark 구조체 배열입니다. 인덱스 i에 해당하는 a[i]는 i번째 상어의 정보를 담고 있습니다.
R, C, M: 각각 격자판의 행, 열 크기와 상어의 수를 나타냅니다.
temp: 상어들이 이동할 때 이동 결과를 저장하는 배열입니다.
shark: 현재 위치에 상어가 있는지를 나타내는 배열입니다. shark[y][x]가 0이 아니면 해당 위치에 상어가 있음을 의미합니다.
dx, dy: 이동 방향을 나타내는 배열입니다. dx[0], dy[0]은 왼쪽으로 이동할 때의 좌표 변화량, dx[1], dy[1]은 오른쪽으로 이동할 때의 좌표 변화량, dx[2], dy[2]는 아래쪽으로 이동할 때의 좌표 변화량, dx[3], dy[3]는 위쪽으로 이동할 때의 좌표 변화량입니다.
ret: 최종 결과값으로, 살아남은 상어들의 크기를 모두 더한 값입니다.
t: 시간 변수로, 각 턴을 의미합니다.
y, x, s, d, ny, nx: 상어의 위치(y, x), 속력(s), 이동 방향(d), 이동 결과 위치(ny, nx)를 저장하는 변수입니다. 이동 결과 위치를 저장하는 이유는 이동 중에 상어들이 겹치게 되면 이동 방향을 재조정해야 하기 때문입니다.
i: 상어를 나타내는 인덱스입니다.
memcpy: 메모리 복사 함수로, temp 배열의 값을 shark 배열에 복사합니다. 이렇게 함으로써 상어들이 이동한 결과를 다음 턴에서도 유지할 수 있습니다.



*/