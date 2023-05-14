#include<bits/stdc++.h>
using namespace std;
const int mxx = 5000;
int n, temp;
int a[500004], b[500004];
vector<int> v; 
int avg, mid, scp, fre;
int main(){
    cin >> n;
    fill(a, a + 500004, mxx);
    for(int i = 0; i < n; i++){
        cin >> a[i];
        v.push_back(a[i]);
        b[a[i]]++;
        
    }
    for(int i = 1; i <= n - 1; i++){
        if(b[i] > b[i - 1]) fre = i;
    }
    sort(a, a + 500004);
    sort(v.begin(), v.end());
    avg = accumulate(v.begin(), v.end(),0) / n;
    mid = a[n / 2];
    scp = a[n - 1] - a[0];
    cout << avg << '\n' << mid << '\n';
    cout << fre << '\n' << scp << '\n';
}


<런타임 에러>