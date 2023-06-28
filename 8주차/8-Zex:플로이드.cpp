#include<bits/stdc++.h>
int n, m, a, b, c, dist[104][104];
const int INF = 987654321;
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	cin >> n >> m;
	fill(&dist[0][0], &dist[0][0] + 104 * 104, INF);
	for(int i = 0; i < m; i++){
		cin >> a >> b >> c;
		a--; b--;
		dist[a][b] = dist[a][b] ? min(dist[a][b], c) : c;
	}
	for(int k=0; k<n; k++)
		for(int i=0; i< n; i++)
			for(int j=0; j< n; j++)
				dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
	for(int i=0; i< n; i++){
		for(int j=0; j< n; j++)
            if(i == j)printf("0 ");
			else printf("%d ", dist[i][j]==INF ? 0 : dist[i][j]);
		puts("");
	}
    return 0;
}


