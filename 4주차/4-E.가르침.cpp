#include<bits/stdc++.h>
using namespace std;
int n, m, words[51];
string s;
int count(int mask){ //단어가 맞는지 확인 하면서 맞으면 ++
    int cnt = 0;
    for(int word : words){
        if(word && (word & mask) == word) cnt++;
    }
    return cnt;
}
int go(int index, int k, int mask){ // 뽑았는지 안뽑았느지 확인
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
            words[i]
        }
    }
    cout << go(0, m, 0) << '\n';
    return 0;
}