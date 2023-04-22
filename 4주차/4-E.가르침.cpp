#include<bits/stdc++.h>
using namespace std;
int n, m, words[51];
string s;
int count(int mask){ //
    int cnt = 0;
    for(int word : words){
        if(word && (word & mask) == word) cnt++;
    }
    return cnt;
}
int go(int index, int k, int mask){ // 재귀로 확인 
    if(k < 0) return 0;
    if(index == 26) return count(mask);
    int ret = go(index + 1, k - 1, mask | (1 << index));
    if(index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a' && index != 'c' - 'a'){
        ret = max(ret, go(index + 1, k, mask));
    }
    return ret;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(char str : s){
            words[i];
        }
    }
    cout << go(0, m, 0) << '\n';
    return 0;
}
/*
1. k개의 단어만 가르칠 수 있다.
2. k개의 알파벳으로 이루어진 단어만 읽을 수 있다.
3. anta, tica는 고정
4. 학생들이 읽을 수 있는 단어의 최댓값 구하기
5.
*/