#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n, m, temp;
// 이분 탐색을 수행하는 함수.
int check(int temp, vector<int> &v){
    int l = 0, r = v.size() - 1;
    int mid;
    while(l <= r){
        mid = (l + r) / 2;
        if(v[mid] > temp) r = mid - 1;
        else if(v[mid] == temp) return 1;
        else l = mid + 1;
    }
    return 0;
}
int main(){
    scanf("%d", &t);
    while(t--){
        vector<int> v; // 각 t갯수에서 수열 원소를 저장할 vector선언
        scanf("%d", &n); // 수열 원소 갯수를 입력받는다.
        for(int i = 0; i < n; i++){ 
            scanf("%d", &temp); 
            v.push_back(temp);
        }
        sort(v.begin(), v.end()); //오름차 정렬 -> 이분탐색을 할려고
        // 찾아야할 수의 개수를 입력받고, 이분탐색을 수행하여 해당 수가 수열에 존재하는지 여부르 출력한다.
        scanf("%d", &m);
        for(int i = 0; i < m; i++) {
            scanf("%d", &temp);
            cout << check(temp, v) << '\n';
        }
    }
    return 0;
}