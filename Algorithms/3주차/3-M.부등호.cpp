#include<bits/stdc++.h>
using namespace std;
//입력받을 부등호의 갯수, 각 자리수 사이의 부등호르 나타내는 a 배열, 중복사용 방지 check배열
int n, check[10];
char a[20];
vector<string> ret;
bool good(char x, char y, char op){ //x와 y의 대소를 판별하여 부등호 만족여부 
    if(x < y && op == '<') return true;
    if(x > y && op == '>') return true;
    return false;
}
void go(int idx, string num){ // idx는 현재 찾고있는 자릿수, num은 지금까지 찾아낸 수열
    if(idx == n + 1){ //기저사례
        ret.push_back(num); return; //기저사례해당되면 ret에다가 푸쉬
    }
    for(int i = 0; i <= 9; i++){ //0~9
        if(check[i]) continue; // 이미 사용된 숫자면 
        //idx가 0인경우는 첫 자리니깐 그냥 사용, 0이 아니면 이전자릿수와 비교해서 부등호 만족하는지 확인!
        if(idx == 0 || good(num[idx - 1], i + '0', a[idx - 1])){ //이스키 변환해야 대소비교
            check[i] = 1; //숫자사용 표시 
            go(idx + 1, num + to_string(i)); // idx + 1고 num + i를 인자로 재귀호출
            check[i] = 0; // 원상복구해서 다른 노드로 ㄱㄱ
        }
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    go(0, "");
    sort(ret.begin(), ret.end());
    cout << ret[ret.size() - 1] << '\n' << ret[0] << '\n';
}