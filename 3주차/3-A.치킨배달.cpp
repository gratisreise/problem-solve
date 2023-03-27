#include <bits/stdc++.h>
using namespace std;
int n, m, a[54][54], result = 987654321;
vector<vector<int>> chickenList; // 치킨집 좌표의 인덱스를 저장
vector<pair<int, int>> _home, chicken; // 치킨과 집의 좌표저장
void combi(int start, vector<int> v){ // 조합으로 좌표모음을 푸쉬해줌
    if(v.size() == m){ // v벡터의 크기가 m곽 같아졌을 때 치킨리스트에 푸쉬
        chickenList.push_back(v); // 벡터를 치킨리스트에 푸쉬!
        return;
    }
    for(int i = start + 1; i < chicken.size(); i++){ //치킨 사이즈 만큼 i 푸쉬하고 
        v.push_back(i); // 
        combi(i, v); // 
        v.pop_back(); //뒤에거 지워주면서 다른애들 들어갈 자리 만들어줌
        
    }
    return;
}
int main(){
    cin >> n >> m; // 기본입력
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
            if(a[i][j] == 1) _home.push_back({i, j}); //집리스트에 넣어줌
            if(a[i][j] == 2) chicken.push_back({i, j}); // 치킨 리스트에 넣어줌
        }
    }
    vector<int> v; //좌표의 모음이 저장될 곳
    combi(-1, v); //조합
    for(vector<int> cList : chickenList){ // 안닫은 치킨집의 번호 먼저뽑기
        int ret = 0; // 도시치킨거리 초기화
        for(pair<int, int> home : _home){ // 집 탐색하며 거리 구할려고
            int _min = 987654321; //최솟값 구하기위해 최대한 큰 값 넣기
            for(int ch : cList){ // 좌표 모음에서 각 좌표의 번호 넣고 뽑기
                int _dist = abs(home.first - chicken[ch].first) + abs(home.second - chicken[ch].second); //거리구하기
                _min = min(_min, _dist); // 치킨거리 구하기위해 최솟값 구하기
            }
            ret += _min; // 도시 치킨거리 구하기 위해
        }
        result = min(result, ret); //치킨거리의 최솟값 구하기
    }
    cout << result << '\n'; //출력!!
    return 0;
}
/*
1. 재귀를 통한 조합이해 및  외우기

*/