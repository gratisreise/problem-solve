#include<bits/stdc++.h>
using namespace std;
using namespace std;
int V, E, K, u, v, w;
vector<pair<int, int>> adj[20001];
int dist[20001];
bool visited[20001];
const int INF = 1e9;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int main(){
    scanf("%d %d %d", &V, &E, &K);
    fill(dist, dist + 20001, INF);
    for(int i = 0; i < E; i++){
        scanf("%d %d %d", &u, &v, &w);
        adj[u].push_back(make_pair(w, v));
    }
    pq.push(make_pair(0, K));
    dist[K] = 0;
    while(pq.size()){
        int here = pq.top().second;
        int here_dist = pq.top().first;
        pq.pop();
        if(dist[here] != here_dist) continue;
        for(pair<int, int> there : adj[here]){
            int _dist = there.first;
            int _there = there.second;
            if(dist[_there] > dist[here] + _dist){
                dist[_there] = dist[here] + _dist;
                pq.push(make_pair(dist[_there], _there));
            }
        }
    }
    for(int i = 1; i <= V; i++){
        if(dist[i] == INF) puts("INF");
        else printf("%d\n", dist[i]);
    }
    return 0;
}