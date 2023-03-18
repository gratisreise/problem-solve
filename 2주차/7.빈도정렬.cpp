#include<bits/stdc++.h>
using namespace std;
int n, c, a[1004];
vector<pair<int, int>> v;   //첫번째에는 갯수 두번째에는 숫자
map<int, int> mp, mp_first; // mp에는 숫자, 갯수 /mp first는 순서
bool cmp(pair<int, int> a, pair<int, int> b){ 
    if(a.first == b.first){ //갯수가 같으면 
        return mp_first[a.second] < mp_first[b.second]; //순서 일찍나온걸로 
    }
    return a.first > b.first; // 갯수의 내림차순으로 정렬
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> c; // 입력 받기
    for(int i = 0; i < n; i++){
        cin >> a[i]; mp[a[i]]++; //배열 a[i]에 숫자저장하고  mp맵에 숫자-갯수
        if(mp_first[a[i]] == 0) mp_first[a[i]] = i + 1; // mp_first맵에 순서 저장
    }
    for(auto it : mp){ //순회 하면서 pair벡터에 넣기
        v.push_back({it.second, it.first}); // 갯수 기준으로 정렬하기 위해
    }
    sort(v.begin(), v.end(), cmp); // cmp함수 기준으로 정렬
    for(auto i : v){ // v벡터 순회
        for(int j = 0; j < i.first; j++){ //숫자를 얼마나 반복해서 뽑아줄지 정함
            cout << i.second << ' ';
        }
    }
    return 0;
}