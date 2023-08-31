#include<bits/stdc++.h>
using namespace std;
int h, w, a[101][101];
string s;
int main(){
    cin >> h >> w;
    for(int i = 0; i < h; i++){
        cin >> s;
        for(int j = 0; j < w; j++){
            if(s[j] == 'c') a[i][j] = 0;
            else a[i][j] = -1;
        }
    }
    for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
            if(a[i][j] == 0){ // 0을 기준으로 배열 앞에있는 수 계속비교
                int cnt = 1;
                while(a[i][j + 1] == -1){ // 행기준으로 +1해서 계속 탐색하면서 비교
                    a[i][j + 1] = cnt++; // 대입되고 나서 ++해준다!! 후위
                    j++;
                }
            }
        }
    }
    for(int i = 0; i < h; i++){ //
        for(int j = 0; j < w; j++){
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
}
/*
1.배열에서 한 수를 기준으로 따로 분리해서 조건으로 탐색가능 ++
2. 대입되고 나서 ++;
*/