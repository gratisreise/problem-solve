#include<bits/stdc++.h>
using namespace std; 
int n, l, ret;  // ret : 가능한 길의 개수
int a[104][104], b[104][104]; // a:원본지도 b:원본지도를 transpose한 지도
void solve(int a[104][104]){ // 각 행 또는 영을 검사하여 가능한 길의 갯수 찾음
    for(int i = 0; i < n; i++){
        int cnt = 1; 
        int j;  
        for(j = 0; j < n - 1; j++){
            if(a[i][j] == a[i][j + 1])cnt++; // 모두 높이가 같으면
            else if(a[i][j] + 1 == a[i][j + 1] && cnt >= l) cnt = 1;  //오르막길이 있으면서 경사로를 놓을 수 있는 경우
            else if(a[i][j] - 1 == a[i][j + 1] && cnt >= 0) cnt = -l + 1;  //내리막길 있으면서 경사로를 놓을 수 있는 경우
            else break;
        }
        if(j == n - 1 && cnt >= 0) ret++; 
    }
    return; 
} 
int main(){
    scanf("%d %d", &n, &l);
    for(int i = 0; i < n; i++){ 
        for(int j = 0; j < n; j++){
            scanf("%d", &a[i][j]); 
            b[j][i] = a[i][j];
        }
    }    
    solve(a); solve(b);  
    printf("%d\n", ret);  
    return 0; 
}