#include <bits/stdc++.h>
using namespace std;
int n, ret=987654321;  // n: 격자판의 크기, ret: 최소 비용을 저장할 변수, v: 꽃을 심은 위치를 표시할 변수, 
int v[20][20], p[20][20]; // p: 격자판의 각 위치에 대한 비용을 저장할 변수, dy, dx: 상하좌우 이동을 위한 변수
int dy[4] = {-1,1,0,0}; 
int dx[4] = {0,0,-1,1};

bool check(int y, int x) { // 꽃을 심을 수 있는 지 확인하는 함수
    if (v[y][x]) return 0; // 이미 꽃이 심어져 있는 경우 false 반환
    for (int i = 0; i < 4; i++) { // 현재 위치에서 상하좌우로 이동
        int ny = y + dy[i];
        int nx = x + dx[i];
        // if (ny < 0 || ny >= n || nx < 0 || nx >= n || v[ny][nx]) { // 격자판의 범위를 벗어나거나 이미 꽃이 심어져 있는 경우 
            return 0; // 꽃을 심을 수 없는 경우 false 반환
        } 
    return 1; // 꽃을 심을 수 있는 경우 true 반환
}

int setFlower(int y, int x){  // 꽃을 심으면서 체크
    v[y][x] = 1; // 꽃임과 꽃술 충돌방지
    int s = p[y][x]; // 현재 위치의 비용으로 초기화
    for (int i = 0; i < 4; i++) { // 현재 위치에서 상하좌우로 이동
        int ny = y + dy[i];
        int nx = x + dx[i];
        // v[ny][nx] = 1; //
        s += p[ny][nx]; // 이동한 위치의 비용을 더함
    }
    return s; // 총 비용 반환
}

void eraseFlower(int y, int x) { //꽃을 지우는 함수
    v[y][x] = 0; // 곷을 심은 위치를 표시를 지움
    for (int i = 0; i < 4; i++) { // 현재 위치에서 상하좌우로 이동
        int ny = y + dy[i];
        int nx = x + dx[i];
        v[ny][nx] = 0; // 꽃을 심은 위치표시를 지움
    }
}

void flower(int cnt, int hap){ // cnt는 심어진 꽃수, 
    if (cnt == 3) { // 3개 심어지면 기저사례
        ret = min(ret, hap); 
        return;
    }
    for (int i = 0; i < n; i++) { 
        for (int j = 0; j < n; j++) { 
            if (check(i, j)) {   
                // 꽃심어지면서 각 지점 합 소환
                flower(cnt + 1, hap + setFlower(i, j));
                eraseFlower(i, j); // 원복
            }
        }
    }
    return; 
}

int main(){
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> p[i][j];
        }
    }
    flower(0, 0);
    cout << ret << '\n';
}

입력으로 꽃을 심을 수 있는 땅의 크기 n과 각 땅의 가치가 주어집니다.

setFlower 함수는 (y, x) 위치에 꽃을 심고, 꽃을 중심으로 상하좌우 
4개의 위치를 꽃으로 채우며 해당 위치들의 가치의 합을 반환합니다.

check 함수는 (y, x) 위치에 꽃을 심을 수 있는지 확인하며, 이미 꽃이 심어져
 있거나 경계를 벗어나면 꽃을 심을 수 없습니다.

eraseFlower 함수는 (y, x) 위치의 꽃을 제거하며, 꽃으로 채워진 위치들도 모두
 꽃을 제거합니다.

flower 함수는 현재 꽃을 심은 횟수 cnt와 현재까지 꽃들의 가치 
합 hap을 인자로 받습니다. cnt가 3이 되면 꽃을 세 개 모두 심은 것이므로 
ret 값과 비교하여 더 작은 값을 ret에 저장합니다. 
그렇지 않은 경우 check 함수를 통해 꽃을 심을 수 있는 위치를 찾아 
setFlower 함수로 꽃을 심고, 재귀적으로 다음 꽃을 심으러 이동합니다.
마지막으로 main 함수에서는 입력을 받은 뒤 flower 함수를 호출하고, ret 값을 출력합니다.

이 코드는 완전 탐색 알고리즘을 사용하여 모든 가능한 꽃을 심어 가장 작은 가치의 합을 구합니다.
 하지만 n의 최대값이 10이므로, 가능한 경우의 수는 15,000 이하로 비교적 적습니다.
  따라서 이 알고리즘은 충분히 효율적으로 동작합니다.



