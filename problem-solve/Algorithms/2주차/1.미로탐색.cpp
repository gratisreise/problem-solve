#include<bits/stdc++.h>
using namespace std;
int n, m, y, x;
int a[101][101], visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
string s;
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = 0; j < m; j++){
            a[i][j] = #include <bits/stdc++.h>
using namespace std;  
string s; 
int lcnt, vcnt; 
bool isVowel(int idx){
	return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
}
int main () { 
	while(true){
		cin >> s; 
		if(s == "end")break; 
		lcnt = vcnt = 0;
		bool flag = 0;
		bool is_include_v = 0;
		int prev = -1;
		for(int i = 0; i < s.size(); i++){
			int idx = s[i]; 
			if(isVowel(idx))lcnt++, vcnt = 0, is_include_v = 1;
			else vcnt++, lcnt = 0;
			if(vcnt == 3 || lcnt == 3) flag = 1; 
			if(i >= 1 && (prev == idx) && (idx != 'e' && idx != 'o')){
				flag  = 1;
			} 
			prev = idx;
		}  
		if(is_include_v == 0) flag = 1;
		if(flag) cout << "<" << s << ">" << " is not acceptable.\n";
		else cout << "<" << s << ">" << " is acceptable.\n";
	} 
	return 0;
}s[j] - '0';
        }
    }
    queue<pair<int, int>> q;
    visited[0][0] = 1;
    q.push({0, 0});
    while(q.size()){
        tie(y, x) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(a[ny][nx] == 0 || visited[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny, nx});
        }
    }
    cout << visited[n - 1][m - 1] << '\n';
    return 0;
}