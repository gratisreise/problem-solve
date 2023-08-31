#include<bits/stdc++.h>
using namespace std; 
int n, len, num, lis[1000004]; // n: 수열의 크기, lis: 최장 증가 부분 수열을 담는 배열, len: 현재까지 구한 최장 증가 부분 수열의 길이, num: 수열의 원소값
pair<int, int> ans[1000004]; // 각 위치에서의 최장 증가 부분 수열의 위치와 원소값을 저장할 배열
stack<int> stk; // 최장 증가 부분 수열을 찾기 위해 사용할 스택
cons int INF = 1e9 + 4;
int main() {
    fill(lis, lis + 1000004, INF);
    scanf("%d", &n); // 수열의 크기 입력받기
    for (int i = 0; i < n; i++){ // 수열 입력받기
        // 가장길게만들어주는 과정
        scanf("%d", &num); // 수열의 i번째 원소값 입력받기
        auto lowerPos = lower_bound(lis, lis + len, num); // 현재 수열의 원소값을 가지고 이분 탐색을 수행하여 삽입할 위치 찾기
        int _pos = (int)(lower_bound(lis, lis + len, num) - lis); // 이분 탐색을 수행한 결과 찾은 위치 _pos
        if(*lowerPos == INF) len++; // lowerPos가 가리키는 값이 0이면, num보다 작은 값들로만 이루어진 최장 증가 부분 수열이 없으므로 길이를 1 증가시켜줌
        *lowerPos = num; // 삽입할 위치에 num 값을 넣어줌
        // 자료구조에 저장과정
        ans[i].first = _pos; // 현재 수열의 위치 i에서의 최장 증가 부분 수열의 위치를 ans 배열에 저장
        ans[i].second = num; // 현재 수열의 위치 i에서의 원소값을 ans 배열에 저장
    }
    // for(int i = 0; i < n; i++){ // 디버깅
    //     pair<int, int> a = ans[i];
    //     cout << a.first << " : " << a.second << " "
    // }
    printf("%d\n", len); // 구한 최장 증가 부분 수열의 길이 출력
    for(int i = n - 1; i >= 0; i--){ // 역순으로 ans 배열을 탐색하면서, stk에 역으로 넣어줌으로써, 최장 증가 부분 수열을 찾음
        if(ans[i].first == len - 1){ // 만약 현재 위치에서의 최장 증가 부분 수열의 위치가 len-1이면
            stk.push(ans[i].second); // 해당 위치에서의 원소값을 스택에 push
            len--; // len-1이었던 위치를 다시 찾아야 하므로 len-1 해줌
        }
    }
    while(stk.size()){ // 스택이 비어있지 않다면
        printf("%d\n", stk.top()); // 스택의 top을 출력하고
        stk.pop(); // pop 해줌
    } 
    return 0; // 프로그램 종료
}

