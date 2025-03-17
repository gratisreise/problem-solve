class Dinic:
	class Edge:
		def __init__(self,to,rev,c,oc):
			self.to = to
			self.rev = rev
			self.c = c
			self.oc = oc
	def __init__(self,n):
		self.lvl = [0] * n
		self.ptr = [0] * n
		self.q = [0] * n
		self.adj = [[] for _ in range(n)]
		self.inf = 0
	def addEdge(self,a,b,c,rc=0):
		self.adj[a].append(self.Edge(b,len(self.adj[b]),c,c))
		self.adj[b].append(self.Edge(a,len(self.adj[a])-1,rc,rc))
		self.inf = max(self.inf, c, rc)
	def dfs(self,v,t,f):
		if(v == t or not f):
			return f
		while(self.ptr[v] < len(self.adj[v])):
			e = self.adj[v][self.ptr[v]]
			if(self.lvl[e.to] == self.lvl[v] + 1):
				p = self.dfs(e.to, t, min(f, e.c))
				if(p):
					self.adj[v][self.ptr[v]].c -= p
					self.adj[e.to][e.rev].c += p
					return p
			self.ptr[v] += 1
		return 0
	def calc(self,s, t):
		flow = 0
		self.q[0] = s
		self.lvl[t] = 1
		while(self.lvl[t]):
			self.lvl = [0] * len(self.q)
			self.ptr = [0] * len(self.q)
			qi = 0
			qe = 1
			self.lvl[s] = 1
			while(qi < qe and not self.lvl[t]):
				v = self.q[qi]
				qi += 1
				for e in self.adj[v]:
					if((not self.lvl[e.to]) and e.c):
						self.q[qe] = e.to
						self.lvl[e.to] = self.lvl[v] + 1
						qe += 1
			p = 1
			while(p):
				p = self.dfs(s, t, self.inf)
				flow += p
		return flow
n, m, k = map(int,input().split())
u = [0] * m
v = [0] * m
for i in range(m):
	u[i], v[i] = [int(j)-1 for j in input().split()]
ans = 0
gap = 16
while(gap):
	mid = ans | gap
	flow = Dinic(n * mid)
	for i in range(n):
		for j in range(mid-1):
			flow.addEdge(i*mid+j,i*mid+j+1,105)
	for i in range(m):
		for j in range(mid):
			flow.addEdge(u[i]*mid+j,v[i]*mid+j,1)
		for j in range(mid-1):
			flow.addEdge(u[i]*mid+j,v[i]*mid+j+1,105)
	if(flow.calc(0,n*mid-1) <= k):
		ans = mid
	gap >>= 1
print(ans)