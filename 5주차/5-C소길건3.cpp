#include<bits/stdc++.h>
using namespace std;
int n;
int main(){
    cin >> n;
    vector<pair<int, int>> a(n);
    for(int i = 0; i < n; i++) cin >> a[i].first >> a[i].second; 
    // 시작 시간 순으로 정렬
    sort(a.begin(), a.end()); 
    // 초기 시간 설정
    int realTime = a[0].first + a[0].second; 
    //순서대로 일 처리하기 
    for(int  i = 1; i < a.size(); i++){
        // 현재 일을 시작할 수 있는 시간이 되면 시작
        realTime = max(realTime, a[i].first);
        realTime += a[i].second;
    }
    //결과 출력
    cout << realTime << '\n';
    return 0;
}
/*
이후, 가장 먼저 도착한 소는 일단 무조건 건너가야 하므로,
해당 소가 건너가는 데 걸리는 시간과 도착 시간을 더해 realTime 변수에 저장합니다.

이후 반복문에서는 정렬된 소들을 순서대로 확인하면서,
현재 시간과 해당 소의 도착 시간 중 큰 값을 선택하여 현재 시간을 갱신하고,
건너가는 데 걸리는 시간을 더해 realTime 변수를 갱신합니다.
*/