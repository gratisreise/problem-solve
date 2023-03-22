<인접행렬> : 정점과 간선의 관계를 나타내는 bool타입의 정사각형 행렬
//Q. 3번노드에서 5번노드로 가는 단방향 경로가 있고 이를 인접행렬로 표현한다면?
    a[3][5] = 1;
//Q. 3번노드에서 5번노드로 가는 양방향 경로가 있고 이를 인접행렬로 표현한다면?
    a[3][5] = 1;
    a[5][3] = 1;
//Q.정점의 갯수가 20개인 그래프를 메모리를 최소로 쓰고 배열을 만들면?
    bool a[20][20];
/*
정점은 0번 부터 9번까지 10개의 노드가 있다. 1 - 2 /  1 - 3 / 3 - 4 라는 경로가 있다.
(1번과 2번, 1번과 3번, 3번과 4번은 연결되어있다.) 이를  이를 인접행렬로 표현한다면?

0번부터 방문안한 노드를 찾고 해당 노드부터 방문, 연결된 노드를 이어서 방문해서 출력하는 재귀함수를 만들고 
싶다면 어떻게 해야할까? 또한, 정점을 방문하고 다시 방문하지 않게 만드려면 어떻게 해야할까?
*/
#include<bits/stdc++.h> // 코드리뷰 다시 보면서 정리!!
using namespace std; 
const int V = 10;
bool a[V][V], visited[V];
void go(int from){  // 가는 로직 
	visited[from] = 1;  // 재방문 방지를 위해 visited 1채우기
	for(int i = 0; i < V; i++){ // 
		if(visited[i]) continue; // 색칠되면 가면 안됨
		if(a[from][i]){ // 1이 있으면 다리 있어서 갈 수 있음
			go(i); // 재귀호출
		}
	}
	return;
}
int main(){
	a[1][2] = 1; a[1][3] = 1; a[3][4] = 1;
	a[2][1] = 1; a[3][1] = 1; a[4][3] = 1;
	for(int i = 0;i < V; i++){
		for(int j = 0; j < V; j++){ //탐색하는 방법
			if(a[i][j] && visited[i] == 0){ //go를 할 수 있는 조건
				go(i); 
			}
		}
	} 
} 

// <인접리스트>
#include<bits/stdc++.h>
using namespace std; 
const int V = 4;
vector<int> adj[V];
int main(){
    adj[0].push_back(1);
    adj[0].push_back(2);
    adj[0].push_back(3);

    adj[1].push_back(0);
    adj[1].push_back(2);

    adj[2].push_back(0);
    adj[2].push_back(1);

    adj[3].push_back(0); 

    for(int i = 0; i < 4; i++){
        cout << i << " :: "; // 디버깅
        for(int there : adj[i]){ // 인접리스트의 각 벡터에서 정수 there를 찾는다.
            cout << there << " ";
        }
        cout << '\n'; 
    }
    // 이렇게도 할 수 있다.
    for(int i = 0; i < 4; i++){
        cout << i << " :: ";
        for(int j = 0; j < adj[i].size(); j++){ // 범위 기반을 대신해서 딴 걸로 씀
            cout << adj[i][j] << " ";
        } 
        cout << '\n'; 
    }
    
} 
//정답코드
Q1.
#include<bits/stdc++.h>
using namespace std; 
const int V = 10;
vector<int> adj[V];  
int visited[V];
void go(int idx){
    visited[idx] = 1;
    for(int there : adj[idx]){
        if(visited[there]) continue;
        go(there);
    } 
    return;
}
int main(){
    adj[1].push_back(2);
    adj[2].push_back(1);

    adj[1].push_back(3); 
    adj[3].push_back(1);

    adj[3].push_back(4);
    adj[4].push_back(3); 
    for(int i = 0; i < V; i++){
        if(adj[i].size() && visited[i] == 0){ 
            go(i);
        }
    } 
}

Q2.
#include<bits/stdc++.h>
using namespace std; 
const int V = 10;
vector<int> adj[V];  
int visited[V];
void go(int idx){
    cout << idx << '\n';
    visited[idx] = 1;
    for(int there : adj[idx]){
        if(visited[there]) continue;
        go(there);
    } 
    return;
}
int main(){
    adj[1].push_back(2);
    adj[2].push_back(1);

    adj[1].push_back(3); 
    adj[3].push_back(1);

    adj[3].push_back(4); 
    adj[4].push_back(3); 
    for(int i = 0; i < V; i++){
        if(adj[i].size() && visited[i] == 0) go(i);
    } 
} 

<맵과 방향벡터>
//Q1
#include <bits/stdc++.h>
using namespace std; 
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
int main(){
    int y = 0, x = 0;  
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        cout << ny << " : " << nx << '\n'; 
    } 
    return 0;
}

//Q2
#include <bits/stdc++.h>
using namespace std; 
const int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int main(){
    int y = 0, x = 0;  
    for(int i = 0; i < 8; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        cout << ny << " : " << nx << '\n'; 
    } 
    return 0;
}

//Q3
#include<bits/stdc++.h>
using namespace std;
//기본선언값
const int n = 3;
int a[n][n], visited[n][n];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
//고함수
void go(int y, int x){
    visited[y][x] = 1;
    cout << y << " : " << x << "\n";
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i]; 
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue; //플로우 제한
        if(a[ny][nx] == 0) continue; // 방문할 수 없는 지역, 맵에있는 값이 0이 아니여야함
        if(visited[ny][nx]) continue; // 방문안한거 찾아야 하니깐 <!!>
        go(ny, nx); // 점 이동해서 거기서 또 4방향 탐색하며 이동
    }
    return;
}
int main(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    go(0, 0); // {0, 0}은 무조건 1
}

<DFS> : 그래프를 탐색할 때 쓰는 알고리즘으로 인접한 노드들을 재귀적으로 방문하여
방문한 정점은 다시 방문하지 않으며 각 분기마다 가능한 가장 멀리 있는 노드까지 탐색하는
알고리즘
//수도코드
DFS(u, adj)
    u.visited = true
    for each v ∈ adj[u]
        if v.visited == false
            DFS(v, adj)
#include<bits/stdc++.h>
using namespace std;
const int n = 6; 
vector<int> adj[n];
int visited[n];
void dfs(int u){
    visited[u] = 1;
    cout << u << "\n";
    for(int v : adj[u]){
        if(visited[v] == 0){
            dfs(v);
        }
    }   
    cout << u << "로부터 시작된 함수가 종료되었습니다.\n";
    return; 
}
int main(){
    adj[1].push_back(2);
    adj[1].push_back(3); 
    adj[2].push_back(4);  
    adj[4].push_back(2);  
    adj[2].push_back(5);   
    dfs(1); 
} 
//하남자의 코드
void dfs(int here){
    visited[here] = 1; 
    for(int there : adj[here]){
        if(visited[there]) continue;
        dfs(there);
    }
}
//상남자의 코드
void dfs(int here){
    if(visited[here]) return;
    visited[here] = 1;
    for(int there : adj[here]){ 
        dfs(there);
    }
}
//종화는 방구쟁이야!!
#include<bits/stdc++.h>
using namespace std; 
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1}; 
int m, n, k, y, x, ret, ny, nx;
int a[104][104];
bool visited[104][104];
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >=n || nx >= m) continue;
        if(a[ny][nx] == 1 && !visited[ny][nx]){
            dfs(ny, nx);
        }
    }
    return;
}

int main(){ 
    cin.tie(NULL);cout.tie(NULL);
    cin >> n >> m; 
    for(int i = 0; i < n; i++){
    	for(int j = 0; j < m; j++){
    		cin >> a[i][j];
		}
	}
	for(int i = 0; i < n; i++){
    	for(int j = 0; j < m; j++){
    		if(a[i][j] == 1 && !visited[i][j]){
    			ret++; dfs(i, j);
			} 
		}
	}
	cout << ret << '\n';
    return 0;
}

<BFS> : 어떤 정점에서 시작해 다음 깊이의 정점으로 이동하기전 현재 깊이의 모든 정점을
탐색하며 방문한 정점은 다시 방문하지 않는 알고리즘 -> 같은 가중치를 가진 그래프에서 최단거리알고리즘으로 쓰임

BFS(G, u)
    u.visited = true
    q.push(u);
    while(q.size()) 
        u = q.front() 
        q.pop()
        for each v ∈ G.Adj[u]
            if v.visited == false
                v.visited = true
                q.push(v)
BFS(G, u)
    u.visited = 1
    q.push(u);
    while(q.size()) 
        u = q.front() 
        q.pop()
        for each v ∈ G.Adj[u]
            if v.visited == false
                v.visited = u.visited + 1
                q.push(v)
//그래프는 인접리스트로 구현 10번정점부터 탐색하는 BFS코드
#include<bits/stdc++.h>
using namespace std;     
vector<int> adj[100];
int visited[100]; 
int nodeList[] = {10, 12, 14, 16, 18, 20, 22, 24};
void bfs(int here){
    queue<int> q; // 큐 선언
    visited[here] = 1;  // 방문된거 색칠
    q.push(here); // 큐에 넣어서 크기를 만들어줌
    while(q.size()){  // while로 반복문을 이용하여 루프생성
        int here = q.front(); q.pop();  //  here를 q에넣고 다시 팝
        for(int there : adj[here]){     //  
            if(visited[there]) continue;
            visited[there] = visited[here] + 1;
            q.push(there);
        }
    }
}
int main(){
    adj[10].push_back(12);
    adj[10].push_back(14);
    adj[10].push_back(16);
    
    adj[12].push_back(18);
    adj[12].push_back(20);


    adj[20].push_back(22);
    adj[20].push_back(24);
    bfs(10);
    for(int i : nodeList){
        cout << i << " : " << visited[i] << '\n';
    }
    cout << "10번으로부터 24번까지 최단거리는 : " << visited[24] - 1 << '\n';
    return 0; 
}

//승원이
#include<bits/stdc++.h>
using namespace std; 
const int max_n = 104;
int n, m, y, x, sy, sx, ey, ex;
int a[max_n][max_n], visited[max_n][max_n]
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1}; 
int main(){ 
    scanf("%d %d", &n, &m); 
    cin >> sy >> sx; 
    cin >> ey >> ex;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
        	cin >> a[i][j];
        }
    }
    queue<pair<int, int>> q;
    visited[sy][sx] = 1;
    q.push({sy, sx});
    while(q.size()){
        tie(y, x) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i]; 
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == 0) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny, nx});
        } 
    }
    printf("%d\n", visited[ey][ex]);
    // 최단거리 디버깅 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
        	cout << visited[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
//순회
#include <bits/stdc++.h>
using namespace std; 
vector<int> adj[1004]; 
int visited[1004];

void postOrder(int here){  
} 
void preOrder(int here){ 
}  
void inOrder(int here){    

} 
int main(){
	adj[1].push_back(2);
	adj[1].push_back(3);
	adj[2].push_back(4);
	adj[2].push_back(5); 
	int root = 1;
    cout << "\n 트리순회 : postOrder \n";
    postOrder(root); memset(visited, 0, sizeof(visited));
    cout << "\n 트리순회 : preOrder \n"; 
    preOrder(root); memset(visited, 0, sizeof(visited)); 
    cout << "\n 트리순회 : inOrder \n"; 
    inOrder(root); 
    return 0;
} 
//순회
#include <bits/stdc++.h>
using namespace std; 
vector<int> adj[1004]; 
int visited[1004];

void postOrder(int here){ 
  	if(visited[here] == 0){ 
  		if(adj[here].size() == 1)postOrder(adj[here][0]);
  		if(adj[here].size() == 2){
  			postOrder(adj[here][0]); 
  			postOrder(adj[here][1]);
		}
  		visited[here] = 1; 
  		cout << here << ' ';
	} 
} 
void preOrder(int here){
  	if(visited[here] == 0){
  		visited[here] = 1; 
  		cout << here << ' ';
  		if(adj[here].size() == 1)preOrder(adj[here][0]);
  		if(adj[here].size() == 2){
  			preOrder(adj[here][0]); 
  			preOrder(adj[here][1]);
		}
	}
}  
void inOrder(int here){   	
	if(visited[here] == 0){ 
  		if(adj[here].size() == 1){ 
  			inOrder(adj[here][0]); 
	  		visited[here] = 1; 
	  		cout << here << ' ';
		}else if(adj[here].size() == 2){
  			inOrder(adj[here][0]); 
	  		
			visited[here] = 1; 
	  		cout << here << ' ';
  			
			inOrder(adj[here][1]);
		}else{
	  		visited[here] = 1; 
	  		cout << here << ' '; 
		}
	}

} 
int main(){
	adj[1].push_back(2);
	adj[1].push_back(3);
	adj[2].push_back(4);
	adj[2].push_back(5); 
	int root = 1;
    cout << "\n 트리순회 : postOrder \n";
    postOrder(root); memset(visited, 0, sizeof(visited));
    cout << "\n 트리순회 : preOrder \n"; 
    preOrder(root); memset(visited, 0, sizeof(visited)); 
    cout << "\n 트리순회 : inOrder \n"; 
    inOrder(root); 
    return 0;
}
<dp의 맛보기!!>
#include<bits/stdc++.h>
using namespace std;
vector<int> v[1004];
int visited[1004]; 
int dfs(int here){
    int ret = 1;
    for(int i : adj[here]){
        if(visited[i]) continue;
        visited[i] = 1;
        ret += dfs(i);
    }
    return ret;
}
int main(){
    v[1].push_back(2);
    v[1].push_back(3);
    visited[1] = 1;
    cout << dfs(1) << '\n';
}




