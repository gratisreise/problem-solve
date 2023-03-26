#include <bits/stdc++.h>
using namespace std;
int n;
vector<string> v;
string s, ret; 
void go(){ 
    while(true){ // 앞에 0이 나오면 그 0을 삭제시켜주는 로직
        // 0을 char형이 아니라 int형으로 선언했었음..
        if(ret.size() && ret.front() == '0') ret.erase(ret.begin());
        
        else break;
    }
    if(ret.size() == 0) ret = "0"; // ret의 크기가 0이면 re에0을 넣는다.
    v.push_back(ret); // ret을 벡터v에 넣어줌 
    ret = ""; // ret 초기화해서 숫자만 올 때 대비해줌
}
bool cmp(string a, string b){ //문자열 정렬은 아스키코드 순이기 때문에 커스텀 필요
    if(a.size() == b.size()) return a < b; //자릿수가 같으면 큰 거 뒤에오게
    return a.size() < b.size(); // 자릿수가 더 큰걸 뒤에 오게 한다.
}
int main(){
    cin >> n; 
    for(int i = 0; i < n; i++){ // n번 반복한다.
        cin >> s; // 입력받음
        ret = ""; // ret 초기화 -> 빼먹었었음
        for(int j = 0; j < s.size(); j++){ // 
            if(s[j] < 65) ret += s[j];
            else if(ret.size()) go();
        }
        if(ret.size()) go(); //s에 숫자만 올 경우 대비한 로직
    }
    sort(v.begin(), v.end(), cmp);
    for(string i : v) cout << i << '\n';
    return 0;
}