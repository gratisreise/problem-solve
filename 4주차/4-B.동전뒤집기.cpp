#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, ret = INF, a[44];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
string s;
// 동전순회하면서 앞뒤 뒤집는 작업, 재귀호출하여 동전들이 뒤집히는 모든 경우 체크
void go(int here){ 
    if(here == n + 1){// 모든 행을 확인하는 경우
        int sum = 0;
        for(int i  = 0; i <= (1 << (n - 1)); i *= 2){ // 가능한 모든 열의 경우를 확인
            int cnt = 0;
            for(int  j = 1; j <= n; j++) if(a[j] & i) cnt++; // i번째 경우에서 앞면인 동전의 개수를 세서 cnt에 저장
            sum += min(cnt, n - cnt); // 이번 경우에서 뒷면인 동전의 개수가 더 적은 경우를 선택하여 더함
        }
        ret = min(ret, sum); // 가능한 모든 경우에서 뒷면인 동전의 개수를 최소화한 값을 ret에 저장
        return;
    }
    
    go(here + 1); 
    a[here] = ~a[here]; 
    go(here + 1); 
}

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 1; i <= n; i++){ //문자열을 비트마스크로 변환
        cin >> s; // 한 줄의 문자열을 입력 받습니다. 예를 들어, "THHHTT"와 같은 형태로 입력됩니다.
        int value = 1; // 각 동전의 앞면(T)에 해당하는 비트값을 의미합니다.
        for(int j = 0; j < s.size(); j++){// 2차 -> 1차로 줄임
            if(s[j] == 'T') a[i] |= value; // 문자열에서 'T'가 나오면, 해당 비트를 1로 설정합니다.
            value *= 2; // 다음 동전의 비트값을 계산하기 위해 2배씩 증가시킵니다.
        }
    }
    go(1); //왜 1??
    cout << ret << '\n';
}
/*

문제에서는 n개의 동전들이 일렬로 놓여져 있고, 각 동전은 앞뒤 두 면 중 하나의 면이 
위를 향하고 있습니다. 여러분은 몇 개의 동전들을 선택해서 모두 뒤집어야 합니다.
 이때, 한 번 뒤집은 동전은 인접한 동전들도 함께 뒤집힙니다.

이를 해결하기 위해서, 이 코드는 비트마스킹과 재귀함수를 이용합니다. 먼저, 
비트마스킹을 이용해서 각 동전의 앞/뒷 면 정보를 저장합니다. 
여기서는 int형 배열 a를 이용해서 1로 표시된 비트는 앞면, 0으로 표시된 비트는 뒷면이라고 했습니다.

그 다음, 재귀함수를 이용해서 동전을 뒤집습니다. 여기서는 각 동전을 선택하거나 선택하지 않는
 두 가지 경우를 고려합니다. 재귀호출 시 선택한 동전은 뒤집고, 
 선택하지 않은 동전은 뒤집지 않습니다.

마지막으로, 모든 동전을 뒤집은 후에는 각 비트 위치를 순회하면서 선택한 동전들 
중 앞면이 몇 개인지 카운트합니다. 그리고 선택한 동전들 중 뒷면이 몇 개인지도 카운트합니다.
 그 중에서 더 적은 쪽의 동전을 모두 뒤집으면, 모든 동전을 뒤집을 수 있습니다.
 이렇게 구한 결과 중 가장 작은 값을 구해서 출력합니다.

*/