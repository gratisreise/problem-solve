#include<bits/stdc++.h> // 헤더파일들을 한번에 포함
using namespace std; 
const int dy[] = {0, -1, 0, 1}; // 방향 배열 선언
const int dx[] = {1, 0, -1, 0}; // dx, dy 배열을 이용해서 이동할 수 있다.
vector<int> dragon[4][11]; // 드래곤 커브 생성을 위한 3차원 배열
int cnt, n, x, y, d, g, a[101][101]; // cnt: 정사각형 개수, n: 드래곤 커브 개수, x, y: 시작 좌표, d: 시작 방향, g: 세대 수, a: 정사각형 그리드
void go(int x, int y, int d, int g){ // 드래곤 커브 생성 함수
    a[x][y] = 1; // 시작 좌표는 방문 표시
    for(int i = 0; i <= g; i++){ // 0세대부터 g세대까지
        for(int dir : dragon[d][i]){ // i세대에서의 방향
            x += dx[dir]; // x좌표 이동
            y += dy[dir]; // y좌표 이동
            a[x][y] = 1; // 방문 표시
        }
    }
    return; // 커브 생성 완료
}
void makeDragon(){ // 드래곤 커브 생성 함수
    for(int i = 0; i < 4; i++){ // 4개의 방향에 대해서
        dragon[i][0].push_back(i); // 0세대는 i방향 하나만 가지므로 삽입
        dragon[i][1].push_back((i + 1) % 4); // 1세대는 i방향 다음 방향으로 삽입
        for(int j = 2; j <= 10; j++){ // 2세대부터 10세대까지
            int n = dragon[i][j - 1].size(); // 이전 세대 크기 구하기
            for(int k = n - 1; k >= 0; k--){ // 이전 세대 역순으로 탐색
                dragon[i][j].push_back((dragon[i][j - 1][k] + 1) % 4); // 다음 방향 삽입
            }
            for(int k = 0; k < n; k++){ // 이전 세대 정방향으로 탐색
                dragon[i][j].push_back(dragon[i][j - 1][k]); // 이전 방향 삽입
            }
        }
    }
    return; // 드래곤 커브 생성 완료
}
int main(){
    cin >> n;
    makeDragon();
    for(int i = 0; i < n; i++){
        cin >> x >> y >> d >> g;
        go(x, y, d, g);
    }
    for(int i = 0; i <= 100; i++){
        for(int j = 0; j <= 100; j++){
            if(a[i][j] && a[i + 1][j] && a[i + 1][j + 1] && a[i][j + 1])cnt++;
        }
    }
    cout << cnt << "\n";
    return 0;
}
/*
1. makeDragon() 함수를 호출하여 4개 방향에 대해 0세대부투 10세대 까지의 드래곤 커브를
미리 계산해둡니다. 이를 위해 dragon 배열을 3차원 배열로 선언하고, 각 방향과 세대에 따라
드래곤 커브를 계산하여 저장합니다.
2. 입력으로 들어온 드래곤 커브를 go()함수를 호출하여그린다. 시작점, 시작 방향, 세대를 입력받아
각 세대별로 드래곤 커브를 그려주는 역할을 합니다. 드래곤 커브는 시계방향으로 90도 회전하면서 
이전 세대의 끝점을 이어붙인 것이므로, 이를 dragon 배열에서 불러와서 방향을 바꾸고,
 각 방향에 따라 x, y 좌표를 이동시키면서 a 배열에 1을 표시하여 드래곤 커브를 그립니다.
3.드래곤 커브를 모두 그린 후, 'a'배열을 순회하면서 격자판의 네 꼭짓점이 모두 드래곤 커브
위에 있는 경우를 찾아서 'cnt' 변수를 증가시킨다.
4. 최종적으로 cnt 변수의 값 출력


*/